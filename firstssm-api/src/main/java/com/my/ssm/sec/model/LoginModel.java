package com.my.ssm.sec.model;

import java.util.Date;

/**
 * 用户登录信息
 * 
 * @ClassName  LoginModel        
 * 
 * @author WJ
 * @date   2019年4月18日 下午5:24:39   
 *
 */
public class LoginModel {

    private String username; // 用户名
    private String password; // 密码
    private String refPasssword; // 确认密码
    private String verifycode;// 验证码
    private Date billdate; // 业务操作时间
    private String language; //默认语言

    private BrowserModel bvo; // 浏览器信息

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRefPasssword() {
        return refPasssword;
    }

    public void setRefPasssword(String refPasssword) {
        this.refPasssword = refPasssword == null ? null : refPasssword.trim();
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode == null ? null : verifycode.trim();
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public BrowserModel getBvo() {
        return bvo;
    }

    public void setBvo(BrowserModel bvo) {
        this.bvo = bvo;
    }

}
