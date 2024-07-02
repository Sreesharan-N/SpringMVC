<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subcategory</title>
</head>
<body>
<form:form id="categoryForm" method="get" action="${pagecontext.request.contextpath}/Application/subcategory" modelAttribute="categoryBean" enctype="multipart/form-data">
		<c:forEach items="${categoryBean}" var= "items" >
	   		<img src="data:image/jpg;base64,${items.pic}" width=200, height=100/>
	   		<a href="/Application/brand/${items.categoryId }">${items.categoryName}</a>
	   	</c:forEach>
	   	</form:form>
</body>
</html>