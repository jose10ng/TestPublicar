package modelo.dao;

import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Libro;
import entidades.Venta;

public interface DaoVentas {

	Venta buscar(int idVenta);
	List<Venta> lista();
	List<Venta> listaVentasDeUnCliente(int idCliente);
	List<Venta> listaVentasDeUnLibro(int idLibro);
	List<Venta> listaVentasEntreFechas(Date ini,Date fin);
	void alta(Cliente c, Libro l);
	
}
