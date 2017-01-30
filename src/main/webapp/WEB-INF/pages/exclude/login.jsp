<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
</head>
<body>
	<div id="login">
	<c:if test="${not empty message}">
		<div class="message"><c:out value="${message}"/></div>
	</c:if>
		<form:form name="form-login" action="" commandName="lgModel"  method="POST">
			<span class="fontawesome-user"></span> 
			<form:input path="usuario" id="user" placeholder="Usuario"/>
			<span class="fontawesome-lock"></span>
			<form:password path="clave" id="pass" placeholder="Clave"/>
			<form:button class="btnSubmit">Login</form:button>
		</form:form>
</body>
</html>