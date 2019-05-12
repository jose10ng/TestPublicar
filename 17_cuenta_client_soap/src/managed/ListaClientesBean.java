package managed;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import servicios.ClienteDto;
import servicios.Servicio;
import servicios.ServicioWSBanca;

@ManagedBean(name="listaClientesBean")
public class ListaClientesBean {
	
	private List<ClienteDto> lista;
	private double saldo;
	private String mens;
	
	public List<ClienteDto> getLista() {
		return lista;
	}
	public void setLista(List<ClienteDto> lista) {
		this.lista = lista;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	
	public String getMens() {
		return mens;
	}
	public void setMens(String mens) {
		this.mens = mens;
	}
	public String listaGen() {
		Servicio serv=new Servicio();
		ServicioWSBanca service=serv.serv();
		try {
			ClienteDto[] clientes=service.clientesPorSaldo(saldo);
			if(clientes!=null&&clientes.length!=0) {
				lista=Arrays.asList(service.clientesPorSaldo(saldo));				
			}else {
				mens="No hay clientes para el saldo: "+saldo;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			mens="Fallo Conexión";
		}
		return "lista_clientes";
	}

}
