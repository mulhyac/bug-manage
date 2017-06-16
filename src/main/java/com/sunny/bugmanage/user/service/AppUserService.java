package com.sunny.bugmanage.user.service;

import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.vo.AppUserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunny on 2017/6/6.
 */
public interface AppUserService {
	/**
	 * 登录
	 *
	 * @param request
	 * @param form
	 *
	 * @return
	 */
	AppUserVo login(HttpServletRequest request, AppUserForm form);

	/**
	 * 根据用户id获取用户详情
	 * @param id
	 * @return
	 */
	AppUserVo getAppUserById(Long id);

	/**
	 * 添加appuser
	 * @param request
	 * @param form
	 * @return
	 */
	AppUserVo addAppUser(HttpServletRequest request, AppUserForm form);
	
}
