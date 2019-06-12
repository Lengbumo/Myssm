/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.sec.service;

import org.springframework.security.core.Authentication;

import com.my.ssm.sec.model.LoginModel;

/**
 * 用户信息认证业务接口
 * 
 * @ClassName  SecurityService        
 * 
 * @author WJ
 * @date   2019年4月18日 下午5:28:51   
 *
 */
public interface SecurityService {

    /**
     * 用户信息认证
     * 
     * @Title authenticate    
     * @param lv
     * @return          
     *  
     * @author WJ
     * @date   2019年4月18日 下午5:29:02
     */
    Authentication authenticate(LoginModel lv);

}
