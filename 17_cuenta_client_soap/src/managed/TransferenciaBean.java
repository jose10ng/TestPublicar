package managed;

import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean(name="transferenciaBean")
public class TransferenciaBean {
		
	@ManagedProperty("#{loginBean}")
	private LoginBean lb;
	
	private int numCuentaDestino;
	private double cantidad;
	private String cuentaDestino;
	
	public LoginBean getLb() {
		return lb;
	}
	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	public int getNumCuentaDestino() {
		return numCuentaDestino;
	}
	public void setNumCuentaDestino(int numCuentaDestino) {
		this.numCuentaDestino = numCuentaDestino;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}	
	public String getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	public String transferir() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		boolean result=false;
		try {
			result=service.transferir(lb.getNumeroCuenta(), numCuentaDestino, cantidad);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(result) {
			return "menu?faces-redirect=true";
		}else {
			cuentaDestino="Esta cuenta no existe o No tiene suficiente saldo";
			return null;
		}
	}

}
