package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;

@Repository("daoClientesImpl")
public class DaoClientesImpl implements DaoClientes {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;

	@Override
	public void alta(Cliente c) {
		em.persist(c);
	}

	@Override
	public void baja(int idCliente) {
		em.remove(em.find(Cliente.class, idCliente));
	}

	@Override
	public void modificar(int idCliente, Cliente nuevosDatos) {
		Cliente c=em.find(Cliente.class, idCliente);
		if(nuevosDatos.getEmail()!=null) {
			c.setEmail(nuevosDatos.getEmail());
		}
		if(nuevosDatos.getPassword()!=null) {
			c.setPassword(nuevosDatos.getPassword());
		}
		if(nuevosDatos.getTelefono()!=0) {
			c.setTelefono(nuevosDatos.getTelefono());
		}
		if(nuevosDatos.getUsuario()!=null) {
			c.setUsuario(nuevosDatos.getUsuario());
		}
		em.merge(c);
	}

	@Override
	public Cliente buscar(int idCliente) {
		return em.find(Cliente.class, idCliente);
	}
	
	@Override
	public Cliente buscar(String usuario, String email) {
		Cliente c=null;
		String jpql="select c from Cliente c where c.usuario=?1 and c.email=?2";
		TypedQuery<Cliente> tq=em.createQuery(jpql, Cliente.class);
		tq.setParameter(1, usuario);
		tq.setParameter(2, email);
		try {
			c=tq.getSingleResult();
		}catch(NoResultException ex) {
			System.out.println("No existe cliente con estas credenciales");
		}catch(NonUniqueResultException ex) {
			System.out.println("Hay varios clientes con estas credenciales");
		}
		return c;
	}

	@Override
	public Cliente buscarLogin(String usuario, String password) {
		Cliente c=null;
		String jpql="select c from Cliente c where c.usuario=?1 and c.password=?2";
		TypedQuery<Cliente> tq=em.createQuery(jpql, Cliente.class);
		tq.setParameter(1, usuario);
		tq.setParameter(2, password);
		try {
			c=tq.getSingleResult();
		}catch(NoResultException ex) {
			System.out.println("No existe cliente con estas credenciales");
		}catch(NonUniqueResultException ex) {
			System.out.println("Hay varios clientes con estas credenciales");
		}
		return c;
	}
	
	@Override
	public List<Cliente> lista() {
		TypedQuery<Cliente> tq=em.createNamedQuery("Cliente.findAll",Cliente.class);		
		return tq.getResultList();
	}

	@Override
	public List<Historico> listaHistoricos(int idCliente) {
		List<Historico> historicos=null;
		Cliente c=em.find(Cliente.class, idCliente);
		if(c!=null) {
			historicos=c.getHistoricos();
		}
		return historicos;
	}

	@Override
	public List<Libro> listaLibros(int idCliente) {
		Cliente c=em.find(Cliente.class, idCliente);
		return c.getLibros();
	}

}
