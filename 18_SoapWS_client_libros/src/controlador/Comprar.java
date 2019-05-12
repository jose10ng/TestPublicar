package controlador;

import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import beans.Cliente;
import beans.Libro;
import modelo.service.ServiceLibros;
import modelo.service.ServiceLibrosImpl;

@Controller
public class Comprar {

	@Autowired
	private ServiceLibros service;
	
	@PostMapping("/doComprar")
	public String comprar(HttpServletRequest request, HttpSession session) {
		Cliente c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			List<Libro> libros=(List<Libro>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			try {
				if(service.realizarVentasEHistorico(c, libros)) {
					request.setAttribute("mensaje", "Compra realizada con éxito.......Puede realizar otra compra usando o modificando esta cesta");
				}else {
					request.setAttribute("mensaje", "No se hizo la compra");				
				}
			} catch (RemoteException e) {
				request.setAttribute("mensaje", "Error de comunicación con el servicio");
				e.printStackTrace();
			}
			return "cesta";
		}else{
			return "error";
		}
	}
}
