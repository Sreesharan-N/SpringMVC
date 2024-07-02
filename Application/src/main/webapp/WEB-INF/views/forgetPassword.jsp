<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
	<font color="red">${message}</font>
	
	<form:form id="fForm" method="post" action="forgetPassword" modelAttribute="forgotpasswordBean">

			<form:label path="email">Enter your email-id</form:label>
			<form:input id="email" name="email" path="" /><br>
			
			<form:label path="newPassword">Enter your new password</form:label>
			<form:input id="newPassword" name="newPassword" path="" /><br>
			
			<form:label path="confirmPassword">Confirm your password</form:label>
			<form:password id="confirmPassword" name="confirmPassword" path="" /><br>
			
			<input type="submit" value="Submit" />
			
		</form:form>
</body>
</html>