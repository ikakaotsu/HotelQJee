<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <!-- Metis Menu Plugin JavaScript -->
    <script src="./static/vendor/metisMenu/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="./static/dist/js/sb-admin-2.js"></script>
    <!-- DataTables JavaScript -->
    <script src="./static/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="./static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="./static/vendor/datatables-responsive/dataTables.responsive.js"></script>
	 
	 
	    <!-- Bootstrap Core CSS -->
	    <link href="<c:url value='./static/vendor/bootstrap/css/bootstrap.min.css' />"  rel="stylesheet"></link>
		   <!-- MetisMenu CSS -->
    	<link href="<c:url value='./static/vendor/metisMenu/metisMenu.min.css'/>"  rel="stylesheet"></link>
    		<!-- Custom CSS -->
    	<link href="<c:url value='./static/dist/css/sb-admin-2.css'/>"  rel="stylesheet"></link>
    	 <!-- DataTables CSS -->
   		<link href="<c:url value='./static/vendor/datatables-plugins/dataTables.bootstrap.css'/>" rel="stylesheet"></link>
   		 <!-- DataTables Responsive CSS -->
    	<link href="<c:url value='./static/vendor/datatables-responsive/dataTables.responsive.css'/>" rel="stylesheet"></link>
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
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="myModalLabel">Ingreso de Pasajero</h4>
                                        </div>
                                        <div class="modal-body">
                                           <%@include file="modalhabitaciones.jsp" %>	
                                        </div>
                                        <div class="modal-footer">
									       <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
									       <button type="button" class="btn btn-primary">Ingresar</button>
  										</div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
	                                        <th>Nro Habitacion</th>
	                                        <th>Nro Personas</th>
	                                        <th>Estado</th>
	                                        <th>Tipo Habitacion</th>
	                                        <th>Apellido y Nombre</th>
	                                        <th>Ingreso</th>
	                                        <th>Despertador</th>
	                                        <th> </th>
	                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>2</td>
                                            <td>DEBE</td>
                                			<td>MT</td>
                                			<td>Perez Juan</td>
                                			<td>08/04/2018|14:30</td>
                                			<td>21:00hs</td>
                                			<td>
                                				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Editar</button>
     										 </td>
                                        </tr>
                  
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
<!-- /#wrapper -->
 	</div>

  <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
</body>

</html>