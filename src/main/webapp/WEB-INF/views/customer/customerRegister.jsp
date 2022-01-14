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

<form:form action="customerRegister.html" modelAttribute="customerForm">
		<table>
			<tr>
				<td><form:label path="fullName">Full Name:</form:label> <FONT color="red"><form:errors path="fullName" /></FONT></td>
				<td><form:input path="fullName" size="26" /></td>
			</tr>
			
			<tr>
				<td><form:label path="emailAddress">Email Address:</form:label> <FONT color="red"><form:errors path="emailAddress" /></FONT></td>
			    <td><form:input path="emailAddress" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label> <FONT color="red"><form:errors path="password" /></FONT></td>
				<td><form:password path="password" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="confirmPassword">Confirm Password:</form:label></td>
				<td><form:password path="confirmPassword" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address:</form:label></td>
				<td><form:textarea path="address" rows="1"></form:textarea></td>
			</tr>
			<tr>
				<td><form:label path="mobileNumber">Mobile Number:</form:label> <FONT color="red"><form:errors path="mobileNumber" /></FONT></td>
				<td><form:input path="mobileNumber" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="googlePlusCode">Google Plus Code:</form:label></td>
				<td><form:input path="googlePlusCode" size="26" /></td>
			</tr>
			<tr>
			<td><form:label path="isPremium">Is Premium:</form:label> <FONT color="red"><form:errors path="isPremium" /></FONT></td>
			<td><form:select path="isPremium">
					<form:option label="Select" value="-1" />
					<form:option label="Yes" value="Y" />
					<form:option label="No" value="N" />
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date of Birth:</form:label></td>
				<td><form:input path="dob" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="masterId">Master Id:</form:label></td>
				<td><form:input path="masterId" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="idValue">Id Value:</form:label></td>
				<td><form:input path="idValue" size="26" /></td>
			</tr>
	
			
			<tr>
				<td><input class="btn btn-success" type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>