package managed;

import java.rmi.RemoteException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import servicios.MovimientoDto;
import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean
public class IngresosBean {
		
	@ManagedProperty("#{loginBean}")
	private LoginBean lb;	
	private double cantidad;
	
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
	
	public String ingresar() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		MovimientoDto m=null;
		try {
			m = new MovimientoDto(cantidad,new Date(),"Ingreso",service.buscarCuenta(lb.getNumeroCuenta()),"No es transferencia");
			service.actualizarCuenta(m);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "menu";
	}
	

}
