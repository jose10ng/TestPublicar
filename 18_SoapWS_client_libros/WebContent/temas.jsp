<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Tema, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	<!-- Latest compiled JavaScript  class="dropdown-toggle"-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		.contenedor{
			max-width: 40%;
		}
	</style>
</head>
<body>
	<h1 align="center"><span class="label label-primary">Temas de Libros</span></h1><br/><br/><br/>
	<div class="container contenedor">
		<%List<Tema> temas=(ArrayList<Tema>)request.getAttribute("temas");
		if(temas!=null){%>
			<form action="libros" method="get">
				<div class="form-group">
					<label for="idTema">Seleccione Tema:</label>
					<select id="idTema" name="idTema" class="form-control">
						<option value="0">Todos los libros</option>
						<%for(Tema t:temas){%>
							<option value=<%=t.getIdTema()%>><%=t.getTema()%></option>
						<%}%>
					</select>
				</div>
				<input type="submit" value="Aceptar" class="btn btn-primary btn-md"/>
			</form><br/>
		<%} %>
		<h3>
			<span class="label label-danger">${requestScope.com}</span><br/><br/><br/>
			<span class="label label-info"><a href="doSalir">Cerrar Sesión</a></span>
		</h3>
	</div>
</body>
</html>