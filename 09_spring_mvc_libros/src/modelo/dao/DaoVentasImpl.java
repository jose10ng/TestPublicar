package modelo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import entidades.Cliente;
import entidades.Libro;
import entidades.Venta;

@Repository("daoVentasImpl")
public class DaoVentasImpl implements DaoVentas {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;
	
	@Override
	public void alta(Cliente c, Libro l) {
		c.getLibros().add(l);
		em.merge(c);
	}
	
	@Override
	public Venta buscar(int idVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaVentasDeUnCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaVentasDeUnLibro(int idLibro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listaVentasEntreFechas(Date ini, Date fin) {
		String jpql="select v from Venta v where v.fecha between ?1 and ?2";
		TypedQuery<Venta> tq=em.createQuery(jpql, Venta.class);
		tq.setParameter(1, ini);
		tq.setParameter(2, fin);		
		return tq.getResultList();
	}

}
