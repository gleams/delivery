package cn.ds.page;

import java.util.ArrayList;
import java.util.List;

//封装前台公共的查询条件
public abstract class BaseQuery {
	// 定义一个标示的boolean值
	private boolean flag = false;
	protected int pageNo=1;
	protected int pageSize=10;
	// 封装子类赋值给父类的条件和值
	private StringBuilder builder = new StringBuilder();
	// o.username like ? and o.email like ?
	private List params = new ArrayList();

	// abc abc@gmail.com

	// 保证此方法必须被调用:由子类传入查询的条件和值
	protected abstract void builderWhere();
//封装传入查询的条件和值
	protected void builderWhere(String where, Object object) {
		builder.append(" and ").append(where);
		params.add(object);
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getWhere() {
		if (!flag) {
			flag = true;
			builderWhere();
		}
		return builder.toString();
	}

	public List getParams() {
		return params;
	}

}
