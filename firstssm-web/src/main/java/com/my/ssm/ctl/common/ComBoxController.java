
package com.my.ssm.ctl.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ssm.core.basic.model.ComBox;
import com.my.ssm.core.util.PConst;
import com.my.ssm.sys.search.MenuSearch;
import com.my.ssm.sys.service.MenuService;

/**
 * 下拉框
 * 
 * @ClassName  ComBoxController        
 * 
 * @author WJ
 * @date   2019年5月6日 上午9:52:34   
 *
 */
@Controller
@RequestMapping(value = "/myssm/manager/combox")
public class ComBoxController {
    protected Logger logger = LoggerFactory.getLogger(ComBoxController.class);

    @Autowired
	private transient MenuService menuService;

    /**
     * 查询最上层菜单下拉框
     * 
     * @Title page    
     * @param request
     * @return          
     *  
     * @author WJ
     * @date   2019年5月5日 下午6:09:46
     */
    @RequestMapping(value = "menuSelect", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ComBox> menuSelect(MenuSearch search) {
    	search.setIsParent(PConst.DEFALUT_1);
    	return menuService.getMenuComboboxVal(search);
    }
    
    /**
     * 查询无下级的菜单下拉框
     * 
     * @Title operationMenuSelect    
     * @param search
     * @return          
     *  
     * @author WJ
     * @date   2019年5月16日 上午10:01:16
     */
    @RequestMapping(value = "operationMenuSelect", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ComBox> operationMenuSelect(MenuSearch search) {
    	search.setIsParent(PConst.DEFALUT_0);
    	return menuService.getMenuComboboxVal(search);
    }
}
