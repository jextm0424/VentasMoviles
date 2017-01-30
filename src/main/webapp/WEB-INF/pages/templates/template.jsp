<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<script src='<c:url value="dwr/engine.js"/>'></script>
<script src='<c:url value="dwr/interface/ajax.js"/>'></script>
<script src='<c:url value="dwr/util.js"/>'></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/default/default.css"/>"  rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
<link href="<c:url value="/resources/css/bootstrap-datepicker.min.css"/>"  rel="stylesheet" type="text/css" />
<sitemesh:write property='head'/>
<title>Sistema de Ventas Online <sitemesh:write property='title'/></title>
</head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
<body class="home" onload="">
	<c:if test="${empty user}">
			<script type="text/javascript">
				window.location.replace("login");
			</script>
	</c:if> 
    <div class="container-fluid display-table">
        <div class="row display-table-row">
            <div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box" id="navigation">
                <div class="logo">
                    <a href="<c:url value="/"/>"><img src='<c:url value="/resources/img/LogoTrendy.jpg"/>' alt="merkery_logo" class="hidden-xs hidden-sm">
                        <!-- <img src="http://kingofwallpapers.com/circle/circle-003.jpg" alt="merkery_logo" class="visible-xs visible-sm circle-logo"> -->
                    </a>
                </div>
                <div class="navi">
                    <ul>  
                    <li><a href="<c:url value="/"/>"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li>
                         <li><a href="<c:url value="/cliente"/>"><i class="fa fa-users" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Clientes</span></a></li>
                         <li><a href="<c:url value="/material"/>"><i class="fa fa-lemon-o" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Material</span></a></li>
                          <li><a href="<c:url value="/personal"/>"><i class="fa fa-blind" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Personal</span></a></li>
                           <li><a href="<c:url value="/consulta"/>"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Consultas</span></a></li>
                            <li><a href="<c:url value="/ventas"/>"><i class="fa fa-archive" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Modificar Ventas</span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-10 col-sm-11 display-table-cell v-align">
                <div class="row">
                    <header>
                        <div class="col-md-7">
                            <nav class="navbar-default pull-left">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="offcanvas" data-target="#side-menu" aria-expanded="false">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>
                            </nav>
                        </div>
                        <div class="col-md-5">
                            <div class="header-rightside">
                                <ul class="list-inline header-top pull-right">
<%--                                     <li>
                                    	<a href="<c:url value="/pedidos"/>" class="icon-info">
                                    		<i class="fa fa-rocket" aria-hidden="true"></i>
                                    		<span class="label label-primary" id="idPedido">0</span>
                                    	</a>
                                    </li>
                                    <li>
                                        <a href="<c:url value="/carrito"/>" class="icon-info">
                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                            <span class="label label-primary" id="idCarrito">0</span>
                                        </a>
                                    </li> --%>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="https://d30y9cdsu7xlg0.cloudfront.net/png/17241-200.png" alt="user">
                                            <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="navbar-content">
                                              
                                                    <span></span>
                                                    <p class="text-muted small">
                                                       Rojas Chavez, Mauro
                                                    </p>
                                                    <div class="divider">
                                                    </div>
                                                    <%-- <a href="<c:url value="/mUsuario"/>" class="btn btn-sm">Cuenta</a> --%>
                                                    <a href="<c:url value="/logoff"/>" class="btn btn-sm active">Cerrar Session</a>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </header>
                </div>
                <div class="user-dashboard">
                    
                    <div class="row"><br>
                    	<c:if test="${not empty message }">
                    		<div class="alert alert-info text-center"><b><c:out value="${message}"/></b></div>
                    	</c:if>
						 <sitemesh:write property='body'/>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <!-- Modal -->
    <div id="add_project" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header login-header">
                    <button type="button" class="close" data-dismiss="modal">X</button>
                    <h4 class="modal-title">Add Project</h4>
                </div>
                <div class="modal-body">
                            <input type="text" placeholder="Project Title" name="name">
                            <input type="text" placeholder="Post of Post" name="mail">
                            <input type="text" placeholder="Author" name="passsword">
                            <textarea placeholder="Desicrption"></textarea>
                    </div>
                <div class="modal-footer">
                    <button type="button" class="cancel" data-dismiss="modal">Close</button>
                    <button type="button" class="add-project" data-dismiss="modal">Save</button>
                </div>
            </div>
			<select>
				<c:forEach items="${TIPDOCUME}" var="item">
					<c:if test="${item.ZSD_CLLAVE == ZSD_CTPDOC2 }"></c:if>
					<option value="${item.ZSD_CLLAVE }">${item.ZSD_DCORTA}</option>
				</c:forEach>
			</select>
        </div>
    </div>
    
    <script src='<c:url value="/resources/js/jquery-2.2.3.min.js"/>'></script>
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/dataTables.bootstrap.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap-datepicker.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap-datepicker.es.min.js"/>'></script>
    
	<script>
	$(document).ready(function(){
		   $('[data-toggle="offcanvas"]').click(function(){
		       $("#navigation").toggleClass("hidden-xs");
		   });
		});
	
	</script>
	<script type="text/javascript">

	
	$(document).ready(function() {
	    $('#dataTable').DataTable();
	} );

	$('#fechaNac').datepicker({
	    format: "dd/mm/yyyy",
	    todayBtn: true,
	    language: "es",
	    autoclose: true
	});
	</script>
	
</body>
</html>