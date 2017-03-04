<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultas</title>
</head>
<body>
	<c:if test="${empty lista }">
		<div class="alert alert-danger" style="text-align: center;"><b>NO SE ENCONTRARON RESULTADOS</b></div>
	</c:if>
	<br/>
	<form action="${pageContext.request.contextPath}/consulta" method="get" >
	<div class="form-group">
		<select class="form-control" id="txtTipo" name="tipo" onchange="getDetalles()">
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
		<select class="form-control" id="txtParametro" name="parametro">
			<option value="">Seleccione:</option>
		</select>
		<button class="btn btn-success">Buscar</button>
	</div>
	</form>
	<c:if test="${not empty lista }">
		<table class="table">
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
						<td>${list.cliente.personal.apellido}, ${list.cliente.personal.nombre}</td>
						<td>${list.cliente.apellido}, ${list.cliente.nombre}</td>
						<td>${list.pesoTotal}</td>
						<%-- <td>${list.pesoTotal}</td> --%>
						<td>${list.precioTotal}</td>
						<%-- <td>${list.precioTotal}</td> --%>
						 <c:choose>
						 	<c:when test="${list.cliente.ubigeo eq  150106}">
						 		<td>CARABAYLLO</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150110}">
						 		<td>COMAS</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150112}">
						 		<td>INDEPENDENCIA</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150117}">
						 		<td>LOS OLIVOS</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150125}">
						 		<td>PUENTE PIEDRA</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150128}">
						 		<td>RIMAC</td>
						 	</c:when>
						 	<c:when test="${list.cliente.ubigeo eq  150135}">
						 		<td>SAN MARTIN DE PORRES</td>
						 	</c:when>						 										 							 							 							 							 	
						 	<c:otherwise>
						 		<td>${list.cliente.ubigeo}</td>
						 	</c:otherwise>
						 </c:choose>
						<%-- <td>${list.cliente.ubigeo }</td> --%>
						<td>${list.cliente.giro.giro}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button class="btn btn-info btn-block" onclick="exportarExcel()">Exportar a Excel</button>
		<br><br>
	</c:if>
	<script>
		function getDetalles(){
			var tipo = $("#txtTipo").val();
			$("#txtParametro").remove();
			$("#txtTipo").after(function(){return "<select class='form-control' name='parametro' id='txtParametro'></select>"});
			switch(tipo){
			case "VE":
				/* ajax.getDatosPersonales(function(data){ */
					/* var json = JSON.parse(data); */
					var json = JSON.parse('${vendedores}');
					for(var i=0; i< json.length;i++){
						$("#txtParametro").append("<option value='"+json[i].idPersonal+"'>"+json[i].idPersonal+" - "+json[i].apellido+", "+json[i].nombre+"</option>");
					}
/* 				}); */
				break;
			case "CL":
				/* ajax.getDatosClientes(function(data){ */
					/* var json = JSON.parse(data); */
					var json = JSON.parse('${clientes}');
					for(var i=0; i< json.length;i++){
						$("#txtParametro").append("<option value='"+json[i].idCliente+"'>"+json[i].idCliente+" - "+json[i].apellido+", "+json[i].nombre+"</option>");
					}					
/* 				});				 */
				break;
			case "MO":
					$("#txtParametro").remove();
					$("#txtTipo").after(function(){return "<input type='text' class='form-control' name='parametro' id='txtParametro'>"});
				break;
			case "PR":
/* 				ajax.getDatosProductos(function(data){ */
					/* var json = JSON.parse(data); */
					var json = JSON.parse('${materiales}');
					for(var i=0; i< json.length;i++){
						$("#txtParametro").append("<option value='"+json[i].idMaterial+"'>"+json[i].material+"</option>");
					}					
/* 				});				 */
				break;
			case "DI":
				$("#txtParametro").append("<option value='0'>DOMINGO</option>");
				$("#txtParametro").append("<option value='1'>LUNES</option>");
				$("#txtParametro").append("<option value='2'>MARTES</option>");
				$("#txtParametro").append("<option value='3'>MIERCOLES</option>");
				$("#txtParametro").append("<option value='4'>JUEVES</option>");
				$("#txtParametro").append("<option value='5'>VIERNES</option>");
				$("#txtParametro").append("<option value='6'>SÁBADO</option>");
				break;
			case "GI":
/* 				ajax.getDatosGiro(function(data){
					var json = JSON.parse(data); */
					var json = JSON.parse('${giros}');
					for(var i=0; i< json.length;i++){
						$("#txtParametro").append("<option value='"+json[i].idGiro+"'>"+json[i].giro+"</option>");
					}					
/* 				});					 */
				break;
			case "DS":
/* 				ajax.getDatosDistrito(function(data){
					var json = JSON.parse(data); */
					var json = JSON.parse('${ubigeos}');
					for(var i=0; i< json.length;i++){
						$("#txtParametro").append("<option value='"+json[i].idUbigeo+"'>"+json[i].descripcion+"</option>");
					}					
/* 				});					 */
				break;
			case "FE":
				$("#txtParametro").remove();
				$("#txtTipo").after(function(){return "<input type='date' data-date-format='DD/MMMM/YYYY' class='form-control' name='parametro' id='txtParametro'>"});
				break;
			default:
				$("#txtParametro").append("<option value='TODO'>TODO</option>");
				break;
			}
		}
		function exportarExcel(){
			window.location.replace("${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}&export=yes");
		}
	</script>
</body>
</html>