package cn.ds.service.Impl;

import java.util.List;

import cn.ds.dao.IBaseDao;
import cn.ds.dao.IEmployeeDao;
import cn.ds.domain.Employee;
import cn.ds.service.IEmployeeService;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements
		IEmployeeService {

	private IEmployeeDao employeeDao;

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public IBaseDao<Employee> getBaseDao() {
		return employeeDao;
	}

	@Override
	public boolean check(Employee employee) {
		List<Employee> employees = findByExample(employee);
		System.err.println("employees=" + employees);
		if (employees!=null && employees.size() == 1) {
			// 修改属性
			employee.setId(employees.get(0).getId());
			return true;
		}
		return false;
	}

}
