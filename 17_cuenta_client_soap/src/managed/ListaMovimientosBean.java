package managed;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import servicios.MovimientoDto;
import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean
public class ListaMovimientosBean {
	
	@ManagedProperty("#{loginBean}")
	private LoginBean lb;
	private List<MovimientoDto> lista;
	private double saldo;
	
	public LoginBean getLb() {
		return lb;
	}
	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	public List<MovimientoDto> getLista() {
		return lista;
	}
	public void setLista(List<MovimientoDto> lista) {
		this.lista = lista;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String listaGen() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		try {
			saldo=service.buscarCuenta(lb.getNumeroCuenta()).getSaldo();
			lista=Arrays.asList(service.listaMov(lb.getNumeroCuenta()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "lista";
	}

}
