<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除信息</title>
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
	<h2>删除作品信息</h2>
	<%
		//request.setCharacterEncoding("UTF-8");
		String book = request.getParameter("Title");
		//String book=request.getParameter("Title");
		String []bookDb =book.split("\\*");
		System.out.print(bookDb[5]);
	%>
	<form action="deleteAction" method="post">
		ISBN:<br/><input type="text" placeholder="ISBN" readonly="readonly " value="<%=bookDb[0]%>" name="book.isbn"><br/>
		Title:<br/><input type="text" placeholder="Title" readonly="readonly " value="<%=bookDb[1]%>" name="book.title"><br/>
		AuthorID:<br/><input type="text" placeholder="AuthorID" readonly="readonly " value="<%=bookDb[2]%>" name="book.authorID"><br/>
		Publisher:<br/><input type="text" placeholder="Publisher" readonly="readonly " value="<%=bookDb[3]%>" name="book.publisher"><br/>
		PublishDate:<br/><input type="text" placeholder="PublishDate" readonly="readonly " value="<%=bookDb[4]%>" name="book.publishdate"><br/>
		Price:<br/><input type="text" placeholder="Price" readonly="readonly " value="<%=bookDb[5]%>" name="book.price"><br/>
		<input type="submit" value="删除"/>
		<a href="welcome">返回</a>
	</form>
</div>
</body>
</html>