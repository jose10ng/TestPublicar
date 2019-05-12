package modelo.dao;

import java.util.List;

import entidades.Cliente;
import entidades.Libro;
import entidades.Tema;

public interface DaoLibros {
	
	boolean alta(Libro l);
	boolean baja(int isbn);
	boolean modificar(int isbn);
	Libro buscar(int isbn);
	List<Libro> lista();
	Tema temaDeUnLibro(int isbn);
	List<Cliente> listaClientes(int isbn);
}
