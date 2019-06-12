/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.core.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import com.my.ssm.core.util.PConst;

/**
 * 扩充注解驱动
 * 
 * @ClassName  CustomDateMapper        
 * 
 * @author WJ
 * @date   2019年4月18日 上午9:40:34   
 *
 */
public class CustomDateMapper extends ObjectMapper {

    private SimpleDateFormat dateFormat = new SimpleDateFormat(PConst.DATE_FORMATTER_YYYY_MM_DD);
    private SimpleDateFormat datetimeFormat = new SimpleDateFormat(PConst.DATE_FORMATTER_YYYY_MM_DD_HH_MM_SS);

    public CustomDateMapper() {
        CustomSerializerFactory factory = new CustomSerializerFactory();
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {

            @Override
            public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                    JsonProcessingException {
                if (date == null) {
                    return;
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                if (cal.get(Calendar.HOUR_OF_DAY) == 0 && cal.get(Calendar.MINUTE) == 0
                        && cal.get(Calendar.SECOND) == 0) {
                    jgen.writeString(dateFormat.format(date));
                } else {
                    jgen.writeString(datetimeFormat.format(date));
                }
            }
        });

        this.setSerializerFactory(factory);
    }

}
