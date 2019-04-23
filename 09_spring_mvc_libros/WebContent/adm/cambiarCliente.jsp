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
</head>
<body>
	<h1 align="center">Modificaciones a clientes</h1><br/><br/>
	Id del Cliente al que se le realizará los cambios: <input type="number" name="idCliente" id="idCliente"/><br/><br/>
	<h3 align="center">Datos a cambiar, si se dejan vacío se mantendrán los actuales</h3><br/>
	Usuario: <input type="text" name="usuario" id="usuario"/><br/>
	Contraseña: <input type="text" name="password" id="password"/><br/>
	Email: <input type="text" name="email" id="email"/><br/>
	Teléfono: <input type="number" name="telefono" id="telefono"/><br/><br/>
	Confirme contraseña del Administrador: <input type="password" name="pwdadmin" id="pwdadmin"/><h4 align="center" id="mensaje"></h4><br/><br/>
		
	<input type="button" onclick="cambiar();" value="Cambiar"/><br/><br/><br/>
	
	<a href="toMenuAdmin">Volver</a>
</body>
</html>