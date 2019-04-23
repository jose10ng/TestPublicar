package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entidades.Cliente;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class AltaCliente extends Herramientas{

	@Autowired
	private ServiceLibros service;
	
	@PostMapping("/altaCliente")
	public String altaCliente(@RequestParam("usuario")String usuario,
							  @RequestParam("password")String password,
							  @RequestParam("email")String email,
							  @RequestParam("telefono")int telefono,
							  HttpServletRequest request) {
		if(service.altaCliente(new Cliente(email, encriptar(password), telefono, usuario))) {
			request.setAttribute("registroOK", "Registro realizado con éxito, puede ya usted acceder");
			return "login";			
		}else {
			request.setAttribute("registroNOK", "El registro no se ha realizado, vuelva a intentarlo");
			return "registro";
		}
	}
	
	@RequestMapping("/comprobar")
	public void siExiste(@RequestParam("usuario")String usuario,
						 @RequestParam("email")String email,
						 HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(service.buscarClienteComprobar(usuario, email)==null) {
			out.println("Usuario disponible");
		}else {
			out.println("Usuario NO disponible");
		}
	}
}
