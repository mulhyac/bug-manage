package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.OrgProject;

public interface OrgProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrgProject record);

    int insertSelective(OrgProject record);

    OrgProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrgProject record);

    int updateByPrimaryKey(OrgProject record);
}