<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add the products</title>
</head>
<body>
<h1>Please fill the Product details</h1>
<form:form action="saveproduct">
Product Id:<form:input path="productId"/>
Product Name:<form:input path="productName"/></br>
Product Quantity:<form:input path="quantityOnHand"/></br>
Product Price:<form:input path="price"/></br>
<input type="Submit" value="Save">
</form:form>
</body>
</html>

