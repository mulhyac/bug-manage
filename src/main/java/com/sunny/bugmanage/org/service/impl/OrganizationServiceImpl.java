package com.sunny.bugmanage.org.service.impl;

import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.mapper.OrganizationMapper;
import com.sunny.bugmanage.org.model.vo.OrganizationVo;
import com.sunny.bugmanage.org.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<OrganizationVo> getAllOrg(OrgForm form) {
        return organizationMapper.selectAllOrg(form);
    }

    @Override
    public String getUUIDByName(String name) {
        return organizationMapper.selectUUIDByName(name);
    }

    @Override
    public void addOrg(OrgForm form) {

    }

    @Override
    public void modifierOrg(OrgForm form) {

    }

    @Override
    public OrganizationVo getOrgByUUID(String uuid) {
        return null;
    }

    @Override
    public void removeOrgByUUID(String uuid) {

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
