<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Libro, java.util.*,beans.Cliente"%>
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
		function inicio() {
			$.get("inicio",cesta);
		}
		function agregar(isbn) {
			$.get("agregar",{"isbn":isbn},function(d,status){
				cesta(d);
			});
		}
		function eliminar(pos) {
			$.post("eliminar",{"pos":pos},cesta);
		}
		function cesta(data) {
			var libros=JSON.parse(data);
			if(libros.com=="errorCom"){
				document.getElementById("volver").innerHTML="<h2>Error de comunicación con el servicio....<a href='toLogin'>Volver al inicio</a></h2>";
			}else{
				if(libros.session=="caducada"){
					document.getElementById("volver").innerHTML="<h2>Sesión expirada....<a href='toLogin'>Volver al inicio</a></h2>";
				}else{
					if(libros.length!=0){
						var tabla="<table align='center' border='1' width='80%'>";
						tabla+="<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Páginas</th><th>Tema</th><th>Su elección</th></tr>";
						libros.forEach(function(o,i){
							tabla+="<tr>";
							tabla+="<td>"+o.titulo+"</td>";
							tabla+="<td>"+o.autor+"</td>";
							tabla+="<td>"+o.precio+"</td>";
							tabla+="<td>"+o.paginas+"</td>";
							tabla+="<td>"+o.tema+"</td>";
							tabla+="<td><a href='#' onclick='eliminar("+i+");'>Eliminar</a></td>";
							tabla+="</tr>";
						});
						tabla+="</table>";
						document.getElementById("cesta").innerHTML=tabla;
					}else{
						document.getElementById("cesta").innerHTML="<h1 align='center'>Cesta vacía</h1>";
					}
				}
			}
		}
	</script>
	<style type="text/css">		
		.contenedor{
			margin-left: 5%
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
<body onload="inicio();">
	<%Cliente c=(Cliente)session.getAttribute("cliente"); %>
	<h3 class="contenedor">
		<span class="label label-success">Hola Usuario: <%=c.getUsuario() %></span>
		<span class="label label-default">Id Cliente: <%=c.getIdCliente() %></span>
	</h3>		
	<h1 align="center"><span class="label label-primary">LIBROS</span></h1><br/>
	<%List<Libro> libros=(ArrayList<Libro>)request.getAttribute("libros");%>
	<%if(libros!=null&&libros.size()!=0){ %>
		<table align="center" border="1" width="80%">
			<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Páginas</th><th>Tema</th><th>Su elección</th></tr>
			<%for(Libro l:libros){ %>
				<tr>
					<td><%=l.getTitulo() %></td>
					<td><%=l.getAutor() %></td>
					<td><%=l.getPrecio() %></td>
					<td><%=l.getPaginas() %></td>
					<td><%=l.getTema().getTema() %></td>
					<td><a href="#" onclick="agregar(<%=l.getIsbn()%>)">Agregar a la cesta</a></td>
				</tr>
			<%} %>	
		</table><br/><br/>
	<%}else{ %>
		<h3 align="center"><span class="label label-info">No hay libros para este tema</span></h3>
	<%} %>
	<h3 class="contenedor"><span class="label label-default"><a href="doTemas">Elija otro tema</a></span></h3><br/><br/>
	<h3><span class="label label-danger">${requestScope.com}</span></h3><br/>
	<h1 align="center"><span class="label label-primary">CESTA</span></h1><br/>
	<div id="cesta"></div>
	<h3><span id="volver" class="label label-danger"></span></h3><br/><br/>
	<%String mens=(String)request.getAttribute("mensaje");
	if(mens!=null){%>
		<h3 align="center"><span class="label label-danger"><%=mens %></span></h3>
	<%} %>
	<form action="doComprar" method="post">
		<input type="submit" value="Comprar" class="btn btn-danger contenedor"/>
	</form>
	<h3 class="contenedor"><span class="label label-info"><a href="doSalir">Cerrar Sesión</a></span></h3>
</body>
</html>