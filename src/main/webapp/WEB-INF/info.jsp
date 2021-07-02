<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>LOGIN INFORMATION</h2>
	<p>User name: <%= request.getAttribute("name") %></p>
	<p>password: <%= request.getAttribute("pass") %></p>
</body>
</html>