/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.employee.EmployeeForm;
import adins.ace.taps.form.report.ReportForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.ReportManager;

public class ReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		ReportForm mForm = (ReportForm) form;
		ReportManager rMan = new ReportManager();
		if ("view".equals(mForm.getTask())) {
			mForm.setListReports(rMan.getAllReports());
			return mapping.findForward("View");
		}
		if("new".equals(mForm.getTask())){
			return mapping.findForward("New");
		}
		if("cancel".equals(mForm.getTask())){
			return mapping.findForward("ListEmployee");
		}
		
		return mapping.findForward("Dashboard");
	}
}
