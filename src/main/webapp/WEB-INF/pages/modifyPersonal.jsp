<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Personal</title>
</head>
<body>
	<form:form action="/addPersonal" method="POST" onsubmit="return validar()" modelAttribute="peModel">
	<form:hidden path="idPersonal" value="${peModel.idPersonal}"/>
		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<form:input path="nombre" cssClass="form-control" value="${peModel.nombre}"/>
		</div>
		<div class="form-group">
			<label for="apellido">Apellido:</label>
			<form:input path="apellido" cssClass="form-control" value="${peModel.apellido}"/>
		</div>
				<div class="form-group">
			<label for="usuario">Usuario:</label>
			<form:input path="usuario" cssClass="form-control" value="${peModel.usuario}"/>
		</div>
		<div class="form-group">
			<label for="clave">Clave:</label>
			<form:password path="clave" cssClass="form-control" value="${peModel.clave}"/>
		</div>		
		<div class="form-group">
			<label for="dni">DNI:</label>
			<form:input path="dni" cssClass="form-control" value="${peModel.dni}"/>
		</div>
		<div class="form-group">
			<label for="estado">Estado</label>
			<form:select path="estado" cssClass="form-control">
				<c:choose>
					<c:when test="${peModel.estado == 41 }">
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
			<label for="idRol">Rol:</label>
				<form:select path="rol.idRol" cssClass="form-control" onchange="validarRol()">
					<c:forEach items="${roles}" var="rol">
						<c:choose>
							<c:when test="${rol.idRol eq  peModel.rol.idRol}">
								<option value="${rol.idRol }" selected="selected" >${rol.descripcion}</option>
							</c:when>
							<c:otherwise>
								<option value="${rol.idRol }">${rol.descripcion}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
		</div>
		<div class="form-group" id="groupTerritorio">
			<label for="idTerritorio">Territorio:</label>
			<form:select path="territorio.idTerritorio" cssClass="form-control">
				<c:forEach items="${territorios}" var="territorio">
					<c:choose>
						<c:when test="${territorio.idTerritorio eq  peModel.territorio.idTerritorio}">
							<option value="${territorio.idTerritorio }" selected="selected" >${territorio.descripcion}</option>
						</c:when>
						<c:otherwise>
							<option value="${territorio.idTerritorio }">${territorio.descripcion}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
		</div>		
		<div class="form-group"  id="groupTipo">
			<label for="idTipo">Tipo:</label>
			<form:select path="tipo.idTipo" cssClass="form-control">
				<c:forEach items="${tipos}" var="tipo">
					<c:choose>
						<c:when test="${tipo.idTipo eq  peModel.tipo.idTipo}">
							<option value="${tipo.idTipo }" selected="selected" >${tipo.descripcion}</option>
						</c:when>
						<c:otherwise>
							<option value="${tipo.idTipo }">${tipo.descripcion}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
		</div>	
		<div class="form-group">
			<button class="btn btn-success">Grabar</button>
		</div>
	</form:form>
	<script type="text/javascript">
		if($("#rol\\.idRol").val()=='A'){
			$("#groupTerritorio").hide();
			$("#groupTipo").hide();
		}else{
			$("#groupTerritorio").show();
			$("#groupTipo").show();
		}
		function validarRol(){
			if($("#rol\\.idRol").val()=='A'){
				$("#groupTerritorio").hide();
				$("#groupTipo").hide();
			}else{
				$("#groupTerritorio").show();
				$("#groupTipo").show();
			}
		}
		
		function validar(){
			if($("#rol\\.idRol").val() == ""){
				alert("Debe Elegir un Rol");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>