package com.my.ssm.core.util;

import java.io.Serializable;
import java.util.List;

/**
 * 封装返回值工具类
 * 
 * @ClassName  AppRespUtil        
 * 
 * @author WJ
 * @date   2019年5月14日 上午11:58:29   
 *
 */
public class AppRespUtil implements Serializable {
	private static final long serialVersionUID = -3353228144067312589L;
	
	private boolean rs;
	private String code;
	private String message;
	private Long count;
	private Object data;
	//private List<?> rows;

	public static AppRespUtil ok() {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		return apu;
	}

	public static AppRespUtil ok(String code) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		return apu;
	}

	public static AppRespUtil ok(String code, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil ok(Object data) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setData(data);
		return apu;
	}

	public static AppRespUtil ok(List<?> list) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setData(list);
		return apu;
	}

	public static AppRespUtil ok(String code, Object data) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		apu.setData(data);
		return apu;
	}

	public static AppRespUtil ok(String code, Object data, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		apu.setData(data);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil ok(String code, List<?> list) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		apu.setData(list);
		return apu;
	}

	public static AppRespUtil ok(String code, List<?> list, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCode(code);
		apu.setData(list);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil ok(Long count, List<?> list) {
		AppRespUtil apu = new AppRespUtil();
		apu.setCode(PConst.DEFALUT_0);
		apu.setMessage("");
		apu.setRs(true);
		apu.setCount(count);
		apu.setData(list);
		return apu;
	}

	public static AppRespUtil ok(Long count, List<?> list, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(true);
		apu.setCount(count);
		apu.setData(list);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil fail() {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		return apu;
	}

	public static AppRespUtil fail(String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil fail(String code, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil fail(List<?> list) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setData(list);
		return apu;
	}

	public static AppRespUtil fail(Object data) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setData(data);
		return apu;
	}

	public static AppRespUtil fail(String code, Object data) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);
		apu.setData(data);
		return apu;
	}

	public static AppRespUtil fail(String code, Object data, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);
		apu.setData(data);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil fail(String code, List<?> list) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);
		apu.setData(list);
		return apu;
	}

	public static AppRespUtil fail(String code, List<?> list, String message) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);
		apu.setData(list);
		apu.setMessage(message);
		return apu;
	}

	public static AppRespUtil fail(String code, Exception e) {
		AppRespUtil apu = new AppRespUtil();
		apu.setRs(false);
		apu.setCode(code);

		String message = e.getMessage();
		if (ToolsUtil.isNull(message)) {
			message = e.getClass().getCanonicalName();
		}
		apu.setMessage(message);
		return apu;
	}

	public boolean isRs() {
		return this.rs;
	}

	public void setRs(boolean rs) {
		this.rs = rs;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		if (ToolsUtil.isNotNull(message)) {
			if (message.length() > 500) {
				message = message.substring(0, 500) + "...";
			}
		}
		this.message = message;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/*public List<?> getRows() {
		return this.rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}*/
}
