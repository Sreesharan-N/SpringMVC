<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Description</title>
</head>
<body >	

	   		<img src="data:image/jpg;base64,${productBean.pic}" width=200, height=100/><br>
	   		${productBean.productName}<br>
	   		${productBean.price}<br>
	   		${productBean.color}<br>
	   		${productBean.details}<br>
	   		${productBean.model}<br>
	   		${productBean.features}<br>	 
	   		
	 <form action="${pagecontext.request.contextpath}/Application/addtocart" method="post" modelAttribute="data">
	 
	 	Quantity:<input type="number" value="1" name="quantity" min="1" max="10">
	 	<input type="hidden" name="price" value="${productBean.price}">
	 	<input type="hidden" name="productId" value="${productBean.productId}">
	 <br>
	   	<button type="submit">Add to cart</button>
	   	<button type="button" >Buy now</button>
	   	
	   </form>
</body>
</html>