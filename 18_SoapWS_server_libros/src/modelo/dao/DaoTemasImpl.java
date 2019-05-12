package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import entidades.Libro;
import entidades.Tema;

@Repository("daoTemasImpl")
public class DaoTemasImpl implements DaoTemas {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;

	@Override
	public boolean alta(Tema t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean baja(int idTema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(int idTema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tema buscar(int idTema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tema> lista() {
		TypedQuery<Tema> tq=em.createNamedQuery("Tema.findAll", Tema.class);
		return tq.getResultList();
	}

	@Override
	public List<Libro> listaLibros(int idTema) {		
		return em.find(Tema.class, idTema).getLibros();
	}

}
