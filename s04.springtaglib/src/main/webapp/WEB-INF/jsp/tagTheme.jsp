<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring theme tag sample</title>
		<link rel="stylesheet"  href='<spring:theme code='default'/>' type="text/css"/>
	</head> 
	<body>
		<header>
		<h1>Spring theme tag sample</h1>
		</header>
		Change theme: 
    	<a href="?theme=default">default</a> | <a href="?theme=teverga">teverga</a> | <a href="?theme=dark">dark</a>
	</body>
</html>