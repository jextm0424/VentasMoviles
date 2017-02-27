<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultas</title>
</head>
<body>
	<br/>
	<div class="form-group">
		<select class="form-control" id="txtTipo" name="txtTipo" onchange="getDetalles()">
			<option value="">Seleccione:</option>
			<option value="VE">Vendedor</option>
			<option value="CL">Cliente</option>
			<option value="MO">Módulo</option>
			<option value="PR">Producto</option>
			<option value="DI">Día</option>
			<option value="GI">Giro</option>
			<option value="DS">Distrito</option>
			<option value="FE">Fecha</option>
			<option value="TO">TODO</option>
		</select>
		<select class="form-control" id="txtParametro" name="txtParametro">
			<option value="">Seleccione:</option>
		</select>
		<button class="btn btn-success">Buscar</button>
	</div>
	
	<c:if test="${not empty lista }">
		<table>
			<thead>
				<tr>
					<td>Fecha</td>
					<td>Vendedor</td>
					<td>Cliente</td>
					<td>Peso</td>
					<!-- <td>Cantidad</td> -->
					<td>Precio</td>
					<!-- <td>Total</td> -->
					<td>Distrito</td>
					<td>Giro</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="list">
					<tr>
						<td>${list.fechaVenta}</td>
						<td>${list.cliente.apellido}, ${list.cliente.nombre}</td>
						<td>${list.cliente.personal.apellido}, ${list.cliente.personal.nombre}</td>
						<td>${list.pesoTotal}</td>
						<%-- <td>${list.pesoTotal}</td> --%>
						<td>${list.precioTotal}</td>
						<%-- <td>${list.precioTotal}</td> --%>
						<c:forEach items="${ubigeos}"  var="ubigeo">
							<c:if test="${ubigeo.idUbigeo eq  list.cliente.ubigeo}">
								<td>${ubigeo.descripcion}</td>
							</c:if>
						</c:forEach>
						<td>${list.cliente.giro.idGiro}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<script>
		function getDetalles(){
			var tipo = $("#txtTipo").val();
			switch(tipo){
			case "VE":
				ajax.getDatosPersonales(function(data){
					var json = JSON.parse(data);
				});
				break;
			case "CL":
			
				break;
			case "MO":
			
				break;
			case "PR":
			
				break;
			case "DI":
				
				break;
			case "GI":
				
				break;
			case "DS":
				
				break;
			case "FE":
				
				break;
			default:
				break;
			}
		}
	</script>
</body>
</html>