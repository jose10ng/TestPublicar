package managed;

import java.rmi.RemoteException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import servicios.CuentaDto;
import servicios.MovimientoDto;
import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean
public class ExtraerBean {
		
	@ManagedProperty("#{loginBean}")
	private LoginBean lb;	
	private double cantidad;
	private String pocoSaldo;
	
	public LoginBean getLb() {
		return lb;
	}
	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPocoSaldo() {
		return pocoSaldo;
	}
	public void setPocoSaldo(String pocoSaldo) {
		this.pocoSaldo = pocoSaldo;
	}
	public String extraer() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		CuentaDto cuenta=null;
		boolean result=false;
		try {
			cuenta = service.buscarCuenta(lb.getNumeroCuenta());
			MovimientoDto m=new MovimientoDto(cantidad,new Date(),"Extracción",cuenta,"No es transferencia");
			result=service.actualizarCuenta(m);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		if(result) {
			return "menu?faces-redirect=true";
		}else {
			pocoSaldo="No tiene suficiente saldo para esta cantidad";
			return null;
		}
	}

}
