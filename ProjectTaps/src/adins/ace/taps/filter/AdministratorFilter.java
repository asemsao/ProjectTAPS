package adins.ace.taps.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import adins.ace.taps.bean.module.RoleBean;

public class AdministratorFilter implements Filter {
	private FilterConfig filterConfig;

	public AdministratorFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		List<RoleBean> roleList = (List) session.getAttribute("role");
		boolean is_admin = false;
		for (int i = 0; i < roleList.size(); i++) {
			if (roleList.get(i).getRoleId().equals("adm")) {
				is_admin = true;
				break;
			}
		}
		if (is_admin) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("/ProjectTaps/dashboard.do");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
