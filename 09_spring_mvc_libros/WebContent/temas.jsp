<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dtos.TemaDto, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">TEMAS</h1><br/>
	<%List<TemaDto> temas=(ArrayList<TemaDto>)request.getAttribute("temas");%>
	<form action="libros" method="get">
		<select name="idTema">
			<option value="0">Todos los libros</option>
			<%for(TemaDto t:temas){%>
				<option value=<%=t.getIdTema()%>><%=t.getTema()%></option>
			<%}%>
		</select>
		<input type="submit" value="Aceptar">
	</form><br/><br/>
	<h3><a href="doSalir">Cerrar Sesión</a></h3>
</body>
</html>