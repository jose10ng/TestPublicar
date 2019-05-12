package modelo.service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import beans.Cliente;
import beans.Historico;
import beans.Libro;
import beans.Tema;
import beans.Venta;

public interface ServiceLibros {

	boolean realizarVentasEHistorico(Cliente c, List<Libro> libros) throws RemoteException;

	List<Venta> listaVentasEntreFechas(Date ini, Date fin) throws RemoteException;

	List<Libro> listaLibrosDeUnTema(int idTema) throws RemoteException;

	List<Tema> listaTemas() throws RemoteException;

	List<Libro> listaLibros() throws RemoteException;

	Libro buscarLibro(int isbn) throws RemoteException;

	List<Historico> listaHistoricosDeUnCliente(int idCliente) throws RemoteException;

	boolean modificarCliente(int idCliente, Cliente nuevosDatos) throws RemoteException;

	boolean altaCliente(Cliente c) throws RemoteException;

	String buscarClienteComprobar(String usuario, String email) throws RemoteException;

	Cliente buscarCliente(String usuario, String password) throws RemoteException;

	boolean loginAdmin(String usuario, String password) throws RemoteException;

	String buscarClient(String usuario, String password) throws RemoteException;
	
}
