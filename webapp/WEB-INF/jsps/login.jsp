<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工注册</title>
</head>
<body>
	<s:form method="POST" action="login_check" theme="simple">
		<s:hidden name="employee.id" />
		<table>
			<tr>
				<td>用户名</td>
				<td><s:textfield name="employee.username" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码</td>
				<td><s:textfield name="employee.password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /> 
				<input type="reset" value="重置" /></td>
			</tr>
		</table>

	</s:form>
</body>
</html>