<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库图书信息</title>
<style>
.center
{
	margin-left:auto;
	margin-right:auto;
	width:40%;
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
	<table border="5">
	<tr>
	<th>ISBN</th><th>Title</th><th>AuthorID</th><th>Publisher</th><th>PublishDate</th><th>Price</th>
	</tr>
	<s:iterator value="books" var="book">
		<tr>
		<td><s:property value="isbn"/></td>
		<td><s:property value="title"/></td>
		<td><s:property value="authorID"/></td>
		<td><s:property value="publisher"/></td>
		<td><s:property value="publishdate"/></td>
		<td><s:property value="price"/></td>
		</tr>
	</s:iterator>
	</table>
	<br/>
	<a href="index">点此返回主页～</a>
</div>
</body>
</html>