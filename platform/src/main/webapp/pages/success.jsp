<%@page import="com.platform.services.TimeGenerator"%>
<%@page import="com.platform.services.QuoteGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<body>

<h1>Welcome to coders cafe</h1>
<!-- <h2> Here is a random thought from a fellow programmer</h2> -->
<%-- <h3> <% out.print(QuoteGenerator.getQuote()); %></h3> --%>

<a>SignUp time <% out.print(TimeGenerator.getTime()); %>  </a>

</body>


</html>