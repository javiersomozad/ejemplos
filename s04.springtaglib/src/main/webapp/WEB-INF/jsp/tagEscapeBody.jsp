<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring escapeBody tag sample</title>
	</head> 
	<body>
		<header>
		<h1>Spring escapeBody tag sample</h1>
		</header>

		<p>
			<spring:escapeBody htmlEscape="true" javaScriptEscape="true">
				<h1>This is Escaped HTML</h1>
				<p>Now everything in this paragraph becomes harmless
					<script>alert('Am I Evil?');</script>
				</p>
			</spring:escapeBody>
		</p>
	</body>
</html>