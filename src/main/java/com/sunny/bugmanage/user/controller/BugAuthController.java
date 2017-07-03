package com.sunny.bugmanage.user.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.form.valid.LoginGroups;
import com.sunny.bugmanage.user.service.AppUserService;
import com.sunny.bugmanage.common.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunny
 * @className com.sunny.bugmanage.user.controller.BugAuthController
 * @date 2017-06-30 16:33
 * @description:
 */
@Api(value = "BugAuthController", description = "登录相关接口")
@RestController
@RequestMapping("/auth")
public class BugAuthController {
    @Autowired
    private AppUserService appUserService;

    @ApiOperation(value = "登录", notes = "根据用户名密码获取用户")
    @PostMapping("/login")
    public BaseResult login(HttpServletRequest request, @RequestBody @Validated({LoginGroups.class}) AppUserForm form) {

        return ResultUtils.success("登录成功", appUserService.login(request, form));
    }

}
