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
			function onclick () {
				var formData = $("#myform").serialize();
				$.ajax({
					url: "update.do",
					type: "post",
					data: formData,
					dataType: "json",
					success: function(data) {
						if(data) {
							alert("修改成功！");
							location.href="list.do";
						} else {
							alert("修改失败！");
							location.href="list.do";
						}
					}
				});
				
			}
		</script>
	</head>
	<body>
		<div class="row">
			<div class="col-mad-12">
					<form id="myform" class="form-horizontal" role="form">
						<table class="table table-bordered table-hover table-striped">
							<tbody>
								<tr>
									<td></td>
									<td align="center">
							    		<label>课程名称:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text"  name="courseName"  value="${course.courseName }">
										<input type="hidden" name="courseId"  value="${course.courseId }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
									<td></td>
									<td align="center">
							    		<label>课程编号:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="courseCode"  value="${course.courseCode }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center" >
							    		<label>排序:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="sortOrder"  value="${course.sortOrder }">
								    </td>
								    <td></td>
						  		</tr>
					  		</tbody>
					  		<tfoot>
					  			<tr>
					  				<td></td>
						  			<td colspan="2" align="right">
						  				<a href="javascript:onclick();" class="btn btn-success">提交信息</a>
						  			</td>
						  			<td></td>
					  			</tr>
					  		</tfoot>
					  	</table>
					</form>
				</div>
		</div>
	</body>
</html>