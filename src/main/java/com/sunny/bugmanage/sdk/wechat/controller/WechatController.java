package com.sunny.bugmanage.sdk.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunny
 * @className com.sunny.bugmanage.sdk.wechat.controller.WechatController
 * @date 2017-06-20 14:09
 * @description:
 */
//@Api(value = "WechatController", description = "微信登录接口")
@RestController
@RequestMapping("/wechat")
public class WechatController {
	
	//@ApiOperation(value = "获取code", notes = "获取code码")
	@GetMapping("/login")
	@SuppressWarnings("rawtypes")
	public String login(HttpServletRequest req, String code) {
		String signature=req.getParameter("signature");
		String echostr=req.getParameter("echostr");
		String timestamp=req.getParameter("timestamp");
		String nonce=req.getParameter("nonce");
		System.out.println(signature+"--"+echostr+"--"+timestamp+"--"+nonce);
		/**
		 * signature:5a10062606961f14b161fc0c74f3d2a1a7d9c0e6
		 echostr:3487097529840754395
		 timestamp:1497944795
		 nonce:1902691782
		 */


		return echostr;
	}  
	

}
