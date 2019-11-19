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
		<script type="text/javascript">
			function list(url) {
				var iframe = "<iframe src='"+ url +"' style='width: 100%; height: 700px; border: 0'></iframe>";
				$("#mydiv").html(iframe);
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>教务管理系统</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-default" role="navigation">
					    <div class="container-fluid">
						    <div class="navbar-header">
						        <a class="navbar-brand" href="index.do">DKEMS</a>
						    </div>
						    <div>
						        <ul class="nav navbar-nav navbar-left">
						        	<c:choose>
						        		<c:when test="${sessionScope.user.role.roleId == 1 }">
						        			<li><a href="javascript:list('../stuClass/list.do') ">班级管理</a></li>
						        			<li><a href="javascript:list('../course/list.do') ">课程管理</a></li>
						        			<li><a href="javascript:list('../user/list.do') ">学生管理</a></li>
						        		</c:when>
						        		<c:otherwise>
						        			<li><a href="javascript:list('../user/selectForm.do')">学生选课</a></li>
						        		</c:otherwise>
						        	</c:choose>
						            <li><a href="javascript:list('../user/personalData.do?userId=${sessionScope.user.userId }') ">个人信息</a></li>
						        </ul>
						        <ul class="nav navbar-nav navbar-right">
						        	<li style="margin:15px 0 0 0">
						        		欢迎 
						        		<i class="fa fa-user"></i>
						        		<span style="text-decoration: none">${sessionScope.user.username }</span>
						        	</li>
						            <li>
						            	<a href="logout.do">
						            		<i class="fa fa-sign-out" aria-hidden="true"></i>
						            		退出系统
						            	</a>
						            </li>
						        </ul>
						    </div>
					    </div>
					</nav>
				</div>
			</div>
			<div class="row">
				<div id="mydiv" class="col-md-12"></div>
			</div>
		</div>
	</body>
</html>