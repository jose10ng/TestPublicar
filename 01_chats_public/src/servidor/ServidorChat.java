package servidor;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import utilities.Utilidades;

@ServerEndpoint("/chat")
public class ServidorChat {
	private Session s;
	private Sessiones single;

	@OnOpen
	public void open(Session s) {
		this.s=s;
		single=Sessiones.getInstance();
		single.agregarSession(s);
		System.out.println("Comunicación abierta******");
	}
	
	@OnMessage
	public void mensaje(String msg) {
		single.recuperarSessiones().forEach(o->{
			try {
				o.getBasicRemote().sendText(Utilidades.agregarAlJSON(msg, "date1", Utilidades.timeNow()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		/*single.recuperarSessiones().forEach(o->{//para no enviarlo a mi mismo
			if(o!=this.s) {
				try {
					o.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	@OnClose
	public void cierre(){
		single.eliminarSession(this.s);
		System.out.println("Comunicación cerrada******");
	}
	
	@OnError
	public void error(Throwable e) {
		System.out.println("Error de comunicación******");
	}

}
