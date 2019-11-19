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
			function save() {
				var formData = $("#myForm").serialize();
				$.ajax({
					url: "add.do",
					type: "post",
					data: formData,
					dataType: "json",
					success: function(data) {
						if(data) {
							alert("添加成功！");
							location.href="list.do";
						} else {
							alert("添加失败！");
							location.href="addForm.do";
						}
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<a href="addForm.do" class="btn btn-success">增加课程</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form id="myForm">
						<table>
							<tr>
								<td>课程名称：</td>		
								<td>
									<input type="text" name="courseName" class="form-control"/>
								</td>					
							</tr>
							<tr>
								<td colspan="2" align="right">
									<a href="javascript:save();" class="btn btn-success">保存</a>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>