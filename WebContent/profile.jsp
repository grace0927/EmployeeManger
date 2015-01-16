<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Employee Manager </title>
</head>
<body>
<h3> Welcome, ${requestScope['employee'].getUsername()}</h3>
<p>First Name: ${requestScope['employee'].getFirstName()} <br>
Last Name: ${requestScope['employee'].getLastName()} <br>
Email: ${requestScope['employee'].getEmail()} <br>

</body>
</html>