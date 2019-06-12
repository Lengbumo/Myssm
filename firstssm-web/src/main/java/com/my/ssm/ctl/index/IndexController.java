/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.ctl.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @com.sl.pt.index.ctl.IndexController.java
 * @remark Home Page
 * @author system
 * @email system@shuangling-tech.com
 * @version 1.0
 * @since JDK 1.7 
 * @create time 2017-10-23 下午5:51:06
 */
@Controller
@RequestMapping(value = "/myssm/manager")
public class IndexController {
    protected Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**去系统首页面*/
    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("/main/index");
        return mv;
    }

    /**去系统首页面*/
    @RequestMapping(value = "center")
    public ModelAndView center(ModelAndView mv) {
        mv.setViewName("/main/index");
        return mv;
    }
    
    /**去系统主页面*/
    @RequestMapping(value = "main")
    public ModelAndView main(ModelAndView mv) {
        mv.setViewName("/main/main");
        return mv;
    }
    
    /**去系统主页面*/
    @RequestMapping(value = "map")
    public ModelAndView map(ModelAndView mv) {
        mv.setViewName("/map/map4");
        return mv;
    }
    
    /**去系统主页面*/
    @RequestMapping(value = "map3")
    public ModelAndView map3(ModelAndView mv) {
        mv.setViewName("/map/map3");
        return mv;
    }

    /**
     * 初始化菜单
     * 
     * @param mv
     * @return
     *
     * @author LiuJM
     * @remark 方法初始化
     * @create time 2017-11-18 上午1:31:46
     */
    /*private void initMenu(ModelAndView mv) {
        try {
            ModuleMenuSearch search = new ModuleMenuSearch();
            search.setParentId(0L);
            List<MenuNavigationVo> listMnvExt = moduleMenuService.listMnvExt(search);
            for (MenuNavigationVo mnv : listMnvExt) {
                if ("SYS_PLAT".equals(mnv.getMenuCode())) {
                    mv.addObject("pmenu", mnv.getMenuCode());
                } else if ("BASE_MANAGE".equals(mnv.getMenuCode())) {
                    mv.addObject("mmenu", mnv.getMenuCode());
                } else if ("WMS_MANGAGE".equals(mnv.getMenuCode())) {
                    mv.addObject("wmenu", mnv.getMenuCode());
                }
            }
        } catch (Exception e) {
            logger.error("IndexController initMenu()->", e);
        }
    }*/

}
