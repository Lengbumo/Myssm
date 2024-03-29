package com.my.ssm.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeUtils;

/**
 * 日期工具类
 * 
 * @ClassName  DateUtil        
 * 
 * @author WJ
 * @date   2019年5月15日 下午3:39:28   
 *
 */
public class DateUtil {
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取YYYY格式
     * 
     * @return
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     * 
     * @return
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     * 
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     * 
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }
    
    /**
     * 获取YYYYMMDDHHmmss格式
     * 
     * @return
     */
    public static String getDate() {
        return sdfDate.format(new Date());
    }
    
    /**
     * 根据输入格式获取日期
     * 
     * @return: String      
     */
    public static String getDate(String format) {
    	SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(new Date());
    }
    
    public static Date getNow() {
        return new Date();
    }

    /**
     * 日期比较，如果s>=e 返回true 否则返回false
     * 
     * @Title compareDate    
     * @param s
     * @param e
     * @return          
     *  
     * @author WJ
     * @date   2019年5月15日 下午3:39:57
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期
     * 
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     * 
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * 返回Timestamp
     * 
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 时间相减得到年数
     * 
     * @Title getDiffYear    
     * @param startTime
     * @param endTime
     * @return          
     *  
     * @author WJ
     * @date   2019年4月17日 下午12:05:15
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     * 
     * @Title getDaySub    
     * @param beginDateStr
     * @param endDateStr
     * @return          
     *  
     * @author WJ
     * @date   2019年5月15日 下午3:40:23
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        //System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 获取指定格式的时间
     * @param pattern
     * @return
     */
    public static final String getFormatForUpImg(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(getTimestamp());
    }

    /**
     * Get current millis
     * @return
     */
    public static final long getTimeInMillis() {
        return DateTimeUtils.currentTimeMillis();
    }

    public static String getStringDate(String _strDate) {
        if (StringUtils.isBlank(_strDate)) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse(_strDate);

            return sdf.format(parse);
        } catch (Exception e) {
        }

        return null;
    }

    public static String getStringDate(String _strDate, String pattern) {
        if (StringUtils.isBlank(_strDate)) {
            return null;
        }

        try {
            if (StringUtils.isBlank(pattern)) {
                pattern = "yyyy-MM-dd";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date parse = sdf.parse(_strDate);

            return sdf.format(parse);
        } catch (Exception e) {
        }

        return null;
    }

    public static String formatDDate(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        } catch (Exception e) {
        }

        return null;
    }

    public static String formatDDateTime(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
        }

        return null;
    }

}
