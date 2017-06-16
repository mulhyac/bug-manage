package com.sunny.bugmanage.user.mapper;
import com.sunny.bugmanage.user.model.AppUserByEmail;
import org.apache.ibatis.annotations.Param;

public interface AppUserByEmailMapper {
    int deleteByPrimaryKey(String email);

    int insert(AppUserByEmail record);

    int insertSelective(AppUserByEmail record);

    AppUserByEmail selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(AppUserByEmail record);

    int updateByPrimaryKey(AppUserByEmail record);

    /**
     * 根据邮箱获取用户
     * @param email
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("email") String email);

	
}