package modelo.dao;

import java.util.List;

import entidades.Libro;
import entidades.Tema;

public interface DaoTemas {

	boolean alta(Tema t);
	boolean baja(int idTema);
	boolean modificar(int idTema);
	Tema buscar(int idTema);
	List<Tema> lista();
	List<Libro> listaLibros(int idTema);
}
