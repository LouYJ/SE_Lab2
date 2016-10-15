<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到图书管理系统</title>
<style>
.center
{
	margin-left:auto;
	margin-right:auto;
	width:40%;
}
</style>
</head>

<body>
	<div class="center">
	<div id="container" style="width:500px;text-align:center">
	<div id="header" style="background-color:#FFA500;">
		<h1 style="margin-bottom:0;">图书数据库管理系统</h1></div>
		<div id="menu" style="background-color:#FFD700;height:200px;width:500px;float:left;">
			<br/><br/>
			<a href="welcome">查询作者</a><br/>
			<a href="createBook">新增图书</a><br/>
			<a href="displayAuthors">查看所有作者</a><br/>
			<a href="displayBooks">查看所有图书</a><br/>
			<a href="upgrade">更新图书信息</a><br/>
		</div>
	<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
	@myLibrary of LouYJ</div>
	</div>
	</div>
</body>
</html>