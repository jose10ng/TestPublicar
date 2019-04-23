package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import dtos.LibroDto;
import entidades.Cliente;
import modelo.service.ServiceLibros;

@Controller
public class Comprar {

	@Autowired
	private ServiceLibros service;
	
	@PostMapping("/doComprar")
	public String comprar(HttpServletRequest request, HttpSession session) {
		Cliente c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			List<LibroDto> libros=(List<LibroDto>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			if(service.realizarVentasEHistorico(c, libros)) {
				request.setAttribute("mensaje", "Compra realizada con éxito.......Puede realizar otra compra usando o modificando esta cesta");
			}else {
				request.setAttribute("mensaje", "No se hizo la compra");				
			}
			return "cesta";
		}else{
			return "error";
		}
	}
}
