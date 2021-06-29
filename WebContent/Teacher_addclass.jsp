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
<style>
#son{
padding-bottom:3px;
/*border:1px solid red;*/
text-align: center;
width:auto;
}
#father{
padding-top: 150px;
padding-left: 250px;
}
</style>
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
<body>
<form action="Teacher_addclassServlet" method="post" class="form-inline">
	 <div id="father">
	 <div id="son">
	 <label for="classid">课程编号：</label>
     <input type="text" name="classid" placeholder="#000000" class="form-control">
     </div>
	
	 <div id="son">
	 <label for="classname">课程名称：</label>
     <input type="text" name="classname" class="form-control">
     </div>

	 <div id="son">
	 <label for="classnumber">课程人数：</label>
     <input type="text" name="classnumber" class="form-control">
     </div>
	

	 <div id="son">
	 <label for="classname">任课教师：${tea.teachername}</label>
     </div>
  
	
      <div id="son">
      <input type="submit" value="添加" name="botton" class="btn btn-default" >
      </div>
      </div>
	</form>
</body>
</html>