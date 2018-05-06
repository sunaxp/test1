<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login page</title>
<style type="text/css">
body{
	background-image:url('images/4.jpg');
	
}
.head{

	margin:auto;
	padding:40px;
	height:20%;
	font-size:5pm;
	text-align:center;
	//text-shadow: 5px 5px 5px #FF0000;
	font-family:"Times New Roman";
	font-size:30px;
	background-color:#E6E6E6;
}
</style>
</head>
<body>
<div>
	<div class="head">用户登陆界面</div>
	<div>
	<form action="/userServlet" name="frm" method="post">
		<div>
			username：<input type="text" name ="username" placeholder="username">
		</div>
		<div>
			password：<input type="text" name ="password" placeholder="password">
		</div>
		<div>
			 <input type="submit" name="Submit" value=" 提交" onclick="return validateLogin()">  
			 <input type="reset" name="Reset" value="重置" />
		</div>
		</form>
	</div>
</div>
<script>
	function validateLogin(){
		var sUsername=document.frm.username.value;
		var sPassword=document.frm.password.value;
		if(sUsername==""){
			alert("请输入用户名！");
			return false;
		}
		if(sPassword==""){
			alert("请输入密码");
			return false;
		}
	}
</script>
</body>
</html>