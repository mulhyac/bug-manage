package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.model.Organization;
import com.sunny.bugmanage.org.model.vo.OrganizationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper extends BaseMapper<Organization, Long> {

    /**
     * 根据名称获取组织uuid
     *
     * @param name
     * @return
     */
    String selectUUIDByName(String name);

    /**
     * 获取全部的组织
     *
     * @param form
     * @return
     */
    List<OrganizationVo> selectAllOrg(OrgForm form);

    /**
     * 根据uuid获取组织id  (去除状态=127的组织)
     *
     * @param uuid
     * @return
     */
    Long selectOrgByUUID(@Param("uuid") String uuid);

    /**
     * 根据id修改组织状态 ta
     *
     * @param org
     */
    void updateOrgById(Organization org) throws BugManageException;

    /**
     * 根据组织uuid获取组织人员上限
     *
     * @param uuid
     * @return
     */
    Integer selectOrgPeopleLimitByUUID(@Param("uuid") String uuid);
    /**
     * 根据组织uuid获取组织项目个数上限
     *
     * @param uuid
     * @return
     */
    Integer selectOrgProLimitByUUID(@Param("uuid") String uuid);
}
