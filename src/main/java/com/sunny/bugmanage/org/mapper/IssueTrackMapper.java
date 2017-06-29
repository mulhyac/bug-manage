package com.sunny.bugmanage.org.mapper;

import com.sunny.bugmanage.org.model.IssueTrack;

public interface IssueTrackMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IssueTrack record);

    int insertSelective(IssueTrack record);

    IssueTrack selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IssueTrack record);

    int updateByPrimaryKey(IssueTrack record);
}