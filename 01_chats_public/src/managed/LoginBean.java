package managed;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import modelo.dao.DaoUsuario;

@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {
	private String usuario;
	private String password;
	private String mens;
	private Set<String> usuarios;
	private ExternalContext ec;
	private ServletContext sc;
	private DaoUsuario user;
	private int control;

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

	public String getMens() {
		return mens;
	}

	public void setMens(String mens) {
		this.mens = mens;
	}

	public int getControl() {
		return control;
	}

	public void setControl(int control) {
		this.control = control;
	}
	
	public Set<String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<String> usuarios) {
		this.usuarios = usuarios;
	}

	public ExternalContext getEc() {
		return ec;
	}

	public void setEc(ExternalContext ec) {
		this.ec = ec;
	}

	public ServletContext getSc() {
		return sc;
	}

	public void setSc(ServletContext sc) {
		this.sc = sc;
	}

	public DaoUsuario getUser() {
		return user;
	}

	public void setUser(DaoUsuario user) {
		this.user = user;
	}

	public boolean existe() {
		boolean existe = false;
		ec = FacesContext.getCurrentInstance().getExternalContext();
		sc = (ServletContext) ec.getContext();
		if (sc.getAttribute("usuarios") != null) {
			usuarios = (Set<String>) sc.getAttribute("usuarios");
		} else {
			usuarios = new HashSet<>();
			sc.setAttribute("usuarios", usuarios);
		}
		if (usuarios.size() >= 1) {
			existe = usuarios.stream().anyMatch(u -> usuario.equals(u));
		}
		usuarios.add(usuario);
		return existe;
	}

	public String login() {
		mens = null;
		user = new DaoUsuario();
		if (!existe()) {
			if (user.obtenerUser(usuario, password) != null) {
				return "chat";
			} else {
				mens = "Datos de acceso incorrectos";
				usuarios.remove(usuario);
				return null;
			}
		} else {
			control = 1;
			mens = "Usted ya está logeado en otro lado.";
			return null;
		}
	}

	public String loginSessionDuplicada() {
		mens = null;
		if (user.obtenerUser(usuario, password) != null) {
			return "chat";
		} else {
			mens = "Datos de acceso incorrectos";
			return null;
		}
	}
	
	/*public void login() {
		mens=null;
		DaoUsuario user=new DaoUsuario();
		if(user.obtenerUser(usuario, password)!=null) {
			user.obtenerUser(usuario,password).forEach((k,v)->System.out.println(k+"  "+v));
			ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
			try {
				ec.redirect(ec.getRequestContextPath()+"/chat.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			mens="Datos de acceso incorrectos";
		}
	}*/
}
