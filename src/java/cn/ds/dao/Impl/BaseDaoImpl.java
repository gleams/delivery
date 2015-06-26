package cn.ds.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ds.dao.IBaseDao;
import cn.ds.page.BaseQuery;
import cn.ds.page.Pager;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements
		IBaseDao<T> {

	protected Class<T> entityClass;

	public BaseDaoImpl() {
		Class clazz = getClass();
		// System.out.println("子类:" + clazz);
		// System.out.println(clazz.getGenericSuperclass());
		Type type = clazz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			entityClass = (Class<T>) pType.getActualTypeArguments()[0];
			System.out.println("BaseDaoImpl:" + entityClass);
		}

	}

	// public BaseDaoImpl(Class<T> entityClass){
	// this.entityClass=entityClass;
	// }

	// public abstract Class<T> getEntityClass();

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = get(id);
		if (t == null) {
			throw new RuntimeException("不能获取主键为" + id + "的对象");
		}
		getHibernateTemplate().delete(t);
	}

	@Override
	public T get(Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> getAll() {
		// getHibernateTemplate().find("from "+entityClass.getName());
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public List<T> findByExample(T t) {
		return getHibernateTemplate().findByExample(t);
	}

	@Override
	public Pager<T> findPager(final BaseQuery baseQuery) {
		final Pager<T> pager = new Pager<T>(baseQuery.getPageNo(),
				baseQuery.getPageSize(), findCount(baseQuery));
		// 获取查询的条件
		String where = baseQuery.getWhere();
		// 封装hql语句
		final StringBuilder builder = new StringBuilder();
		builder.append("select o from ").append(entityClass.getName());
		builder.append(" as o where 1=1 ");
		if (StringUtils.isNotBlank(where)) {
			builder.append(where);
		}
		System.out.println("baseDao findPager:" + builder.toString());

		List<T> rows = getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {
					@Override
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(builder.toString());
						// 设置查询条件
						int i = 0;
						for (Object object : baseQuery.getParams()) {
							query.setParameter(i++, object);
						}
						// 设置从什么地方开始取数据
						query.setFirstResult((pager.getPageNo() - 1)
								* pager.getPageSize());
						// 设置取多少条数据
						query.setMaxResults(pager.getPageSize());
						return query.list();
					}
				});
		pager.setRows(rows);
		return pager;
	}

	private int findCount(final BaseQuery baseQuery) {
		// 获取查询的条件
		String where = baseQuery.getWhere();
		// 封装hql语句
		final StringBuilder builder = new StringBuilder();
		builder.append("select count(o) from ").append(entityClass.getName());
		builder.append(" as o where 1=1 ");
		if (StringUtils.isNotBlank(where)) {
			builder.append(where);
		}
		System.out.println("baseDao findCount:" + builder.toString());
		Long count = getHibernateTemplate().execute(
				new HibernateCallback<Long>() {
					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(builder.toString());
						// 设置查询条件
						int i = 0;
						for (Object object : baseQuery.getParams()) {
							query.setParameter(i++, object);
						}
						return (Long) query.uniqueResult();
					}
				});
		return count.intValue();
	}
}
