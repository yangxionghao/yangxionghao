<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<meta charset="UTf-8">
<title>Insert title here</title>
</head>
<%
Object message = request.getAttribute("message");
if(!"".equals(message) && message!=null){
%>
	<script type="text/javascript">

	alert("<%=request.getAttribute("message")%>");
	
	</script>
	<% }%>
<body>
<script type="text/javascript">
$(function(){
	$("#zhicheng option[value='${tea.teachertype}']").prop("selected",true);
});
</script>
<form action="Teacher_UpdateServlet" method="post" class="form-inline">
		<table style="position:relative;top:200px;left:600px;cellspacing:1;border:0" >
	
	 <tr>
	 <td>教师工号&nbsp;&nbsp;</td>
     <td><input type="text" name="teacherid" value="${tea.teacherid}" readonly="true" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	<tr>
	<td>教师姓名&nbsp;&nbsp;</td>
	<td><input type="text" name="teachername" value="${tea.teachername}" readonly="true" class="form-control"></td>
	<td></td>
	</tr>
	
	<tr>
	<td></td>
	<td><span id="span1" style="color:red;font-size:15px;text-align:left" ></span></td>
	<td></td>
	</tr>
	
	 <tr>
	 <td>教师性别&nbsp;&nbsp;</td>
     <td><input type="text" name="teachersex" value="${tea.teachersex}" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
     <tr>
	 <td>教师所在学院&nbsp;&nbsp;</td>
     <td><input type="text" name="teacherxueyuan" value="${tea.teacherxueyuan}" class="form-control"></td>
	 <td></td>
	 </tr>
	
	<tr>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	 <tr>
	 <td>职称&nbsp;&nbsp;</td>
     <td><select name="teachertype" id="zhicheng" class="form-control">
     <option value="教授">教授</option>
     <option value="副教授">学生</option>
     <option value="讲师">讲师</option>
     <option value="助教">助教</option>
     </select></td>
	 <td></td>
	 </tr>
	
	  <tr align="center" >
      <td colspan="3" >
      <input type="submit" value="确定" name="botton" style="position:relative;width:170px;heigth:60px;" class="form-control">
      </td>
      </tr>
      </table>
	</form>
</body>
</html>