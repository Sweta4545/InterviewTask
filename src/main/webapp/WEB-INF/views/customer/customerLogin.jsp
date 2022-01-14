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

<form:form modelAttribute="customer" action="customerLogin.html" >
		<table>
			<tr>
				<td><div class="form-group"><form:label path="emailAddress">Email Address:</form:label></div></td>
				<td><form:input class="form-control" path="emailAddress" /></td>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="emailAddress"></form:errors></FONT>
				</td>
			</tr>
			<tr>
				<td><div class="form-group"><form:label path="password">Password:</form:label></div></td>
				<td><form:password class="form-control" path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="password"></form:errors></FONT>
				</td>
			</tr>
			<tr><td></td>
				<td><input class="btn btn-outline-success" type="submit" value="Login" /></td>
			</tr>
			<tr><td></td><td><a href="customerRegister.html"> Register</a></td></tr>
		</table>
	</form:form>
</body>
</html>