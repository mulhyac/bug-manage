package com.sunny.bugmanage.org.service.impl;

import com.sunny.bugmanage.common.UserContext.BugAppUser;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.fields.Status;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.org.form.OrgUserForm;
import com.sunny.bugmanage.org.mapper.OrganizationUserMapper;
import com.sunny.bugmanage.org.model.OrganizationUser;
import com.sunny.bugmanage.org.service.OrganizationService;
import com.sunny.bugmanage.org.service.OrganizationUserService;
import com.sunny.bugmanage.user.service.AppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            modifierOrgUserByUserUuId(form);
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
    public void modifierOrgUserByUserUuId(OrgUserForm form) throws BugManageException {
        OrganizationUser orgUser = getOrganizationUserByUserUuId(form.getOrgUuid(), form.getUserUuid());
        if (orgUser != null) {
            //if (orgUser.getRole() != form.getRole()) {
            form.setId(orgUser.getId());
            BeanUtils.copyProperties(form, orgUser);
            orgUser.setStatus(null);//TODO:强制去除状态防止接口修改人员状态
            organizationUserMapper.updateByPrimaryKeySelective(orgUser);
            // }
        }
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
