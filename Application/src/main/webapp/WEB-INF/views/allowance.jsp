<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allowance Table</title>
</head>
<body>
<font color="red">${message}</font>
	<form:form id="allowanceForm" method="post" action="${pagecontext.request.contextpath}/Application/allowance" modelAttribute="allowanceBean" >

			<form:label path="cmpId">CompanyId</form:label>
			<form:input id="cmpId" name="cmpId" path="" /><br>
			
			<form:label path="hra">House Residence Allowance</form:label>
			<form:input id="hra" name="hra" path="" /><br>
			
			<form:label path="ha">Health Allowance</form:label>
			<form:input id="ha" name="ha" path="" /><br>
			
			<form:label path="da">Dearness Allowance</form:label>
			<form:input id="da" name="da" path="" /><br>
			
			<form:label path="pf">Provident Fund</form:label>
			<form:input id="pf" name="pf" path="" /><br>
			
			<form:label path="pt">Professional Taxes</form:label>
			<form:input id="pt" name="pt" path="" /><br>
			
			
			<input type="submit" value="Submit" />
			
		</form:form>
</body>
</html>