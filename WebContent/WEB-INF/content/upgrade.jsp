<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新图书信息</title>
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
<div id="container" style="width:350px">
	<div id="header" style="background-color:#FFA500;text-align:center">
		<b>请输入你想要更新的图书信息</b>
	</div>
	<div id="content" style="background-color:#FFFACD;height:350px;float:left;">
		<form action="upgradebook" method="post"><br/>
		
			ISBN:<br/><input type="text" name="book.isbn" style="width:350px"><br/>
			Title：<br/><input type="text" name="book.title" style="width:350px"><br/>
		    AuthorID:<br/><input type="text" name="book.authorID" style="width:350px"/><br/>
		    Publisher:<br/><input type="text" name="book.publisher" style="width:350px"/><br/>
		    PublishDate:<br/><input type="text" name="book.publishdate"style="width:350px"/><br/>
		    Price:<br/><input type="text" name="book.price" style="width:350px"/><br/>
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