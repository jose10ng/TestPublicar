package managed;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class SalirBean {
	/*
	@ManagedProperty("#{loginBean}")
	LoginBean lb;

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	*/
	public String salida() {
		ExternalContext exc=FacesContext.getCurrentInstance().getExternalContext();
		
		//Map<String,Object> atr=exc.getSessionMap();
		//atr.forEach((n,s)->System.out.println("Nombre:"+n+"  Objeto:"+s));
		
		//LoginBean lb=(LoginBean) atr.get("loginBean");
		//System.out.println("numero cuenta********"+lb.getNumeroCuenta());
		if((HttpSession) exc.getSession(false)!=null) {
			HttpSession hs=(HttpSession) exc.getSession(false);
			//hs.removeAttribute("loginBean");			
			hs.invalidate();
		}
		
		
		//System.out.println("numero cuenta********"+lb.getNumeroCuenta());
		
		//exc.invalidateSession();
		return "inicio";
	}

}
