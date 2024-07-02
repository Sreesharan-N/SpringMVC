<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee</title>
</head>
<body>
	<form:form id="allallowanceForm" method="post" action="${pagecontext.request.contextpath}/Application/allallowance" modelAttribute="allallowanceBean" >
		<form:label path="empId">EmployeeId</form:label>
			<form:input id="empId" name="empId" path="" /><br>
			<input type="submit" value="Submit" /><br>
			<a href="all">all</a>
	</form:form>
</body>
</html>