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
			function saveChange() {
				var formData = $("#myform").serialize();
				$.ajax({
					url: "update.do",
					type: "post",
					data: formData,
					dataType: "json",
					success: function(data) {
						if (data) {
							alert("修改成功！");
						} else {
							alert("修改失败！");
						}
						location.href="list.do";
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
							    		<label>姓名:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="username"  value="${user.username }">
								    	<input type="hidden" name="userId" value="${user.userId }">
										<input type="hidden" name="password" value="${user.password }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center" >
							    		<label>手机号码:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="cellphone"  value="${user.cellphone }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center">
										<label>身份角色：</label>
									</td>
									<td align="center">
										<input type="text" id="myrole" class="form-control" name="role"  value="${user.role.roleName }" />
									</td>
									<td></td>		
						  		</tr>
						  		<tr>
							  		<td></td>
										<td align="center">
											<label>班级：</label>
										</td>
									<td align="center">
											<input type="text" id="myclass" class="form-control" name="stuClass"  value="${user.stuClass.stuClassNo }" />
									</td>
									<td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center">
							    		<label>身份证号码:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="myclass" type="text" name="idCard"  value="${user.idCard }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center">
							    		<label>email:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="email"  value="${user.email }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
						  			<td></td>
									<td align="center" >
							    		<label>照片:</label>
							    	</td>
							    	<td align="center">
								    	<input class="form-control" id="focusedInput" type="text" name="photo"  value="${user.photo }">
								    </td>
								    <td></td>
						  		</tr>
						  		<tr>
							  		<td></td>
									<td align="center">
										<label >状态：</label>
										<input class="form-control" id="focusedInput" type="hidden" name="status"  value="${user.status }">
									</td>
									<td align="center">
									</td>
									<td></td>	
						  		</tr>
					  			</tbody>
					  		<tfoot>
					  			<tr>
					  				<td></td>
						  			<td colspan="2" align="center">
						  				<a href="javascript:saveChange();" class="btn btn-success">提交信息</a>
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