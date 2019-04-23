<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dtos.LibroDto, java.util.*, entidades.Cliente"%>
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
	</script>
</head>
<body onload="inicio();">
	<%Cliente c=(Cliente)session.getAttribute("cliente"); %>
	<h3>Hola Usuario: <%=c.getUsuario() %></h3>
	<h3>Id Cliente: <%=c.getIdCliente() %></h3>		
	<h1 align="center">LIBROS</h1><br/>
	<%List<LibroDto> libros=(ArrayList<LibroDto>)request.getAttribute("libros");%>
	<%if(libros!=null&&libros.size()!=0){ %>
		<table align="center" border="1" width="80%">
			<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Páginas</th><th>Tema</th><th>Su elección</th></tr>
			<%for(LibroDto l:libros){ %>
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
		<h1 align="center">No hay libros para este tema</h1>
	<%} %>
	<a href="doTemas">Elija otro tema</a><br/><br/>
	<h1 align="center">CESTA</h1><br/>
	<div id="cesta">
	</div>
	<div id="volver">
	</div><br/><br/>
	<%String mens=(String)request.getAttribute("mensaje");
	if(mens!=null){%>
		<h3><%=mens %></h3>
	<%} %>
	<form action="doComprar" method="post">
		<input type="submit" value="Comprar">
	</form>
	<h3><a href="doSalir">Cerrar Sesión</a></h3>
</body>
</html>