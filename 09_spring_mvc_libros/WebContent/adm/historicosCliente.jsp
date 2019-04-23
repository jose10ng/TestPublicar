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
		function lista() {
			if(true){
				var idCliente=$("#idCliente").val();
				var pwdadmin=$("#pwdadmin").val();
				$.post("historicosCl",{"idCliente":idCliente,"pwdadmin":pwdadmin}, function(d,s) {
					var obj=JSON.parse(d);
					if(obj.error=="error"){
						var mens="<h1 align='center'>"+obj.mensaje+"</h1>";
						$("#lista").html(mens);
					}else{
						if(obj.length!=0){
							var tabla="<table align='center' width='80%' border='1'>";
							tabla+="<tr><th>Id Histórico</th><th>Cantidad</th></tr>";
							obj.forEach(function(o,i){
								tabla+="<tr>";
								tabla+="<td>"+o.idHistorico+"</td>";
								tabla+="<td>"+o.cantidad+"</td>";
								tabla+="</tr>";
							});
							tabla+="</table>";
							$("#lista").html(tabla);
						}else{
							$("#lista").html("<h1 align='center'>Este cliente no tiene históricos</h1>");
						}						
					}					
				});
			}
		}
		
		function comprobar() {
			var p=document.getElementById("idCliente").value;
			if(isNaN(p)||p>=1999999999){
				alert("Id Cliente no es un número o está fuera de rango");
				return false;
			}else{
				return true;
			}			
		}
	</script>	
</head>
<body>
	<h1 align="center">Lista de Históricos de un clientes</h1><br/><br/>
	Id del Cliente para obtener sus históricos: <input type="number" name="idCliente" id="idCliente"/><br/><br/>
	Confirme contraseña del Administrador: <input type="password" name="pwdadmin" id="pwdadmin"/><h4 align="center" id="mensaje"></h4><br/><br/>
	<div id="lista">
	</div>
	<input type="button" onclick="lista();" value="Listar"/><br/><br/><br/>	
	<a href="toMenuAdmin">Volver</a>
</body>
</html>