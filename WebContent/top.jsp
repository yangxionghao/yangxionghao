<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>Bootstrap基本模板</title>

		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
			<!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.8.3.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.min.js"></script>
		<title></title>
		<style>
		#top{
		border:1px solid red;
		
		height:60px;
		width:50%;
		padding-left: 10px;
		}
		</style>
	</head>
	<body>
	     <label for="typename">欢迎您！<%=session.getAttribute("usertype")%></label>
		 <div  style="float:right;"><a href="denglu.jsp" target="_top">首页</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="denglu.jsp" target="_top">退出登录</a></div>
	</body>
</html>