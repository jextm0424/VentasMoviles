<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty user}">
	<script type="text/javascript">
		window.location.replace("login");
	</script>
</c:if>
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<img alt='Logo Trendy' src="<c:url value="/resources/img/LogoTrendy.jpg"/>" class="img" width="100%">
	</div>
	<div class="col-md-3"></div>
</div>
</body>
</html>
