/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.bean.module.OrganizationLevelBean;
import adins.ace.taps.bean.module.RoleBean;
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.login.LoginForm;
import adins.ace.taps.manager.DashboardManager;
import adins.ace.taps.manager.LoginManager;
import adins.ace.taps.module.ExtractPhoto;
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
		DashboardManager dMan = new DashboardManager();
		DashboardBean bean = new DashboardBean();
		
		if ("login".equals(tForm.getTask())) {
			boolean pass = false;
			if (!"".equals(tForm.getUsername())
					&& !"".equals(tForm.getPassword())) {

				String username = tForm.getUsername();
				String password = tForm.getPassword();
				String domainName = App.getConfiguration("domain_name");
				

				//MODE AUTO
				if ("auto".equals(App.getConfiguration("recovery_mode"))) {
					session.setAttribute("recoveryMode", "false");
					if(session.getAttribute("aDStatus").toString().equalsIgnoreCase("false")){
						session.setAttribute("recoveryMode", "true");
					}
				}
				else if ("true".equals(App.getConfiguration("recovery_mode"))) {
					session.setAttribute("recoveryMode", "true");
				}
				else{
					session.setAttribute("recoveryMode", "false");
				}
				pass = loginAuth.getAuthenticationUser(username, password,
						domainName,request);
				
				// jangan ubah2 action login lagi selain pass = true
				// pass = true;
				
				tForm.setPassword("");
				if (pass) {
					username = tForm.getUsername();
					List<RoleBean> roleList = lMan.roleList(username);
					List<OrganizationLevelBean> organizationLevel=lMan.GetOrganizationLevel(username);
					String fullname = lMan.getFullName(username);
					session.setAttribute("organizationCode",organizationLevel.get(0).getOrganizationCode());
					session.setAttribute("organizationLevel",organizationLevel.get(0).getOrganizationLevel());
					session.setAttribute("role", roleList);
					session.setAttribute("username", username);
					session.setAttribute("fullname", fullname);
					/* Star Achievement */
//					session.setAttribute("star", dMan.starAchievemet(username));
					session.setAttribute("greenStar", dMan.greenStar(username));
					session.setAttribute("redStar", dMan.redStar(username));
					/* set image for header */
					bean = dMan.getPhotoEmployees(username);
					try {
						response.setContentType("image/*");
						byte[] buffer = bean.getProfilePicture();
						if (buffer == null) {
							buffer = ExtractPhoto.extractBytes(getServlet()
									.getServletContext().getRealPath("/")
									+ "images/user.png");
						}

						BufferedImage image = ImageIO
								.read(new ByteArrayInputStream(buffer));
						File newFile = new File(getServlet()
								.getServletContext().getRealPath("/")
								+ "images/" + username + "_image.png");
						ImageIO.write(image, "png", newFile);
						session.setAttribute("pathPhoto", "images/" + username
								+ "_image.png");
					} catch (Exception e) {
						e.printStackTrace();
					}

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
