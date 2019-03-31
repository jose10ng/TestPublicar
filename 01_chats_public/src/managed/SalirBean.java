package managed;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="salirBean")
public class SalirBean {

	private ExternalContext ec;		
	private HttpSession hs;		
	private ServletContext sc;
	private Set<String> usuarios;
	private LoginBean lb;
	
	public ExternalContext getEc() {
		return ec;
	}

	public void setEc(ExternalContext ec) {
		this.ec = ec;
	}

	public HttpSession getHs() {
		return hs;
	}

	public void setHs(HttpSession hs) {
		this.hs = hs;
	}

	public ServletContext getSc() {
		return sc;
	}

	public void setSc(ServletContext sc) {
		this.sc = sc;
	}

	public Set<String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<String> usuarios) {
		this.usuarios = usuarios;
	}

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public String cerrarSession() {
		ec=FacesContext.getCurrentInstance().getExternalContext();
		sc=(ServletContext) ec.getContext();
		hs=(HttpSession)ec.getSession(false);
		lb=(LoginBean)hs.getAttribute("loginBean");
		if(sc.getAttribute("usuarios")!=null&&lb!=null) {
			usuarios=(Set<String>)sc.getAttribute("usuarios");
			usuarios.remove(lb.getUsuario());
		}
		if(hs!=null) {
			hs.removeAttribute("loginBean");
			return "inicio";
		}else {
			return null;			
		}
	}
}
