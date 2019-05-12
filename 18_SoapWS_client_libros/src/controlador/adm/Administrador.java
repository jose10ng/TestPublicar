package controlador.adm;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Historico;
import beans.Venta;
import modelo.service.ServiceLibros;
import modelo.service.ServiceLibrosImpl;
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
							 HttpSession session) throws IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");
		if(admin.equals(encriptar(pwdadmin))) {
			if(esAdecuado(idCliente)) {
				int id=Integer.parseInt(idCliente);
				try {
					if(service.modificarCliente(id, parsear(usuario, password, email, telefono))) {
						out.println("Modificación realizada con ÉXITO");
					}else {
						out.println("Id de Cliente incorrecto o ha habido un error");
					}
				} catch (RemoteException e) {
					out.println("Error de comunicación con el servicio");
					e.printStackTrace();
				}
			}else {
				out.println("El Id de Cliente debe ser numérico, no estar vacío o no pasarse de rango");
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
							 	 HttpSession session) throws IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");
		if(admin.equals(encriptar(pwdadmin))){			
			if(esAdecuado(idCliente)) {
				int id=Integer.parseInt(idCliente);
				try {
					List<Historico> historicos = service.listaHistoricosDeUnCliente(id);
					if(historicos!=null) {
						out.println(jsonHistoricos(historicos));
					}else {
						out.println(mensajesError("error", "Id de Cliente incorrecto o ha habido un error"));
					}
				} catch (RemoteException e) {
					out.println(mensajesError("error", "Error de comunicación con el servicio"));
					e.printStackTrace();
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
							HttpSession session) throws IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String admin=(String) session.getAttribute("admin");		
		if(admin.equals(encriptar(pwdadmin))){	
			try {
				List<Venta> ventas = service.listaVentasEntreFechas(obtenerFecha(ini), obtenerFecha(fin));
				if(ventas!=null) {
					out.println(jsonVentas(ventas));
				}else {
					out.println(mensajesError("error", "Ha habido un error o no hay ventas en estas fechas"));
				}
			} catch (RemoteException e) {
				out.println(mensajesError("error", "Error de comunicación con el servicio"));
				e.printStackTrace();
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
