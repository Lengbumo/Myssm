package com.my.ssm.core.generator.code;

/**
 * 公共的字段
 * 
 * @ClassName  PublicEnum        
 * 
 * @author WJ
 * @date   2019年4月29日 下午3:17:20   
 *
 */
public enum PublicEnum {

	ID,CORP_ID,CORP,ORGN_ID,ORGN,TS,RD,ACTIVE_FLAG,CREATED_BY,REMARK,CREATED_DATE,MODIFIED_BY,MODIFIED_DATE,SAASID;
	
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
        for (PublicEnum e: PublicEnum.values()){
        	if (e.toString().equals(key)) {
            	include = true;
                break;
            }
        }
        return include;
    }
	
}
