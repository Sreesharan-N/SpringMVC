<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
	<form:form id="categoryForm" method="get" action="${pagecontext.request.contextpath}/Application/category" modelAttribute="categoryBean" enctype="multipart/form-data">
	   	<c:forEach items="${categoryBean}" var= "items" >
	   		<img src="data:image/jpg;base64,${items.pic}" width=200, height=100/>
	   		<a href="/Application/subcategory/${items.categoryId }">${items.categoryName}</a>
	   	</c:forEach>
	</form:form>
</body>
</html>