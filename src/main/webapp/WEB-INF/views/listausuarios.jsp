<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
   		<meta name="description" content="">
    	<meta name="author" content="">
	    <title>Hotel Verision 0.1</title>
	    
	       <!-- jQuery -->
    <script src="./static/vendor/jquery/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
    <script src="./static/vendor/bootstrap/js/bootstrap.min.js"></script>
	
	    <!-- Bootstrap Core CSS -->
	    <link href="<c:url value='./static/vendor/bootstrap/css/bootstrap.min.css' />"  rel="stylesheet"></link>
		   <!-- MetisMenu CSS -->
    	<link href="<c:url value='./static/vendor/metisMenu/metisMenu.min.css'/>"  rel="stylesheet"></link>
    		<!-- Custom CSS -->
    	<link href="<c:url value='./static/dist/css/sb-admin-2.css'/>"  rel="stylesheet"></link>	
    		<!-- DataTables CSS -->
    	<link href="./static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    		<!-- DataTables Responsive CSS -->
    	<link href="./static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">    	
			<!-- Custom Fonts -->
    	<link href="<c:url value='./static/vendor/font-awesome/css/font-awesome.min.css'/>"  rel="stylesheet"></link>
	
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	
	</head>

<body>

    <div id="wrapper">
        <%@include file="navegacion.jsp" %>	

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Lista de Usuarios
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Email</th>
                                            <th>SSO ID</th>
                                      			<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        					  		<th width="100"></th>
				        					  	</sec:authorize>
				        					  	<sec:authorize access="hasRole('ADMIN')">
				        							<th width="100"></th>
				        						</sec:authorize>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${usuarios}" var="usuario">
											<tr>
												<td></td>
												<td>${usuario.nombre}</td>
												<td>${usuario.apellido}</td>
												<td>${usuario.email}</td>
												<td>${usuario.ssoId}</td>
					    						<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
													<td><a href="<c:url value='/editar-usuario-${usuario.ssoId}' />" class="btn btn-success custom-width">editar</a></td>
				        						</sec:authorize>
				        						<sec:authorize access="hasRole('ADMIN')">
													<td><a href="<c:url value='/borrar-usuario-${usuario.ssoId}' />" class="btn btn-danger custom-width">borrar</a></td>
        										</sec:authorize>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
        </div>
  	</div>
<!-- /#wrapper -->
 	</div>
    


    <!-- Metis Menu Plugin JavaScript -->
    <script src="./static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./static/dist/js/sb-admin-2.js"></script>
    
     <!-- DataTables JavaScript -->
    <script src="./static/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="./static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="./static/vendor/datatables-responsive/dataTables.responsive.js"></script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>