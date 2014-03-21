/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.form.manageRole.ManageRoleForm;
import adins.ace.taps.manager.ManageRoleManager;



public class ManageRoleAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ManageRoleForm erForm = (ManageRoleForm) form;
		ManageRoleManager erMan = new ManageRoleManager();
		erForm.setListRole(erMan.searchListRole());
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		if ("listMenu".equals(erForm.getTask())) {
			erForm.setListMenu(erMan.searchListMenu(erForm.getRoleId()));			
			String json = gson.toJson(erForm);
			PrintWriter out = response.getWriter();
			out.write(json);
			return null;
		}
		if ("retrieveSummary".equals(erForm.getTask())) {
			String json = gson.toJson(erForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}
		if ("updateRoleMenu".equals(erForm.getTask())) {
			 Map params = new HashMap();
			 params = gson.fromJson(request.getParameter("params"),HashMap.class);
			 params.put("roleId", params.get("roleId").toString());
			 erMan.deleteRoleMenu(params);
			 
			 String temp = "";
			 for (String item : (Iterable<String>) params.get("listMenu")) {
				 
				 params.put("menuId", item);
				 System.out.println(params.get("roleId"));
				 System.out.println(params.get("menuId"));
				 System.out.println("=====================");
				 erMan.insertRoleMenu(params);
			 }
			 params.put("listMenu", temp);
		}
		//erForm.setListEmployeeRole(erMan.searchEmployeeRole());
		return mapping.findForward("ListEmployeeRole");
	}
}
