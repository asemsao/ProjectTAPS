package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.employee.ChangePasswordForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.LoginManager;

public class ChangePasswordAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/* code to change password */
		ChangePasswordForm cpForm = (ChangePasswordForm) form;
		HttpSession session = request.getSession(true);
		if ("changePassword".equals(cpForm.getTask())
				&& session.getAttribute("username") != null) {
			LoginManager lMan = new LoginManager();
			EmployeeManager mMan = new EmployeeManager();
			Map user = new HashMap();
			user.put("username", session.getAttribute("username"));
			user.put("password", cpForm.getOldPassword());
			session.setAttribute("messagecolor", "red");
			if (lMan.tryLogin(user)) {
				if (cpForm.getNewPassword().equals(cpForm.getNewPasswordConfirmation())) {
					if (cpForm.getNewPassword().length() > 5) {
						user.put("password", cpForm.getNewPassword());
						if (mMan.updateLoginEmployee(user)) {
							session.setAttribute("messagecp", "Change Password SUCCESSFULL!");
							session.setAttribute("messagecolor", "green");
						} else {
							session.setAttribute("messagecp", "Change Password FAILED!");
						}
					} else {
						session.setAttribute("messagecp", "Password must be contain min. 6 characters");
					}

				} else {
					session.setAttribute("messagecp", "Change Password FAILED! Your Password is Doesn't Match");
				}
			} else {
				session.setAttribute("messagecp", "Change Password FAILED! Your Old Password is Incorrect!");
			}
			cpForm.setOldPassword("");
			cpForm.setNewPassword("");
			cpForm.setNewPasswordConfirmation("");
			return mapping.findForward("Dashboard");
		}
		return mapping.findForward(null);
	}
}
