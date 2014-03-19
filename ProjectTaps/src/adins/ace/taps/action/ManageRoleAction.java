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

import adins.ace.taps.form.manageRole.ManageRoleForm;
import adins.ace.taps.manager.ManageRoleManager;



public class ManageRoleAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ManageRoleForm erForm = (ManageRoleForm) form;
		ManageRoleManager erMan = new ManageRoleManager();
		
		//erForm.setListEmployeeRole(erMan.searchEmployeeRole());
		return mapping.findForward("ListEmployeeRole");
	}
}
