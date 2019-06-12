
package com.my.ssm.sec.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sec.model.UserDetailsBeanModel;

/**
 * 系统信息工具类
 * 
 * @ClassName  MiscUtil        
 * 
 * @author WJ
 * @date   2019年5月5日 下午4:32:05   
 *
 */
public class MiscUtil {

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private static Object getPrincipal() {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            return authentication.getPrincipal();
        }

        return null;
    }

    public static Long getUserId() {
        Long userId = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            userId = ((UserDetailsBeanModel) principal).getUserId();
        }

        return userId;
    }

    public static String getUserCode() {
        String usercode = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            usercode = ((UserDetailsBeanModel) principal).getUsername();
        }

        return usercode;
    }

    /** 获取中文登陆名*/
    public static String getUserNameZ() {
        String usernamez = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            usernamez = ((UserDetailsBeanModel) principal).getUsernamez();
        }

        return usernamez;
    }

    /** 获取英文登陆名*/
    public static String getUserNamee() {
        String usernamee = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            usernamee = ((UserDetailsBeanModel) principal).getUsernamee();
        }

        return usernamee;
    }

    public static String getUserDescr() {
        String userdescr = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            userdescr = ((UserDetailsBeanModel) principal).getUserdescr();
        }

        return userdescr;
    }

    public static String getSaasid() {
        String saasid = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            saasid = ((UserDetailsBeanModel) principal).getSaasid();
        }

        return saasid;
    }

    public static Long getCorpId() {
        Long corpId = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            corpId = ((UserDetailsBeanModel) principal).getCorpId();
        }

        return corpId;
    }

    public static String getCorp() {
        String corp = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            corp = ((UserDetailsBeanModel) principal).getCorp();
        }

        return corp;
    }

    public static Long getOrgnId() {
        Long orgnId = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            orgnId = ((UserDetailsBeanModel) principal).getOrgnId();
        }

        return orgnId;
    }

    public static String getOrgn() {
        String orgn = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            orgn = ((UserDetailsBeanModel) principal).getOrgn();
        }

        return orgn;
    }

    public static boolean isAdmin() {
        boolean flag = false;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            flag = ((UserDetailsBeanModel) principal).getAdmin();
        }

        return flag;
    }

    public static String getToken() {
        String token = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            token = ((UserDetailsBeanModel) principal).getToken();
        }

        return token;
    }

    public static BrowserModel getBrowser() {
    	BrowserModel browser = null;
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            browser = ((UserDetailsBeanModel) principal).getBrowser();
        }

        return browser;
    }

    public static void setBrowser(BrowserModel browser) {
        Object principal = getPrincipal();
        if (principal instanceof UserDetailsBeanModel) {
            ((UserDetailsBeanModel) principal).setBrowser(browser);
        }
    }

}
