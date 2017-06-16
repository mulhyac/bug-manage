package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.model.AppUserByUsername;
import org.apache.ibatis.annotations.Param;

public interface AppUserByUsernameMapper {
    int deleteByPrimaryKey(String userId);

    int insert(AppUserByUsername record);

    int insertSelective(AppUserByUsername record);

    AppUserByUsername selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(AppUserByUsername record);

    int updateByPrimaryKey(AppUserByUsername record);

    /**
     * 根据用户名获取用户id
     * @param userName
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("userName")String userName);

	
}