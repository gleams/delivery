package cn.ds.service;

import cn.ds.domain.Employee;

public interface IEmployeeService extends IBaseService<Employee> {
	// 验证登录,成功之后Employee必须包含id
	public boolean check(Employee employee);

	// public Employee check(String username,String password);
}
