<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>登录</title>

		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
			<!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.8.3.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.min.js"></script>
<style>
#first{
padding-bottom:3px;
margin-left:50px;
margin-top:80px;
text-align:center;
align-content:center;
/*border:1px solid red;*/
width: auto;

}
#end{
padding-bottom:3px;
padding-left:50px;
text-align:center;
/*border:1px solid red;*/
width: auto;
  	
}
#father{
border-radius:10px;
background-color:#A9A9A9;
width:350px;
height:300px;
/*border:1px solid red;*/
margin-top: 200px;
margin-left: 700px;

}

</style>
<title>Insert title here</title>
</head>
   <%
		Object message = request.getAttribute("message");
		if (message != null && !"".equals(message)) {
	%>
	<script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	</script>
	<%
		}
	%>
<body background="img/3.jpg">
<form action="ManagerServlet" method="post" class="form-inline">
<div id="father"  >
<div id="first" class="form-group" >
<label for="usertype">用户类型：</label>
<select name="usertype"   class="form-control" style="width:200px;">
<option value="教师">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教师</option>
<option value="同学">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生</option>
<option value="管理员">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员</option>
</select>
</div>

<div id="end" class="form-group">
<label for="userid">用户编号：</label>
<input type="text" name="userid"  class="form-control">
</div>


<div id="end" class="form-group">
<label for="userpassword">用户密码：</label>
<input type="password" name="userpass"   class="form-control">
</div>

<div id="end" >
<input type="submit" value="登录" style="width:150px;" class="btn btn-default" >
</div>
</div>
</form>
</body>
</html>