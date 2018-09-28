package com.cobra.boot.commons;

import java.io.Serializable;

import org.springframework.util.StringUtils;


/**
 * @ClassName: ResponseResult
 * @Description: 通用的结果相应类
 * @Author: cobra
 * @Date: 2018年9月28日
 * @version: v1.0
 */
public class ResponseResult implements Serializable{
	private static final long serialVersionUID = 1L;
	public static String SUCCESS = "SUCCESS";
	public static String FAIL = "FAIL";
	private String code;
	private String msg;

	private static ResponseResult result = new ResponseResult();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static ResponseResult newInstance(String code, String msg) {
		result.setCode(StringUtils.isEmpty(code) ? ResponseResult.SUCCESS : code);
		result.setMsg(msg);
		return result;
	}
}
