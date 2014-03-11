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
		EmployeeManager empMan = new EmployeeManager();

		OrganizationForm orgForm = (OrganizationForm) form;

		PrintWriter out = response.getWriter();
		Map params = new HashMap();
		Map paramsEmployee = new HashMap();

		if (orgForm.getPage() == null) {
			orgForm.setPage(1);
		}
		if (orgForm.getPageEmployee() == null) {
			orgForm.setPageEmployee(1);
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
				|| "first-lookup-organization".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}

		if ("last".equals(orgForm.getTask())
				|| "last-lookup-organization".equals(orgForm.getTask())) {
			orgForm.setPage(orgForm.getMaxpage());
		}

		if ("prev".equals(orgForm.getTask())
				|| "prev-lookup-organization".equals(orgForm.getTask())) {
			if (orgForm.getPage() > 1) {
				orgForm.setPage(orgForm.getPage() - 1);
			}
		}
		if ("next".equals(orgForm.getTask())
				|| "next-lookup-organization".equals(orgForm.getTask())) {
			if (orgForm.getPage() < orgForm.getMaxpage()) {
				orgForm.setPage(orgForm.getPage() + 1);
			}
		}

		if ("first-lookup-employee".equals(orgForm.getTask())) {
			orgForm.setPageEmployee(1);
		}

		if ("last-lookup-employee".equals(orgForm.getTask())) {
			orgForm.setPageEmployee(orgForm.getMaxpageEmployee());
		}

		if ("prev-lookup-employee".equals(orgForm.getTask())) {
			if (orgForm.getPageEmployee() > 1) {
				orgForm.setPageEmployee(orgForm.getPageEmployee() - 1);
			}
		}
		if ("next-lookup-employee".equals(orgForm.getTask())) {
			System.out.println("jancuk");
			System.out.println(orgForm.getPageEmployee());
			System.out.println(orgForm.getMaxpageEmployee());
			if (orgForm.getPageEmployee() < orgForm.getMaxpageEmployee()) {
				orgForm.setPageEmployee(orgForm.getPageEmployee() + 1);
				System.out.println("cek");
				System.out.println(orgForm.getPageEmployee());
			}
		}

		if ("search".equals(orgForm.getTask())
				|| "search-lookup-organization".equals(orgForm.getTask())
				|| "search-lookup-employee".equals(orgForm.getTask())) {
			orgForm.setPage(1);
			orgForm.setPageEmployee(1);
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

		paramsEmployee.put("start", (orgForm.getPageEmployee() - 1) * 10 + 1);
		paramsEmployee.put("end", (orgForm.getPageEmployee() * 10));
		paramsEmployee.put("category", orgForm.getSearchCategory());
		paramsEmployee.put("keyword", orgForm.getSearchKeyword());
		orgForm.setListEmployees(empMan.searchEmployees(paramsEmployee));
		orgForm.setCountRecordEmployee(empMan.countEmployees(paramsEmployee));
		if (orgForm.getCountRecordEmployee() % 10 == 0) {
			orgForm.setMaxpageEmployee((int) Math.ceil(orgForm
					.getCountRecordEmployee() / 10));
		} else {
			orgForm.setMaxpageEmployee(((int) Math.ceil(orgForm
					.getCountRecordEmployee() / 10)) + 1);
		}

		if ("new".equals(orgForm.getTask())) {
			return mapping.findForward("New");
		}
		if ("edit".equals(orgForm.getTask())) {
			System.out.println(orgForm.getOrganizationCode());
			return mapping.findForward("Edit");
		}
		if ("cancel".equals(orgForm.getTask())) {
			return mapping.findForward("ListEmployee");
		}

		// AJAX
		if ("search-lookup-organization".equalsIgnoreCase(orgForm.getTask())
				|| "first-lookup-organization".equalsIgnoreCase(orgForm
						.getTask())
				|| "prev-lookup-organization".equalsIgnoreCase(orgForm
						.getTask())
				|| "next-lookup-organization".equalsIgnoreCase(orgForm
						.getTask())
				|| "last-lookup-organization".equalsIgnoreCase(orgForm
						.getTask())
				|| "search-lookup-employee".equalsIgnoreCase(orgForm.getTask())
				|| "first-lookup-employee".equalsIgnoreCase(orgForm.getTask())
				|| "prev-lookup-employee".equalsIgnoreCase(orgForm.getTask())
				|| "next-lookup-employee".equalsIgnoreCase(orgForm.getTask())
				|| "last-lookup-employee".equalsIgnoreCase(orgForm.getTask())) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(orgForm);
			out.print(json);
			return null;
		}

		return mapping.findForward("ListOrganization");
	}
}
