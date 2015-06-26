package cn.ds.action;

import cn.ds.domain.Employee;
import cn.ds.service.IEmployeeService;

public class LoginAction extends BaseAction {
	private IEmployeeService employeeService;
	private Employee employee = new Employee();

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 必须提供一个get方法,不是的话只能取到一个属性的值
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 显示登录页面
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	// 验证登录
	public String check() throws Exception {
		System.out.println("check:" + employee);
		// 必须判断employee.getUsername,getPassword不能为空
		if (employee.getUsername() == null || "".equals(employee.getUsername())
				|| employee.getPassword() == null
				|| "".equals(employee.getPassword())) {
			addActionError("用户名,密码不能为空");
			return SUCCESS;
		}
		if (employeeService.check(employee)) {// 登录成功
			getRequest().getSession().setAttribute(LOGIN_USER, employee);
			return MAIN;
		}
		addActionError("登录失败");
		return SUCCESS;
	}
}
