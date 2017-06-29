package com.sunny.bugmanage.user.controller;

import com.sunny.bugmanage.common.aspects.cache.Cacheable;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.valid.SelectGroup;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.form.valid.LoginGroups;
import com.sunny.bugmanage.user.form.valid.RegisterGroups;
import com.sunny.bugmanage.user.model.WeixinUser;
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
    public BaseResult login(HttpServletRequest request, @RequestBody @Validated({LoginGroups.class}) AppUserForm form) {

        return ResultUtils.success("登录成功", appUserService.login(request, form));
    }

    @ApiOperation(value = "注册用户", notes = "注册新用户")
    @PutMapping
    public BaseResult addAppUser(HttpServletRequest request, @RequestBody @Validated({RegisterGroups.class}) AppUserForm form) {

        return ResultUtils.success("注册成功", appUserService.addAppUser(request, form));
    }

    @ApiOperation(value = "获取全部用户", notes = "获取用户(支持分页、模糊搜索)")
    @RequestMapping(method = RequestMethod.GET)
    @Cacheable(value = "获取全部用户", key = "'#root.methodName_'+#form.getKey()+#form.getPageNum()+#form.getPageSize()")
    public BaseResult getAllAPPUser(@Validated({SelectGroup.class}) AppUserForm form) {

//        return ResultUtils.success(appUserService.getAllAPPUser(form));
        return ResultUtils.success(appUserService.getAllAPPUser(form));
    }

    @ApiOperation(value = "查询用户名是否存在", notes = "查询用户名是否存在")
    @GetMapping(value = "/check/{userName:.+}"/*,produces = {"application/json"}*/)
    public BaseResult checkUserName(@PathVariable("userName") String userName) {


        return appUserService.checkUserName(userName);
    }

    @ApiOperation(value = "查询用户名是否存在", notes = "查询用户名是否存在")
    @GetMapping(value = "/code",produces = {"application/json"})
    public BaseResult getCode(String code) {
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1b35d0bff220017e&redirect_uri=http://zyx.tunnel.ifugle.cn/bug/main/user/code&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect



        System.out.println("code："+code);
  /*      String appId="wx3a81fc983840e341";
        String appsecret="70b61b4b8fb6a9eef82ccfb626324328";


        //access_token
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";

        JsonObject json= HttpHelperUtils.sendGet(url);

        String access_token= json.getAsJsonPrimitive("access_token").getAsString();
        String openid=  json.getAsJsonPrimitive("openid").getAsString();

        url="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
        json= HttpHelperUtils.sendGet(url);
*/


        WeixinUser user= new WeixinUser();
       /* user.setCity(json.getAsJsonPrimitive("city").getAsString());
        user.setCountry(json.getAsJsonPrimitive("country").getAsString());
        user.setSex(json.getAsJsonPrimitive("sex").getAsInt());
        user.setOpenid(json.getAsJsonPrimitive("openid").getAsString());
        user.setHeadimgurl(json.getAsJsonPrimitive("headimgurl").getAsString());
        user.setUnionid(json.getAsJsonPrimitive("unionid").getAsString());
        user.setLanguage(json.getAsJsonPrimitive("language").getAsString());*/
        return ResultUtils.success(user);
    }
}
