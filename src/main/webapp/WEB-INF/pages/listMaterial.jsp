<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Materiales</title>
</head>
<body>
	<form action="materiaList" method="GET">
		<div class="form-group">
			<select id="tipoFiltro" name="tipoFiltro" class="form-control">
				<option value="E">Estado</option>
				<option value="M">Nombre de Material</option>
				<option value="I">Codigo de Material</option>
				<option value="T">Todo</option>
			</select>
			<input type="text" id="parametro" name="parametro" class="form-control">
		</div>
		<button class="btn btn-success">Enviar</button>
	</form> 
		<c:if test="${ not empty materiales}">
			<table class="table">
				<thead>
					<tr>
						<td>Material</td>
						<td>Estado</td>
						<td>Precio</td>
						<td>Peso</td>
						<td>Opciones</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${materiales}" var="material">
					<tr>
						<td>${material.material }</td>
						<td>${material.estado }</td>
						<td>${material.precio }</td>
						<td>${material.peso }</td>
						<td><button onclick="modificarMaterial(${material.idMaterial})" class="btn btn-info">Modificar</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	<script type="text/javascript">
		function modificarMaterial(idMaterial){
			window.location.replace('<c:url value="/modifyMaterial"/>'+"?idMaterial="+idMaterial);
		}
	</script>
</body>
</html>