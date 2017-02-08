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
				<input type="hidden" value="${venta.pk.venta.idVenta}" id="idVenta" name="idVenta"/>
			</div>
			<div class="col-md-6">
				<input type="text" data-format="dd-MM-yyyy hh:mm:ss"  id="fechaVenta" value="${venta.pk.venta.fechaVenta }" class="form-control" readonly="readonly">
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
			<input type="hidden" name="codMaterial" value="${venta.pk.material.idMaterial}">
			<div class="col-md-3">
				<p style="text-align: center;">${venta.pk.material.material }</p>
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.pk.material.precio }" step="0.01" name="precio" >
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.pk.material.peso }" step="0.01" name="peso" >
			</div>
			<div class="col-md-3">
				<input type="number" class="form-control" value="${venta.cantidad }" step="1" name="cantidad">
			</div>
		</div>
	</c:forEach>
		<br><br><br>
		<button class="btn btn-info btn-block" onclick="return confirmar()" id="confirmar">Confirmar</button>
		<button class="btn btn-success btn-block" disabled="disabled"  id="grabar" onclick="grabar()">Grabar</button>
<script type="text/javascript">
	function confirmar(){
		var isValid = true;
		$( "input[name='cantidad']" ).each(function() {
			if(this.value==''){isValid = false;}else{this.readOnly = true;}
		});
		$( "input[name='peso']" ).each(function() {
			if(this.value==''){isValid = false;}else{this.readOnly = true;}
		});
		$( "input[name='precio']" ).each(function() {
			if(this.value==''){isValid = false;}else{this.readOnly = true;}
		});
		if(isValid){
			$("#grabar").attr("disabled",false);
		}else{
			alert("Debe Llenar todos los campos");
		}
	}
	function grabar(){
		var idVenta = $("#idVenta").val();
		var idMateriales = $("input[name='codMaterial']");
		var cantidades = $("input[name='cantidad']");
		var pesos = $("input[name='peso']");
		var precios = $("input[name='precio']");
		var detalle ="";
		for(var i=0; i< cantidades.length; i++){
			if(cantidades.length == (i+1)){
				detalle+= idMateriales[i].value + "-"+ cantidades[i].value + "-"+pesos[i].value + "-" + precios[i].value;	
			}else{
				detalle+= idMateriales[i].value + "-"+ cantidades[i].value + "-"+pesos[i].value + "-" + precios[i].value+";";
			}
			
		}
		window.location.replace("<c:url value='/modVenta?detalle="+detalle+"&idVenta="+idVenta+"'/>");
	}
</script>
</body>
</html>