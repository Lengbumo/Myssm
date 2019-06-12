package com.my.ssm.core.generator.code;

/**
 * 不显示在页面上的字段
 * 
 * @ClassName  HiddenEnum        
 * 
 * @author WJ
 * @date   2019年4月29日 下午3:17:20   
 *
 */
public enum HiddenEnum {

	ID,CORP_ID,CORP,ORGN_ID,ORGN,TS,RD,ACTIVE_FLAG,SAASID;
	
	/**
	 * 是否存在
	 * 
	 * @Title isInclude    
	 * @param key
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月29日 下午3:21:30
	 */
	public static boolean isInclude(String key){
        boolean include = false;
        for (HiddenEnum e: HiddenEnum.values()){
        	if (e.toString().equals(key) || key.contains("UDF")) {
            	include = true;
                break;
            }
        }
        return include;
    }
	
}
