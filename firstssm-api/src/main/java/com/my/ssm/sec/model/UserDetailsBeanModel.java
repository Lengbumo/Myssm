/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.sec.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.ToolsUtil;
import com.my.ssm.sys.model.User;


/**
 * 用户认证信息
 * 
 * @ClassName  UserDetailsBeanModel        
 * 
 * @author WJ
 * @date   2019年4月18日 下午4:42:43   
 *
 */
public class UserDetailsBeanModel implements UserDetails {
    private static final long serialVersionUID = 4183019465820875334L;

    private Long userId;
    private String username;
    private String usernamez;
    private String usernamee;
    private String password;
    private String userdescr;
    private String salt;
    private Boolean admin;
    private List<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String language; // 语言
    private String loginType; // PC/RF/APP/WS
    private String token; // 终端TOKEN
    private String usetType; // 用户类型
    private Date bdate; // 业务时间(该时间在登录的时候获取)
    private String saasid;
    private Long ts;
    private String facePath; // 头像路径

    private Long corpId;
    private String corp;
    private Long orgnId;
    private String orgn;
    private BrowserModel browser;

    private String defWhCode; // 默认仓库(仅供APP使用)

    public UserDetailsBeanModel(String username, String loginType, Date bdate, User user, BrowserModel browser,
            List<String> authorities) {
        this(username, loginType, bdate, user, browser, authorities, true, true, true, true);
    }

    private UserDetailsBeanModel(String username, String loginType, Date bdate, User user, BrowserModel browser,
            List<String> authorities, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked) {

        // 是否管理员处理
        String adminFlag = user.getAdminFlag();
        boolean isAdmin = (ToolsUtil.isNull(adminFlag) || PConst.BOOLEAN_N.equals(adminFlag)) ? false : true;

        this.userId = user.getId();
        this.username = username;
        this.usernamez = user.getUserName();
        this.usernamee = user.getUserEname();
        this.userdescr = user.getUserDescr();
        this.password = user.getPcPassword();
        this.salt = user.getSalt();
        this.admin = isAdmin;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = new ArrayList<GrantedAuthority>();

        this.loginType = loginType;
        this.usetType = user.getUserType();
        this.bdate = bdate;
        this.saasid = user.getSaasid();
        this.facePath = user.getFaceImg();
        this.corpId = user.getCorpId();
        this.corp = user.getCorp();
        this.orgnId = user.getOrgnId();
        this.orgn = user.getOrgn();
        this.browser = browser;

        authorities = authorities == null ? new ArrayList<String>() : authorities;
        for (String auth : authorities) {
            this.authorities.add(new SimpleGrantedAuthority("ROLE_" + auth));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsernamez() {
        return usernamez;
    }

    public String getUsernamee() {
        return usernamee;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getUserdescr() {
        return userdescr;
    }

    public String getSalt() {
        return salt;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getLoginType() {
        return loginType;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getUsetType() {
        return usetType;
    }

    public String getSaasid() {
        return saasid;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getFacePath() {
        return facePath;
    }

    public Long getCorpId() {
        return corpId;
    }

    public String getCorp() {
        return corp;
    }

    public Long getOrgnId() {
        return orgnId;
    }

    public String getOrgn() {
        return orgn;
    }

    public BrowserModel getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserModel browser) {
        this.browser = browser;
    }

    public String getDefWhCode() {
        return defWhCode;
    }

    public void setDefWhCode(String defWhCode) {
        this.defWhCode = defWhCode;
    }

}
