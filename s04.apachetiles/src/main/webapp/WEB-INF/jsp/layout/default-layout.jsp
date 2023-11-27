<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Apache tiles</title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="sidebar" />
	<tiles:insertAttribute name="footer" />
</body>
</html>