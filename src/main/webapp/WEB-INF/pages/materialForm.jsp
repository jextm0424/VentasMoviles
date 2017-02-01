<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Material</title>
</head>
<body>
	<form:form action="" method="POST" modelAttribute="matModel">
		<div class="form-group">
			<label for="material">Nombre: </label>
			<form:input path="material"  required="required" cssClass="form-control" maxlength="70"/>
		</div>
		<div class="form-group">
			<label for="precio">Precio: </label>
			<form:input path="precio" required="required" type="number" cssClass="form-control" step="0.01"/>
		</div>
		<div class="form-group">
			<label for="peso">Peso: </label>
			<form:input path="peso" type="number" required="required" cssClass="form-control" step="0.01"/>
		</div>
		<form:button class="btn btn-success">Enviar</form:button>
	</form:form>
</body>
</html>