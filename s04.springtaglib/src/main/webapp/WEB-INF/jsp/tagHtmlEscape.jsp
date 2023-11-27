<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring htmlScape tag sample</title>
	</head> 
	<body>
		<header>
		<h1>Spring htmlScape tag sample</h1>
		</header>

		HTML escaped:
		<p>
			<!-- Changes htmlEscape value -->
			<spring:htmlEscape defaultHtmlEscape="true" /> 
		</p>

	</body>
</html>