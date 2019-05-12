package mappers;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/*
import dtos.ClienteDto;
import dtos.HistoricoDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;*/
import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;

public class Mapper {

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
	
	protected String jsonHistoricos(List<Historico> historicos) {
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
	}
	
	protected String jsonVentas(List<Venta> ventasL) {
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
	}
	
	protected String jsonTemas(List<Tema> t) {
		JSONArray temas=new JSONArray();
		t.forEach(tm->{
			JSONObject obj=new JSONObject();
			obj.put("idTema", tm.getIdTema());
			obj.put("tema", tm.getTema());
			temas.add(obj);
		});
		return JSONValue.toJSONString(temas);
	}
	
	protected String jsonClientes(List<Cliente> c) {
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
	}
	
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
		if(obj.get("email")!=null) {
			c.setEmail(obj.get("email").toString());
		}
		if(obj.get("telefono")!=null) {
			c.setTelefono(Integer.parseInt(obj.get("telefono").toString()));
		}
		if(obj.get("usuario")!=null) {
			c.setUsuario(obj.get("usuario").toString());
		}
		if(obj.get("pass")!=null) {
			c.setPassword(obj.get("pass").toString());
		}		
		c.setIdCliente(Integer.parseInt(obj.get("idCliente").toString()));		
		return c;
	}
	
	protected String jsonLibro(Libro l) {
		JSONObject obj=new JSONObject();
		obj.put("isbn", l.getIsbn());
		obj.put("titulo", l.getTitulo());
		obj.put("autor", l.getAutor());
		obj.put("precio", l.getPrecio());
		obj.put("paginas", l.getPaginas());
		obj.put("tema", l.getTema().getTema());
		return JSONValue.toJSONString(obj);
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
}
