package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.OrganizationUser;

public interface OrganizationUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationUser record);

    int insertSelective(OrganizationUser record);

    OrganizationUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationUser record);

    int updateByPrimaryKey(OrganizationUser record);
}