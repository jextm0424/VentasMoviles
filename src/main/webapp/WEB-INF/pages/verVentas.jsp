<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
		<tr>
			<td>Fecha</td>
			<td>Cliente</td>
			<td>Precio</td>
			<td>Peso</td>
			<td>Opciones</td>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${ventas }" var="venta">
				<tr>
					<td>${venta.fechaVenta }</td>
					<td>${venta.cliente.apellido }, ${venta.cliente.nombre }</td>
					<td>${venta.precioTotal }</td>
					<td>${venta.pesoTotal }</td>
					<td><button onclick="borrarventa(${venta.idVenta},this)">Eliminar</button> <a href="<c:url value="/modificarVenta?idVenta=${venta.idVenta}"/>">Modificar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		function borrarventa(idVenta,el){
			if(confirm("¿Desea Borrar la venta?")){
				ajax.deleteVenta(idVenta,function(data){
					if(data == "S"){
						alert("Se Borro Correctamente");
						$(el).parent().parent().remove();
					}else{
						alert("Error al Borrar venta");
					}
				});
			}
		}
	</script>
</body>
</html>