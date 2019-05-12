package controlador;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class LoginAdmin extends Herramientas {

	@Autowired
	private ServiceLibros service;

	@RequestMapping("/loginAdmin")
	public String login(@RequestParam("usuario")String usuario,
						@RequestParam("password")String password,
						HttpServletRequest request,
						HttpSession session) {
		try {
			if(service.loginAdmin(usuario, encriptar(password))) {
				session.setAttribute("admin", encriptar(password));
				return "adm/menuAdmin";
			}else {
				if(usuario.isEmpty()||password.isEmpty()) {
					request.setAttribute("mensaje", "Favor completar los datos de accesos");				
				}else {
					request.setAttribute("mensaje", "Datos de acceso incorrectos");
				}			
				return "admin";
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "Error de comunicación con el servicio");		
			return "admin";
		}
	}
}
