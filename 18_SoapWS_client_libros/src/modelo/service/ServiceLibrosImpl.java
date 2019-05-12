package modelo.service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import beans.Cliente;
import beans.Historico;
import beans.Libro;
import beans.Tema;
import beans.Venta;
import mappers.Mapper;
import servicios.ServicioLibros;
import servicios.ServicioLibrosProxy;

@Service("serviceLibros")
public class ServiceLibrosImpl extends Mapper implements ServiceLibros {
	
	private ServicioLibros servicio;
	
	public ServiceLibrosImpl(){
		ServicioLibrosProxy pr=new ServicioLibrosProxy();
		servicio=pr.getServicioLibros();
	}
	
	@Override
	public boolean loginAdmin(String usuario, String password) throws RemoteException {
		return servicio.loginAdmin(usuario, password);
	}

	@Override		
	public Cliente buscarCliente(String usuario, String password) throws RemoteException {
		return cliente(servicio.buscarCliente(usuario, password));
	}

	@Override		
	public String buscarClient(String usuario, String password) throws RemoteException {
		return servicio.buscarCliente(usuario, password);
	}

	@Override
	public String buscarClienteComprobar(String usuario, String email) throws RemoteException {
		return servicio.buscarClienteComprobar(usuario, email);
	}

	@Override
	public boolean altaCliente(Cliente c) throws RemoteException {
		return servicio.altaCliente(jsonCliente(c));
	}

	@Override
	public boolean modificarCliente(int idCliente, Cliente nuevosDatos) throws RemoteException {
		return servicio.modificarCliente(idCliente, jsonCliente(nuevosDatos));
	}

	@Override
	public List<Historico> listaHistoricosDeUnCliente(int idCliente) throws RemoteException {
		return historicos(servicio.listaHistoricosDeUnCliente(idCliente));
	}

	@Override
	public Libro buscarLibro(int isbn) throws RemoteException {
		return libro(servicio.buscarLibro(isbn));
	}

	@Override
	public List<Libro> listaLibros() throws RemoteException {
		return listaLibros(servicio.listaLibros());
	}

	@Override
	public List<Tema> listaTemas() throws RemoteException {
		return temas(servicio.listaTemas());
	}

	@Override
	public List<Libro> listaLibrosDeUnTema(int idTema) throws RemoteException {
		return listaLibros(servicio.listaLibrosDeUnTema(idTema));
	}

	@Override
	public List<Venta> listaVentasEntreFechas(Date ini, Date fin) throws RemoteException {
		return ventas(servicio.listaVentasEntreFechas(ini, fin));
	}

	@Override
	public boolean realizarVentasEHistorico(Cliente c, List<Libro> libros) throws RemoteException {
		return servicio.realizarVentasEHistorico(jsonCliente(c), jsonLibros(libros));
	}
	
}
