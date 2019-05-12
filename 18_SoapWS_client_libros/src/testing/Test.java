package testing;

import java.rmi.RemoteException;

import servicios.ServicioLibros;
import servicios.ServicioLibrosProxy;

public class Test {

	public static void main(String[] args) {
		ServicioLibrosProxy pr=new ServicioLibrosProxy();
		ServicioLibros service=pr.getServicioLibros();
		
		try {
			System.out.println(service.listaLibros());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
