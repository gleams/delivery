package cn.ds.page;

import org.apache.commons.lang3.StringUtils;

//封装前台的查询条件
public class EmployeeQuery extends BaseQuery {
	private String username;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	protected void builderWhere() {
		if(StringUtils.isNotBlank(username)){
			builderWhere("o.username like ?", "%"+username+"%");
		}
		if(StringUtils.isNotBlank(email)){
			builderWhere("o.email like ?", "%"+email+"%");
		}
	}

}
