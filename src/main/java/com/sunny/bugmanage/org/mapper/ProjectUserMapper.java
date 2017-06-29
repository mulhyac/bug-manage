package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.ProjectUser;

public interface ProjectUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectUser record);

    int insertSelective(ProjectUser record);

    ProjectUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectUser record);

    int updateByPrimaryKey(ProjectUser record);
}