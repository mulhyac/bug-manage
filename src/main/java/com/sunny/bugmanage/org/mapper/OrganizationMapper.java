package com.sunny.bugmanage.org.mapper;

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
     * 根据uuid获取组织id
     *
     * @param uuid
     * @return
     */
    Long selectOrgByUUID(@Param("uuid") String uuid);
}