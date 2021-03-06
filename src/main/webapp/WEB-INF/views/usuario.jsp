<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
   		<meta name="description" content="">
    	<meta name="author" content="">
	    <title>Hotel Verision 0.1</title>
	
		 <script src="./static/vendor/jquery/jquery.js"></script>
	    <!-- Bootstrap Core CSS -->
	    <link href="<c:url value='./static/vendor/bootstrap/css/bootstrap.min.css' />"  rel="stylesheet"></link>
		   <!-- MetisMenu CSS -->
    	<link href="<c:url value='./static/vendor/metisMenu/metisMenu.min.css'/>"  rel="stylesheet"></link>
    		<!-- Custom CSS -->
    	<link href="<c:url value='./static/dist/css/sb-admin-2.css'/>"  rel="stylesheet"></link>
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
	           	<div class="well lead">Formulario Registro Usuarios</div>
		 			<form:form method="POST" modelAttribute="usuario" class="form-horizontal">
						<form:input type="hidden" path="id" id="id"/>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="nombre">Nombre</label>
								<div class="col-md-7">
									<form:input type="text" path="nombre" id="nombre" class="form-control input-sm"/>
									<div class="has-error">
										<form:errors path="nombre" class="help-inline"/>
									</div>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="apellido">Apellido</label>
								<div class="col-md-7">
									<form:input type="text" path="apellido" id="apellido" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="apellido" class="help-inline"/>
									</div>
								</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="domicilio">Domicilio</label>
									<div class="col-md-7">
										<form:input type="text" path="domicilio" id="domicilio" class="form-control input-sm"/>
										<div class="has-error">
											<form:errors path="domicilio" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="Pais">Pais</label>
									<div class="col-md-7">
										<form:select path="Pais" id="Pais">
											<form:option value="-1" label="Seleccionar Pais"/>
											<form:options items="${paises}" itemValue="id" itemLabel="nombre" class="form-control input-sm"/>
										</form:select>
										<div class="has-error">
											<form:errors path="pais" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<script type="text/javascript">
							$(document).ready(function(){
								$('select#Pais').change(
								 function(){
									 $.getJSON("obtenerprovincia",{
										 idpais: $(this).val(),
										 ajax: 'true'
									 }, function(data){
			 							 var html = '<option value="">Seleccionar Provincia</option>';
									 	 var len = data.length;
									 	 for(var i = 0; i < len; i++){
									 		 html += '<option value="' + data[i].id + '">'
									 		  + data[i].nombre + '</option>';
									 		 }
									 	 html += '</option>';
									 	 
									 	 $('select#Provincia').html(html);
									 	 });
									 });
								$('select#Provincia').change(
									function(){			
										$.getJSON("obtenerlocalidad",{
											idprovincia: $(this).val(),
											ajax:'true'
										}, function(data){
											var html = '<option value="">Seleccionar Localidad</option>';
											var len = data.length;
											for(var i=0; i < len; i++){
												html += '<option value="' + data[i].id + '">'
												+ data[i].nombre + '</option>';	
											}
											html += '</option>';
											
											$('select#Localidad').html(html);
											});
										});	
								});
						</script>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="Provincia">Provincia</label>
									<div class="col-md-7">
										<form:select path="Provincia" id="Provincia">
											<form:option value="-1" label="Seleccionar Provincia"/>
											<c:if test="${editar}">
											<form:options items="${provincias}" itemValue="id" itemLabel="nombre" class="form-control input-sm"/>
											</c:if>
										</form:select>
										<div class="has-error">
											<form:errors path="provincia" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>					
						
						<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-3 control-lable" for="Localidad">Localidad</label>
									<div class="col-md-7">
										<form:input type="text" path="localidad2" id="Localidad2"
											class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="localidad2" class="help-inline" />
										</div>
									</div>
								</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="telefono">Telefono</label>
									<div class="col-md-7">
										<form:input type="text" path="telefono" id="telefono" class="form-control input-sm"/>
										<div class="has-error">
											<form:errors path="telefono" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="cuil">Cuil</label>
									<div class="col-md-7">
										<form:input type="text" path="cuil" id="cuil" class="form-control input-sm"/>
										<div class="has-error">
											<form:errors path="cuil" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="categoria">Categoria</label>
									<div class="col-md-7">
										<form:input type="text" path="categoria" id="categoria" class="form-control input-sm"/>
										<div class="has-error">
											<form:errors path="categoria" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="profesion">Profesion</label>
									<div class="col-md-7">
										<form:input type="text" path="profesion" id="profesion" class="form-control input-sm"/>
										<div class="has-error">
											<form:errors path="profesion" class="help-inline"/>
										</div>
									</div>
							</div>
						</div>
				
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="email">Email</label>
								<div class="col-md-7">
									<form:input type="text" path="email" id="email" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="email" class="help-inline"/>
									</div>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
								<div class="col-md-7">
									<c:choose>
										<c:when test="${editar}">
											<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
										</c:when>
										<c:otherwise>
											<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
											<div class="has-error">
												<form:errors path="ssoId" class="help-inline"/>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="password">Password</label>
								<div class="col-md-7">
									<form:input type="password" path="password" id="password" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="password" class="help-inline"/>
									</div>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="usuarioPerfil">Roles</label>
								<div class="col-md-7">
									<form:select path="usuarioPerfil" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="usuarioPerfil" class="help-inline"/>
									</div>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="form-actions floatRight">
								<c:choose>
									<c:when test="${editar}">
										<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listausuarios' />">Cancelar</a>
									</c:when>
									<c:otherwise>
										<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listausuarios' />">Cancelar</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
				</form:form>
		</div> 
<!-- /#wrapper -->
 	</div>
    

   <!-- jQuery -->
   

    <!-- Bootstrap Core JavaScript -->
    <script src="./static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="./static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./static/dist/js/sb-admin-2.js"></script>

</body>

</html>