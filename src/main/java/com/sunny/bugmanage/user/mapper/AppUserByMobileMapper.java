package com.sunny.bugmanage.user.mapper;
import com.sunny.bugmanage.user.model.AppUserByMobile;
import org.apache.ibatis.annotations.Param;

public interface AppUserByMobileMapper {
    int deleteByPrimaryKey(String mobile);

    int insert(AppUserByMobile record);

    int insertSelective(AppUserByMobile record);

    AppUserByMobile selectByPrimaryKey(String mobile);

    int updateByPrimaryKeySelective(AppUserByMobile record);

    int updateByPrimaryKey(AppUserByMobile record);

    /**
     * 根据手机号获取用户id
     * @param mobile
     * @return
     */
    Long selectAppUserIdByPrimaryKey(@Param("mobile") String mobile);

	
}