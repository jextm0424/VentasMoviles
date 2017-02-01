<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Material</title>
</head>
<body>
	<form:form action="/addMaterial" method="POST" modelAttribute="matModel">
		<form:hidden path="idMaterial"  value="${matModel.idMaterial}"/>
		<div class="form-group">
			<label for="material">Nombre: </label>
			<form:input path="material"  required="required" cssClass="form-control" maxlength="70" value="${matModel.material }"/>
		</div>
		<div class="form-group">
			<label for="peso">Estado: </label>
			<form:select path="estado" cssClass="form-control">
				<c:choose>
					<c:when test="${matModel.estado == 41 }">
						<form:option value="A" selected="selected">Activo</form:option>
						<form:option value="I">Inactivo</form:option>
					</c:when>
					<c:otherwise>
						<form:option value="I" selected="selected">Inactivo</form:option>
						<form:option value="A">Activo</form:option>					
					</c:otherwise>
				</c:choose>
			</form:select>
		</div>		
		<div class="form-group">
			<label for="precio">Precio: </label>
			<form:input path="precio" required="required" type="number" cssClass="form-control" step="0.01" value="${matModel.precio }"/>
		</div>
		<div class="form-group">
			<label for="peso">Peso: </label>
			<form:input path="peso" type="number" required="required" cssClass="form-control" step="0.01" value="${matModel.peso }"/>
		</div>
		<form:button class="btn btn-success">Enviar</form:button>
	</form:form>
</body>
</html>