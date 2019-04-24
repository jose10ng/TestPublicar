package modelo.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtos.HistoricoDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;
import mappers.MapperADtos;
import modelo.dao.DaoClientes;
import modelo.dao.DaoHistoricos;
import modelo.dao.DaoLibros;
import modelo.dao.DaoTemas;
import modelo.dao.DaoVentas;

@Service("serviceLibros")
public class ServiceLibrosImpl extends MapperADtos implements ServiceLibros {
	
	@Autowired
	private DaoClientes clientes;
	@Autowired
	private DaoTemas temas;
	@Autowired
	private DaoLibros libros;
	@Autowired
	private DaoVentas ventas;
	@Autowired
	private DaoHistoricos historicos;
		
	@Override
	public Cliente buscarCliente(String usuario, String password) {
		return clientes.buscarLogin(usuario, password);
	}
	
	@Override
	public Cliente buscarClienteComprobar(String usuario, String email) {
		return clientes.buscar(usuario, email);
	}

	@Transactional
	@Override
	public boolean altaCliente(Cliente c) {
		boolean r=false;
		if(clientes.buscar(c.getUsuario(), c.getEmail())==null) {
			clientes.alta(c);
			r=true;
		}
		return r;
	}

	@Override
	public boolean bajaCliente(Cliente c) {
		boolean r=false;
		if(clientes.buscar(c.getUsuario(), c.getEmail())!=null) {
			clientes.baja(c.getIdCliente());
			r=true;
		}
		return r;		
	}

	@Override
	public boolean modificarCliente(Cliente c, Cliente nuevosDatos) {
		boolean r=false;
		if(clientes.buscar(c.getUsuario(), c.getEmail())!=null) {
			clientes.modificar(c.getIdCliente(), nuevosDatos);
			r=true;
		}
		return r;
	}
	
	@Transactional
	@Override
	public boolean modificarCliente(int idCliente, Cliente nuevosDatos) {
		boolean r=false;
		if(clientes.buscar(idCliente)!=null) {
			clientes.modificar(idCliente, nuevosDatos);
			r=true;
		}
		return r;
	}

	@Override
	public Cliente buscarCliente(int idCliente) {
		return clientes.buscar(idCliente);
	}

	@Override
	public List<Cliente> listaClientes() {
		return clientes.lista();
	}

	@Override
	public List<Historico> listaHistoricosDeUnCliente(int idCliente) {
		return clientes.listaHistoricos(idCliente);
	}

	@Override
	public List<Libro> listaLibrosDeUnCliente(int idCliente) {
		return clientes.listaLibros(idCliente);
	}

	@Override
	public boolean altaHistorico(Historico h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaHistorico(int idHistorico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Historico buscarHistorico(int idHistorico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historico> listaHistoricos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente clienteDeUnHistorico(int idHistorico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaLibro(Libro l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaLibro(int isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarLibro(int isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Libro buscarLibro(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> listaLibros() {
		return libros.lista();
	}

	@Override
	public Tema temaDeUnLibro(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listaClientesDeUnLibro(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaTema(Tema t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaTema(int idTema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarTema(int idTema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tema buscarTema(int idTema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tema> listaTemas() {
		return temas.lista();
	}

	@Override
	public List<Libro> listaLibrosDeUnTema(int idTema) {
		return temas.listaLibros(idTema);
	}

	@Override
	public Venta buscarVenta(int idVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaVentas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaVentasDeUnCliente(int idCliente) {
		return ventas.listaVentasDeUnCliente(idCliente);
	}

	@Override
	public List<Venta> listaVentasDeUnLibro(int idLibro) {
		return ventas.listaVentasDeUnLibro(idLibro);
	}

	@Override
	public List<Venta> listaVentasEntreFechas(Date ini, Date fin) {
		return ventas.listaVentasEntreFechas(ini, fin);
	}
	
	@Override
	public List<TemaDto> listaTemasDto() {
		return temas.lista().stream().map(t->obtenerDto(t)).collect(Collectors.toList());
	}
	
	@Override
	public List<LibroDto> listaLibroDtosDeUnTema(int idTema) {
		return temas.listaLibros(idTema).stream().map(l->obtenerDto(l)).collect(Collectors.toList());
	}
	
	@Override
	public List<LibroDto> listaLibroDtos() {
		return libros.lista().stream().map(l->obtenerDto(l)).collect(Collectors.toList());
	}
	
	@Override
	public LibroDto buscarLibroDto(int isbn) {
		return obtenerDto(libros.buscar(isbn));
	}
	
	@Transactional
	@Override
	public boolean realizarVentasEHistorico(Cliente c, List<LibroDto> libros) {	
		boolean r=false;
		if(c!=null&&libros!=null) {
			if(!libros.isEmpty()) {
				r=libros.stream().allMatch(l->obtenerEnt(l)!=null);
				if(r) {
					libros.forEach(l->ventas.alta(c.getIdCliente(), l.getIsbn()));				
					double total=libros.stream().mapToDouble(l->l.getPrecio()).sum();
					Historico h=new Historico();
					h.setCliente(c);
					h.setCantidad(total);		
					historicos.alta(h);
				}
			}
		}
		return r;
	}
	
	@Override
	public List<HistoricoDto> listaHistoricoDtosDeUnCliente(int idCliente) {
		List<HistoricoDto> lista=null;
		if(clientes.listaHistoricos(idCliente)!=null) {
			lista=clientes.listaHistoricos(idCliente).stream().map(h->obtenerDto(h)).collect(Collectors.toList());
		}
		return lista;
	}
	
	@Override
	public List<VentaDto> listaVentasDtosEntreFechas(Date ini, Date fin) {
		return ventas.listaVentasEntreFechas(ini, fin).stream().map(v->obtenerDto(v)).collect(Collectors.toList());
	}
}
