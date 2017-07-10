package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.user.model.AppUserByMobile;
import org.apache.ibatis.annotations.Param;

public interface AppUserByMobileMapper extends BaseMapper<AppUserByMobile,String> {
   
    /**
     * 根据手机号获取用户id
     * @param mobile
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("mobile") String mobile);

	
}
