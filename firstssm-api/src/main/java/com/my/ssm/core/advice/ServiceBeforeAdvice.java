/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.core.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.my.ssm.core.advice.util.AdviceUtil;
import com.my.ssm.sec.util.MiscUtil;

/**
 * 调用service方法前拦截
 * 
 * @ClassName  ServiceBeforeAdvice        
 * 
 * @author WJ
 * @date   2019年5月6日 下午2:23:03   
 *
 */
public class ServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (args == null) {
            return;
        }

        Long userId = MiscUtil.getUserId();
        String userCode = MiscUtil.getUserCode();
        String userName = MiscUtil.getUserNameZ();
        AdviceUtil.setTrackUser(userId, userCode, userName);
    }

}
