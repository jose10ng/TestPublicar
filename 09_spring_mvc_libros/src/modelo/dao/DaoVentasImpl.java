package modelo.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import entidades.Venta;

@Repository("daoVentasImpl")
public class DaoVentasImpl implements DaoVentas {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;
	
	@Override
	public void alta(int idCliente, int isbn) {
		Venta v=new Venta();
		v.setIdCliente(idCliente);
		v.setIdLibro(isbn);
		v.setFecha(Date.from(Instant.now()));
		em.persist(v);
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
		String jpql="select v from Venta v where v.idCliente=?1";
		Query q=em.createQuery(jpql, Venta.class);
		q.setParameter(1, idCliente);
		return q.getResultList();
	}

	@Override
	public List<Venta> listaVentasDeUnLibro(int idLibro) {
		String jpql="select v from Venta v where v.idLibro=?1";
		Query q=em.createQuery(jpql, Venta.class);
		q.setParameter(1, idLibro);
		return q.getResultList();
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
