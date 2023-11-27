<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring bind tag sample</title>
	</head> 
	<body>
		<header>
		<h1>Spring url bind sample</h1>
		</header>


		<p>
			<spring:bind path="customer.name" >
				Value: ${status.value} <br />
				Expression: ${status.expression}
			</spring:bind>
		</p>
			<hr />
		We can create a personalized form fields:
			<div>
				<spring:bind path="customer.name">
					<label>${status.expression}</label>
					<input type="text" name="${status.expression}" value="${status.value}" />
				</spring:bind>
			</div>
			<div>
				<spring:bind path="customer.address">
					<label>${status.expression}</label>
					<input type="text" name="${status.expression}" value="${status.value}" />
				</spring:bind>
			</div>
			<div>
				<spring:bind path="customer.email">
					<label>${status.expression}</label>
					<input type="text" name="${status.expression}" value="${status.value}" />
						<!--  In case of validation errors, we could display all of them -->
					    <c:if test="${status.error}">
                		Error codes:
                		<c:forEach items="${status.errorMessages}" var="error">
                    		<c:out value="${error}"/>
                		</c:forEach>
            </c:if>
				</spring:bind>
			</div>
			<hr />
			Or just escape html (or not)	
			<div>
				<spring:bind path="customer.address" htmlEscape="true">
					${status.value}
				</spring:bind>
			</div>

			<div>
				<spring:bind path="customer.address" htmlEscape="false">
					${status.value}
				</spring:bind>
			</div>
	</body>
</html>