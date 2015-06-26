package cn.ds.action;

import cn.ds.domain.Employee;
import cn.ds.page.BaseQuery;
import cn.ds.page.EmployeeQuery;
import cn.ds.page.Pager;
import cn.ds.service.IEmployeeService;

public class EmployeeAction extends CRUDAction<Employee> {

	private IEmployeeService employeeService;
	private Employee employee;
	private Pager<Employee> pager;
	private BaseQuery baseQuery = new EmployeeQuery();

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Pager<Employee> getPager() {
		return pager;
	}

	public BaseQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(BaseQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	@Override
	public String list() throws Exception {
		pager = employeeService.findPager(baseQuery);
		return SUCCESS;
	}

	@Override
	public String save() throws Exception {
		if (id == null) {// 新增后保存
			employeeService.save(employee);
		} else {// 修改后保存
			employeeService.update(employee);
		}
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		if (id != null) {
			employeeService.delete(id);
		}
		return RELOAD;
	}

	@Override
	protected void prepareInputSave() throws Exception {
		if (id == null) {
			employee = new Employee();
		} else {
			employee = employeeService.get(id);
		}
	}

}
