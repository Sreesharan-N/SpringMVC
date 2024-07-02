<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee</title>
</head>
<body>
<table>
		<thead><tr>
			<td>cmpId</td>
			<td>empId</td>
			<td>empName</td>
			<td>empSalary</td>
			<td>hra</td>
			<td>ha</td>
			<td>da</td>
			<td>pf</td>
			<td>pt</td>
			<td>basicSalary</td>
			<td>totalSalary</td>
			<td>gss</td>
			<td>netSalary</td>
			</tr>
		</thead>
		<c:forEach items="${alldata}" var="items">
		<tr>
			<td>${items.cmpId}</td>
			<td>${items.empId}</td>
			<td>${items.empName}</td>
			<td>${items.empSalary}</td>
			<td>${items.empBean.hra }</td>
			<td>${items.empBean.ha }</td>
			<td>${items.empBean.da }</td>
			<td>${items.empBean.pf }</td>
			<td>${items.empBean.pt }</td>
			<td>${items.empBean.basicSalary }</td>
			<td>${items.empBean.totalSalary }</td>
			<td>${items.empBean.gss }</td>
			<td>${items.empBean.netSalary }</td>
			
		</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>