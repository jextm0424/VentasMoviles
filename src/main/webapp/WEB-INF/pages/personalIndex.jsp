<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel de Personal</title>
</head>
<body>
	<div class="row">
		<div class="col-md-3 hidden-xs hidden-sm" ></div>
		<div class="col-md-6 col-xs-12">
			<div class="jumbotron">
				<h1>Panel de Personal!</h1>
				<p>Personal</p>
				<p>
					<a class="btn btn-primary btn-lg" href='<c:url value="/addPersonal"/>' role="button">Agregar</a>
					<a class="btn btn-primary btn-lg" href="<c:url value="/personalList"/>" role="button">Modificar</a>
				</p>
			</div>
		</div>
		<div class="col-md-3 hidden-xs hidden-sm"></div>
	</div>
</body>
</html>