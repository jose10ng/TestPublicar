package prueba;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dtos.MovimientoDto;
import modelo.service.ServiceBancaEjbLocal;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServiceBancaEjbLocal service;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(MovimientoDto md:service.listaMov(1000)) {
			System.out.print(md.getCantidad()+" | ");
		}
		System.out.println();
		System.out.println(service.buscarCuenta(1000).getNumeroCuenta()+" | "+service.buscarCuenta(1000).getSaldo());
		
	}

}
