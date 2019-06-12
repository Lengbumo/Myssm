/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.run;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @com.sl.pt.wms.run.JettyRun.java
 * @remark JettyRun
 * @author system
 * @email system@shuangling-tech.com
 * @version 1.0
 * @since JDK 1.7 
 * @create time 2017-10-22 下午11:31:19
 */
public class JettyRun {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        try {
            String webapp = "src/main/webapp";

            Server server = new Server(8088);

            WebAppContext context = new WebAppContext();
            context.setDescriptor(webapp + "WEB-INF/web.xml");
            context.setResourceBase(webapp);
            context.setContextPath("/my-ssm");
            context.setClassLoader(Thread.currentThread().getContextClassLoader());
            context.setConfigurationDiscovered(true);
            context.setParentLoaderPriority(true);

            server.setHandler(context);
            server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
            server.start();
            System.out.println("http://127.0.0.1:8088/my-ssm/index.jsp");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
