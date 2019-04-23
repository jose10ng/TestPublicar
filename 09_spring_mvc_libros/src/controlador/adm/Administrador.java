package controlador.adm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dtos.HistoricoDto;
import dtos.VentaDto;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class Administrador extends Herramientas {
	
	@Autowired
	private ServiceLibros service;

	@PostMapping("/cambiosCliente")
	public void cambioClient(@RequestParam("idCliente")String idCliente,
							 @RequestParam("usuario")String usuario,
							 @RequestParam("password")String password,
							 @RequestParam("email")String email,
							 @RequestParam("telefono")String telefono,							   
							 @RequestParam("pwdadmin")String pwdadmin,
							 HttpServletResponse response,
							 HttpSession session) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");
		if(admin.equals(encriptar(pwdadmin))) {
			if(esAdecuado(idCliente)&&esAdecuado(telefono)) {
				int id=Integer.parseInt(idCliente);
				if(service.modificarCliente(id, parsear(usuario, password, email, telefono))) {
					out.println("Modificación realizada con ÉXITO");
				}else {
					out.println("Id de Cliente incorrecto o ha habido un error");
				}
			}else {
				out.println("El Id de Cliente y Tel deben ser numéricos, no estar vacíos o no pasarse de rango");
			}
		}else {
			if(pwdadmin.isEmpty()) {
				out.println("Debe introducir el Password del Administrador");
			}else {
				out.println("Password del Administrador INCORRECTO");
			}			
		}
	}
	
	@PostMapping("/historicosCl")
	public void historicosClient(@RequestParam("idCliente")String idCliente,					   
							 	 @RequestParam("pwdadmin")String pwdadmin,
							 	 HttpServletResponse response,
							 	 HttpSession session) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");
		if(admin.equals(encriptar(pwdadmin))){			
			if(esAdecuado(idCliente)) {
				int id=Integer.parseInt(idCliente);
				List<HistoricoDto> historicos=service.listaHistoricoDtosDeUnCliente(id);
				if(historicos!=null) {
					out.println(jsonHistoricosDtos(historicos));
				}else {
					out.println(mensajesError("error", "Id de Cliente incorrecto o ha habido un error"));
				}
			}else {
				out.println(mensajesError("error", "El Id de Cliente debe ser numérico, no estar vacío o no pasarse de rango"));
			}
		}else {
			if(pwdadmin.isEmpty()) {
				out.println(mensajesError("error", "Debe introducir el Password del Administrador"));
			}else {
				out.println(mensajesError("error", "Password del Administrador INCORRECTO"));
			}			
		}
	}
	
	@PostMapping("/ventasFecha")
	public void ventasFecha(@RequestParam("ini")String ini,
							@RequestParam("fin")String fin,
							@RequestParam("pwdadmin")String pwdadmin,
							HttpServletResponse response,
							HttpSession session) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");		
		if(admin.equals(encriptar(pwdadmin))){	
			List<VentaDto> ventas=service.listaVentasDtosEntreFechas(obtenerFecha(ini), obtenerFecha(fin));
			if(ventas!=null) {
				out.println(jsonVentasDtos(ventas));
			}else {
				out.println(mensajesError("error", "Ha habido un error o no hay ventas en estas fechas"));
			}
		}else {
			if(pwdadmin.isEmpty()) {
				out.println(mensajesError("error", "Debe introducir el Password del Administrador"));
			}else {
				out.println(mensajesError("error", "Password del Administrador INCORRECTO"));
			}			
		}
	}	
}
