package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.org.form.OrgForm;
import com.sunny.bugmanage.org.model.Organization;
import com.sunny.bugmanage.org.model.vo.OrganizationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

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
}