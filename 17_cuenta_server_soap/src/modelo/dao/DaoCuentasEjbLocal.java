package modelo.dao;

import java.util.List;

import javax.ejb.Local;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;

@Local
public interface DaoCuentasEjbLocal {

	Cuenta buscar(int numeroCuenta);

	void actualizar(Cuenta c);

	List<Cliente> obtenerClientesPorSaldo(double saldo);

	List<Cuenta> cuentasCliente(int dni);

}
