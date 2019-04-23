package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import utilidades.Herramientas;

@Controller
public class LoginAdmin extends Herramientas {

	@RequestMapping("/loginAdmin")
	public String login(@RequestParam("usuario")String usuario,
						@RequestParam("password")String password,
						HttpServletRequest request,
						HttpSession session) {
		Properties datos=new Properties();
		/*datos.setProperty("usuario", usuario);
		datos.setProperty("password", encriptar(password));*/
		ServletContext context=session.getServletContext();
		String real=context.getRealPath(context.getInitParameter("admin"));
		try(InputStreamReader in=new InputStreamReader(new FileInputStream(real));) {
			datos.load(in);
			/*PrintStream out=new PrintStream("D:\\Projects\\09_spring_mvc_libros\\WebContent\\WEB-INF/datos.properties");
			PrintWriter out=new PrintWriter(new FileOutputStream(new File("D:\\Projects\\09_spring_mvc_libros\\WebContent\\WEB-INF/datos.properties")));
			datos.list(out);*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(datos.getProperty("usuario").equals(usuario)&&datos.getProperty("password").equals(encriptar(password))) {
			session.setAttribute("admin", encriptar(password));
			return "adm/menuAdmin";
		}else {
			if(usuario.isEmpty()||password.isEmpty()) {
				request.setAttribute("mensaje", "Favor completar los datos de accesos");				
			}else {
				request.setAttribute("mensaje", "Datos de acceso incorrectos");
			}			
			return "admin";
		}
	}
}
