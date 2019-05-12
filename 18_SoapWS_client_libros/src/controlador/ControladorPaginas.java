package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorPaginas {
	
	@RequestMapping("/toLogin")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/toRegistro")
	public String registro() {
		return "registro";
	}
	
	@RequestMapping("/toAdmin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/toMenu")
	public String construction() {
		return "menu";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/doSalir")
	public String salir(HttpSession session) {
		/*Cliente c=(Cliente) session.getAttribute("cliente");
		session.removeAttribute(c.getIdCliente()+c.getUsuario()); Mejor invalido la sesión y así evito el nullPointer
		session.removeAttribute("cliente");*/
		session.invalidate();
		return "menu";
	}
	
	@RequestMapping("/doCambioDatosCliente")
	public String cambioDatosCliente() {
		return "adm/cambiarCliente";
	}
	
	@RequestMapping("/doVentas")
	public String ventasEntreFechas() {
		return "adm/ventasFechas";
	}
	
	@RequestMapping("/doHistoricos")
	public String historicosCliente() {
		return "adm/historicosCliente";
	}
	
	@RequestMapping("/toMenuAdmin")
	public String alMenuAdmin() {
		return "adm/menuAdmin";
	}

}
