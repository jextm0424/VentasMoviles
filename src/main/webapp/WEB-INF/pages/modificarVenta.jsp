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
			<input type="hidden" value="${venta.pk.venta.idVenta}"/>
			<input type="date" id="fechaVenta" value="${venta.pk.venta.fechaVenta }">
		</c:if>
		<p>Material: ${venta.pk.material.material }</p>
		<p>Precio: ${venta.pk.material.precio }</p>
		<p>Peso: ${venta.pk.material.peso }</p>
		<p>Cantidad: ${venta.cantidad }</p>
	</c:forEach>
</body>
</html>