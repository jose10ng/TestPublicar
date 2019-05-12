package modelo.dao;

import java.util.List;

import javax.ejb.Local;

import entidades.Movimiento;

@Local
public interface DaoMovimientosEjbLocal {

	void registrar(Movimiento m);

	List<Movimiento> lista(int idCuenta);

}
