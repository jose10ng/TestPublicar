package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import beans.Cliente;
import beans.Historico;
import beans.Libro;
import beans.Venta;
import mappers.Mapper;

public class Herramientas{

	protected String jsonLibros(List<Libro> cesta) {
		JSONArray libros=new JSONArray();
		cesta.forEach(ld->{
			JSONObject obj=new JSONObject();
			obj.put("titulo", ld.getTitulo());
			obj.put("autor", ld.getAutor());
			obj.put("precio", ld.getPrecio());
			obj.put("paginas", ld.getPaginas());
			obj.put("tema", ld.getTema().getTema());
			libros.add(obj);
		});
		return JSONValue.toJSONString(libros);
	}
	
	protected String encriptar(String password) {		
		return DigestUtils.sha256Hex(password);
	}
	
	protected String jsonHistoricos(List<Historico> historicos) {
		JSONArray hist=new JSONArray();
		historicos.forEach(h->{
			JSONObject obj=new JSONObject();
			obj.put("idHistorico", h.getIdHistorico());
			obj.put("cantidad", h.getCantidad());
			hist.add(obj);
		});
		return JSONValue.toJSONString(hist);
	}
	
	protected Cliente parsear(String usuario, String password, String email, String telefono) {
		Cliente c=new Cliente();
		if(!usuario.isEmpty()) {
			c.setUsuario(usuario);
		}
		if(!password.isEmpty()) {
			c.setPassword(encriptar(password));
		}
		if(!email.isEmpty()) {
			c.setEmail(email);
		}
		if(!telefono.isEmpty()) {
			c.setTelefono(Integer.parseInt(telefono));
		}
		return c;		
	}
	
	protected String mensajesError(String error, String mensaje) {
		JSONObject obj=new JSONObject();
		obj.put("error", error);
		obj.put("mensaje", mensaje);
		return JSONValue.toJSONString(obj);
	}
	
	protected boolean esAdecuado(String s) {
		boolean r=true;
		boolean r1=false;
		for(char c:s.toCharArray()) {
			r&=Character.isDigit(c);
		}
		if(r) {
			if(!s.isEmpty()&&s.length()<10) {
				r1=true;
			}
		}
		return r1;
	}
	
	protected Date obtenerFecha(String s) {
		Date fecha=null;
		try {
			fecha=new SimpleDateFormat("yyyy-MM-dd").parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("No se formateó la fecha");
		}
		return fecha;
	}
	
	protected String jsonVentas(List<Venta> vt) {
		JSONArray ventas=new JSONArray();
		vt.forEach(v->{
			JSONObject obj=new JSONObject();
			obj.put("id", v.getIdVEnta());
			obj.put("cliente", v.getIdCliente());
			obj.put("libro", v.getIdLibro());
			obj.put("fecha", v.getFecha().toString());
			ventas.add(obj);
		});
		return JSONValue.toJSONString(ventas);
	}
}
