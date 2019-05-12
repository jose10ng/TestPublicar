package prueba;

import java.rmi.RemoteException;

import servicios.Servicio;
import servicios.ServicioWSBanca;

public class Test {

	public static void main(String[] args) {
		Servicio serv=new Servicio();
		ServicioWSBanca s=serv.serv();
		try {
			System.out.println(s.buscarCuenta(1000).getSaldo());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
