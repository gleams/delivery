package cn.ds.service.Impl;

import java.io.Serializable;
import java.util.List;

import cn.ds.dao.IBaseDao;
import cn.ds.page.BaseQuery;
import cn.ds.page.Pager;
import cn.ds.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	public abstract IBaseDao<T> getBaseDao();
	@Override
	public void save(T t) {
		getBaseDao().save(t);		
	}

	@Override
	public void update(T t) {
		getBaseDao().update(t);		
	}

	@Override
	public void delete(Serializable id) {
		getBaseDao().delete(id);		
	}

	@Override
	public T get(Serializable id) {
		return getBaseDao().get(id);
	}

	@Override
	public List<T> getAll() {
		return getBaseDao().getAll();
	}
	@Override
	public List<T> findByExample(T t) {
		return getBaseDao().findByExample(t);
	}
	@Override
	public Pager<T> findPager(BaseQuery baseQuery) {
		return getBaseDao().findPager(baseQuery);
	}

}
