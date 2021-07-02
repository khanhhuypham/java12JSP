<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div style = "width: 500px; margin: auto;">
	<h2>LOGIN</h2>
	<% String path = request.getContextPath();%>
	
	<form action = "<%= path %>/login" method = "post">
		<label>Username</label>
		<input type = "text" name = "username">
		
		<label>Password</label>
		<input type = "password" name = "password">
		
		<button type = "submit">Login</button>
	</form>
</div>

</body>
</html>