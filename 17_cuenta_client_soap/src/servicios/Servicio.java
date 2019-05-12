package servicios;

public class Servicio {
	
	public ServicioWSBanca serv() {
		ServicioWSBancaProxy pr=new ServicioWSBancaProxy();
		return pr.getServicioWSBanca();
	}	

}
