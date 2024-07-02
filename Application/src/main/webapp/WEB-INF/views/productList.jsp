<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
		<c:forEach items="${productBean}" var= "items" >
	   		<img src="data:image/jpg;base64,${items.pic}" width=200, height=100/><br>
	   		${items.price}<br>
	   		${items.color}<br>
	   		<a href="/Application/productDescription/${items.productId }">${items.productName}</a><br>
	   	</c:forEach>
</body>
</html>