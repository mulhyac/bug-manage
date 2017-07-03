package com.sunny.bugmanage.user.controller;

import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.form.valid.RegisterGroups;
import com.sunny.bugmanage.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunny
 * @className com.sunny.bugmanage.user.controller.BugRegController
 * @date 2017-06-30 16:34
 * @description: 注册controller
 */
//@Api(value = "BugRegController", description = "注册相关接口")
@RestController
@RequestMapping("/reg")
public class BugRegController {
    @Autowired
    private AppUserService appUserService;

    //@ApiOperation(value = "注册用户", notes = "注册新用户")
    @PutMapping
    public BaseResult addAppUser(HttpServletRequest request, @RequestBody @Validated({RegisterGroups.class}) AppUserForm form) {

        return ResultUtils.success("注册成功", appUserService.addAppUser(request, form));
    }

    //@ApiOperation(value = "验证用户名是否存在", notes = "验证用户名是否存在")
    @GetMapping(value = "/check/{userName:.+}"/*,produces = {"application/json"}*/)
    public BaseResult checkUserName(@PathVariable("userName") String userName) {

        return appUserService.checkUserName(userName);
    }
}
