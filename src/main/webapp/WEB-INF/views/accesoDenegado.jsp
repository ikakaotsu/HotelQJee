<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Acceso Denegado</title>
</head>
<body>
	<div class="generic-container">
		<div class="authbar">
			<span>El usuario <strong>${loggedinuser}</strong>, No esta atorizado a accedera a esta pagina.</span> <span class="floatRight"><a href="<c:url value="/index" />">Volver</a></span>
		</div>
	</div>
</body>
</html>