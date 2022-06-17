<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Details</title>
</head>
<body>

<div class="cont">
		<div>
			<h1>Expense Details</h1>
		</div>
		<div class="dawb">
			<p>Expense Name: ${yeet.getExpense()}</p>
			<p>Expense Description: ${yeet.getDescription()}</p>
			<p>Vendor: ${yeet.getVendor()}</p>
			<p>Amount: <fmt:formatNumber value="${yeet.getAmount()}" minIntegerDigits="2" type="currency"/></p>
		</div>
	</div>
<a href="/expenses">Go Back</a>
</body>
</html>