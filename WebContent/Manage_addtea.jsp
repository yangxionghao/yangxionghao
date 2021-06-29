<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

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
<body>
  <div style="padding-left: 400px;padding-top: 100px">
<form action="Manage_addteaServlet" method="post" class="form-inline">
		<table  >
	
	 <tr>
	 <td>教师工号&nbsp;&nbsp;</td>
     <td><input type="text" name="teacherid" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td>教师姓名&nbsp;&nbsp;</td>
	<td><input type="text" name="teachername" class="form-control"></td>
	<td></td>
	</tr>
	
	<tr>
	<td></td>
	<td><span id="span1" style="color:red;font-size:15px;text-align:left"></span></td>
	<td></td>
	</tr>
	
	 <tr>
	 <td>教师性别&nbsp;&nbsp;</td>
     <td><input type="text" name="teachersex" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
     <tr>
	 <td>教师所在学院&nbsp;&nbsp;</td>
     <td><input type="text" name="teacherxueyuan" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	 <tr>
	 <td>职称&nbsp;&nbsp;</td>
     <td><select name="teachertype" class="form-control">
     <option value="教授">教授</option>
     <option value="副教授">学生</option>
     <option value="讲师">讲师</option>
     <option value="助教">助教</option>
     </select></td>
	 <td></td>
	 </tr>
	
	  <tr align="center" >
      <td colspan="3" >
      <input type="submit" value="添加" name="botton" style="position:relative;width:170px;heigth:60px;" >
      </td>
      </tr>
      </table>
	</form>
	</div>
</body>
</html>