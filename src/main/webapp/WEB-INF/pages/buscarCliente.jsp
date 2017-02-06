<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar CLiente</title>
</head>
<body>
	
		<div class="form-group">
		<div class="col-md-3">
			<label for="txtTipo">Buscar Por:</label>
		</div>
		<div class="col-md-3">
			<select class="form-control" id="tipo">
				<option value="0">Codigo de Cliente</option>
				<option value="1">Número de Documento</option>
				<option value="2">Nombre</option>
				<option value="3">Apellido</option>
				<option value="4">Dia De Visita</option>
				<option value="5">Todo</option>
			</select>
		</div>
		<div class="col-md-3">
			<input type="text" id="txtTipo" class="form-control"/>
		</div>
		<div class="col-md-3">
			<button class="btn btn-info" onclick="buscar()">Buscar</button>
		</div>
		</div>
	
	<c:if test="${not empty clientes}">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<td>Nombre</td>
						<td>Apellido</td>
						<td>Tipo Documento</td>
						<td>Número De Documento</td>
						<td>Opciones</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clientes}" var="cliente">
						<tr>	
							<td>${cliente.nombre}</td>
							<td>${cliente.apellido}</td>
							<td>${cliente.tipoDocumento.tipoDocumento}</td>
							<td>${cliente.nroDocumento}</td>
							<td><button onclick="editar(${cliente.idCliente})" class="btn btn-info">Editar</button> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script type="text/javascript">
			function editar(idCliente){
				window.location.replace("editarCliente?idCliente="+idCliente);
			}
		</script>
	</c:if>
	<script type="text/javascript">
		function buscar(){
			window.location.replace("buscarCliente?tipo="+$("#tipo").val()+"&txtTipo="+$("#txtTipo").val());
			return false;
		}
	</script>
</body>
</html>
