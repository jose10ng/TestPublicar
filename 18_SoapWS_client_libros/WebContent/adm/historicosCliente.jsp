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
	<style type="text/css">		
		.contenedor{
			max-width: 40%;
		}
		table,tr,th,td{
			border-radius: 20px;border-color: red
		}
		
		td{
			color: white;background: blue
		}
		table{
			width: 90%
		}
	</style>
</head>
<body>
	<div  class="container contenedor">
		<h1 align="center"><span class="label label-primary">Lista de Históricos de un clientes</span></h1><br/><br/>
		<div class="form-group">
			<label for="idCliente">Id del Cliente para obtener sus históricos: </label>
			<input type="number" name="idCliente" id="idCliente" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="idCliente">Confirme contraseña del Administrador: </label>
			<input type="password" name="pwdadmin" id="pwdadmin" class="form-control"/>
		</div>
		<h3><span class="label label-danger" id="mensaje"></span></h3>
		<input type="button" onclick="lista();" value="Listar" class="btn btn-primary btn-md"/><br/><br/><br/>	
		<h3><span class="label label-info"><a href="toMenuAdmin">Volver</a></span></h3>
	</div><br/><br/>
	<div id="lista">
	</div><br/>
</body>
</html>