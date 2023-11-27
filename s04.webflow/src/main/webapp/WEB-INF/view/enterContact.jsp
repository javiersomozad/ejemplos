<!DOCTYPE html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Step3 : Enter Contact</title>
	</head> 
	<body>
		<h2>Step3 : Enter Contact</h2>
		<div>
		<sf:form modelAttribute="newUser">
			<fieldset><legend>Contact info</legend>		
			<input type="hidden" name="_flowExecutionKey" value="{$flowExecutionKey}">	
				<label for="phone">Phone</label><br />
				<sf:input path="phone"  /><br />
				<label for="email">Email</label><br />
				<sf:input path="email"  /><br />
				<label for="url">Url</label><br />
				<sf:input path="url"  /><br />
				<input type="submit" name="_eventId_contactEntered" value="Continue &gt;&gt;"  /><br />
				<input type="submit" name="_eventId_cancel" value="Cancel"  />
			</fieldset>
		</sf:form>
        </div>
	</body>
</html>
