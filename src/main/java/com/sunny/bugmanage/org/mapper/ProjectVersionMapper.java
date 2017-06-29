package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.ProjectVersion;

public interface ProjectVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectVersion record);

    int insertSelective(ProjectVersion record);

    ProjectVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectVersion record);

    int updateByPrimaryKey(ProjectVersion record);
}