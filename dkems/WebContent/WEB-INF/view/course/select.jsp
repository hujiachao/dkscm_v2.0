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
			function saveCheck() {
				var ids = "";
				$("input[type=checkbox]:checked").each(function(i) {
					ids = ids + this.value + "-";
				});
				ids = ids.substring(0, ids.length - 1);
				$.ajax({
					url: "select.do",
					type: "post",
					data: {
						"ids": ids
					},
					dataType: "json",
					success: function(data) {
						if (data) {
							alert("选课成功！");
						} else {
							alert("选课失败！");
						}
						location.href="personalData.do?userId=${nullList.get(0) }";
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="rol-md-12">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th></th>
								<th style="text-align: center; height:30px; line-height: 30px; font-size: 18px;">课程名称</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="course" items="${nullList.get(1) }" varStatus="s">
								<tr>
									<td align="center">
										<input type="checkbox" style="width: 30px; height: 30px;" value="${course.courseId }" class="form-control" />
									</td>
									<td  align="center" style="text-align: center; height:30px; line-height: 30px; font-size: 18px;">
										${course.courseName }
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2" align="right">
									<a href="javascript:saveCheck();" class="btn btn-success btn-primary btn-lg">选课</a>
								</td>
							</tr>
						</tfoot>	
					</table>
				</div>
			</div>
		</div>
	</body>
</html>