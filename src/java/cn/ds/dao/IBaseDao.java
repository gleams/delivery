package cn.ds.dao;

import java.io.Serializable;
import java.util.List;

import cn.ds.page.BaseQuery;
import cn.ds.page.Pager;

public interface IBaseDao<T> {
	void save(T t);

	void update(T t);

	void delete(Serializable id);

	T get(Serializable id);

	List<T> getAll();

	// 按照实例查询,只要有非主键的属性不为空,就会自动加到查询条件
	List<T> findByExample(T t);
	
	//获取分页
	Pager<T> findPager(BaseQuery  baseQuery);
}
