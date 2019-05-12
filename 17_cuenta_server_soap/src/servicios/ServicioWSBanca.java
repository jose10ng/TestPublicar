package servicios;

import javax.ejb.EJB;
import javax.jws.WebService;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import modelo.service.ServiceBancaEjbLocal;

@WebService(serviceName="bancoWS")
public class ServicioWSBanca {
	
	@EJB
	ServiceBancaEjbLocal service;
	
	public MovimientoDto[] listaMov(int idCuenta) {
		return service.listaMov(idCuenta);
	}

	public CuentaDto buscarCuenta(int numeroCuenta) {
		return service.buscarCuenta(numeroCuenta);
	}
	
	public boolean transferir(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		return service.transferir(numCuentaOrigen, numCuentaDestino, cantidad);
	}

	public ClienteDto[] clientesPorSaldo(double saldo) {
		return service.clientesPorSaldo(saldo);
	}

	public void registrarMov(MovimientoDto mDto) {
		service.registrarMov(mDto);
	}

	public boolean actualizarCuenta(MovimientoDto mDto) {
		return service.actualizarCuenta(mDto);
	}
	

}
