<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
<font color="red">${message}</font>
<form:form id="empForm" method="post" action="${pagecontext.request.contextpath}/Application/empLogin" modelAttribute="empBean" >

			<form:label path="cmpId">CmpId</form:label>
			<form:input id="cmpId" name="cmpId" path="" /><br>
			
			<form:label path="empId">EmpId</form:label>
			<form:input id="empId" name="empId" path="" /><br>
			
			<form:label path="empName">EmpName</form:label>
			<form:input id="empName" name="empName" path="" /><br>
			
			<form:label path="empSalary">EmpSalary</form:label>
			<form:input id="empSalary" name="empSalary" path="" /><br>
			
			
			<input type="submit" value="Submit" />
			
		</form:form>
</body>
</html>