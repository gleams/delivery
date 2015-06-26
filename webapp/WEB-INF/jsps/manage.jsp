<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<a href='employee_input'>继续添加</a>
<body>
	<table border="1">
  <tr>
    <th>用户名</th>
    <th>密码</th>
    <th>操作</th>
  </tr>
  <s:iterator value="emps">
  <tr>
    <td><s:property value="username"/></td>
    <td><s:property value="password"/></td>
    <td>
    	<a href='<s:url action="employee_input" ><s:param name="id" value="id"/></s:url>'>编辑</a>
    	<a href='<s:url action="employee_delete" ><s:param name="id" value="id"/></s:url>'>删除</a>
    </td>
  </tr>
  </s:iterator>
</table>

</body>
</html>