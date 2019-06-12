package com.my.ssm.core.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.my.ssm.core.basic.model.BasicModel;
import com.my.ssm.core.basic.model.Key;
import com.my.ssm.core.basic.search.BasicSearch;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.exception.BizException;
import com.my.ssm.core.util.AppRespUtil;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.sec.util.MiscUtil;

public abstract class BasicController<T, S extends BasicSearch> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** 获取映射文件的命名空间 */
    protected abstract BasicService<T, S> getPagedService();

    /** 获取查询条件Bean对象 */
    protected abstract Class<S> getSearchBean();
    
    /** 获取请求的URL */
    protected abstract String getReqUrl();
    
    /** 去初始页面 */
    @RequestMapping(value = "toInit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toInit(ModelAndView mv) {
    	beforeToInit(mv);
    	mv.setViewName(getInitPageName());
    	
        return mv;
    }
    
    /** 去初始化页面操作处理 */
    protected ModelAndView beforeToInit(ModelAndView mv) {
    	return mv;
    }
    
    /** 批量删除 */
    @RequestMapping(value = {"bulkDelete"}, method = {RequestMethod.POST})
    @ResponseBody
    public AppRespUtil bulkDelete(HttpServletRequest request) {
        String parameter = request.getParameter(PConst.SYS_REGULAR_PARAM);
        List<Key> idList = JSONArray.parseArray(parameter, Key.class);
        if (idList.size() < 0) {
            return AppRespUtil.fail("E00006", "要删除的记录不能为空!");
        }

        try {
            getPagedService().bulkDelete(idList);
        } catch (BizException e) {
            logger.error("BasicController bulkDelete()->", e);
            return AppRespUtil.fail(e.getErrCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("BasicController bulkDelete()->", e);
            return AppRespUtil.fail("系统异常!");
        }

        return AppRespUtil.ok();
    }
    
    /** 根据Id查询详情后操作 */
    @RequestMapping(value = {"view/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AppRespUtil view(@PathVariable("id") Long id) {
    	Object data = null;
        try {
            data = getPagedService().selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("BasicController view()->", e);
            return AppRespUtil.fail(e.getMessage());
        }

        // 根据Id查询详情后操作
        afterViewByIKey(data);

        return AppRespUtil.ok(data);
    }
    
    /** 根据Id查询拓展详情 */
    @RequestMapping(value = {"viewExt/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AppRespUtil viewExt(@PathVariable("id") Long id) {
        Object data = null;
        try {
            data = getPagedService().selectExtByPrimaryKey(id);
        } catch (Exception e) {
            logger.error("BasicController viewExt()->", e);
            return AppRespUtil.fail(e.getMessage());
        }

        // 根据Id查询拓展详情后操作
        afterViewExtByIKey(data);

        return AppRespUtil.ok(data);
    }
    
    /** 根据Id查询详情后操作 */
    protected Object afterViewByIKey(Object record) {
        return record;
    }
    
    /** 根据Id查询拓展详情后操作 */
    protected Object afterViewExtByIKey(Object record) {
        return record;
    }
    
    /** 分页查询*/
    @RequestMapping(value = "page", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AppRespUtil page(S search, HttpServletRequest request) {
        Long total = null;
        List<T> dlist = null;

        try {
            // 分页查询之前操作
            beforePage(search, request);

            dlist = getPagedService().page(search);
            total = search.getTotalResult();
        } catch (Exception e) {
            logger.error("BasicController page()->", e);
            return AppRespUtil.fail(e.getMessage());
        }

        // 分页查询之后操作
        return afterPage(dlist, total);
    }
    
    /** 去Form表单页面*/
    @RequestMapping(value = "toForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toForm(ModelAndView mv, T record) {
    	// 去Form页面之前操作
        beforeToForm(mv);
    	
    	// 自定义Form
        toFormExt(mv);
        
        // 获取数据
        if (mv.getModel().get("data") == null && record instanceof BasicModel) {
            String user = MiscUtil.getUserNameZ();
            Date date = DateUtil.getNow();

            BasicModel data = (BasicModel) record;
            data.setCreatedBy(user);
            data.setCreatedDate(date);
            data.setModifiedBy(user);
            data.setModifiedDate(date);
            mv.addObject("data", data);
        }
        mv.setViewName(getInitFormName());
        
    	return mv;
    }
    
    /** 去查看页面*/
    @RequestMapping(value = "toView/{id}", method = {RequestMethod.GET})
    public ModelAndView toViewById(@PathVariable("id") Long id, ModelAndView mv) {
    	try {
    		// 去View页面之前操作
            beforeToView(id, mv);
            
            // 获取数据
            if (mv.getModel().get("data") == null) {
                T data = getPagedService().selectByPrimaryKey(id);
                mv.addObject("data", data);
            }
		} catch (Exception e) {
			logger.error("BasicController toViewById()->", e);
		}
    	mv.setViewName(getInitViewName());
    	
    	return mv;
    }
    
    /** 去查看页面*/
    @RequestMapping(value = "toView", method = {RequestMethod.GET})
    public ModelAndView toView(ModelAndView mv, HttpServletRequest request) {
    	String id = request.getParameter("id");
    	mv.addObject("id", id);
    	
    	beforeToView(mv);
    	mv.setViewName(getInitViewName());
    	return mv;
    }
    
    /** 去编辑页面*/
    @RequestMapping(value = {"toEdit/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toEditById(@PathVariable("id") Long id, ModelAndView mv) {
        try {
        	// 去Edit页面之前操作
            beforeToEdit(id, mv);

            // 获取数据
            if (mv.getModel().get("data") == null) {
                T data = getPagedService().selectByPrimaryKey(id);
                mv.addObject("data", data);
            }
		} catch (Exception e) {
			logger.error("BasicController toEditById()->", e);
		}
        mv.setViewName(getInitFormName());

        return mv;
    }
    
    /** 去编辑页面*/
    @RequestMapping(value = "toEdit", method = {RequestMethod.GET})
    public ModelAndView toEdit(ModelAndView mv, HttpServletRequest request) {
    	String id = request.getParameter("id");
    	mv.addObject("id", id);
    	
    	beforeToEdit(mv);
    	mv.setViewName(getInitFormName());
    	return mv;
    }
    
    /** 保存*/
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public AppRespUtil save(T record) {
        try {
            // 数据保存之前操作
            beforeSave(record);

            getPagedService().save(record);

            return AppRespUtil.ok(record);
        } catch (BizException e) {
            logger.error("BasicController save()->", e);
            return AppRespUtil.fail(e.getErrCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("BasicController save()->", e);
            return AppRespUtil.fail("系统异常");
        }
    }
    
    /** 分页查询之前操作 */
    protected S beforePage(S search, HttpServletRequest request) {
    	return search;
    }

    /** 分页查询之后操作 */
    protected AppRespUtil afterPage(List<T> dlist, Long total) {
        return AppRespUtil.ok(total, dlist);
    }
    
    /** 去Form页面操作处理 */
    protected ModelAndView beforeToForm(ModelAndView mv) {
        return mv;
    }
    
    /** 去自定义Form页面*/
    protected ModelAndView toFormExt(ModelAndView mv) {
        return mv;
    }
    
    /**根据ID实现自定义VIEW数据获取*/
    protected ModelAndView beforeToView(ModelAndView mv) {
        return mv;
    }
    
    /**根据ID实现自定义VIEW数据获取*/
    protected ModelAndView beforeToView(Long id, ModelAndView mv) {
        return mv;
    }
    
    /**根据ID实现自定义EDIT数据获取*/
    protected ModelAndView beforeToEdit(ModelAndView mv) {
        return mv;
    }
    
    /**根据ID实现自定义EDIT数据获取*/
    protected ModelAndView beforeToEdit(Long id, ModelAndView mv) {
        return mv;
    }
    
    /** 数据保存之前操作 */
    protected T beforeSave(T record) {
        return record;
    }
    
    /** 获取Init Page页面URL */
    protected abstract String getInitPageName();
    
    /** 获取Init Form页面URL */
    protected abstract String getInitFormName();
    
    /** 获取Init View页面URL */
    protected abstract String getInitViewName();
    
}
