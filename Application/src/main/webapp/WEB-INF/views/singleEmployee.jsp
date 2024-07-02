<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Salary page</title>
</head>
<body>

<font color="red">${message}</font>
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
		
		<tr>
			<td>${pag.cmpId}</td>
			<td>${pag.empId}</td>
			<td>${pag.empName}</td>
			<td>${pag.empSalary}</td>
			<td>${pag.empBean.hra }</td>
			<td>${pag.empBean.ha }</td>
			<td>${pag.empBean.da }</td>
			<td>${pag.empBean.pf }</td>
			<td>${pag.empBean.pt }</td>
			<td>${pag.empBean.basicSalary }</td>
			<td>${pag.empBean.totalSalary }</td>
			<td>${pag.empBean.gss }</td>
			<td>${pag.empBean.netSalary }</td>
			
		</tr>
		
		
	</table>
</body>
</html>