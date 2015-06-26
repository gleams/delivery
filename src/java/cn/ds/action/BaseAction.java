package cn.ds.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//不是CRUD需求Action就继承此类
public class BaseAction extends ActionSupport {
	public static final String LOGIN_USER = "loginUser";
	public static final String RELOAD = "reload";

	public static final String MAIN = "main";

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}
}
