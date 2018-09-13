package com.buzhi.enums;

public enum ResultEnum {
	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0, "成功"),
	USER_ERROR_NOUSER(1,"用户不存在"),
	USER_ERROR_LOGIN_FAIL(2,"用户信息错误"),
	USER_ERROR_EXIST(3,"用户已存在"),
	USER_ERROR_SIGN_FAIL(4,"注册失败"),
	
	CONTENT_NODATA(100,"查无记录"),
	COMMENT_NODATA(200,"评论不存在"),
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
