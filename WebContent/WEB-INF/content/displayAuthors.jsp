<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库作者信息</title>
<style>
.center
{
	margin-left:auto;
	margin-right:auto;
	width:30%;
}
table, td, th
{
	border:1px solid green;
}
th
{
	background-color:green;
	color:white;
}
</style>
</head>

<body>
<div class="center">
	<table border="1">
	<tr>
	<th>AuthorID</th><th>Name</th><th>Age</th><th>Country</th>
	</tr>
		
	<s:iterator value="authors" var="author">
	<tr>
		<td><s:property value="authorID"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="age"/></td>
		<td><s:property value="country"/></td>
	</tr>
	</s:iterator>
	</table>
	<a href="index">点此返回主页～</a>
</div>
</body>
</html>