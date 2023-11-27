<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title><spring:message code="welcome.title" /></title>
	</head> 
	<body>
		<header>
		<h1><spring:message code="welcome.title" text="Welcome default title" /></h1>
		</header>
		<p>
			<spring:message code="welcome.content" text="This is the default content" />
		</p>
	</body>
</html>