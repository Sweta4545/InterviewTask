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

<form:form action="adminRegister.html" modelAttribute="adminForm">
		<table>
			<tr>
				<td><form:label path="adminName">Admin Name:</form:label> <FONT color="red"><form:errors path="adminName" /></FONT></td>
				<td><form:input path="adminName" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="adminEmail">Admin Email:</form:label> <FONT color="red"><form:errors path="adminEmail" /></FONT></td>
				<td><form:input path="adminEmail" size="26" /></td>
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
			<td><form:label path="adminGender">Select Gender:</form:label> <FONT color="red"><form:errors path="adminGender" /></FONT></td>
			<td><form:select path="adminGender">
					<form:option label="--Select Gender--" value="-1" />
					<form:option label="Male" value="M" />
					<form:option label="Female" value="F" />
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="phoneNo">Phone No:</form:label> <FONT color="red"><form:errors path="phoneNo" /></FONT></td>
				<td><form:input path="phoneNo" size="26" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address:</form:label></td>
				<td><form:textarea path="address" rows="1"></form:textarea></td>
			</tr>
			<tr>
				<td><input class="btn btn-success" type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
	
</body>
</html>