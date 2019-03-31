package servidor;

import java.util.HashSet;

import javax.websocket.Session;

public class Sessiones {
	private static Sessiones obj;
	private static HashSet<Session> sessiones;
	
	private Sessiones() {
		sessiones=new HashSet<>();
	}
	
	static {
		obj=new Sessiones();
	}
	
	public static Sessiones getInstance() {
		return obj;
	}
	
	public void agregarSession(Session s) {
		sessiones.add(s);
	}
	
	public HashSet<Session> recuperarSessiones(){
		return sessiones;
	}
	
	public void eliminarSession(Session s) {
		sessiones.remove(s);
	}
}
