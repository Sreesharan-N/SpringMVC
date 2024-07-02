 <%@include file="nav.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
</head>
<body>


	<c:forEach items="${form.cartentry}" var= "items" >
	<img src="data:image/jpg;base64,${items.product.pic}" width=200, height=100/><br>
	   		${items.product.productName}<br>
	   		Price:${items.price}<br>
	   		Color:${items.product.color}<br>
	   		
	<form:form action="${pagecontext.request.contextpath}/Application/deleteCart" method="post" modelAttribute="delete">
	
		<button type="submit">Delete</button><br>
		<input type="hidden" value="${items.cartId}" name="cartId">
		<input type="hidden" value="${items.productId}" name="productId">
	</form:form>
	<br>
	   		
	 <form:form action="${pagecontext.request.contextpath}/Application/updateCart" method="post" modelAttribute="update">
	
		<input type="number" value="${items.quantity}" name="quantity" min="1" max="10">
		<input type="hidden" value="${items.entryId}" name="entryId">
		<button type="submit">update</button>
		
	</form:form>
	<br>
	
	</c:forEach>
	<p>SubTotal(${form.cartbean.totalQuantity}):${form.cartbean.subTotal}
	
	
</body>
</html>