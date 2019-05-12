package controlador;

import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Libro;
import beans.Tema;
import modelo.service.ServiceLibros;
import modelo.service.ServiceLibrosImpl;

@Controller
public class LibrosYTemas {

	@Autowired
	private ServiceLibros service;

	@GetMapping("/libros")
	public String libros(@RequestParam("idTema")String idTema,
						 HttpServletRequest request) {
		List<Libro> libros;
		int numTema=Integer.parseInt(idTema);
		if(numTema==0) {
			try {
				libros=service.listaLibros();
				request.setAttribute("libros", libros);
				return "cesta";
			} catch (RemoteException e) {
				e.printStackTrace();
				request.setAttribute("com", "Error de comunicación con el servicio");
				return "temas";
			}
		}else {
			try {
				libros=service.listaLibrosDeUnTema(numTema);
				request.setAttribute("libros", libros);
				return "cesta";
			} catch (RemoteException e) {
				e.printStackTrace();
				request.setAttribute("com", "Error de comunicación con el servicio");
				return "temas";
			}			
		}
	}
	
	@RequestMapping("/doTemas")
	public String temas(HttpServletRequest request) {
		try {
			List<Tema> temas = service.listaTemas();
			request.setAttribute("temas", temas);
			return "temas";
		} catch (RemoteException e) {
			e.printStackTrace();
			request.setAttribute("com", "Error de comunicación con el servicio");
			return "cesta";			
		}
	}
}
