<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<center>Welcome ${loggedInUser}</center>
	<center>${message}</center><br>
	<a href="profile?emailId=${loggedInUser}">View Profile</a>
	
	
	<!--  		<form:form id="profileForm" method="get" action="welcome" modelAttribute="userBean" >
	
			UserName:${userBean.username}<br/>
			
			
			Email:${userBean.email}<br/>
			
			Phoneno:${userBean.phoneno}<br/>
			
			
			<a href="/SpringMVCloginExample/Delete?cartid=${cartentry.cartId}&entryid=${cartentry.entryId}">
		</form:form>-->
			
			
			
		
	
</body>
</html>