package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtos.LibroDto;
import modelo.service.ServiceLibros;

@Controller
public class LibrosYTemas {

	@Autowired
	private ServiceLibros service;

	@GetMapping("/libros")
	public String libros(@RequestParam("idTema")String idTema,
						 HttpServletRequest request) {
		List<LibroDto> libros=null;
		int numTema=Integer.parseInt(idTema);
		if(numTema==0) {
			libros=service.listaLibroDtos();
		}else {
			libros=service.listaLibroDtosDeUnTema(numTema);			
		}
		request.setAttribute("libros", libros);
		return "cesta";
	}
	
	@RequestMapping("/doTemas")
	public String temas(HttpServletRequest request) {
		request.setAttribute("temas", service.listaTemasDto());
		return "temas";
	}
}
