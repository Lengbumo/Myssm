package com.my.ssm.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sec.util.MiscUtil;

/**
 * 浏览器相关的工具类
 * 
 * @ClassName BrowserUtil
 * 
 * @author WJ
 * @date 2019年4月17日 下午2:19:43
 *
 */
public class BrowserUtil {

	private static String UNKNOWN = "unknown";

	/**
	 * 获取用户真实IP地址
	 * 
	 * @Title getIpAddr
	 * @param request
	 * @return
	 * 
	 * @author WJ
	 * @date 2019年4月17日 下午2:08:33
	 */
	public static String getIpAddr(HttpServletRequest request) {
		// 不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
		// 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
		String ip = request.getHeader("x-forwarded-for");

		if (!ToolsUtil.isNull(ip) && !UNKNOWN.equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			if (ip.indexOf(PConst.COMMA) != -1) {
				ip = ip.split(PConst.COMMA)[0];
			}
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ToolsUtil.isNull(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 获取浏览器类型、版本等信息
	 * 
	 * @Title getUserAgentModel
	 * @param request
	 * @return
	 * 
	 * @author WJ
	 * @date 2019年4月26日 上午11:03:43
	 */
	public static BrowserModel getUserAgentModel(HttpServletRequest request) {
		if (request == null) {
			return null;
		}

		String userAgent = request.getHeader("user-agent");
		String s;
		BrowserModel browser = new BrowserModel();
		String msieP = "msie ([\\d.]+)";
		String edgP = "edge\\/([\\d.]+)";
		String firefoxP = "firefox\\/([\\d.]+)";
		String chromeP = "chrome\\/([\\d.]+)";
		String operaP = "opera.([\\d.]+)";
		String safariP = "version\\/([\\d.]+)";
		Pattern pattern = null;
		Matcher mat = null;
		// 一律转成小写
		String str = userAgent.toLowerCase();

		// 默认为其他浏览器 防止后续识别代码错误
		browser.setBroType("other");
		browser.setBroversion("0.0");

		try {
			// ie
			// 9.0 mozilla/5.0 (compatible; msie 9.0; windows nt 10.0;)
			// 11.0 mozilla/5.0 (windows nt 10.0; rv:11.0) like gecko
			if (str.indexOf(PConst.MSIE) >= 0 || str.indexOf(PConst.TRIDENT) >= 0) {
				// 判断是否IE<11浏览器
				boolean isIE = str.indexOf("compatible") > -1 && str.indexOf("msie") > -1;
				boolean isIE11 = str.indexOf("trident") > -1 && str.indexOf("rv:11.0") > -1;
				if (isIE) {
					pattern = Pattern.compile(msieP);
					mat = pattern.matcher(str);
					if (mat.find()) {
						s = mat.group();
						browser.setBroversion(s.substring(s.indexOf("msie") + 4).split(" ")[1]);
					}
				} else if (isIE11) {
					browser.setBroversion("11.0");
				}

				browser.setBroType("ie");
			}
			// firefox
			// mozilla/5.0 (windows nt 10.0; win64; x64; rv:66.0) gecko/20100101
			// firefox/66.0
			else if (str.indexOf(PConst.FIREFOX) >= 0) {
				pattern = Pattern.compile(firefoxP);
				mat = pattern.matcher(str);
				if (mat.find()) {
					s = mat.group();
					browser.setBroversion(s.split("/")[1]);
				}

				browser.setBroType("firefox");
			}
			// chrome
			// mozilla/5.0 (windows nt 10.0; wow64) applewebkit/537.36 (khtml, like gecko)
			// chrome/69.0.3497.100 safari/537.36
			else if (str.indexOf(PConst.CHROME) >= 0) {
				pattern = Pattern.compile(chromeP);
				mat = pattern.matcher(str);
				if (mat.find()) {
					s = mat.group();
					browser.setBroversion(s.split("/")[1]);
				}

				browser.setBroType("chrome");
			}
			// edge
			// mozilla/5.0 (windows nt 10.0; win64; x64) chrome/64.0.3282.140 safari/537.36
			// edge/18.17763
			else if (str.indexOf(PConst.EDGE) >= 0) {
				pattern = Pattern.compile(edgP);
				mat = pattern.matcher(str);
				if (mat.find()) {
					s = mat.group();
					browser.setBroversion(s.split("/")[1]);
				}

				browser.setBroType("edge");
			}
			// opera
			// opera/9.27 (windows nt 5.2; u; zh-cn)
			// mozilla/5.0 (macintosh; ppc mac os x; u; en) opera 8.0
			else if (str.indexOf(PConst.OPERA) >= 0) {
				pattern = Pattern.compile(operaP);
				mat = pattern.matcher(str);
				if (mat.find()) {
					s = mat.group();
					if (s.indexOf(PConst.LEFT_SLASH) >= 0) {
						browser.setBroversion(s.split(PConst.LEFT_SLASH)[1]);
					} else {
						browser.setBroversion(s.split(" ")[1]);
					}

				}

				browser.setBroType("opera");
			}
			// safari
			// mozilla/5.0 (macintosh; intel mac os x 10_11) applewebkit/601.1.56 (khtml,
			// like gecko) version/9.0 safari/601.1.56
			else if (str.indexOf(PConst.SAFARI) >= 0) {
				pattern = Pattern.compile(safariP);
				mat = pattern.matcher(str);
				if (mat.find()) {
					s = mat.group();
					browser.setBroversion(s.split("/")[1]);
				}

				browser.setBroType("safari");
			}
			// other
			else {
				// TODO
			}
		} catch (Exception e) {

		}
		
		String _requrl = request.getHeader("user-agent");
        if (ToolsUtil.isNotNull(_requrl)) {
        	browser.setIp(getIpAddr(request));
        	browser.setUrl(request.getRequestURI().replace(request.getContextPath(), ""));
        }

		return browser;
	}
	
	public static void setBrowser(HttpServletRequest request) {
        BrowserModel browser = getUserAgentModel(request);
        MiscUtil.setBrowser(browser);
    }
}
