<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page:)</title>


</head>
<body bgcolor="edcba">

	<div style="height: 50px; border =50px; background-color:"></div>


	<form:form action="login" method="post" modelAttribute="currentUser">

Enter UserName: <form:input path="username" />
		<br>
		<br>
Enter Password: <form:input type="password" path="password" />
		<br>
		<br>
SignIn As: <form:select path="signinAs">
			<form:option value="Pitcher" />
			<form:option value="Mentor" />
			<form:option value="Techie" />
		</form:select>
		<br>

		<input type="submit" value="Login" />
	</form:form>

	<form:form action="signup" method="post" modelAttribute="signup">

		<input type="submit" value="Sign Up" />

	</form:form>

</body>
</html>