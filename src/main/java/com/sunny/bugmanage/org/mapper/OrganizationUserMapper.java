package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.OrganizationUser;
import org.apache.ibatis.annotations.Param;

public interface OrganizationUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationUser record);

    int insertSelective(OrganizationUser record);

    OrganizationUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationUser record);

    int updateByPrimaryKey(OrganizationUser record);

    /**
     * 根据用户uuid获取组织成员
     * @param orgUuId
     * @param userUuId
     * @return
     */
    OrganizationUser selectOrganizationUserByUserUuId(@Param("orgUuid") String orgUuId, @Param("userUuid")String userUuId);
}