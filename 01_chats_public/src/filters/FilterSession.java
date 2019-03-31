package filters;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterSession
 */
/*@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		asyncSupported = true, 
		urlPatterns = { 
				"/FilterSession", 
				"/*"
		})*/
public class FilterSession implements Filter {

    /**
     * Default constructor. 
     */
    public FilterSession() {
    	System.out.println("Constructor del filtro");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
    	System.out.println("destroy del filtro");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter del filtro");
		/*HttpServletRequest hsr=(HttpServletRequest)request;
		HttpSession hs=hsr.getSession(false);
		if(hs==null) {
			System.out.println("hs es null");
		}else {
			System.out.println("hs NO es  null");
			System.out.println("Atributos "+hs.getAttribute("loginBean"));
		}*/
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //System.out.println("getRequestURI:"+req.getRequestURI()+"  getContextPath:"+req.getContextPath()+"  RESOURCE_IDENTIFIER:"+ResourceHandler.RESOURCE_IDENTIFIER);

        if (!req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            //res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            res.setDateHeader("Expires", 0); // Proxies.
            System.out.println("comienza con");
        }
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("init del filtro");
	}

}
