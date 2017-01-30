<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cliente</title>
</head>
<body>
	<div class="row">
		<form:form action="" method="POST" modelAttribute="cliModel">
		<div class="form-group">
			<label for="nombre">Nombre</label>
			<form:input path="nombre" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label for="apellido">Apellido</label>
			<form:input path="apellido" cssClass="form-control"/>
		</div>		
		<div class="form-group">
			<label for="direccion">Direccion</label>
			<form:input path="direccion" cssClass="form-control"/>
		</div>		
		<div class="form-group">
			<label for="tipoDoc">Tipo Documento</label>
			<form:select path="tipoDocumento.idTipoDoc" cssClass="form-control">
				<form:options items="${tipoDocs}" itemLabel="tipoDocumento" itemValue="idTipoDoc"/>
			</form:select>
		</div>		
		<div class="form-group">
			<label for="nroDocumento">NroDocumento</label>
			<form:input path="nroDocumento" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label for="giro">Giro</label>
			<form:select path="giro.idGiro" cssClass="form-control">
				<form:options items="${giros}"  itemValue="idGiro" itemLabel="giro"/>
			</form:select>
		</div>		
		<div class="form-group">
			<label for="diaVisita">Dia de Visita</label>
			<form:select path="diaVisita" cssClass="form-control">
				<form:option value="0">Domingo</form:option>
				<form:option value="1">Lunes</form:option>
				<form:option value="2">Martes</form:option>
				<form:option value="3">Miercoles</form:option>
				<form:option value="4">Juesves</form:option>
				<form:option value="5">Viernes</form:option>
				<form:option value="6">Sabado</form:option>
			</form:select>
		</div>	
		<div class="form-group">
			<label for="modulo">Modulo</label>
			<form:input path="modulo" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label for="ubigeo">Ubigeo</label>
			<form:input path="ubigeo" cssClass="form-control"/>
		</div>	
		<div class="form-group">
			<label for="nombreLargo">Nombre Largo</label>
			<form:input path="nombreLargo" cssClass="form-control"/>
		</div>		
		<div class="form-group">
			<form:button class="btn btn-success">Enviar</form:button>
		</div>
		</form:form>
	</div>
</body>
</html>