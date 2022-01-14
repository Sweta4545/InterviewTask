<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #F0F8FF;">

<form:form modelAttribute="accountForm">
		<table>
			<tr>
				<td><form:label path="accountNumber">Account Number:</form:label></td>
				<td><form:input path="accountNumber" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="accountOpenDate">Account Open Date:</form:label></td>
				<td><form:input path="accountOpenDate" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="accountCloseDate">Account Close Date:</form:label></td>
				<td><form:input path="accountCloseDate" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="balance">Balance:</form:label></td>
				<td><form:input path="balance" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="accountType">Account Type:</form:label></td>
				<td><form:input path="accountType" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="customerId">Customer Id:</form:label></td>
				<td><form:input path="customerId" size="26" /></td>
			</tr>
			<tr>
				<td><input class="btn btn-success" type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>