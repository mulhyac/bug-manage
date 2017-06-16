package com.sunny.bugmanage.handle;

import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.exception.BugManageException;
import com.sunny.bugmanage.utils.ResultUtils;
import org.apache.ibatis.binding.BindingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sunny
 * @className com.sunny.bugmanage.handle.BugManageHandle
 * @date 2017-06-06 20:33
 * @description:
 */
@ControllerAdvice
public class BugManageHandle {
	private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BugManageHandle.class);

	@ExceptionHandler({ BindException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })//定义要处理的异常类
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResult validExceptionHandle(Exception ex) {

		if (ex instanceof BindException) {
			BindException bingException = (BindException) ex;
			return ResultUtils.error(ResultEnum.PARAMETER_ERROR, bingException.getAllErrors());
		} else if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
			return ResultUtils.error(ResultEnum.PARAMETER_ERROR, methodArgumentNotValidException.getBindingResult().getAllErrors());
		} else if (ex instanceof HttpMessageNotReadableException) {
			HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) ex;
			return ResultUtils.error(100, httpMessageNotReadableException.getMessage());
		} else {
			return ResultUtils.error(200, ex.getMessage());
		}
		/* else {
			throw new BugManageException(200, ex.getCause());
		}*/
	}

	@ExceptionHandler({ BugManageException.class, BindingException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResult ExceptionHandle(Exception ex) {
		if (ex instanceof BindingException) {
			BindingException bindingException = (BindingException) ex;
			return ResultUtils.error(100, bindingException.getMessage());
		} else {
			BugManageException bugManageException = (BugManageException) ex;
			return ResultUtils.error(bugManageException.getCode(), bugManageException.getMessage());
		}

	}

/*
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResult systemExceptionHandle(Exception ex) {
		return ResultUtils.error(200, ex.getMessage());
	}
*/

}
