package cn.ds.service;

import java.io.Serializable;
import java.util.List;

import cn.ds.page.BaseQuery;
import cn.ds.page.Pager;

public interface IBaseService<T> {
	void save(T t);

	void update(T t);

	void delete(Serializable id);

	T get(Serializable id);

	List<T> getAll();
	
	List<T> findByExample(T t);
	
	Pager<T> findPager(BaseQuery  baseQuery);
}
