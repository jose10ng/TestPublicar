package modelo.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;
import mappers.Mapper;
import modelo.dao.DaoClientes;
import modelo.dao.DaoHistoricos;
import modelo.dao.DaoLibros;
import modelo.dao.DaoTemas;
import modelo.dao.DaoVentas;

@Service("serviceLibros")
public class ServiceLibrosImpl extends Mapper implements ServiceLibros {
	
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
	@Autowired
	private ServletContext context;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpSession session;
		
	@Override
	public boolean loginAdmin(String usuario, String password) {
		/*WebApplicationContext wac=ContextLoader.getCurrentWebApplicationContext();
		ServletContext context=wac.getServletContext(); se puede obtener el Context con este objeto
		y también inyectándolo. Inyectando request, response y session parece NO funcionar
		System.out.println("request "+request);
		System.out.println("response "+response);
		System.out.println("session "+session);
		System.out.println("context "+context);*/
		boolean r=false;
		Properties datos=new Properties();
		String real=context.getRealPath(context.getInitParameter("admin"));
		try(InputStreamReader in=new InputStreamReader(new FileInputStream(real));) {
			datos.load(in);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(datos.getProperty("usuario").equals(usuario)&&datos.getProperty("password").equals(password)) {
			r=true;
		}
		return r;
	}
			
	@Override
	public String buscarCliente(String usuario, String password) {
		String r=null;
		if(clientes.buscarLogin(usuario, password)!=null) {
			r=jsonCliente(clientes.buscarLogin(usuario, password));
		}
		return r;
	}
	
	@Override
	public String buscarClienteComprobar(String usuario, String email) {
		String r=null;
		if(clientes.buscar(usuario, email)!=null) {
			r="no disponible";
		}
		return r;
	}

	@Transactional
	@Override
	public boolean altaCliente(String cl) {
		boolean r=false;
		Cliente c=cliente(cl);
		if(clientes.buscar(c.getUsuario(), c.getEmail())==null) {
			clientes.alta(new Cliente(c.getEmail(),c.getPassword(),c.getTelefono(),c.getUsuario()));
			r=true;
		}
		return r;
	}
	
	@Transactional
	@Override
	public boolean modificarCliente(int idCliente, String clNuevosDatos) {
		boolean r=false;
		Cliente nuevosDatos=cliente(clNuevosDatos);
		if(clientes.buscar(idCliente)!=null) {
			clientes.modificar(idCliente, new Cliente(nuevosDatos.getEmail(),nuevosDatos.getPassword(),nuevosDatos.getTelefono(),nuevosDatos.getUsuario()));
			r=true;
		}
		return r;
	}
	
	@Override
	public String listaTemas() {
		return jsonTemas(temas.lista());
	}
	
	@Override
	public String listaLibrosDeUnTema(int idTema) {
		return jsonLibros(temas.listaLibros(idTema));
	}
	
	@Override
	public String listaLibros() {
		return jsonLibros(libros.lista());
	}
	
	@Override
	public String buscarLibro(int isbn) {
		return jsonLibro(libros.buscar(isbn));
	}
	
	@Transactional
	@Override
	public boolean realizarVentasEHistorico(String cliente, String cesta) {	
		boolean r=false;
		Cliente cl=cliente(cliente);
		Cliente c=clientes.buscar(cl.getUsuario(), cl.getEmail());
		List<Libro> libros=listaLibros(cesta);
		if(c!=null&&libros!=null) {
			if(!libros.isEmpty()) {
				r=libros.stream().allMatch(l->l!=null);
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
	public String listaHistoricosDeUnCliente(int idCliente) {
		List<Historico> lista=null;
		if(clientes.listaHistoricos(idCliente)!=null) {
			lista=clientes.listaHistoricos(idCliente);
		}
		return jsonHistoricos(lista);
	}
	
	@Override
	public String listaVentasEntreFechas(Date ini, Date fin) {
		return jsonVentas(ventas.listaVentasEntreFechas(ini, fin));
	}
}
