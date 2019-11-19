<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">
	    <link rel="stylesheet" type="text/css" href="../static/css/styles.css">
	    <link rel="stylesheet" type="text/css" href="../static/images/bg-image.jpeg">
	    <title>登录</title>
  	</head>
  	<body>
	    <div id="login-bg" class="container-fluid">
	      <div class="bg-img"></div>
	      <div class="bg-color"></div>
	    </div>
	    <div class="container" id="login">
	        <div class="row justify-content-center">
		        <div class="col-lg-8">
		          <div class="login">
		            <h1>教务管理系统</h1>
		            <form action="login.do" method="post">
		            	<div class="form-group">
		                    <input type="text" name="cellphone" class="form-control" placeholder="请填写手机号码">
		                </div>
		                <div class="form-group">
		                    <input type="password" name="password" class="form-control" placeholder="请填写登录密码">
		                </div>
		                
		                <br>
		                <button type="submit" class="btn btn-lg btn-block btn-success">登录</button>
		             </form>
		          </div>
		        </div>
	        </div>
	    </div>
	  </body>
</html>