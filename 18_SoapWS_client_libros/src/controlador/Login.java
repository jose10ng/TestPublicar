package controlador;

import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Cliente;
import beans.Tema;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class Login extends Herramientas {

	@Autowired
	private ServiceLibros service;
	
	@RequestMapping("/login")
	public String login(@RequestParam("usuario")String usuario,
						@RequestParam("password")String password,
						HttpServletRequest request,
						HttpSession session) {
		try {
			String cc = service.buscarClient(usuario, encriptar(password));
			if(cc!=null) {
				try {
					Cliente c = service.buscarCliente(usuario, encriptar(password));
					List<Tema> temas = service.listaTemas();
					session.setAttribute("cliente", c);
					request.setAttribute("temas", temas);
					return "temas";
				} catch (RemoteException e) {
					e.printStackTrace();
					request.setAttribute("mensaje", "Error de comunicación con el servicio");			
					return "login";
				}
			}else {
				if(usuario.isEmpty()||password.isEmpty()) {
					request.setAttribute("mensaje", "Favor completar los datos de accesos");				
				}else {
					request.setAttribute("mensaje", "Datos de acceso incorrectos");
				}			
				return "login";
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "Error de comunicación con el servicio");			
			return "login";
		}
	}

}
