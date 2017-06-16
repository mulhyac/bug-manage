package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.model.AppUser;
import com.sunny.bugmanage.user.model.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;

public interface AppUserMapper {
	int deleteByPrimaryKey(String id);

	int insert(AppUser record);

	int insertSelective(AppUser record);

	AppUser selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(AppUser record);

	int updateByPrimaryKey(AppUser record);

	/**
	 * 根据id获取用户
	 *
	 * @param id
	 *
	 * @return
	 */
	AppUserVo findAppUserVoByPrimaryKey(@Param("id") Long id, @Param("status") Byte status);

}