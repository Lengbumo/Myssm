package com.my.ssm.core.util.model;

import java.security.MessageDigest;

public class MD5 {

    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return str;
    }

    public static void main(String[] args) {
        //System.out.println(md5("0vl7CkmRh2RU5rydeliverUser黄芳data[{\"productSum\":\"30\",\"productSku\":\"1010204009\",\"orderNo\":\"90423153809252\"},{\"productSum\":\"30\",\"productSku\":\"1010204011\",\"orderNo\":\"90423153809252\"},{\"productSum\":\"60\",\"productSku\":\"1010206003\",\"orderNo\":\"90423153809252\"},{\"productSum\":\"60\",\"productSku\":\"1010206011\",\"orderNo\":\"90423153809252\"}]distributionDate2019-04-23u8ContractName湖南昂文教育咨询有限公司u8ContractNo010001distributionNo19040015operType10vl7CkmRh2RU5ry"));
    	System.out.println(md5("0vl7CkmRh2RU5rydeliverUser黄芳data[{\"productSum\":\"5\",\"productSku\":\"102050022\",\"orderNo\":\"90321164807708\"},{\"productSum\":\"40\",\"productSku\":\"1020500041\",\"orderNo\":\"90321164807708\"},{\"productSum\":\"20\",\"productSku\":\"1020700005\",\"orderNo\":\"90321164807708\"},{\"productSum\":\"5\",\"productSku\":\"1020800013\",\"orderNo\":\"90321164807708\"},{\"productSum\":\"10\",\"productSku\":\"102050018\",\"orderNo\":\"90321164807708\"}]distributionDate2019-03-22u8ContractName湖南昂文教育咨询有限公司u8ContractNo180166distributionNo19059001operType10vl7CkmRh2RU5ry"));
    	//System.out.println(md5("E0009").toUpperCase());
    }
}
