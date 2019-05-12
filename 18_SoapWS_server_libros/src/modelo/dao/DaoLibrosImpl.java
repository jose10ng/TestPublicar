package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import entidades.Cliente;
import entidades.Libro;
import entidades.Tema;

@Repository("daoLibrosImpl")
public class DaoLibrosImpl implements DaoLibros {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;

	@Override
	public boolean alta(Libro l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean baja(int isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(int isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Libro buscar(int isbn) {
		return em.find(Libro.class, isbn);
	}

	@Override
	public List<Libro> lista() {
		List<Libro> l=null;
		TypedQuery<Libro> tq=em.createNamedQuery("Libro.findAll", Libro.class);
		l=tq.getResultList();
		l.forEach(ll->System.out.println("Titulo: "+ll.getTitulo()));
		return l;
	}

	@Override
	public Tema temaDeUnLibro(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listaClientes(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
