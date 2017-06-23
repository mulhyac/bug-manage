package com.sunny.bugmanage.user.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.form.valid.LoginGroups;
import com.sunny.bugmanage.user.form.valid.RegisterGroups;
import com.sunny.bugmanage.user.service.AppUserService;
import com.sunny.bugmanage.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunny on 2017/6/6.
 */
@Api(value = "AppUserController", description = "用户相关接口")
@RestController
@RequestMapping("/main/user")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;

	@ApiOperation(value = "登录", notes = "根据用户名密码获取用户")
	@PostMapping("/login")
	public BaseResult login(HttpServletRequest request, @RequestBody @Validated({ LoginGroups.class }) AppUserForm form) {

		return ResultUtils.success("登录成功", appUserService.login(request, form));
	}

	@ApiOperation(value = "注册用户", notes = "注册新用户")
	@PutMapping
	public BaseResult addAppUser(HttpServletRequest request, @RequestBody @Validated({ RegisterGroups.class }) AppUserForm form) {

		return ResultUtils.success("注册成功", appUserService.addAppUser(request, form));
	}

	@ApiOperation(value = "获取用户", notes = "获取用户(支持分页、模糊搜索)")
	@GetMapping
	public BaseResult getAllAPPUser( @RequestBody @Validated({ RegisterGroups.class }) AppUserForm form) {

		return ResultUtils.success("注册成功", appUserService.getAllAPPUser(form));
	}
	@ApiOperation(value = "查询用户名是否存在", notes = "查询用户名是否存在")
	@GetMapping(value = "/check/{userName:.+}"/*,produces = {"application/json"}*/)
	public BaseResult checkUserName(@PathVariable("userName") String userName) {

		return appUserService.checkUserName(userName);
	}
}
