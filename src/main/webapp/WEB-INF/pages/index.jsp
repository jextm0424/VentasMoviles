<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty user}">
	<script type="text/javascript">
		window.location.replace("login");
	</script>
</c:if>
ggg
</body>
</html>
