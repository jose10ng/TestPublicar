package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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

import dtos.LibroDto;
import entidades.Cliente;
import modelo.service.ServiceLibros;
import utilidades.Herramientas;

@Controller
public class Cesta extends Herramientas {
	
	@Autowired
	private ServiceLibros service;
	
	private Cliente c;
	private List<LibroDto> cesta;
	
	@GetMapping("/agregar")
	public void agregar(@RequestParam("isbn")String isbn, HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		int idLibro=Integer.parseInt(isbn);
		c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			cesta=(List<LibroDto>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			if(cesta==null) {
				cesta=new ArrayList<>();
				cesta.add(service.buscarLibroDto(idLibro));
			}else {
				cesta.add(service.buscarLibroDto(idLibro));			
			}
			session.setAttribute(c.getIdCliente()+c.getUsuario(), cesta);
			out.println(jsonLibroDtos(cesta));
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
		c=(Cliente) session.getAttribute("cliente");
		if(c!=null) {
			cesta=(List<LibroDto>) session.getAttribute(c.getIdCliente()+c.getUsuario());
			if(cesta!=null&&cesta.size()!=0) {
				cesta.remove(p);
			}
			session.setAttribute(c.getIdCliente()+c.getUsuario(), cesta);		
			out.println(jsonLibroDtos(cesta));
		}else {
			JSONObject obj=new JSONObject();
			obj.put("session", "caducada");
			out.println(JSONValue.toJSONString(obj));
		}
	}
	
	@GetMapping("/inicio")
	public void inicio(HttpSession session, HttpServletResponse response) throws IOException {
		c=(Cliente) session.getAttribute("cliente");
		cesta=(List<LibroDto>) session.getAttribute(c.getIdCliente()+c.getUsuario());
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		if(cesta!=null) {
			out.println(jsonLibroDtos(cesta));
		}else {
			out.println(JSONValue.toJSONString(new JSONArray()));			
		}
	}

}
