package com.my.ssm.sec.model;

/**
 * 浏览器类
 * 
 * @ClassName:  BrowserModel   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月15日 下午2:51:16   
 *
 */
public class BrowserModel {

	private String broType; // 浏览器类型
	
	private String broversion; // 浏览器版本
	
	private String ip; // IP地址

    private String url; // 请求地址

	/**
	 * 浏览器类型
	 * 
	 * @Title: getBroType    
	 * @Desc:  
	 * @param: @return      
	 * @return: String      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午2:52:22
	 */
	public String getBroType() {
		return broType;
	}

	/**
	 * 浏览器类型
	 * 
	 * @Title: setBroType    
	 * @Desc:  
	 * @param: @param broType      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午2:52:28
	 */
	public void setBroType(String broType) {
		this.broType = broType;
	}

	/**
	 * 浏览器版本
	 * 
	 * @Title: getBroversion    
	 * @Desc:  
	 * @param: @return      
	 * @return: String      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午2:52:34
	 */
	public String getBroversion() {
		return broversion;
	}

	/**
	 * 浏览器版本
	 * 
	 * @Title: setBroversion    
	 * @Desc:  
	 * @param: @param broversion      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午2:52:38
	 */
	public void setBroversion(String broversion) {
		this.broversion = broversion;
	}

	/**
	 * IP地址
	 * 
	 * @Title getIp    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:10:04
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP地址
	 * 
	 * @Title setIp    
	 * @param ip          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:10:13
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 请求地址
	 * 
	 * @Title getUrl    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:10:18
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 请求地址
	 * 
	 * @Title setUrl    
	 * @param url          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:10:26
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
