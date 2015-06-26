package cn.ds.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
//处理CRUD,分页,查询
public abstract class CRUDAction<T> extends BaseAction implements
		ModelDriven<T>, Preparable {
	// 定义id给子类使用
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// 不用写代码,execute,input,save,delete都会自动调用这个方法
	

	@Override
	public String execute() throws Exception {
		return list();
	}

	// 需要子类重写:显示列表
	public abstract String list() throws Exception;

	// 显示修改或者增加的页面
	@Override
	public String input() throws Exception {
		return INPUT;
	}

	// 需要子类重写:保存方法
	public abstract String save() throws Exception;

	// 需要子类重写:删除方法
	public abstract String delete() throws Exception;

	// 在子类调用input方法之前自动被调用
	public void prepareInput() throws Exception {
		prepareInputSave();
	}

	// 在子类调用save方法之前自动被调用
	public void prepareSave() throws Exception {
		prepareInputSave();
	}

	// 需要子类重写
	protected abstract void prepareInputSave() throws Exception;

	public void prepare() throws Exception {
		
		
	}

	

}
