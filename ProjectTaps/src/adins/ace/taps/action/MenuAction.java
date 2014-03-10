/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.menu.MenuForm;
import adins.ace.taps.manager.EmployeeManager;

public class MenuAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MenuForm mForm = (MenuForm) form;
		//HttpSession session = request.getSession(true);

		if ("dashboard".equals(mForm.getTask())) {
			return mapping.findForward("Dashboard");
		}
		
		if ("employee".equals(mForm.getTask())){
			return mapping.findForward("Employee");
		}
		
		if("organization".equals(mForm.getTask())){
			return mapping.findForward("Organization");
		}
		
		if ("project".equals(mForm.getTask())) {
			return mapping.findForward("Project");
		}
		
		if("report".equals(mForm.getTask())){
			return mapping.findForward("Report");
		}
		
		if("assignment".equals(mForm.getTask())){
			return mapping.findForward("Assignment");
		}
		
		if("employeeReportSupervisor".equals(mForm.getTask())){
			return mapping.findForward("employeeReportSupervisor");
		}
		
		if ("appraisal".equals(mForm.getTask())) {
			return mapping.findForward("Appraisal");
		}
		return mapping.findForward("Dashboard");
	}
}
