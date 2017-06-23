package com.sunny.bugmanage.user.service;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.vo.AppUserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
	 * 添加app_user
	 * @param request
	 * @param form
	 * @return
	 */
	AppUserVo addAppUser(HttpServletRequest request, AppUserForm form);

	/**
	 * 根据用户名获取用户id 
	 * @param userName
	 * @return
	 */
	Long getAppUserIdByUserName(String userName);

	/**
	 * 获取全部app用户
	 * @param form
	 * @return
	 */
	List<AppUserVo> getAllAPPUser(AppUserForm form);

	/**
	 * 检查用户名是否存在
	 * @param userName
	 * @return
	 */
	BaseResult checkUserName(String userName);
}
