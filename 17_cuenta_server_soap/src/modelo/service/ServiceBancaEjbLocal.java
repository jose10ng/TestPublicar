package modelo.service;

import javax.ejb.Local;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;

@Local
public interface ServiceBancaEjbLocal {

	MovimientoDto[] listaMov(int idCuenta);

	CuentaDto buscarCuenta(int numeroCuenta);
	
	boolean transferir(int numCuentaOrigen, int numCuentaDestino, double cantidad);

	ClienteDto[] clientesPorSaldo(double saldo);

	void registrarMov(MovimientoDto mDto);

	boolean actualizarCuenta(MovimientoDto mDto);

}
