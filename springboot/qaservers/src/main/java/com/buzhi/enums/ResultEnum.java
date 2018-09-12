package com.buzhi.enums;

public enum ResultEnum {
	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0, "成功"),
	USER_ERROR_NOUSER(1,"用户不存在"),
	USER_ERROR_LOGIN_FAIL(2,"用户信息错误"),
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
