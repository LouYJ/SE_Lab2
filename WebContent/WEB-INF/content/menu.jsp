<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找到的图书</title>
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
	<div id="container" style="width:500px;text-align:center">
		<div id="header" style="background-color:#FFA500;">
			<b>下列是作者：<s:property value="author.name"/>的作品</b>
		</div>
		<div id="header1" style="background-color:#FFD700;">
			<b>点击书名查看图书具体信息</b>
		</div>

		<s:iterator value="bookList" var="book">
		<div id="menu" style="background-color:#FFFACD;width:450px;float:left;">
			<a href="bookDetail?Title=${book.isbn }+*+${book.title }+*+${book.authorID }+*+
			${book.publisher }+*+${book.publishdate }+*+${book.price }">${book.title }</a>
		</div>
		<div id="content" style="background-color:#FFFACD;width:50px;float:left;">
			<a href="deleteQuery?Title=${book.isbn }+*+${book.title }+*+${book.authorID }+*+
			${book.publisher }+*+${book.publishdate }+*+${book.price }">删除</a>
		</div>
		</s:iterator>
		<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
			@myLibrary of LouYJ
		</div>
		
	</div>
</div>
</body>
</html>