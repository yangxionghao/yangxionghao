<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped">
			<tr>
				<td align="center" ><a href="Student_update.jsp" target="right"><span id="span1" style="color:blue;font-size:15px;text-align:left">修改个人信息</span></a></td>
			</tr>
			
			<tr>
				<td align="center"><a href="Student_xuankeServlet" target="right"><span id="span2" style="color:blue;font-size:15px;text-align:left" >选课</span></a></td>
			</tr>

            <tr>
				<td align="center"><a href="Student_lookclassServlet" target="right"><span id="span3" style="color:blue;font-size:15px;text-align:left" >浏览课程信息</span></a></td>
			</tr>
			</table>
</body>
</html>