package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.user.model.AppUserByEmail;
import org.apache.ibatis.annotations.Param;

public interface AppUserByEmailMapper extends BaseMapper<AppUserByEmail,String> {
    
    /**
     * 根据邮箱获取用户
     * @param email
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("email") String email);

	
}
