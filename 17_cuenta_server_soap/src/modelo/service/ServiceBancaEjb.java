package modelo.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import entidades.Cuenta;
import entidades.Movimiento;
import modelo.dao.DaoCuentasEjbLocal;
import modelo.dao.DaoMovimientosEjbLocal;
import utiliades.Herramientas;

/**
 * Session Bean implementation class ServiceBancaEjb
 */
@Stateless
@LocalBean
public class ServiceBancaEjb implements ServiceBancaEjbLocal {

    @EJB
    DaoCuentasEjbLocal cuentas;
    @EJB
    DaoMovimientosEjbLocal movi;
    
    @Override
	public MovimientoDto[] listaMov(int idCuenta){
    	return movi.lista(idCuenta).stream().map(m->Herramientas.obtenerDto(m)).toArray(mm->new MovimientoDto[mm]);
    }
    
    @Override
	public void registrarMov(MovimientoDto mDto) {
    	movi.registrar(Herramientas.obtenerEntidad(mDto));
    }
    
    @Override
	public CuentaDto buscarCuenta(int numeroCuenta) {
    	return Herramientas.obtenerDto(cuentas.buscar(numeroCuenta));
    }
    
    @Override
	public boolean actualizarCuenta(MovimientoDto mDto) {
    	boolean ok=false;
    	Cuenta c=cuentas.buscar(mDto.getCuentaDto().getNumeroCuenta());
    	if(mDto.getOperacion().equals("Ingreso")) {
    		c.setSaldo(c.getSaldo()+mDto.getCantidad());
        	cuentas.actualizar(c);
        	movi.registrar(Herramientas.obtenerEntidad(mDto));
        	ok=true;
    	}
    	else if(mDto.getOperacion().equals("Extracción")){
    		if(c.getSaldo()-mDto.getCantidad()>=0) {
    			c.setSaldo(c.getSaldo()-mDto.getCantidad());
    	    	cuentas.actualizar(c);
    	    	movi.registrar(Herramientas.obtenerEntidad(mDto));
    	    	ok=true;
    		}
    	}
    	return ok;
    }

	@Override
	public boolean transferir(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		boolean ok=false;
		if(cuentas.buscar(numCuentaDestino)!=null) {
			Cuenta cO=cuentas.buscar(numCuentaOrigen);
			Cuenta cD=cuentas.buscar(numCuentaDestino);
			if(cO.getSaldo()-cantidad>=0) {
				cO.setSaldo(cO.getSaldo()-cantidad);
				cuentas.actualizar(cO);
				Movimiento mO=new Movimiento(cantidad, new Date(), "Transferencia realizada a:", cO, String.valueOf(cD.getNumeroCuenta()));
				movi.registrar(mO);
				
				cD.setSaldo(cD.getSaldo()+cantidad);
				cuentas.actualizar(cD);
				Movimiento mD=new Movimiento(cantidad, new Date(), "Transferencia recibida por:", cD, String.valueOf(cO.getNumeroCuenta()));
				movi.registrar(mD);
				ok=true;
			}
		}
		return ok;		
	}
	
	@Override
	public ClienteDto[] clientesPorSaldo(double saldo){
		return cuentas.obtenerClientesPorSaldo(saldo).stream().map(c->Herramientas.obtenerDto(c)).toArray(nn->new ClienteDto[nn]);
	}
    
    

}
