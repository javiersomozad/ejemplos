<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring eval tag sample</title>
	</head> 
	<body>
		<header>
		<h1>Spring eval tag sample</h1>
		</header>
		Showing app info from properties:
		<p>
			<spring:eval expression="@someSettings.getProperty('app.name')" /> -   
			<spring:eval expression="@someSettings.getProperty('app.version')" />  
		</p>
		Simple arithmetic:
		<p>
			<spring:eval expression="${price} * 166.386" var="priceInPesetas"/>
			${price} - ${priceInPesetas}  
		</p>
		Random value using java utils
		<p>
			<spring:eval expression="new java.util.Random().nextInt(100)" var="randomNumber"/>
			${randomNumber}  
		</p>
		
	</body>
</html>