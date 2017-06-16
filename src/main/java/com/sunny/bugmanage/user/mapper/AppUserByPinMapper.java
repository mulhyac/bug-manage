package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.model.AppUserByPin;

public interface AppUserByPinMapper {
    int deleteByPrimaryKey(String pin);

    int insert(AppUserByPin record);

    int insertSelective(AppUserByPin record);

    AppUserByPin selectByPrimaryKey(String pin);

    int updateByPrimaryKeySelective(AppUserByPin record);

    int updateByPrimaryKey(AppUserByPin record);
}