package managed;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import servicios.CuentaDto;
import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
		
	private int numeroCuenta;
	private String existe;
	private CuentaDto cuenta;
	private boolean ajax;
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getExiste() {
		return existe;
	}
	public void setExiste(String existe) {
		this.existe = existe;
	}
	public CuentaDto getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaDto cuenta) {
		this.cuenta = cuenta;
	}
	public boolean isAjax() {
		return ajax;
	}
	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}
	public String verCuenta() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		ajax=false;
		cuenta=null;
		try {
			cuenta = service.buscarCuenta(numeroCuenta);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(cuenta!=null) {
			//ajax=true;
			existe=null;
			return "menu?faces-redirect=true";
		}else {
			return existe="Esta cuenta no existe";
		}
	}

}
