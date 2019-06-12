package com.my.ssm.core.advice.util;

import com.my.ssm.core.advice.vo.SysTrackUser;
import com.my.ssm.core.util.ToolsUtil;

/**
 * 拦截器工具
 * 
 * @ClassName AdviceUtil
 * 
 * @author WJ
 * @date 2019年5月6日 下午2:25:15
 *
 */
public class AdviceUtil {

	private static final ThreadLocal<SysTrackUser> tlTackUser = new ThreadLocal<SysTrackUser>();

	private static SysTrackUser getSysTrackUser() {
		SysTrackUser sysTrackUser = (SysTrackUser) tlTackUser.get();
		if (sysTrackUser == null) {
			sysTrackUser = new SysTrackUser();
			tlTackUser.set(sysTrackUser);
		}

		return sysTrackUser;
	}

	public static void setTrackUser(Long userId) {
		SysTrackUser sysTrackUser = getSysTrackUser();
		sysTrackUser.setUserId(userId);
	}

	public static void setTrackUser(Long userId, String userCode) {
		SysTrackUser sysTrackUser = getSysTrackUser();
		sysTrackUser.setUserId(userId);
		sysTrackUser.setUserCode(userCode);
	}

	public static void setTrackUser(Long userId, String userCode, String userName) {
		SysTrackUser sysTrackUser = getSysTrackUser();
		sysTrackUser.setUserId(userId);
		sysTrackUser.setUserCode(userCode);
		sysTrackUser.setUserName(userName);
	}

	public static Long getUserId() {
		return getSysTrackUser().getUserId();
	}

	public static String getUserCode() {
		String userCode = getSysTrackUser().getUserCode();
		return ((ToolsUtil.isNull(userCode)) ? "SYSTEM" : userCode);
	}

	public static String getUserName() {
		String userName = getSysTrackUser().getUserName();
		return ((ToolsUtil.isNull(userName)) ? "SYSTEM" : userName);
	}

}
