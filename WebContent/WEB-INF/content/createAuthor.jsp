<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增作者</title>
<style>
.center
{
	margin-left:auto;
	margin-right:auto;
	width:25%;
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
	<div id="container" style="width:300px">
		<div id="header" style="background-color:#FF6600;text-align:center">
			<b>该作者不存在</b>
		</div>
		<div id="header" style="background-color:#FFA500;text-align:center">
			<b>请输入该作者的信息</b>
		</div>
		<div id="content" style="background-color:#FFFACD;height:350px;float:left;">
			<form action="insertAuthor" method="post"><br/>
			    AuthorID:<br/><input type="text" name="author.authorID" style="width:300px"/><br/>
			    Name:<br/><input type="text" name="author.name" style="width:300px"/><br/>
			    Age:<br/><input type="text" name="author.age" style="width:300px"/><br/>
			    Country:<br/><input type="text" name="author.country" style="width:300px"/><br/>
		    	<div id="button" style="text-align:center">
		    		<input type="submit" value="OK"/>
		    	</div>
			</form>
		</div>
		<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
			@myLibrary of LouYJ
		</div>
	</div>
</div>
</body>
</html>