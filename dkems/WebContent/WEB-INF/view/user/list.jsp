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
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3>学生信息表</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th style="text-align: center">序号</th>
								<th style="text-align: center">学生姓名</th>
								<th style="text-align: center">手机号码</th>
								<th style="text-align: center">学生班级</th>
								<th style="text-align: center">email</th>
								<th style="text-align: center">身份证号码</th>
								<th style="text-align: center">照片</th>
								
								<th style="text-align: center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${page.list }" varStatus="s">
								<tr>
									<td align="center">${(page.pageNum - 1) * page.pageSize + s.count }</td>
									<td align="center">${user.username }</td>
									<td align="center">${user.cellphone }</td>
									<td align="center">${user.stuClass.stuClassNo }</td>
									<td align="center">${user.email }</td>
									<td align="center">${user.idCard }</td>
									<td align="center">${user.photo }</td>
									<td align="center">
										<a href="personalData.do?userId=${user.userId }" class="btn btn-success btn-xs">详情</a>
										<a href="updateFormStu.do?userId=${user.userId }" class="btn btn-warning btn-xs">修改</a>
										<a href="delete.do?userId=${user.userId }" class="btn btn-danger btn-xs">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="9" align="center">
									<ul class="pagination">
										<li><a href="list.do?num=${page.pageNum == 1 }">首页</a></li>
										<c:choose>
											<c:when test="${page.pageNum == 1 }">
												<li><a href="#">&laquo;上一页</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="list.do?num=${page.pageNum - 1 }">&laquo;上一页</a></li>
											</c:otherwise>	
										</c:choose>
									    <li>
									    	<a href="#">
									    		共查询${page.totalCount }条，分${page.totalPage }页显示，当前是第${page.pageNum }页
									    	</a>
									    </li>
									    <c:choose>
											<c:when test="${page.pageNum == page.totalPage }">
												<li><a href="#">&&raquo;下一页</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="list.do?num=${page.pageNum + 1 }">&&raquo;下一页</a></li>
											</c:otherwise>	
										</c:choose>
										<li><a href="list.do?num=${page.totalPage }">末页</a></li>
									</ul>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>