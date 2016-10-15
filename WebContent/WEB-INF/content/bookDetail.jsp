<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
<style>
.center
{
	margin-left:auto;
	margin-right:auto;
	width:20%;
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
	<%
		//request.setCharacterEncoding("UTF-8");
		String book = request.getParameter("Title");
		//String book=request.getParameter("Title");
		String []bookDb =book.split("\\*");
		System.out.print(bookDb[5]);
	%>
	
	<table>
		<tr><th>ISBN</th><td><%=bookDb[0]%></td></tr>
		<tr><th>Title</th><td><%=bookDb[1]%></td></tr>
		<tr><th>AuthorID</th><td><%=bookDb[2]%></td></tr>
		<tr><th>Publiser</th><td><%=bookDb[3]%></td></tr>
		<tr><th>PubliserDate</th><td><%=bookDb[4]%></td></tr>
		<tr><th>Price</th><td><%=bookDb[5]%></td></tr>	
	</table>
	<br/>
	<a href="index">点此返回主页～</a>
</div>
</body>
</html>