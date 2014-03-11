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

import adins.ace.taps.form.organization.OrganizationForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.OrganizationManager;

public class OrganizationAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrganizationManager orgMan = new OrganizationManager();
		OrganizationForm orgForm = (OrganizationForm) form;
		PrintWriter out = response.getWriter();
		Map params = new HashMap();

		if (orgForm.getPage() == null) {
			orgForm.setPage(1);
		}

		if ("delete".equals(orgForm.getTask())) {
			// tolong di validasi tree dan employee, di validasi di manager atau
			// disini seterah
			orgForm.setPage(1);
			if (orgMan.deleteOrganization(orgForm.getOrganizationCode())) {
				orgForm.setMessage("Delete Organization Successfull!");
			} else {
				orgForm.setMessage("Delete Organization Failed!");
			}
		}

		if ("first".equals(orgForm.getTask())
				|| "first-ajax".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}

		if ("last".equals(orgForm.getTask())
				|| "last-ajax".equals(orgForm.getTask())) {
			orgForm.setPage(orgForm.getMaxpage());
		}

		if ("prev".equals(orgForm.getTask())
				|| "prev-ajax".equals(orgForm.getTask())) {
			if (orgForm.getPage() > 1) {
				orgForm.setPage(orgForm.getPage() - 1);
			}
		}
		if ("next".equals(orgForm.getTask())
				|| "next-ajax".equals(orgForm.getTask())) {
			if (orgForm.getPage() < orgForm.getMaxpage()) {
				orgForm.setPage(orgForm.getPage() + 1);
			}
		}

		if ("search".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}

		params.put("start", (orgForm.getPage() - 1) * 10 + 1);
		params.put("end", (orgForm.getPage() * 10));

		orgForm.setListOrganizations(orgMan.searchOrganizations(params));
		orgForm.setCountRecord(orgMan.countOrganizations(params));
		if (orgForm.getCountRecord() % 10 == 0) {
			orgForm.setMaxpage((int) Math.ceil(orgForm.getCountRecord() / 10));
		} else {
			orgForm.setMaxpage(((int) Math.ceil(orgForm.getCountRecord() / 10)) + 1);
		}

		if ("new".equals(orgForm.getTask())) {
			EmployeeManager empMan = new EmployeeManager();
			orgForm.setListEmployees(empMan.searchEmployees(params));
			return mapping.findForward("New");
		}
		if ("edit".equals(orgForm.getTask())) {
			return mapping.findForward("Edit");
		}
		if ("cancel".equals(orgForm.getTask())) {
			return mapping.findForward("ListEmployee");
		}

		if ("lookupsearch".equalsIgnoreCase(orgForm.getTask())
				|| "first-ajax".equalsIgnoreCase(orgForm.getTask())
				|| "prev-ajax".equalsIgnoreCase(orgForm.getTask())
				|| "next-ajax".equalsIgnoreCase(orgForm.getTask())
				|| "last-ajax".equalsIgnoreCase(orgForm.getTask())) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(orgForm);
			out.print(json);
			return null;
		}
		return mapping.findForward("ListOrganization");
	}
}
