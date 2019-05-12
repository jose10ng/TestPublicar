package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cliente;
import entidades.Historico;

@Repository("daoHistoricosImpl")
public class DaoHistoricosImpl implements DaoHistoricos {
	
	@PersistenceContext(unitName="librosName")
	private EntityManager em;

	@Override
	public void alta(Historico h) {
		em.persist(h);
	}

	@Override
	public boolean baja(int idHistorico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Historico buscar(int idHistorico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historico> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente clienteDeUnHistorico(int idHistorico) {
		// TODO Auto-generated method stub
		return null;
	}

}
