package escuchadores;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Escuchas
 *
 */
@WebListener
public class Escuchas implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Escuchas() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Sesi�n creada");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
        System.out.println("Sesi�n destruida XXXXXXXXXXXX");
    }
	
}
