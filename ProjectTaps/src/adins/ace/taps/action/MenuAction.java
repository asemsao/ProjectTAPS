/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.form.menu.MenuForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.manager.DashboardManager;
import adins.ace.taps.module.ExtractPhoto;

public class MenuAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MenuForm mForm = (MenuForm) form;
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("link") != null){
			session.removeAttribute("link");
		}
		
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
			session.setAttribute("link", "assignment");
			return mapping.findForward("Assignment");
		}
		
		if("employeeReportSupervisor".equals(mForm.getTask())){
			session.setAttribute("link", "employeeReportSupervisor");
			return mapping.findForward("EmployeeReportSupervisor");
		}
		
		if("employeeReport".equals(mForm.getTask())){
			session.setAttribute("link", "employeeReport");
			return mapping.findForward("EmployeeReport");
		}
		
		if ("appraisal".equals(mForm.getTask())) {
			return mapping.findForward("Appraisal");
		}
		
		if ("transferProject".equals(mForm.getTask())) {
			return mapping.findForward("TransferProject");
		}
		
		if ("manageRole".equals(mForm.getTask())) {
			return mapping.findForward("ManageRole");
		}
		
		if ("logout".equals(mForm.getTask())) {
			session.invalidate();
			return mapping.findForward("Welcome");
		}
		
		return mapping.findForward("Dashboard");
	}
	
}
