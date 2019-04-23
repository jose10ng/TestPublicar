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
			var ini=$("#ini").val();
			var fin=$("#fin").val();
			var pwdadmin=$("#pwdadmin").val();
			$.post("ventasFecha",{"ini":ini,"fin":fin,"pwdadmin":pwdadmin},function(d,s){
				alert(d);
				var obj=JSON.parse(d);
				if(obj.error=="error"){
					$("#lista").html("<h2 align='center'>"+obj.mensaje+"</h2>");
				}else{
					if(obj.length!=0){
						var tabla="<table align='center' width='80%' border='1'>";
						tabla+="<tr><th>Id Venta</th><th>Id Cliente</th><th>Id Libro</th><th>Fecha</th></tr>";
						obj.forEach(function(o,i) {
							tabla+="<tr>";
							tabla+="<td>"+o.id+"</td>";
							tabla+="<td>"+o.cliente+"</td>";
							tabla+="<td>"+o.libro+"</td>";
							tabla+="<td>"+o.fecha+"</td>";
							tabla+="</tr>";
						});
						tabla+="</table>";
						$("#lista").html(tabla);
					}else{
						$("#lista").html("<h2 align='center'>No hay ventas en estas fechas</h2>");
					}
				}				
			});
		}
	</script>
</head>
<body>
	<h1 align="center">Lista de Ventas entre fechas</h1><br/><br/><br/>
	Fecha inicio: <input type="date" name="ini" id="ini"/><br/><br/>
	Fecha fin: <input type="date" name="fin" id="fin"/><br/><br/>
	Confirme contraseña del Administrador: <input type="password" name="pwdadmin" id="pwdadmin"/><br/><br/>
	<div id="lista">
	</div>
	<input type="button" onclick="lista();" value="Listar"/><br/><br/><br/>
	
	<a href="toMenuAdmin">Volver</a>
</body>
</html>