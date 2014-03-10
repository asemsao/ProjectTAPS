/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.login.LoginForm;
import adins.ace.taps.module.LoginModule;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginForm tForm = (LoginForm) form;
		LoginModule loginAuth = new LoginModule();
		//HttpSession session = request.getSession(true);

		if ("login".equals(tForm.getTask())) {
			boolean pass = false;
			if (!"".equals(tForm.getUsername())
					&& !"".equals(tForm.getPassword())) {

				String username = tForm.getUsername();
				String password = tForm.getPassword();
				String domainName = "nu-ace.ad-ins.com";

				pass = loginAuth.getAuthenticationUser(username, password, domainName);

				tForm.setPassword("");
				tForm.setUsername("");
				if (pass) {
					/*
					 * SET SESSION
					 * session.setAttribute("username", username);
					 */
					
					return mapping.findForward("Dashboard");
				} else {
					return mapping.findForward("Dashboard");
					//return mapping.findForward("Welcome");
				}
			} else {
				return mapping.findForward("Welcome");
			}
		} else {
			return mapping.findForward("Welcome");
		}
	}
}