package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.model.AppUserExtend;

public interface AppUserExtendMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AppUserExtend record);

    int insertSelective(AppUserExtend record);

    AppUserExtend selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AppUserExtend record);

    int updateByPrimaryKey(AppUserExtend record);
}