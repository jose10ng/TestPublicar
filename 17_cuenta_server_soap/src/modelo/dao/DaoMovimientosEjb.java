package modelo.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entidades.Cuenta;
import entidades.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosEjb
 */
@Stateless
@LocalBean
public class DaoMovimientosEjb implements DaoMovimientosEjbLocal {
	
	@PersistenceContext(unitName="cajero_PU")
	EntityManager em;

    @Override
	public void registrar(Movimiento m) {
    	em.persist(m);
    }
    
    @Override
	public List<Movimiento> lista(int idCuenta){
    	Cuenta c=em.find(Cuenta.class, idCuenta);
    	em.refresh(c);
    	return c.getMovimientos();
    }

}
