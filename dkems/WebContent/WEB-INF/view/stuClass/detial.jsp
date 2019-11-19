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
				  	<tbody>
					    <tr>
					    	<td align="center">班级编号：</td>
				      		<td colspan="2" align="center">${stuClass.stuClassNo }</td>
				      	</tr>
				      	<tr>
				      		<td align="center">排序：</td>
				      		<td colspan="2" align="center">${stuClass.sortOrder }</td>
				      	</tr>
				    	<tr>
				      		<td align="center">创建时间：</td>
				      		<td colspan="2" align="center">${stuClass.createTime }</td>
				      	</tr>
				  	</tbody>
				  	<tfoot>
				  		<tr>
				  			<td colspan="2" align="center">
				  				<a href="list.do" class="btn btn-success">退出页面</a>
				  			</td>
				  		</tr>
				  	</tfoot>
				</table>
			</div>
		</div>
	</body>
</html>