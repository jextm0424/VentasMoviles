<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Personal</title>
</head>
<body>
	<form:form action=""  method="POST" commandName="peModel">
		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<form:input path="nombre" cssClass="form-control" placeholder="Nombre"/>
		</div>
		<div class="form-group">
			<label for="apellido">Apellido:</label>
			<form:input path="apellido" cssClass="form-control" placeholder="Apellido"/>
		</div>
				<div class="form-group">
			<label for="usuario">Usuario:</label>
			<form:input path="usuario" cssClass="form-control" placeholder="Usuario"/>
		</div>
		<div class="form-group">
			<label for="clave">Clave:</label>
			<form:password path="clave" cssClass="form-control" placeholder="Clave"/>
		</div>		
		<div class="form-group">
			<label for="dni">DNI:</label>
			<form:input path="dni" cssClass="form-control" placeholder="DNI"/>
		</div>
		<div class="form-group">
			<label for="idRol">ROL:</label>
			<form:select path="rol.idRol" cssClass="form-control" onchange="validarRol(this)">
				<form:option value="">Seleccione:</form:option>
				<form:options items="${roles}" itemLabel="descripcion"  itemValue="idRol"/>
			</form:select>			 
		</div>
		<div class="form-group" id="groupTerritorio">
			<label for="idTerritorio">Territorio:</label>
			<form:select path="territorio.idTerritorio" cssClass="form-control">
				<form:option value="0">Seleccione:</form:option>
				<form:options items="${territorios}" itemLabel="descripcion"  itemValue="idTerritorio"/>
			</form:select>			
		</div>		
		<div class="form-group" id="groupTipo">
			<label for="idTipo">Tipo:</label>
			<form:select path="tipo.idTipo" cssClass="form-control">
				<form:option value="">Seleccione:</form:option>
				<form:options items="${tipos}" itemLabel="descripcion"  itemValue="idTipo"/>
			</form:select>
		</div>	
		<div class="form-group">
			<button class="btn btn-success">Grabar</button>
		</div>
	</form:form>
<script type="text/javascript">
	function validarRol(el){
		if(el.value == 'A'){
			$("#groupTerritorio").hide();
			$("#groupTipo").hide();
		}else{
			$("#groupTerritorio").show();
			$("#groupTipo").show();
		}
	}
</script>
</body>
</html>