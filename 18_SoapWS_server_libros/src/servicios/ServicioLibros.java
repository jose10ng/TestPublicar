package servicios;

import java.util.Date;

import javax.jws.WebService;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import modelo.service.ServiceLibros;

@WebService(serviceName="librosws")
public class ServicioLibros{

	@Autowired
	ServiceLibros service;
	
	{
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public boolean loginAdmin(String usuario, String password) {
		return service.loginAdmin(usuario, password);
	}
	
	public String buscarCliente(String usuario, String password) {
		return service.buscarCliente(usuario, password);
	}

	public String buscarClienteComprobar(String usuario, String email) {
		return service.buscarClienteComprobar(usuario, email);
	}

	public String listaTemas() {
		return service.listaTemas();
	}

	public String listaLibrosDeUnTema(int idTema) {
		return service.listaLibrosDeUnTema(idTema);
	}

	public String listaLibros() {
		return service.listaLibros();
	}

	public String buscarLibro(int isbn) {
		return service.buscarLibro(isbn);
	}

	public String listaHistoricosDeUnCliente(int idCliente) {
		return service.listaHistoricosDeUnCliente(idCliente);
	}

	public String listaVentasEntreFechas(Date ini, Date fin) {
		return service.listaVentasEntreFechas(ini, fin);
	}

	public boolean realizarVentasEHistorico(String cliente, String cesta) {
		return service.realizarVentasEHistorico(cliente, cesta);
	}

	public boolean modificarCliente(int idCliente, String clNuevosDatos) {
		return service.modificarCliente(idCliente, clNuevosDatos);
	}

	public boolean altaCliente(String cl) {
		return service.altaCliente(cl);
	}
}
