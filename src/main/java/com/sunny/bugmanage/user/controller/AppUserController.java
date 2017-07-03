package com.sunny.bugmanage.user.controller;

import com.sunny.bugmanage.common.aspects.cache.Cacheable;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.valid.SelectGroup;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.WeixinUser;
import com.sunny.bugmanage.user.service.AppUserService;
import com.sunny.bugmanage.common.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @name  AppUserController
 * @date 2017-06-3 09:09
 * @description:
 */
@Api(value = "AppUserController", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
    
    @ApiOperation(value = "获取全部用户", notes = "获取用户(支持分页、模糊搜索)")
    @RequestMapping(method = RequestMethod.GET)
    @Cacheable(value = "获取全部用户", key = "'#root.methodName_'+#form.getKey()+#form.getPageNum()+#form.getPageSize()")
    public BaseResult getAllAPPUser(@Validated({SelectGroup.class}) AppUserForm form) {

//        return ResultUtils.success(appUserService.getAllAPPUser(form));
        return ResultUtils.success(appUserService.getAllAPPUser(form));
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
