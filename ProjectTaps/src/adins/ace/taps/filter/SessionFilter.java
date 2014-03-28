package adins.ace.taps.filter;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adins.ace.taps.configuration.App;
import adins.ace.taps.module.GetUserDomainModule;

public class SessionFilter implements Filter {
	private FilterConfig filterConfig;

	public SessionFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		session.setAttribute("aDStatus", checkAD());
		if (session.getAttribute("username") != null) {
			resp.sendRedirect("/ProjectTaps/dashboard.do");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}
	
	public boolean checkAD(){
		boolean flag = true;
		String username = App.getConfiguration("ad_username");
		String password = App.getConfiguration("ad_password");
		String domainName = App.getConfiguration("domain_name");
		GetUserDomainModule domainAuth = new GetUserDomainModule();
		Hashtable<String, String> env = new Hashtable<String, String>();

		env = domainAuth.getDomainAuthentication(username, password,domainName);
		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
			if (!ctx.equals(null)) {
				flag = true;
			}
		} catch (NamingException ex) {
			System.out.println(ex.getCause());
			if(ex.getCause().toString().contains(App.getConfiguration("ad_ip"))){
				flag = false;
			}
		}
		return flag;
	}

}
