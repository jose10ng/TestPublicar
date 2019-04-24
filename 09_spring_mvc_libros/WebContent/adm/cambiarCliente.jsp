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
	<script type="text/javascript">
		function cambiar() {
			var idCliente=$("#idCliente").val();
			var usuario=$("#usuario").val();
			var password=$("#password").val();
			var email=$("#email").val();
			var telefono=$("#telefono").val();
			var pwdadmin=$("#pwdadmin").val();
			if(true){
				$.post("cambiosCliente",
						{
						 "idCliente":idCliente,
						 "usuario":usuario,
						 "password":password,
						 "email":email,
						 "telefono":telefono,
						 "pwdadmin":pwdadmin
						},
						function(d,s) {
							$("#mensaje").html("");
							$("#mensaje").html(d);
						}			
				);
			}
		}

		function telefonoNum() {
			var p=document.getElementById("telefono").value;
			if(isNaN(p)){
				alert("El teléfono debe ser numérico");
				return false;
			}else{
				return true;
			}
		}
		

		function idClienteFueraRango() {
			var p=document.getElementById("idCliente").value;
			if(p>=1999999999){
				alert("El Id Cliente está fuera de rango");
				return false;
			}else{
				return true;
			}
		}
		
		function comprobar() {
			return telefonoNum()&&idClienteFueraRango();
		}
	</script>
	<style type="text/css">		
		.contenedor{
			max-width: 40%;
		}
	</style>
</head>
<body>
	<h1 align="center"><span class="label label-primary">Modificaciones a clientes</span></h1><br/><br/>
	<div class="container contenedor">
		<div class="form-group">
			<label for="idCliente">Id del Cliente al que se le realizará los cambios:</label>
			<input type="number" name="idCliente" id="idCliente" class="form-control"/><br/>
		</div>
		<h3 align="center"><span class="label label-info">Datos a cambiar, si se dejan vacío se mantendrán los actuales</span></h3><br/>
		<div class="form-group">
			<label for="usuario">Usuario: </label><input type="text" name="usuario" id="usuario" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="password">Contraseña: </label><input type="text" name="password" id="password" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="email">Email: </label><input type="text" name="email" id="email" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="telefono">Teléfono: </label><input type="number" name="telefono" id="telefono" class="form-control"/><br/>
		</div>
		<div class="form-group">
			<label for="pwdadmin">Confirme contraseña del Administrador: </label>
			<input type="password" name="pwdadmin" id="pwdadmin" class="form-control"/>
		</div><br/>
		<h3><span class="label label-danger" id="mensaje"></span></h3><br/><br/>		
		<input type="button" onclick="cambiar();" value="Cambiar" class="btn btn-primary btn-md"/><br/><br/>
		
		<h3><span class="label label-info"><a href="toMenuAdmin">Volver</a></span></h3>
	</div>
</body>
</html>