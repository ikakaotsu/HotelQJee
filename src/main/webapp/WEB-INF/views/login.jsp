<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
   		<meta name="description" content="">
    	<meta name="author" content="">
		<title>Hotel</title>
		
		    <!-- jQuery -->
    <script src="./static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./static/vendor/bootstrap/js/bootstrap.min.js"></script>
		
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
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Favor de Registrarse</h3>
                    </div>
                    <div class="panel-body">
                    	<c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" role="form">
                        	<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Nombre y password invalidos.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Ha salido exitosamente.</p>
								</div>
							</c:if>
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Ingresar Usuario" id="nombreusuario" name="ssoId" type="text" autofocus required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Ingresar Contraseña" name="password" type="password" required>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input id="rememberme" name="remember-me" type="checkbox">Recordarme
                                    </label>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                <input type="submit"class="btn btn-lg btn-success btn-block" value="Entrar">
                                <!-- Change this to a button or input when using this as a form -->
<!--                                 <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a> -->
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <!-- Metis Menu Plugin JavaScript -->
    <script src="./static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./static/dist/js/sb-admin-2.js"></script>
</body>
</html>