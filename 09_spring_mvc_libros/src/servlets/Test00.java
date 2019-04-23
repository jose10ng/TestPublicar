package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import modelo.service.ServiceLibros;

/**
 * Servlet implementation class Test00
 */
@WebServlet("/Test00")
public class Test00 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ServiceLibros service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		/*service.altaAlumno(new Alumno("cabra",55,"cabra@net","cabritos","9999"));
		Alumno al=service.buscarAlumno("cabra2");
		al.setEdad(55);
		al.setNombre("cabrita");
		al.setPassword("5555");
		service.modificarAlumno("cabra2", al);
		service.matricularAlumno("jsf", 12);
		service.eliminarAlumno("cabra2");
		service.modificarMatricula("jsf", 12, 5.6);
		service.modificarMatricula("cecy", 4, 9.8);*/
				
		out.println("<html><body>");

		out.println("<h1 align='center'>LISTA CLIENTES<h1><table border='1' width='80%'>");
		service.listaClientes().forEach(c->out.println("<tr><td>"+c.getIdCliente()+"</td><td>"+c.getUsuario()+"</td><td>"+c.getEmail()+"</td></tr>"));
		out.println("</table></br></br>");
/*
		out.println("<h1 align='center'>LISTA MATRICULAS<h1><table border='1' width='80%'>");
		service.listaMatriculaDto().forEach(m->out.println("<tr><td>"+m.getId().getUsuario()+"</td><td>"+m.getId().getIdCurso()+"</td><td>"+m.getNota()+"</td></tr>"));
		out.println("</table></br></br>");
		
		out.println("<h1 align='center'>LISTA ALUMNOS<h1><table border='1' width='80%'>");
		service.listaAlumnosDto().forEach(a->out.println("<tr><td>"+a.getUsuario()+"</td><td>"+a.getNombre()+"</td><td>"+a.getEmail()+"</td><td>"+a.getEdad()+"</td></tr>"));
		out.println("</table>");
		
		out.println("<h1 align='center'>LISTA CURSOS DE UN ALUMNO<h1><table border='1' width='80%'>");
		service.cursosDtoAlumno("juan").forEach(c->out.println("<tr><td>"+c.getIdCurso()+"</td><td>"+c.getNombre()+"</td><td>"+c.getDuracion()+"</td><td>"+c.getDocumento()+"</td></tr>"));
		out.println("</table>");
		
		MatriculaDto m=service.buscarMatriculaDto("jsf", 12);
		out.println("<h1 align='center'>Usuario: "+m.getId().getUsuario()+" idCurso: "+m.getId().getIdCurso()+" Nota: "+m.getNota()+"<h1>");
		*/
		out.println("</body></html>");
	}

}
