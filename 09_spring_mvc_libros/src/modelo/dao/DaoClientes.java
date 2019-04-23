package modelo.dao;

import java.util.List;

import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;

public interface DaoClientes {
	
	void alta(Cliente c);
	void baja(int idCliente);
	void modificar(int idCliente, Cliente nuevosDatos);
	Cliente buscar(int idCliente);
	List<Cliente> lista();
	List<Historico> listaHistoricos(int idCliente);
	List<Libro> listaLibros(int idCliente);
	Cliente buscar(String usuario, String email);
	Cliente buscarLogin(String usuario, String password);

}
