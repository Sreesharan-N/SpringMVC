<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Table</title>
</head>
<body>
<center>
<font color="red">${message}</font>
<table>
		<thead><tr>
			<td>cmpId</td>
			<td>empId</td>
			<td>empName</td>
			<td>empSalary</td>
			</tr>
		</thead>
		<c:forEach items="${result}" var= "items" >
		<tr>
			<td>${items.cmpId}</td>
			<td>${items.empId}</td>
			<td>${items.empName}</td>
			<td>${items.empSalary}</td>
		</tr>
		</c:forEach>
		
	</table></center>
	
	<a href="allowance">all</a>
</body>
</html>