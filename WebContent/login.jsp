<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Manager System</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$().ready(function(){
	$('#auth').submit(function() {
		var username = $('#username').val();
		var password = $('#password').val();
		$.post('loginAuth',{username:username,password:password},function(response){
			$('#display').html(response);
			});
		return false;
		});
});
</script>
</head>
<body>
<h3> Employee Manage System</h3>
<div id="display">
<form id="auth" method="post">
UserName: <input id="username" type="text" name="username"><br/>
Password: <input id="password" type="password" name="password"><br/>
<input id="submit" type="submit" value="Submit">
</form>
</div>
</body>
</html>