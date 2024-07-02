<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brand</title>
</head>
<body>
	<c:forEach items="${categoryBean}" var= "items" >
	   		<img src="data:image/jpg;base64,${items.pic}" width=200, height=100/>
	   		<a href="/Application/productList/${items.categoryId }">${items.categoryName}</a>
	   	</c:forEach>
</body>
</html>