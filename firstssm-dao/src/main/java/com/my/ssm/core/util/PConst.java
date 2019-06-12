package com.my.ssm.core.util;

import org.springframework.context.ApplicationContext;

/**
 *  系统枚举类型
 * 
 * @ClassName:  Const   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月16日 上午11:33:17   
 *
 */
public class PConst {
	
	/** 环境变量 */
    public static final String APP_CTX = "CTX_PATH";
    public static final String APP_KEYWORDS = "KEYWORDS";
    public static final String APP_DESCRIPTION = "DESCRIPTION";
    public static final String APP_WEBLINK = "WEBLINK";
    public static final String APP_WEBNAME = "WEBNAME";
    public static final String APP_WEBLOGO = "WEBLOGO";
    public static final String JS_VERSION = "JS_VERSION";
    public static final String CSS_VERSION = "CSS_VERSION";
    public static final String APP_KEYWORDS_KEY = "WEB.KEYWORDS";
    public static final String APP_DESCRIPTION_KEY = "WEB.DESCRIPTION";
    public static final String APP_WEBLINK_KEY = "WEB.LINK";
    public static final String APP_WEBNAME_KEY = "WEB.NAME";
    public static final String APP_WEBLOGO_KEY = "WEB.LOGO";
    public static final String JS_VERSION_KEY = "JS.VERSION";
    public static final String CSS_VERSION_KEY = "CSS.VERSION";
    /**该值会在web容器启动时由WebAppContextListener初始化*/
    public static ApplicationContext WEB_APP_CONTEXT = null;
    public static String APP_CTX_VALUE = null;
    
    /** 用户认证信息 */
    public static final String _SECURITY_USER = "_SECURITY_USER_";
    public static final String _SECURITY_CODE = "_SECURITY_CODE_";
	
	/** 冒号 */
	public static final String COLON = ":";
	/** 逗号 */ 
	public static final String COMMA = ",";
	/** / */
	public static final String LEFT_SLASH = "/";
	/** . */
	public static final String SPOT = ".";
	
	// 字段类型
	public static final String VARCHAR = "VARCHAR";
	public static final String DECIMAL = "DECIMAL";
	public static final String NUMBER = "NUMBER";
	
	// 布尔值
	public static final String BOOLEAN_Y = "Y";
	public static final String BOOLEAN_N = "N";
	
	// 浏览器类型
	public static final String MSIE = "msie";
	public static final String TRIDENT = "trident";
	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String EDGE = "edge";
	public static final String OPERA = "opera";
	public static final String SAFARI = "safari";
	
	/** 系统固定参数 */
    public static final String SYS_REGULAR_PARAM = "_PARAM";
    
    /** 日期格式 */
    public static final String DATE_FORMATTER_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMATTER_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    /**默认值*/
    public static final String DEFALUT_0 = "0";
    public static final String DEFALUT_1 = "1";
    public static final String DEFALUT_2 = "2";
    public static final String DEFALUT_3 = "3";
    public static final String DEFALUT_4 = "4";
    public static final String DEFALUT_5 = "5";
    public static final String DEFALUT_6 = "6";
    public static final String DEFALUT_7 = "7";
    public static final String DEFALUT_8 = "8";
    public static final String DEFALUT_9 = "9";
    
    /**操作方式*/
    public static final String OPERATOR_TYPE = "OPERATOR_TYPE";// 操作方式
    public static final String OPERATOR_TYPE_PC = "PC";// PC
    public static final String OPERATOR_TYPE_RF = "RF";// RF
    public static final String OPERATOR_TYPE_APP = "APP";// APP
    public static final String OPERATOR_TYPE_WS = "WS";// WS
    
    /**方法类型*/
    public static final String OPERATE_TYPE_INSERT = "insert";
    public static final String OPERATE_TYPE_UPDATE = "update";
    
    /**项目模块*/
    public static final String MODULE_CODE_LOGIN = "login";
    public static final String MENU_CODE_LOGIN = "SEC_LOGIN";
    public static final String MENU_NAME_LOGIN = "用户登录";
    public static final String MODULE_CODE_LOGIN_OUT = "logout";
    public static final String MENU_CODE_LOGIN_OUT = "SEC_LOGOUT";
    public static final String MENU_NAME_LOGIN_OUT = "用户登出";
}
