<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring url tag sample</title>
	</head> 
	<body>
		<header>
		<h1>Spring url tag sample</h1>
		</header>
		<spring:url value="/customer/get" var="customerUrl" htmlEscape="true" >
   			<spring:param name="code" value="1" />
   			<spring:param name="idCard" value="44555666L" />
 		</spring:url>
		<p>
			<a href="${customerUrl}">See customer data</a>
		</p>
	</body>
</html>