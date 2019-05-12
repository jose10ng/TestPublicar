package mappers;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import beans.Cliente;
import beans.Historico;
import beans.Libro;
import beans.Tema;
import beans.Venta;
import utilidades.Herramientas;

public class Mapper extends Herramientas{

	protected String jsonLibros(List<Libro> cesta) {
		JSONArray libros=new JSONArray();
		cesta.forEach(l->{
			JSONObject obj=new JSONObject();			
			obj.put("isbn", l.getIsbn());			
			obj.put("titulo", l.getTitulo());
			obj.put("autor", l.getAutor());
			obj.put("precio", l.getPrecio());
			obj.put("paginas", l.getPaginas());
			obj.put("tema", l.getTema().getTema());
			libros.add(obj);
		});
		return JSONValue.toJSONString(libros);
	}
	
	protected List<Libro> listaLibros(String cesta) {
		JSONArray li=(JSONArray) JSONValue.parse(cesta);
		List<Libro> libros=new ArrayList<>();
		li.forEach(l->{
			Libro ll=new Libro();
			JSONObject obj=(JSONObject) l;
			ll.setAutor(obj.get("autor").toString());
			ll.setIsbn(Integer.parseInt(obj.get("isbn").toString()));
			ll.setPaginas(Integer.parseInt(obj.get("paginas").toString()));
			ll.setPrecio(Double.parseDouble(obj.get("precio").toString()));
			ll.setTitulo(obj.get("titulo").toString());
			Tema t=new Tema();
			t.setTema(obj.get("tema").toString());
			ll.setTema(t);
			libros.add(ll);
		});
		return libros;
	}
	
	/*protected String jsonHistoricos(List<Historico> historicos) {
		JSONArray hist=new JSONArray();
		historicos.forEach(h->{
			JSONObject obj=new JSONObject();
			obj.put("idHistorico", h.getIdHistorico());
			obj.put("cantidad", h.getCantidad());
			obj.put("clienteIdCliente", h.getCliente().getIdCliente());
			obj.put("clienteUsuario", h.getCliente().getUsuario());
			hist.add(obj);
		});
		return JSONValue.toJSONString(hist);
	}*/
	
	protected List<Historico> historicos(String jsonHistoricos){
		JSONArray hi=(JSONArray) JSONValue.parse(jsonHistoricos);
		List<Historico> historicos=new ArrayList<>();
		hi.forEach(h->{
			Historico hh=new Historico();
			Cliente c=new Cliente();
			JSONObject obj=(JSONObject) h;
			hh.setIdHistorico(Integer.parseInt(obj.get("idHistorico").toString()));
			hh.setCantidad(Double.parseDouble(obj.get("cantidad").toString()));
			c.setIdCliente(Integer.parseInt(obj.get("clienteIdCliente").toString()));
			c.setUsuario(obj.get("clienteUsuario").toString());
			hh.setCliente(c);
			historicos.add(hh);
		});
		return historicos;
	}
	
	/*protected String jsonVentas(List<Venta> ventasL) {
		JSONArray ventas=new JSONArray();
		ventasL.forEach(v->{
			JSONObject obj=new JSONObject();
			obj.put("id", v.getIdVEnta());
			obj.put("cliente", v.getIdCliente());
			obj.put("libro", v.getIdLibro());
			obj.put("fecha", v.getFecha().toString());
			ventas.add(obj);
		});
		return JSONValue.toJSONString(ventas);
	}*/
	
	protected List<Venta> ventas(String jsonVentas){
		JSONArray ve=(JSONArray) JSONValue.parse(jsonVentas);
		List<Venta> ventas=new ArrayList<>();
		ve.forEach(v->{
			Venta vv=new Venta();
			JSONObject obj=(JSONObject) v;
			vv.setIdVEnta(Integer.parseInt(obj.get("id").toString()));
			vv.setIdCliente(Integer.parseInt(obj.get("cliente").toString()));
			vv.setIdLibro(Integer.parseInt(obj.get("libro").toString()));
			vv.setFecha(obtenerFecha(obj.get("fecha").toString()));
			ventas.add(vv);
		});
		return ventas;
	}
	
	/*protected String jsonTemas(List<Tema> t) {
		JSONArray temas=new JSONArray();
		t.forEach(tm->{
			JSONObject obj=new JSONObject();
			obj.put("idTema", tm.getIdTema());
			obj.put("tema", tm.getTema());
			temas.add(obj);
		});
		return JSONValue.toJSONString(temas);
	}*/
	
	protected List<Tema> temas(String jsonTemas){
		JSONArray te=(JSONArray) JSONValue.parse(jsonTemas);
		List<Tema> temas=new ArrayList<>();
		te.forEach(t->{
			Tema tt=new Tema();
			JSONObject obj=(JSONObject) t;
			tt.setIdTema(Integer.parseInt(obj.get("idTema").toString()));
			tt.setTema(obj.get("tema").toString());
			temas.add(tt);
		});
		return temas;
	}
	
	/*protected String jsonClientes(List<Cliente> c) {
		JSONArray clientes=new JSONArray();
		c.forEach(cl->{
			JSONObject obj=new JSONObject();
			obj.put("email", cl.getEmail());
			obj.put("idCliente", cl.getIdCliente());
			obj.put("telefono", cl.getTelefono());
			obj.put("usuario", cl.getUsuario());
			clientes.add(obj);
		});
		return JSONValue.toJSONString(clientes);
	}*/
	
	protected String jsonCliente(Cliente c) {
		JSONObject obj=new JSONObject();
		obj.put("email", c.getEmail());
		obj.put("idCliente", c.getIdCliente());
		obj.put("telefono", c.getTelefono());
		obj.put("usuario", c.getUsuario());
		obj.put("pass", c.getPassword());
		return JSONValue.toJSONString(obj);
	}
	
	protected Cliente cliente(String jsonCl) {
		JSONObject obj=(JSONObject)JSONValue.parse(jsonCl);
		Cliente c=new Cliente();
		c.setEmail(obj.get("email").toString());
		c.setIdCliente(Integer.parseInt(obj.get("idCliente").toString()));
		c.setTelefono(Integer.parseInt(obj.get("telefono").toString()));
		c.setUsuario(obj.get("usuario").toString());
		c.setPassword(obj.get("pass").toString());
		return c;
	}
	
	/*protected String jsonLibro(Libro l) {
		JSONObject obj=new JSONObject();
		obj.put("titulo", l.getTitulo());
		obj.put("autor", l.getAutor());
		obj.put("precio", l.getPrecio());
		obj.put("paginas", l.getPaginas());
		obj.put("tema", l.getTema().getTema());
		return JSONValue.toJSONString(obj);
	}*/
	
	protected Libro libro(String jsonLibro) {
		JSONObject obj=(JSONObject) JSONValue.parse(jsonLibro);
		Libro l=new Libro();
		l.setAutor(obj.get("autor").toString());
		l.setIsbn(Integer.parseInt(obj.get("isbn").toString()));
		l.setPaginas(Integer.parseInt(obj.get("paginas").toString()));
		l.setPrecio(Double.parseDouble(obj.get("precio").toString()));
		l.setTitulo(obj.get("titulo").toString());
		Tema t=new Tema();
		t.setTema(obj.get("tema").toString());
		l.setTema(t);
		return l;
	}
}
