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
		a,input{border-radius: 5px;border-color: red}
		option{color: white;background: green}
		a{color: orange;background: blue}
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
	<h1 align="center" id="disp"></h1><br/><br/>
	<form action="altaCliente" method="post" onsubmit="return comprobar();">
		Usuario: <input type="text" name="usuario" id="usuario"/><br/><br/>
		Contraseña: <input type="text" name="password" id="password"/><br/><br/>
		Confirmar Contraseña: <input type="text" name="confirmar" id="confirmar"/><br/><br/>
		Email: <input type="text" name="email" id="email"/><br/><br/>
		Teléfono: <input type="text" name="telefono" id="telefono"/><br/><br/><br/><br/>
		<input type="submit" value="Guardar"/><br/><br/>
		<a href="#" onclick="existe();">Comprobar disponibilidad</a>
	</form><br/><br/><br/><br/>
	<h1 align="center">${requestScope.registroNOK}</h1><br/><br/>
	<a href="toMenu">Volver</a>	
</body>
</html>