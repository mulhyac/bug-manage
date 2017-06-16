package com.sunny.bugmanage.common.enums;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.enums.ResultEnum
 * @date 2017-06-06 14:25
 * @description:
 */
public enum ResultEnum {
	/**
	 * 成功
	 */
	SUCCESS(0, "成功!"),
	/**
	 * 账号不存在
	 */
	USER_NAME_NOT_EXIST(1,"账号不存在"),
	/**
	 * 账号不存在
	 */
	POSSWORD_ERROR(2,"密码错误"),
	/**
	 *   注册用户异常
	 */
	INSERT_APP_USER_ERROR(3,"注册用户异常" ),
	/**
	 * 账号存在
	 */
	USER_NAME_EXIST(4,"账号已经存在"),
	/**
	 * 参数异常
	 */
	PARAMETER_ERROR(100,"参数异常!"), ;
	private Integer code;
	private String msg;

	ResultEnum (Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode () {
		return code;
	}
	public String getMsg () {
		return msg;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
