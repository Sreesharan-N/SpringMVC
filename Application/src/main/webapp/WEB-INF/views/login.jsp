<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<font color="red">${message}</font>
		<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">

			<form:label path="email">Enter your E-mail</form:label>
			<form:input id="email" name="email" path="" /><br>
			<form:label path="password">Please enter your password</form:label>
			<form:password id="password" name="password" path="" /><br>
			<a href="forgetPassword">forgetPassword?</a><br>
			<input type="submit" value="Submit" />
			<a href="register">Register</a>
			
		</form:form>
		
</body>
</html>