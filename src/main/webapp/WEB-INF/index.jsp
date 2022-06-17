<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Swag</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Save Travels</h1>
<table class="table">
   	<thead>
   		<tr>
   			<th>ID</th>
   			<th>Expense</th>
   			<th>Vendor</th>
   			<th>Amount</th>
   			<th>Description</th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:forEach  var="allExpenses" items="${ akali }">
   			<tr>
   				<td><c:out value="${ allExpenses.getId() }" /></td>				
   				<td><a href="/expenses/${allExpenses.getId()}"><c:out value="${ allExpenses.getExpense() }" /></a></td>
   				<td><c:out value="${ allExpenses.getVendor() }" /></td>
   				<td><c:out value="${ allExpenses.getAmount() }" /></td>
   				<td><c:out value="${ allExpenses.getDescription() }" /></td>
   				
   				<td class="actions">
							<a href="/expenses/${allExpenses.getId()}/edit">Edit</a>
							<form action="/expenses/${allExpenses.getId()}/delete" method="post">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" value="Delete"/>
							</form>
				</td>
   			</tr>
   		</c:forEach>
   	</tbody>
   </table>




<h2>Add an Expense</h2>
	<form:form action="/munkie" method="post" modelAttribute="travel">
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
</body>
</html>