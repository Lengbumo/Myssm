package com.my.ssm.core.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 读取配置文件信息工具类
 * 
 * @ClassName: PropertyUtil
 * @Desc:
 * 
 * @author: WJ
 * @date: 2019年4月17日 上午10:07:04
 *
 */
public class PropertyUtil {

	private static Properties propertie;

	/**
	 * 加载在resources下的配置文件  文件名需加上后缀.properties
	 * 
	 * @Title initInResources    
	 * @param propertiesName
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月18日 上午11:21:52
	 */
	public static Properties initInResources(String propertiesName) {
		if (propertie == null) {
			propertie = new Properties();
			try {
				propertie = PropertiesLoaderUtils.loadProperties(new ClassPathResource(propertiesName));
			} catch (Exception ex) {
				System.out.println(String.format("未找到配置文件%s", propertiesName));
			}
		}
		return propertie;
	}
	
	/**
	 * 读取resources下配置文件内容 文件名需加上后缀.properties
	 * 
	 * @Title getDateInResources    
	 * @param propertiesName
	 * @param key
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月18日 上午11:21:58
	 */
	public static String getDateInResources(String propertiesName, String key) {
		propertie = initInResources(propertiesName);
        String value = propertie.getProperty(key);
        return value;
	}
	
	/**
	 * 加载在项目根路径下的配置文件  文件名需加上后缀.properties
	 * 
	 * @Title init    
	 * @param propertiesName
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月18日 上午11:21:27
	 */
	public static Properties init(String propertiesName) {
		if (propertie == null) {
			propertie = new Properties();
			try {
				String path = PropertyUtil.class.getResource("/").getPath();
		        path = StrUtil.sub(path, 1, path.indexOf("/target"));
				
				InputStream in = new BufferedInputStream(new FileInputStream(path + File.separator +propertiesName));
				// 防止乱码
				propertie.load(new InputStreamReader(in, "utf-8"));
				
			} catch (Exception ex) {
				System.out.println(String.format("未找到配置文件%s", propertiesName));
			}
		}
		return propertie;
	}
	
	/**
	 * 读取项目根路径下配置文件内容 文件名需加上后缀.properties
	 * 
	 * @Title getDate    
	 * @param propertiesName
	 * @param key
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月18日 上午11:21:18
	 */
	public static String getDate(String propertiesName, String key) {
		propertie = init(propertiesName);
        String value = propertie.getProperty(key);
        return value;
	}
	
	/*public static void main(String[] args) {
		getDate("build","generator.password");
	}*/

}
