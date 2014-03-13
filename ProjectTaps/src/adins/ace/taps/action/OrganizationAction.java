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

import adins.ace.taps.bean.organization.OrganizationBean;
import adins.ace.taps.form.organization.OrganizationForm;
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

		if ("new".equals(orgForm.getTask())) {
			return mapping.findForward("New");
		}
		if ("edit".equals(orgForm.getTask())) {
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.replaceAll("-", "")));
			return mapping.findForward("Edit");
		}
		if ("saveEdit".equals(orgForm.getTask())) {
			System.out.println("Save Edit");
			orgMan.submitEdit(orgForm.getOrgBean());

		}
		if ("cancel".equals(orgForm.getTask())) {
			return mapping.findForward("ListEmployee");
		}

		if ("delete".equals(orgForm.getTask())) {
			// tolong di validasi tree dan employee, di validasi di manager atau
			// disini seterah
			orgForm.setPage(1);
			System.out.println(" orgForm.getOrganizationCode() "+orgForm.getOrganizationCode().replaceAll("-", ""));
			if (orgMan.countMemberOrganizations(orgForm.getOrganizationCode().replaceAll("-", ""))==0)
			{
				if (orgMan.countChildOrganizations(orgForm.getOrganizationCode().replaceAll("-", ""))==0)
				{
					orgMan.deleteOrganization(orgForm.getOrganizationCode().replaceAll("-", ""));
					orgForm.setMessage("Delete Organization Successfull!");
				}
				else orgForm.setMessage("Delete Organization Failed! has child");
			}
			else orgForm.setMessage("Delete Organization Failed! has member");
		}
		if ("Save".equals(orgForm.getTask())) {
			System.out.println("insert");
			orgMan.submitInsert(orgForm.getOrgBean());
		}
		if ("first".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}

		if ("last".equals(orgForm.getTask())) {
			orgForm.setPage(orgForm.getMaxpage());
		}

		if ("prev".equals(orgForm.getTask())) {
			if (orgForm.getPage() > 1) {
				orgForm.setPage(orgForm.getPage() - 1);
			}
		}
		if ("next".equals(orgForm.getTask())) {
			if (orgForm.getPage() < orgForm.getMaxpage()) {
				orgForm.setPage(orgForm.getPage() + 1);
			}
		}

		if ("search".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}

		params.put("start", (orgForm.getPage() - 1) * 10 + 1);
		params.put("end", (orgForm.getPage() * 10));
		params.put("category", orgForm.getSearchCategory());
		params.put("keyword", orgForm.getSearchKeyword());

		orgForm.setListOrganizations(orgMan.searchOrganizations(params));
		orgForm.setCountRecord(orgMan.countOrganizations(params));

		if (orgForm.getCountRecord() % 10 == 0) {
			orgForm.setMaxpage((int) Math.ceil(orgForm.getCountRecord() / 10));
		} else {
			orgForm.setMaxpage(((int) Math.ceil(orgForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListOrganization");
	}
}
