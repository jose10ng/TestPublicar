package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtos.TemaDto;
import entidades.Cliente;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class Login extends Herramientas {
	
	@Autowired
	ServiceLibros service;
	
	@RequestMapping("/login")
	public String login(@RequestParam("usuario")String usuario,
						@RequestParam("password")String password,
						HttpServletRequest request,
						HttpSession session) {
		Cliente c=service.buscarCliente(usuario, encriptar(password));
		if(c!=null) {
			session.setAttribute("cliente", c);
			request.setAttribute("temas", service.listaTemasDto());
			return "temas";
		}else {
			if(usuario.isEmpty()||password.isEmpty()) {
				request.setAttribute("mensaje", "Favor completar los datos de accesos");				
			}else {
				request.setAttribute("mensaje", "Datos de acceso incorrectos");
			}			
			return "login";
		}
	}

}
