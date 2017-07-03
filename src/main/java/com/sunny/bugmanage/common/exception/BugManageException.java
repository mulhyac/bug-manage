package com.sunny.bugmanage.common.exception;

import com.sunny.bugmanage.common.enums.ResultEnum;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.exception.BugManageException
 * @date 2017-06-06 20:29
 * @description:
 */
public class BugManageException extends RuntimeException{
	private Integer code;

	public BugManageException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public BugManageException(String msg) {
		super(msg);
	}

	public BugManageException(ResultEnum resultEnum, Throwable cause) {

		super(cause.getMessage() + resultEnum.getMsg(), cause);
		this.code = resultEnum.getCode();
	}
	
	public BugManageException(Integer code,Throwable cause) {
		super(cause);
		this.code = code;
	}

	public BugManageException(ResultEnum resultEnum, Object obj) {
		super(resultEnum.getMsg() + obj);
		this.code = resultEnum.getCode();
	}

	public BugManageException(Integer code, String msg) {
		super(msg);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
