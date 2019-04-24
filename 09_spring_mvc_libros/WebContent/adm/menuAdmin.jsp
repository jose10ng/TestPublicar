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

	<style type="text/css">		
		.contenedor{
			margin-left: 5%;
		}
	</style>
</head>
<body>
	<h1 align="center"><span class="label label-primary">MENU DEL ADMINISTRADOR</span></h1><br/><br/><br/><br/>
	<div class="container contenedor">
		<h3>
			<span class="label label-danger"><a href="doCambioDatosCliente">Cambio datos de clientes</a></span><br/><br/>
			<span class="label label-info"><a href="doVentas">Lista Ventas entre fechas</a></span><br/><br/>
			<span class="label label-success"><a href="doHistoricos">Lista Históricos de un Cliente</a></span><br/><br/><br/>
			<span class="label label-default"><a href="doSalir">Salir</a></span>
		</h3>
	</div>
</body>
</html>