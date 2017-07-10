package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.user.model.AppUserByUsername;
import org.apache.ibatis.annotations.Param;

public interface AppUserByUsernameMapper extends BaseMapper<AppUserByUsername,String> {
    
    /**
     * 根据用户名获取用户id
     * @param userName
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("userName")String userName);

	
}
