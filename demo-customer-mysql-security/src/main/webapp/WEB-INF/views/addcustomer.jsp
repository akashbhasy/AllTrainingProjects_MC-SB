<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add the Customer</title>
</head>
<body>
<h1>Please fill the customer details</h1>
<form:form action="savecustomer">
customer Id:<form:input path="customerID"/>
customer Name:<form:input path="customerName"/></br>
customer Address:<form:input path="customerAddress"/></br>
 Price:<form:input path="billAmount"/></br>
<input type="Submit" value="Save">
</form:form>
</body>
</html>

