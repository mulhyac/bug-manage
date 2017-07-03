package com.sunny.bugmanage.org.service;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.model.vo.OrganizationVo;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.bugmanage.org.service.OrganizationService
 * @date 2017-07-03 10:50
 * @description:
 */
public interface OrganizationService {
    /**
     * 根据名称获取组织
     * @param form
     * @return
     */
    List<OrganizationVo> getAllOrg(OrgForm form);

    /**
     * 根据组织名称获取uuid
     * @param name
     * @return
     */
    String getUUIDByName(String name);

    /**
     * 添加组织
     * @param form
     */
    void addOrg(OrgForm form);

    /**
     * 修改组织
     * @param form
     */
    void  modifierOrg(OrgForm form);

    /**
     * 根据uuid获取组织
     * @param uuid
     * @return
     */
    OrganizationVo getOrgByUUID(String uuid);

    /**
     * 根据uuid删除组织
     * @param uuid
     */
    void removeOrgByUUID(String uuid);

    /**
     * 检验组织名称是否存在
     * @param name
     * @return
     */
    BaseResult checkOrgName(String name);
}
