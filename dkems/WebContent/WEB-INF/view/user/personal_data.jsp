<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../static/css/font-awesome.min.css">
		<script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="row">
			<div class="col-mad-12">
				<table class="table table-condensed table-hover">
					<caption style="text-align: center; font: 18px bold">
						${list.get(0).role.roleName }个人信息
					</caption>
				  	<tbody>
					    <tr>
					    	<td align="center">姓名：</td>
				      		<td colspan="2" align="center">${list.get(0).username }</td>
				      	</tr>
				      	<tr>
				      		<td align="center">手机号码：</td>
				      		<td colspan="2" align="center">${list.get(0).cellphone }</td>
				      	</tr>
				    	<tr>
				      		<td align="center">身份角色：</td>
				      		<td colspan="2" align="center">${list.get(0).role.roleName }</td>
				      	</tr>
				      	<tr>
				     	 	<c:choose>
				    			<c:when test="${list.get(0).role.roleId == 1 }">
				    				<td align="center">教授班级：</td>
				      				<td colspan="2" align="center">${list.get(0).stuClass.stuClassNo }</td>
				    			</c:when>
				    			<c:otherwise>
				    				<td align="center">所在班级：</td>
				      				<td colspan="2" align="center">${list.get(0).stuClass.stuClassNo }</td>
				    			</c:otherwise>
				    		</c:choose>
				     	</tr>
				    	<tr>
				      		<td align="center">身份证号码：</td>
				      		<td colspan="2" align="center">${list.get(0).idCard }</td>
				      	</tr>
				      	<tr>
				     	 	<td align="center">email：</td>
				      		<td colspan="2" align="center">${list.get(0).email }</td>
				      	</tr>
				      	<tr>
				      		<td align="center">状态：</td>
				      		<td colspan="2" align="center">${list.get(0).status }</td>
				      	</tr>
				      	<c:choose>
				      		<c:when test="${list.get(0).role.roleId == 1 }">
				      			<c:forEach var="course" items="${list.get(1) }" varStatus="s" >
									<tr>
										<td align="center">教授课程：</td>
						      			<td align="center">${course.courseName }</td>
						      			<td align="center">${course.courseCode }</td>
									</tr>
				      			</c:forEach>
				      		</c:when>
				      		<c:otherwise>
				      			<c:forEach var="course" items="${list.get(1) }" varStatus="s" >
									<tr>
										<td align="center">已选课程：</td>
						      			<td align="center">${course.courseName }</td>
						      			<td align="center">${course.courseCode }</td>
									</tr>
				      			</c:forEach>
				      		</c:otherwise>
				      	</c:choose>
				  	</tbody>
				  	<tfoot>
				  		<tr>
				  			<td colspan="3" align="center">
				  				<a href="loginForm.do" class="btn btn-success">退出页面</a>
				  				<a href="updateForm.do?userId=${list.get(0).userId }" class="btn btn-danger">修改信息</a>
				  			</td>
				  		</tr>
				  	</tfoot>
				</table>
			</div>
		</div>
	</body>
</html>