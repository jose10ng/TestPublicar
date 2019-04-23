package modelo.service;

import java.util.Date;
import java.util.List;

import dtos.ClienteDto;
import dtos.HistoricoDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;

public interface ServiceLibros {

	boolean altaCliente(Cliente c);
	boolean bajaCliente(Cliente c);
	boolean modificarCliente(Cliente c, Cliente nuevosDatos);
	Cliente buscarCliente(int idCliente);
	List<Cliente> listaClientes();
	List<Historico> listaHistoricosDeUnCliente(int idCliente);
	List<Libro> listaLibrosDeUnCliente(int idCliente);
	Cliente buscarCliente(String usuario, String email);

	boolean altaHistorico(Historico h);
	boolean bajaHistorico(int idHistorico);
	Historico buscarHistorico(int idHistorico);
	List<Historico> listaHistoricos();
	Cliente clienteDeUnHistorico(int idHistorico);

	boolean altaLibro(Libro l);
	boolean bajaLibro(int isbn);
	boolean modificarLibro(int isbn);
	Libro buscarLibro(int isbn);
	List<Libro> listaLibros();
	Tema temaDeUnLibro(int isbn);
	List<Cliente> listaClientesDeUnLibro(int isbn);

	boolean altaTema(Tema t);
	boolean bajaTema(int idTema);
	boolean modificarTema(int idTema);
	Tema buscarTema(int idTema);
	List<Tema> listaTemas();
	List<Libro> listaLibrosDeUnTema(int idTema);

	Venta buscarVenta(int idVenta);
	List<Venta> listaVentas();
	List<Venta> listaVentasDeUnCliente(int idCliente);
	List<Venta> listaVentasDeUnLibro(int idLibro);
	List<Venta> listaVentasEntreFechas(Date ini,Date fin);
	List<TemaDto> listaTemasDto();
	List<LibroDto> listaLibroDtosDeUnTema(int idTema);
	List<LibroDto> listaLibroDtos();
	LibroDto buscarLibroDto(int isbn);
	boolean realizarVentasEHistorico(Cliente c, List<LibroDto> libros);
	Cliente buscarClienteComprobar(String usuario, String email);
	boolean modificarCliente(int idCliente, Cliente nuevosDatos);
	List<HistoricoDto> listaHistoricoDtosDeUnCliente(int idCliente);
	List<VentaDto> listaVentasDtosEntreFechas(Date ini, Date fin);
}
