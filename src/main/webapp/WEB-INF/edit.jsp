<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert expense here</title>
</head>
<body>
	<h1>Edit Expense</h1>
	
	<form:form action="/expenses/${foot.id}/edit/edited" method="post" modelAttribute="foot">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="expense">Expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
<a href="/expenses">Go Back</a>
</body>
</html>