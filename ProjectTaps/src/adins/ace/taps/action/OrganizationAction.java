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

import adins.ace.taps.form.organization.OrganizationForm;
import adins.ace.taps.manager.OrganizationManager;

public class OrganizationAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Organization");
		OrganizationManager orgMan = new OrganizationManager();
		OrganizationForm orgForm = (OrganizationForm) form;
		Map params = new HashMap();

		if (orgForm.getPage() == null) {
			orgForm.setPage(1);
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
