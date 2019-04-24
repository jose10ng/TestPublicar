<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 align="center"><span class="label label-primary">Login del Administrador</span></h1><br/><br/><br/>
	<div class="container">
		<form action="loginAdmin" method="post">
			<div class="form-group">
				<label for="usuario">Administrador: </label>
				<input type="text" name="usuario" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="password">Contraseña del Administrador: </label>
				<input type="password" name="password" class="form-control"/>
			</div>
			<input type="submit" value="Entrar" class="btn btn-danger btn-md">
		</form><br/>
		<h3>
			<span class="label label-danger">${requestScope.mensaje}</span><br/><br/>
			<span class="label label-info"><a href="toMenu">Volver</a></span>
		</h3>
	</div>
</body>
</html>