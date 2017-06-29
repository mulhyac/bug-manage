package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.ProjectIssue;

public interface ProjectIssueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectIssue record);

    int insertSelective(ProjectIssue record);

    ProjectIssue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectIssue record);

    int updateByPrimaryKey(ProjectIssue record);
}