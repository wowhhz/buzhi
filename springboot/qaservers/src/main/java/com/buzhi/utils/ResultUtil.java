package com.buzhi.utils;

import com.buzhi.enums.ResultEnum;
import com.buzhi.model.Result;

public class ResultUtil {
	
	public static Result success(Object object){
		Result result = new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}
	
	public static Result success(){
		return success("");
	}

	public static Result error(Integer code,String msg){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static Result error(ResultEnum enums){
		Result result = new Result();
		result.setCode(enums.getCode());
		result.setMsg(enums.getMsg());
		return result;
	}
}
