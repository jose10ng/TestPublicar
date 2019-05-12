package modelo.service;

import java.util.Date;

import javax.servlet.ServletContext;

public interface ServiceLibros {

	String buscarCliente(String usuario, String password);

	String buscarClienteComprobar(String usuario, String email);

	String listaTemas();

	String listaLibrosDeUnTema(int idTema);

	String listaLibros();

	String buscarLibro(int isbn);

	String listaHistoricosDeUnCliente(int idCliente);

	String listaVentasEntreFechas(Date ini, Date fin);

	boolean realizarVentasEHistorico(String cliente, String cesta);

	boolean modificarCliente(int idCliente, String clNuevosDatos);

	boolean altaCliente(String cl);

	boolean loginAdmin(String usuario, String password);
}
