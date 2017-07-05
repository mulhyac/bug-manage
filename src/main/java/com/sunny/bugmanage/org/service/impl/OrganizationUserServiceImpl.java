package com.sunny.bugmanage.org.service.impl;

import com.sunny.bugmanage.common.UserContext.BugAppUser;
import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.fields.Role;
import com.sunny.bugmanage.common.fields.Status;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.org.form.OrgUserForm;
import com.sunny.bugmanage.org.mapper.OrganizationUserMapper;
import com.sunny.bugmanage.org.model.OrganizationUser;
import com.sunny.bugmanage.org.model.vo.OrganizationUserVo;
import com.sunny.bugmanage.org.service.OrganizationService;
import com.sunny.bugmanage.org.service.OrganizationUserService;
import com.sunny.bugmanage.user.service.AppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.service.impl.OrganizationUserServiceImpl
 * @date 2017-07-03 14:25
 * @description:
 */
@Service
public class OrganizationUserServiceImpl implements OrganizationUserService {
    @Autowired
    private OrganizationUserMapper organizationUserMapper;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private AppUserService appUserService;

    @Override
    public void addOrgUserBySelf(String uuId) {
        OrgUserForm form = new OrgUserForm();
        form.setOrgUuid(uuId);
        //  form.setPosition("管理员");
        form.setUserUuid(BugAppUser.userUUId());
        form.setRole(Status.ORG_USER_ROLE_MANAGE);
//        form.setName(BugAppUser.nickName());
        addOrgUser(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrgUser(OrgUserForm form) {
        Byte role = form.getRole();
        String orgUuid = form.getOrgUuid();
        String userUuid = form.getUserUuid();
        OrganizationUser user = getOrganizationUserByUserUuId(orgUuid, userUuid);
        if (user != null) {
            //存在的用户修改
            form.setId(user.getId());
            modifierOrgUserByUserUuId(user.getId(), form);
        }
        //验证组织uuid和用户uuid
        Long orgId = organizationService.getOrgByUUID(orgUuid);
        String nickName = appUserService.getAppUserNickNameByUuid(userUuid);
        if (StringUtils.isBlank(nickName) || orgId == null) {
            return;
        }
        OrganizationUser orgUser = new OrganizationUser();
        BeanUtils.copyProperties(form, orgUser);
        orgUser.setPosition(getPositionByRole(role));
        orgUser.setName(nickName);

        organizationUserMapper.insertSelective(orgUser);
    }

    @Override
    public OrganizationUser getOrganizationUserByUserUuId(String orgUuId, String userUuId) throws BugManageException {
        return organizationUserMapper.selectOrganizationUserByUserUuId(orgUuId, userUuId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifierOrgUserByUserUuId(Long id, OrgUserForm form) throws BugManageException {
        Byte role = form.getRole();
        if (role != null && Role.ORG_USER_MANAGE >= organizationUserMapper.selectRoleByIdAndUserUuId(id, BugAppUser.userUUId())) {
            //禁止修改角色，这个是项目管理员干的事情
            throw new BugManageException(ResultEnum.PERMISSION_DENIED);
        }
        //判断成员状态
        form.setId(id);
        OrganizationUser orgUser = new OrganizationUser();
        BeanUtils.copyProperties(form, orgUser);
        organizationUserMapper.updateByPrimaryKeySelective(orgUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeOrgUserByOrgUUId(String orgUUId) throws BugManageException {
        OrganizationUser orgUser = new OrganizationUser();
        orgUser.setStatus(Status.Del_Status);
        orgUser.setOrgUuid(orgUUId);
        organizationUserMapper.updateOrgUserByOrgUUId(orgUser);
    }

    @Override
    public Map<String, Object> getOrgUserByOrgUUId(String orgUuId, OrgUserForm form) {
        form.setOrgUuid(orgUuId);
        List<OrganizationUserVo> orgUser = organizationUserMapper.selectOrgUserByOrgUUId(form);
        Map<String, Object> map = new HashMap();
        map.put("orgUser", orgUser);
        map.put("count", getOrgUserCountByOrgUuId(orgUuId));
        return map;
    }

    @Override
    public int getOrgUserCountByOrgUuId(String orgUuId) {
        return organizationUserMapper.selectOrgUserCountByOrgUuId(orgUuId);
    }

    /**
     * 获取职位
     *
     * @param role
     * @return
     */
    private String getPositionByRole(Byte role) {
        switch (role) {
            case 1:
                return "成员";
            case 20:
                return "项目负责";
            case 30:
                return "管理员";
            default:
                return "成员";
        }
    }
}
