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
<form:form id="dummyForm" method="post" action="dummy" enctype="mutipart/form-data" modelAttribute="dummyBean" >
			<form:label path="image">Upload your image</form:label>
			<form:input type="file" name="image" path="" /><br>
			<input type="submit" value="Submit" />
			
</form:form>
</body>
</html>