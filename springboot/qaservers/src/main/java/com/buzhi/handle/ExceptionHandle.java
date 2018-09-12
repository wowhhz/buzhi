package com.buzhi.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buzhi.exception.UserException;
import com.buzhi.model.Result;
import com.buzhi.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		logger.error("error", e);
		if(e instanceof UserException){
			UserException userException = (UserException)e;
			return ResultUtil.error(userException.getCode(), userException.getMessage());
		}else{
			return ResultUtil.error(100,e.getMessage());
		}
	}
}
