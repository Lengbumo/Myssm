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
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.my.ssm.core.advice.util.AdviceUtil;
import com.my.ssm.core.basic.model.BasicModel;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;

/**
 * 调用mapper方法前拦截
 * 
 * @ClassName  DaoBeforeAdvice        
 * 
 * @author WJ
 * @date   2019年5月6日 下午2:36:10   
 *
 */
public class DaoBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (args == null) {
			return;
		}

		Date date = DateUtil.getNow();
		String userName = AdviceUtil.getUserName();
		String name = method.getName();
		if (name.startsWith(PConst.OPERATE_TYPE_INSERT)) {
			for (Object arg : args) {
				if (arg instanceof BasicModel) {
					BasicModel entity = (BasicModel) arg;
					entity.setCreatedDate(date);
					entity.setCreatedBy(userName);
					entity.setModifiedDate(date);
					entity.setModifiedBy(userName);
				}
			}
		} else if (name.startsWith(PConst.OPERATE_TYPE_UPDATE)) {
			for (Object arg : args) {
				if (arg instanceof BasicModel) {
					BasicModel entity = (BasicModel) arg;
					entity.setCreatedBy(null);
					entity.setCreatedDate(null);
					entity.setModifiedDate(date);
					entity.setModifiedBy(userName);
				}
			}
		}
	}

}
