package modelo.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;

/**
 * Session Bean implementation class CuentasEjb
 */
@Stateless
@LocalBean
public class DaoCuentasEjb implements DaoCuentasEjbLocal {
	
	@PersistenceContext(unitName="cajero_PU")
	EntityManager em;

    @Override
	public List<Cuenta> cuentasCliente(int dni){
    	Cliente c=em.find(Cliente.class, dni);
    	return c.getCuentas();
    }
    
    @Override
	public List<Cliente> obtenerClientesPorSaldo(double saldo){
    	String jpql="select distinct(c) from Cliente c join c.cuentas b where b.saldo>?1";//distinct(c) para no traer clientes repetidos en la columna
    	TypedQuery<Cliente> tq=em.createQuery(jpql,Cliente.class);
    	tq.setParameter(1, saldo);
    	return tq.getResultList();
    }    
    
    @Override
	public Cuenta buscar(int numeroCuenta) {
    	return em.find(Cuenta.class, numeroCuenta);
    }
    
    @Override
	public void actualizar(Cuenta c) {
    	em.merge(c);
    }

}
