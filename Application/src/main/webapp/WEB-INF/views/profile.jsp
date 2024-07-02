<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<center><font color="red">${message}</font></center>

	<form:form id="profileForm" method="get" action="profile" modelAttribute="profileBean" enctype="multipart/form-data">

<center>Profile details of ${profileBean.username}	<br>


			<img src="data:image/jpg;base64,${profileBean.pic}" width=300, height=300/><br>
			<br>

			UserName:${profileBean.username}<br/>
			
			Email:${profileBean.email}<br/>
			
			Phoneno:${profileBean.phoneno}<br/>
			
			<a href="editProfile?emailId=${profileBean.email}">Edit Profile</a>
			
			</center>
			
		</form:form>
</body>
</html>