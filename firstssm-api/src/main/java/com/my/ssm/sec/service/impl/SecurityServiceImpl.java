/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.sec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.ssm.core.exception.BizException;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.ToolsUtil;
import com.my.ssm.sec.model.AuthenticationModel;
import com.my.ssm.sec.model.LoginModel;
import com.my.ssm.sec.model.UserDetailsBeanModel;
import com.my.ssm.sec.service.SecurityService;
import com.my.ssm.sys.model.User;
import com.my.ssm.sys.service.OperationLogService;
import com.my.ssm.sys.service.UserService;


/**
 * 用户信息认证业务接口实现类
 * 
 * @ClassName  SecurityServiceImpl        
 * 
 * @author WJ
 * @date   2019年4月18日 下午5:29:57   
 *
 */
@SuppressWarnings("deprecation")
@Service
public class SecurityServiceImpl implements SecurityService {

	private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private OperationLogService operationLogService;

    @Override
    public Authentication authenticate(LoginModel lv) {
        String loginName = lv.getUsername();
        String password = lv.getPassword();
        Date bdate = lv.getBilldate();

        // 用户名密码校验
        if (ToolsUtil.isNull(loginName)) {
            throw new BizException("E00001", "用户不能为空");
        }
        if (ToolsUtil.isNull(password)) {
            throw new BizException("E00001", "密码不能为空");
        }

        // 获取用户名
        User user = userService.getByUserCode(loginName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名【" + loginName + "】不存在");
        }

        // 验证用户是否运行登录
        if (!PConst.BOOLEAN_Y.equals(user.getAfPc()) && !PConst.BOOLEAN_Y.equals(user.getAdminFlag())) {
            throw new BizException("E00001", "该账户禁止登录,如有疑问请联系管理员");
        }

        // 密码加密处理
        String passwordHash = user.getPcPassword();
        String salt = user.getSalt();
        String encodePassword = passwordEncoder.encodePassword(password, salt);

        // 验证密码是否相等
        if (!StringUtils.equals(passwordHash, encodePassword)) {
            throw new BadCredentialsException("密码错误");
        }

        // 权限设置
        List<String> authorities = new ArrayList<String>();

        // 缓存用户信息
        UserDetailsBeanModel principal = new UserDetailsBeanModel(loginName, PConst.OPERATOR_TYPE_PC, bdate, user,
                lv.getBvo(), authorities);

        AuthenticationModel authentication = new AuthenticationModel(principal);
        authentication.setAuthenticated(true);
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);

        // 写入登录日志
        operationLogService.execLogIn(user, lv.getBvo());

        // 更新最后一次的登录时间
        user.setLastDate(DateUtil.getNow());
        userService.updateByPrimaryKey(user);

        return authentication;
    }

    //***************************GET/SET*******************************
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

}
