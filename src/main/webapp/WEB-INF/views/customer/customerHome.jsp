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
			if (session.getAttribute("fullName") != null) {
		%>
		<b>Welcome :</b>
		<%
			out.print(session.getAttribute("fullName"));
		%>
		<%
			}
		%>
		<br><a href="customerLogout.html">Log Out</a>
		</div>
		
		My Account Details
		
		<table class="table">
				<thead class="thead-light">
					<tr><th><core:out value="CustomerId"></core:out></th>
						<th><core:out value="AccountNumber"></core:out></th>
						<th><core:out value="Balance"></core:out></th>
					</tr>
					<core:forEach var="customer" items="${customerList}">
						<tr>
							<td><core:out value="${customer.customerId}"></core:out></td>
							
			
						</tr>

					</core:forEach>
			</table>
			
		<a href="addAccount.html" class="btn btn-outline-success">Transfer Money</a>
		
		
		

</html>