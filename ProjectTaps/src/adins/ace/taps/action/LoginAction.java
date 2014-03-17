/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.module.RoleBean;
import adins.ace.taps.form.login.LoginForm;
import adins.ace.taps.manager.LoginManager;
import adins.ace.taps.module.LoginModule;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginForm tForm = (LoginForm) form;
		LoginManager lMan = new LoginManager();
		LoginModule loginAuth = new LoginModule();
		HttpSession session = request.getSession(true);
		Map params = new HashMap();
		
		if ("login".equals(tForm.getTask())) {
			boolean pass = false;
			if (!"".equals(tForm.getUsername())
					&& !"".equals(tForm.getPassword())) {

				/*String username = tForm.getUsername();
				String password = tForm.getPassword();*/
				//Testing ntar dihapus
				String username = "kartiko.ew";
				String password = "K@rtik02014";
				////
				String domainName = "nu-ace.ad-ins.com";

				pass = loginAuth.getAuthenticationUser(username, password, domainName);

				///TESTING HAPUS NANTI
				pass = true;
				/////
				tForm.setPassword("");
				tForm.setUsername("");
				if (pass) {
					/*
					 * SET SESSION
					 * session.setAttribute("username", username);
					 */
					///TESTING HAPUS NANTI
					username = "domain100";
					/////
					params.put("userDomain", username);
					List<RoleBean> roleList = lMan.roleList(params);
					session.setAttribute("role", roleList);
					session.setAttribute("username", username);
					return mapping.findForward("Dashboard");
				} else {
					return mapping.findForward("Welcome");
				}
			} else {
				return mapping.findForward("Welcome");
			}
		} else {
			return mapping.findForward("Welcome");
		}
	}
}
