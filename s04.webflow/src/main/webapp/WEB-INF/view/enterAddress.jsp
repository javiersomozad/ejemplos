<!DOCTYPE html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Step2 : Enter Address</title>
	</head> 
	<body>
		<h2>Step2 : Enter Address</h2>
		<div>
		<sf:form modelAttribute="newUser">
			<fieldset><legend>Address info</legend>		
			<input type="hidden" name="_flowExecutionKey" value="{$flowExecutionKey}">	
				<label for="address">Address</label><br />
				<sf:textarea  path="address" /><br />
				<label for="city">City</label><br />
				<sf:input path="city"  /><br />
				<input type="submit" name="_eventId_submit" value="Continue &gt;&gt;"  /><br />
				<input type="submit" name="_eventId_cancel" value="Cancel"  />
			</fieldset>
		</sf:form>
        </div>
	</body>
</html>
