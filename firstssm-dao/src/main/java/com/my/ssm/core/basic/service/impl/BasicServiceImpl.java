package com.my.ssm.core.basic.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.model.BasicModel;
import com.my.ssm.core.basic.model.Key;
import com.my.ssm.core.basic.search.BasicSearch;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.exception.BizException;

public abstract class BasicServiceImpl<Model extends BasicModel, Search extends BasicSearch> implements BasicService<Model, Search> {

	private static final long serialVersionUID = -4025308346429491652L;

	protected abstract BasicMapper<Model, Search> getBasicMapper();
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return getBasicMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Model model) {
		return getBasicMapper().insert(model);
	}

	@Override
	public int insertSelective(Model model) {
		return getBasicMapper().insertSelective(model);
	}

	@Override
	public Model selectByPrimaryKey(Long id) {
		return getBasicMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Model model) {
		return getBasicMapper().updateByPrimaryKeySelective(model);
	}

	@Override
	public int updateByPrimaryKey(Model model) {
		return getBasicMapper().updateByPrimaryKey(model);
	}

	@Override
	public List<Model> page(Search search) {
		search.setTotalResult(getBasicMapper().count(search));
		return getBasicMapper().page(search);
	}

	@Override
	public Long count(Search search) {
		return getBasicMapper().count(search);
	}

	@Override
	public List<Object> pageExt(Search search) {
		search.setTotalResult(getBasicMapper().countExt(search));
		return getBasicMapper().pageExt(search);
	}

	@Override
	public Long countExt(Search search) {
		return getBasicMapper().countExt(search);
	}

	@Override
	public List<Model> list(Search search) {
		return getBasicMapper().list(search);
	}

	@Override
	public List<Object> listExt(Search search) {
		return getBasicMapper().listExt(search);
	}

	@Override
	public Object selectExtByPrimaryKey(Long id) {
		return getBasicMapper().selectExtByPrimaryKey(id);
	}

	@Override
	public Model selectByBizKey(Search search) {
		return getBasicMapper().selectByBizKey(search);
	}

	@Override
	public Object selectExtByBizKey(Search search) {
		return getBasicMapper().selectExtByBizKey(search);
	}

	@Override
	public void deleteByBizKey(Model model) {
		getBasicMapper().deleteByBizKey(model);
	}

	@Override
	public void bulkDelete(List<Key> keyList) {
		getBasicMapper().bulkDelete(keyList);
	}

	@Override
	public void updateByBizKey(Model model) {
		getBasicMapper().updateByBizKey(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(Model model) {
		if (null != model.getId()) {
			// update
			Model primaryKey = getBasicMapper().selectByPrimaryKey(model.getId());
			if (null == primaryKey) {
				throw new BizException("E00001", "数据不存在");
			}
			getBasicMapper().updateByPrimaryKeySelective(model);
		} else {
			// save
			try {
				ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
		        Class<Search> clazz = (Class<Search>) ptype.getActualTypeArguments()[1];
		        Search search = (Search) clazz.newInstance();
		        BeanUtils.copyProperties(model, search);
				Model bizKey = getBasicMapper().selectByBizKey(search);
				if (null != bizKey) {
					 throw new BizException("E00001", "数据已存在");
				}
				getBasicMapper().insertSelective(model);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new BizException("E00002", e.getMessage());
			}
		}
	}
	
}
