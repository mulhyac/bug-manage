package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.AppUser;
import com.sunny.bugmanage.user.model.AppUserExtend;

import javax.servlet.http.HttpServletRequest;

public interface AppUserExtendMapper {
    int deleteByPrimaryKey(String userId);

    int insert(AppUserExtend record);

    int insertSelective(AppUserExtend record);

    AppUserExtend selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AppUserExtend record);

    int updateByPrimaryKey(AppUserExtend record);

    /**
     * 添加用户扩展
     * @param request
     * @param appUser
     * @param form
     */
    void insertAppUser(HttpServletRequest request, AppUser appUser, AppUserForm form);
}