<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Products</title>
</head>
<body>
	<h3>Products List</h3>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Adress</th>
			<th>price</th>
		</tr>
		<c:forEach var="customer" items="${customer }">
			<tr>
				<td>${customer.customerID}</td>
				<td>${customer.customerName }</td>
				<td>${customer.customerAddress }</td>
				<td>${customer.billAmount }</td>

			</tr>
		</c:forEach>
	</table>
<h2><a href="index">Home</a></h2>

</body>
</html>