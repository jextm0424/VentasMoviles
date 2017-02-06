<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Personales</title>
</head>
<body>
	<form action="" method="get">
		<div class="form-group">
			<label for="tipo">Filtro</label>
			<select id="tipo" name="tipo" class="form-control">
				<option value="N">Nombre</option>
				<option value="C">Código</option>
			</select>
			<input type="text" name="parametro" id="parametro" class="form-control">
			<button class="btn btn-info">Buscar</button>
		</div>
	</form>
	<c:if test="${not empty personales}">
	<table class="table">
		<thead>
			<tr>
				<td>Cod.</td>
				<td>Apellido, Nombre</td>
				<td>Usuario</td>
				<td>Clave</td>
				<td>Estado</td>
				<td>Rol</td>
				<td>Territorio</td>
				<td>Tipo</td>
				<td>Opciones</td>
			</tr>
		</thead>
		<c:forEach items="${personales}" var="personal" >
			<tbody>
				<tr>
					<td>${personal.idPersonal}</td>
					<td>${personal.apellido}, ${personal.nombre}</td>
					<td>${personal.usuario}</td>
					<td>${personal.clave}</td>
					<td>${personal.estado}</td>
					<td>${personal.rol.descripcion}</td>
					<td>${personal.territorio.descripcion}</td>
					<td>${personal.tipo.descripcion}</td>
					<td>
						<button onclick="modificarPersonal(${personal.idPersonal})" class="btn btn-info">Modificar</button>
						<button onclick="eliminarPersonal(${personal.idPersonal},this)" class="btn btn-danger">Eliminar</button>
					</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>
		<script type="text/javascript">
			function modificarPersonal(idPersonal){
				window.location.replace("<c:url value='/modifyPersonal?idPersonal="+idPersonal+"'/>");
			}
			function eliminarPersonal(idPersonal,el){
				if(confirm("¿Esta Seguro que desea eliminar el personal "+ idPersonal+"?")){
					
				}
			}
		</script>
	</c:if>
</body>
</html>