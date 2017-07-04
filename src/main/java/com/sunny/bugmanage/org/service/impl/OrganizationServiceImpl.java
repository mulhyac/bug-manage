package com.sunny.bugmanage.org.service.impl;

import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.fields.Status;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.common.utils.UUIDUtills;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.mapper.OrganizationMapper;
import com.sunny.bugmanage.org.model.Organization;
import com.sunny.bugmanage.org.model.vo.OrganizationVo;
import com.sunny.bugmanage.org.service.OrganizationService;
import com.sunny.bugmanage.org.service.OrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.service.impl.OrganizationServiceImpl
 * @date 2017-07-03 10:51
 * @description:
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationUserService organizationUserService;

    @Override
    public List<OrganizationVo> getAllOrg(OrgForm form) {
        form.setStatus(Status.Disable_Status);
        return organizationMapper.selectAllOrg(form);
    }

    @Override
    public String getUUIDByName(String name) {
        return organizationMapper.selectUUIDByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrg(OrgForm form) {
        String name = form.getName();
        //检验组织名称是否可用
        BaseResult check = checkOrgName(name);
        if (check.getCode() != 0) {
            throw new BugManageException(check.getCode(), check.getMsg());
        }
        Organization org = new Organization();
        String uuId = UUIDUtills.getUUID();
        org.setUuid(uuId);
        org.setName(name);
        org.setIntro(form.getIntro());
        //创建组织
        organizationMapper.insertSelective(org);
        //添加组织成员
        organizationUserService.addOrgUserBySelf(uuId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifierOrg(OrgForm form) {

    }

    @Override
    public Long getOrgByUUID(String uuid) {
        return organizationMapper.selectOrgByUUID(uuid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeOrgByUUID(String uuid) {
        Long id = getOrgByUUID(uuid);
        if (id != null) {
            Organization org=new Organization();
            org.setId(id);
            org.setStatus(Status.Del_Status);
            organizationMapper.updateByPrimaryKeySelective(org);
        }
    }

    @Override
    public BaseResult checkOrgName(String name) {
        String uuId = getUUIDByName(name);
        if (StringUtils.isBlank(uuId)) {
            return ResultUtils.success();
        } else {
            return ResultUtils.error(ResultEnum.ORG_NAME_EXIST);
        }
    }
}
