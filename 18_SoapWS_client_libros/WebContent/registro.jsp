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
			max-width: 40%;
		}
	</style>
	<script type="text/javascript">
		function obligatorios() {
			if(document.getElementById("usuario").value==""||document.getElementById("password").value==""){
				alert("Usuario y Password son campos obligatorios");
				return false;
			}else{
				return true;
			}
		}
		
		function confirmarPassword() {
			if(document.getElementById("password").value!=document.getElementById("confirmar").value){
				alert("Password deben coincidir");
				return false;
			}else{
				return true;
			}
		}
		
		function passwordMasDeCuatro() {
			var p=document.getElementById("password").value;
			if(p.length<4){
				alert("Password debe tener 4 o más caracteres");
				return false;
			}else{
				return true;
			}
		}
		
		function comprobarEmail() {
			var p=document.getElementById("email").value;
			if(!p.includes("@")&&!p.includes(".")){
				alert("Email debe tener formato xxx@xxxx.xxx");
				return false;
			}else{
				return true;
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
		
		function comprobar() {
			return obligatorios()&&confirmarPassword()&&passwordMasDeCuatro()&&comprobarEmail()&&telefonoNum();
		}
		
		function existe() {
			var usuario=document.getElementById("usuario").value;
			var email=document.getElementById("email").value;
			$.get("comprobar",{"usuario":usuario,"email":email},function(d,s){
				document.getElementById("disp").innerHTML=d;
			});
		}
	</script>
</head>
<body>	
	<h1 align="center"><span class="label label-primary">Registro de Cliente</span></h1><br/><br/>
	<div class="container contenedor">	
		<form action="altaCliente" method="post" onsubmit="return comprobar();">
			<div class="form-group">
				<label for="usuario">Usuario: </label>
				<input type="text" name="usuario" id="usuario" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="password">Contraseña: </label>
				<input type="text" name="password" id="password" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="confirmar">Confirmar Contraseña: </label>
				<input type="text" name="confirmar" id="confirmar" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="email">Email: </label>
				<input type="text" name="email" id="email" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono: </label>
				<input type="text" name="telefono" id="telefono" class="form-control"/>
			</div><br/>
			<input type="submit" value="Guardar" class="btn btn-danger btn-md"><br/>
			<h3><span class="label label-info"><a href="#" onclick="existe();">Comprobar disponibilidad</a></span></h3>
		</form><br/><br/>
		<h3 align="center">
			<span class="label label-primary" id="disp"></span><br/><br/>
			<span class="label label-danger">${requestScope.registroNOK}</span>
		</h3><br/><br/>
		<h3><span class="label label-info"><a href="toMenu">Volver</a></span></h3>
	</div>
</body>
</html>