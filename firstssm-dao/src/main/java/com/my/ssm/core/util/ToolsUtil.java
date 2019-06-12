package com.my.ssm.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 工具类
 * 
 * @ClassName:  ToolsUtil   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月15日 下午3:55:51   
 *
 */
public class ToolsUtil {
	
	private static String pattern = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";

    /**
     * 随机生成六位数验证码 
     * @return
     */
    public static int getRandomNum() {
        Random r = new Random();
        //(Math.random()*(999999-100000)+100000)
        return r.nextInt(900000) + 100000;
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean isNotNull(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isNull(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }

    /**
     * 字符串转换为字符串数组
     * @param str 字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str, String splitRegex) {
        if (isNull(str)) {
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     * @param str	字符串
     * @return
     */
    public static String[] str2StrArray(String str) {
        return str2StrArray(str, ",\\s*");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date) {
        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     * @param date
     * @return
     */
    public static Date str2Date(String date) {
        if (isNotNull(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        } else {
            return null;
        }
    }

    /**
     * 按照参数format的格式，日期转字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    /**
     * 把时间根据时、分、秒转换为时间段
     * @param StrDate
     */
    public static String getTimes(String strDate) {
        String resultTimes = "";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now;

        try {
            now = new Date();
            java.util.Date date = df.parse(strDate);
            long times = now.getTime() - date.getTime();
            long day = times / (24 * 60 * 60 * 1000);
            long hour = (times / (60 * 60 * 1000) - day * 24);
            long min = ((times / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long sec = (times / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

            StringBuffer sb = new StringBuffer();
            //sb.append("发表于：");
            if (hour > 0) {
                sb.append(hour + "小时前");
            } else if (min > 0) {
                sb.append(min + "分钟前");
            } else {
                sb.append(sec + "秒前");
            }

            resultTimes = sb.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultTimes;
    }

    /**
     * 写txt里的单行内容
     * @param filePath  文件路径
     * @param content  写入的内容
     */
    public static void writeFile(String fileP, String content) {
    	//项目路径
        String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
        filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
        if (filePath.indexOf(PConst.COLON) != 1) {
            filePath = File.separator + filePath;
        }
        try {
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
      * 验证邮箱
      * @param email
      * @return
      */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern
                    .compile(pattern);
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 读取txt里的单行内容
     * @param filePath  文件路径
     */
    public static String readTxtFile(String fileP) {
        try {
        	//项目路径
            String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
            filePath = filePath.replaceAll("file:/", "");
            filePath = filePath.replaceAll("%20", " ");
            filePath = filePath.trim() + fileP.trim();
            if (filePath.indexOf(PConst.COLON) != 1) {
                filePath = File.separator + filePath;
            }
            String encoding = "utf-8";
            File file = new File(filePath);
            // 判断文件是否存在
            if (file.isFile() && file.exists()) {
            	// 考虑到编码格式
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                @SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    return lineTxt;
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件,查看此路径是否正确:" + filePath);
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
        }
        return "";
    }

    /**
     * 获取文件的后缀名
     * 
     * @param fileName
     * @return
     */
    public static String getFileSuffix(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }

        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 格式化指定格式的数字
     * 
     * @param arg0
     * @param len
     * @return
     */
    public static String format(BigDecimal arg0, int len) {
        if (arg0 == null) {
            return "0.00";
        }

        return format(arg0.toString(), len);
    }

    /**
     * 格式化数字
     * 
     * @param arg0
     * @param len
     * @return
     */
    public static String format(String arg0, int len) {
        if (arg0 == null || arg0.length() < 1) {
            return null;
        }
        NumberFormat formater = null;
        double num = Double.parseDouble(arg0);
        if (len == 0) {
            formater = new DecimalFormat("000");
        } else {
            StringBuffer buff = new StringBuffer();
            buff.append("0.");
            for (int i = 0; i < len; i++) {
                buff.append("0");
            }
            formater = new DecimalFormat(buff.toString());
        }
        String result = formater.format(num);

        return result = result.indexOf(".") == -1 ? result + ".00" : result;
    }
    
    /**
     * 首字母转大写
     * 
     * @Title: toUpperCaseFirstOne    
     * @Desc:  
     * @param: @param s
     * @param: @return      
     * @return: String      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月16日 上午9:45:32
     */
    public static String toUpperCaseFirstOne (String s) {
  		if(Character.isUpperCase(s.charAt(0))) {
  		    return s;
  		} else {
  		    return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
  		}
  	}
  	
  	/**
  	 * 首字母转小写
  	 * 
  	 * @Title: toLowerCaseFirstOne    
  	 * @Desc:  
  	 * @param: @param s
  	 * @param: @return      
  	 * @return: String      
  	 * @throws 
  	 *  
  	 * @author: WJ
  	 * @date:   2019年4月16日 上午9:45:37
  	 */
  	public static String toLowerCaseFirstOne(String s){
  	  if(Character.isLowerCase(s.charAt(0))) {
  	    return s;
  	  } else {
  		return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
  	  }
  	}
  	
  	/**
  	 * 根据Unicode编码判断是否是中文汉字和符号
  	 * 
  	 * @Title: isChinese    
  	 * @Desc:  
  	 * @param: @param c
  	 * @param: @return      
  	 * @return: boolean      
  	 * @throws 
  	 *  
  	 * @author: WJ
  	 * @date:   2019年4月17日 上午11:27:36
  	 */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

}
