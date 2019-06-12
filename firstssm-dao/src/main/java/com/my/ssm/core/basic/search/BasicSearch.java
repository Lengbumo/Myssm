package com.my.ssm.core.basic.search;

import java.util.ResourceBundle;

import com.my.ssm.core.basic.model.BasicModel;

/**
 * 查询分页对象
 * 
 * @ClassName  BasicSearch        
 * 
 * @author WJ
 * @date   2019年4月28日 下午12:04:23   
 *
 */
public class BasicSearch extends BasicModel{

	private static final long serialVersionUID = -149027870469761662L;

	private Long limit; // 每页显示记录数
	
    private Long totalPage; // 总页数
    
    private Long totalResult; // 总记录数
    
    private Long currentPage; // 当前页数
    
    private Long startCursor; // 当前页开始行数
    
    private String searchParam; // 查询参数

	/**每页显示记录数*/
	public Long getLimit() {
		return limit;
	}

	public BasicSearch() {
        try {
            this.limit = Long.valueOf((getPageLimit()));
        } catch (Exception e) {
            this.limit = 10L;
        }
    }
	
	/**每页显示记录数*/
	public void setLimit(Long limit) {
		this.limit = limit;
	}

	/**总页数*/
	public Long getTotalPage() {
		if (totalResult % limit == 0)
            totalPage = totalResult / limit;
        else
            totalPage = totalResult / limit + 1;
        return totalPage;
	}

	/**总页数*/
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	/**总记录数*/
	public Long getTotalResult() {
		return totalResult;
	}

	/**总记录数*/
	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}

	/**当前页数*/
	public Long getCurrentPage() {
		if (currentPage <= 0)
            currentPage = 1L;
        if (currentPage > getTotalPage())
            currentPage = getTotalPage();
        startCursor = (currentPage - 1) * limit;
        return currentPage;
	}

	/**当前页数*/
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
    
	/**当前页开始行数*/
	public Long getStartCursor() {
		if (null != currentPage) {
			startCursor = (currentPage - 1) * limit;
		}
		return startCursor;
	}

	/**当前页开始行数*/
	public void setStartCursor(Long startCursor) {
		this.startCursor = startCursor;
	}
	
	protected String getPageLimit() {
		try {
    		ResourceBundle resource = ResourceBundle.getBundle("defset");
    		return resource.getString("page.showCount");
		} catch (Exception e) {
			return "10";
		}
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	
}
