<!DOCTYPE html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Step4 : Enter Login</title>
	</head> 
	<body>
		<h2>Step4 : Enter Login</h2>
		<div>
		<sf:form modelAttribute="newUser">
			<fieldset><legend>Login info</legend>		
			<input type="hidden" name="_flowExecutionKey" value="{$flowExecutionKey}">	
				<label for="login">Login</label><br />
				<sf:input path="login"  /><br />
				<label for="password">Password</label><br />
				<sf:password path="password"  /><br />
				<input type="submit" name="_eventId_loginEntered" value="Continue &gt;&gt;"  /><br />
				<input type="submit" name="_eventId_cancel" value="Cancel"  />
			</fieldset>
		</sf:form>
        </div>
	</body>
</html>
