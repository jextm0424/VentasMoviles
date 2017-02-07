<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Venta</title>
</head>
<body>

	<c:forEach items="${detVenta}" var="venta" varStatus="myIndex">
		<c:if test="${myIndex.index == 0 }">
		<div class="row">
		<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="fechaVenta">Fecha de Venta</label>
				<input type="hidden" value="${venta.pk.venta.idVenta}"/>
			</div>
			<div class="col-md-6">
				<input type="datetime" id="fechaVenta" value="${venta.pk.venta.fechaVenta }" class="form-control">
			</div>
		</div>
		<br><br><br>
		<div class="row">
			<div class="col-md-3">
				<p style="text-align: center;"><b>MATERIAL</b></p>
			</div>
			<div class="col-md-3">
				<p style="text-align: center;"><b>PRECIO</b></p>
			</div>
			<div class="col-md-3">
				<p style="text-align: center;"><b>PESO</b></p>
			</div>
			<div class="col-md-3">
				<p style="text-align: center;"><b>CANTIDAD</b></p>
			</div>			
		</div>
		</c:if>
		<div class="row">
			<input type="hidden" name="codMaterial" id="${venta.pk.material.idMaterial}">
			<div class="col-md-3">
				<p style="text-align: center;">${venta.pk.material.material }</p>
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.pk.material.precio }" step="0.01">
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.pk.material.peso }" step="0.01">
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.cantidad }" step="1">
			</div>
		</div>
	</c:forEach>
		<br><br><br>
		<button class="btn btn-info btn-block" onclick="confirmar()" id="confirmar">Confirmar</button>
		<button class="btn btn-success btn-block" disabled="disabled"  id="grabar">Grabar</button>
<script type="text/javascript">
	function confirmar(){
		$("#grabar").attr("disabled",false);
	}
</script>
</body>
</html>