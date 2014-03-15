/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.employeeRole.EmployeeRoleBean;
import adins.ace.taps.form.employeeRole.EmployeeRoleForm;
import adins.ace.taps.manager.EmployeeRoleManager;

public class EmployeeRoleAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeRoleForm erForm = (EmployeeRoleForm) form;
		EmployeeRoleManager erMan = new EmployeeRoleManager();
		
		Map params = new HashMap();
		
		if ("detailRole".equals(erForm.getTask())) {
			System.out.println(erForm.getParam()+"param");
			params.put("userDomain", erForm.getParam());
			erForm.setErBean(erMan.detailEmployeeRole(params));
			System.out.println(erForm.getErBean().getEmployeeName());
			return mapping.findForward("DetailEmployeeRole");
		}
		erForm.setListEmployeeRole(erMan.searchEmployeeRole());
		return mapping.findForward("ListEmployeeRole");
	}
}
