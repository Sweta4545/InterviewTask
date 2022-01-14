<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored ="false" %>
    
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #F0F8FF;">
		
		<div style="text-align: right;">
		<%
			if (session.getAttribute("adminName") != null) {
		%>
		<b>Welcome :</b>
		<%
			out.print(session.getAttribute("adminName"));
		%>
		<%
			}
		%>
		<br><a href="adminLogout.html">Log Out</a>
		</div>
		
Account Details<br>
<core:if test="${!empty allAccountList}">				
<table class="table">
				<thead class="thead-light">
					<tr>
						<th><core:out value="AccountNumber"></core:out></th>
						<th><core:out value="AccountOpenDate"></core:out></th>
						<th><core:out value="AccountCloseDate"></core:out></th>
						<th><core:out value="Balance"></core:out></th>
						<th><core:out value="AccountType"></core:out></th>
						<th><core:out value="CustomerId"></core:out></th>
						<th><core:out value="Action"></core:out></th>
					</tr>
					<core:forEach var="account" items="${allAccountList}">
						<tr>
							<td><core:out value="${account.accountNumber}"></core:out></td>
							<td><core:out value="${account.accountOpenDate}"></core:out></td>
							<td><core:out value="${account.accountCloseDate}"></core:out></td>
							<td><core:out value="${account.balance}"></core:out></td>
							<td><core:out value="${account.accountType}"></core:out></td>
							<td><core:out value="${account.customerId}"></core:out></td>
							<td><a
								href="deleteAccount.html?accountId=${account.accountId}"><i
									class="far fa-trash-alt"></i></a>
							<a
								href="addAccount.html?accountId=${account.accountId}"><i
									class="far fa-pencil-alt"></i></a></td>
			
						</tr>

					</core:forEach>
			</table>
				</core:if>
			
		
		<div class="container text-center">
				<a href="addAccount.html" class="btn btn-outline-success">Add
					Account</a>
			</div>
		
		
		
		

</html>