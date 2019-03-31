package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerUser implements HttpSessionListener, ServletContextListener  {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session Creada");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destruida");		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context ini");
	}
	
}
