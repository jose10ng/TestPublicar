package managed;

import javax.faces.bean.ManagedBean;

import modelo.dao.DaoUsuario;

@ManagedBean(name="registroBean")
public class RegistroBean {
	private String usuario;
	private String password;
	private String nombre;
	private int edad;
	private String ocupado;
	private String mensError;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getOcupado() {
		return ocupado;
	}
	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}
	public String getMensError() {
		return mensError;
	}
	public void setMensError(String mensError) {
		this.mensError = mensError;
	}
	
	public String registro() {
		DaoUsuario daouser=new DaoUsuario();
		if(daouser.altaUser(usuario, password, nombre, edad)) {
			return "inicio";
		}else {
			mensError="Usuario no válido";
			return null;
		}
	}
	
	public String comprobar() {
		DaoUsuario daouser=new DaoUsuario();
		ocupado=daouser.obtenerUser(usuario)!=null?"Ocupado":"Libre";
		System.out.println(ocupado);
		return ocupado;
	}
	
}
