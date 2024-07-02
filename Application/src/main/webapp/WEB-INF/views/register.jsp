<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<font color="red">${message}</font>
	
	<form:form id="registerForm" method="post" action="register" enctype="multipart/form-data" modelAttribute="registerBean" >

			<form:label path="username">Enter your user-name</form:label>
			<form:input id="username" name="username" path="" /><br>
			
			<form:label path="password">Please enter your password</form:label>
			<form:password id="password" name="password" path="" /><br>
			
			<form:label path="email">Enter your e-mail</form:label>
			<form:input id="email" name="email" path="" /><br>
			
			<form:label path="phoneno">Enter your phone_no</form:label>
			<form:input id="phoneno" name="phoneno" path="" /><br>
			
			<form:label path="image">Upload your image</form:label>
			<form:input type="file" id="image" name="image" path="image" /><br>
			
			
			
			<input type="submit" value="Submit" />
			
		</form:form>
</body>
</html>