<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form id="editForm" method="post" action="editProfile" modelAttribute="editBean" enctype="multipart/form-data">
            
			<form:label path="username">Enter your user-name</form:label>
			<form:input id="username" name="username" path="" value="${editBean.username }"/><br>
			
			<form:label path="password">Please enter your password</form:label>
			<form:password id="password" name="password" path="" value="${editBean.password }"/><br>
			
			<form:label path="email">Enter your e-mail</form:label>
			<form:input type="readonly" id="email" name="email" path="" value="${editBean.email }"/><br>
			
			<form:label path="phoneno">Enter your phone_no</form:label>
			<form:input id="phoneno" name="phoneno" path="" value="${editBean.phoneno }"/><br>
			
			<form:label path="image">Upload your image</form:label>
			<form:input type="file" id="image" name="image" path="image" value="${editBean.image }"/><br>
			
			
			
			<input type="submit" value="Submit" />
			
		</form:form>
</body>
</html>