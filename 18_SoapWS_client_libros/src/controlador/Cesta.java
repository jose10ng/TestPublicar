package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Cliente;
import beans.Libro;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class Cesta extends Herramientas {

	@Autowired
	private ServiceLibros service;

	/*private ServiceLibros service;
	{
		service=new ServiceLibrosImpl();
	}*/
		
	@GetMapping("/agregar")
	public void agregar(@RequestParam("isbn")String isbn,
						HttpSession session,
						HttpServletResponse response) throws IOException {		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		int idLibro=Integer.parseInt(isbn);
		Cliente c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			List<Libro> cesta=(List<Libro>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			if(cesta==null) {
				cesta=new ArrayList<>();
				try {
					cesta.add(service.buscarLibro(idLibro));
					session.setAttribute(c.getIdCliente()+c.getUsuario(), cesta);
					out.println(jsonLibros(cesta));
				} catch (RemoteException e) {
					JSONObject obj=new JSONObject();
					obj.put("com", "errorCom");
					out.println(JSONValue.toJSONString(obj));
					e.printStackTrace();
				}
			}else {
				try {
					cesta.add(service.buscarLibro(idLibro));
					out.println(jsonLibros(cesta));
				} catch (RemoteException e) {
					JSONObject obj=new JSONObject();
					obj.put("com", "errorCom");
					out.println(JSONValue.toJSONString(obj));
					e.printStackTrace();
				}			
			}
		}else {
			JSONObject obj=new JSONObject();
			obj.put("session", "caducada");
			out.println(JSONValue.toJSONString(obj));
		}		
	}
	
	@PostMapping("/eliminar")
	public void eliminar(@RequestParam("pos")String pos, HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();		
		int p=Integer.parseInt(pos);
		Cliente c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			List<Libro> cesta=(List<Libro>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			if(cesta!=null&&cesta.size()!=0) {
				cesta.remove(p);
			}		
			out.println(jsonLibros(cesta));
		}else {
			JSONObject obj=new JSONObject();
			obj.put("session", "caducada");
			out.println(JSONValue.toJSONString(obj));
		}
	}
	
	@GetMapping("/inicio")
	public void inicio(HttpSession session, HttpServletResponse response) throws IOException {
		Cliente c=(Cliente) session.getAttribute("cliente");
		List<Libro> cesta=(List<Libro>) session.getAttribute(c.getIdCliente()+c.getUsuario());
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		if(cesta!=null) {
			out.println(jsonLibros(cesta));
		}else {
			out.println(JSONValue.toJSONString(new JSONArray()));			
		}
	}

}
