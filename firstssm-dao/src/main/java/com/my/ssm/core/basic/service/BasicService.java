package com.my.ssm.core.basic.service;

import java.io.Serializable;
import java.util.List;

import com.my.ssm.core.basic.model.Key;

public interface BasicService<Model, Search> extends Serializable{

	/**
	 * 根据主键删除数据
	 * 
	 * @Title: deleteByPrimaryKey    
	 * @Desc:  
	 * @param: @param id
	 * @param: @return      
	 * @return: int      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:55:50
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 插入数据(all)
	 * 
	 * @Title: insert    
	 * @Desc:  
	 * @param: @param model
	 * @param: @return      
	 * @return: int      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:56:03
	 */
    int insert(Model model);

    /**
     * 插入数据(有则插入)
     * 
     * @Title: insertSelective    
     * @Desc:  
     * @param: @param model
     * @param: @return      
     * @return: int      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月16日 下午3:56:21
     */
    int insertSelective(Model model);

    /**
     * 根据主键查询详情
     * 
     * @Title: selectByPrimaryKey    
     * @Desc:  
     * @param: @param id
     * @param: @return      
     * @return: Customer      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月16日 下午3:56:36
     */
    Model selectByPrimaryKey(Long id);

    /**
     * 更新数据(有则更新)
     * 
     * @Title: updateByPrimaryKeySelective    
     * @Desc:  
     * @param: @param model
     * @param: @return      
     * @return: int      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月16日 下午3:56:54
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 更新数据(all)
     * 
     * @Title: updateByPrimaryKey    
     * @Desc:  
     * @param: @param model
     * @param: @return      
     * @return: int      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月16日 下午3:57:10
     */
    int updateByPrimaryKey(Model model);
	
	/**
	 * 分页查询List集合
	 * 
	 * @Title: page    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: List<Model>      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午2:05:33
	 */
	List<Model> page(Search search);
	
	Long count(Search search);
	
	/**
	 * 分页拓展查询List集合
	 * 
	 * @Title: pageExt    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午2:08:57
	 */
	List<Object> pageExt(Search search);
	
	Long countExt(Search search);
	
	/**
	 * 查询List集合
	 * 
	 * @Title: list    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: List<Model>      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:40:12
	 */
	List<Model> list(Search search);
	
	/**
	 * 拓展查询List集合
	 * 
	 * @Title: list    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:40:12
	 */
	List<Object> listExt(Search search);
	
	/**
	 * 根据Id查询拓展详情
	 * 
	 * @Title: selectExtByPrimaryKey    
	 * @Desc:  
	 * @param: @param id
	 * @param: @return      
	 * @return: Object      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:41:09
	 */
	Object selectExtByPrimaryKey(Long id);
	
	/**
	 * 根据search查询详情
	 * 
	 * @Title: selectByPrimaryKey    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: Model      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:41:55
	 */
	Model selectByBizKey(Search search);
	
	/**
	 * 根据search查询拓展详情
	 * 
	 * @Title: selectExtByBizKey    
	 * @Desc:  
	 * @param: @param search
	 * @param: @return      
	 * @return: Object      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:43:43
	 */
	Object selectExtByBizKey(Search search);
	
	/**
	 * 删除数据
	 * 
	 * @Title: deleteByBizKey    
	 * @Desc:  
	 * @param: @param model      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:44:14
	 */
	void deleteByBizKey(Model model);
	
	/**
	 * 批量删除数据
	 * 
	 * @Title: bulkDelete    
	 * @Desc:  
	 * @param: @param keyList      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:46:55
	 */
	void bulkDelete(List<Key> keyList);
	
	/**
	 * 更新数据
	 * 
	 * @Title: updateByBizKey    
	 * @Desc:  
	 * @param: @param model      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月16日 下午3:47:30
	 */
	void updateByBizKey(Model model);
	
	/**
	 * 保存数据
	 * 
	 * @Title save    
	 * @param model          
	 *  
	 * @author WJ
	 * @date   2019年5月6日 上午10:41:56
	 */
	void save(Model model);
}
