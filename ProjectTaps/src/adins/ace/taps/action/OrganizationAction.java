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
		OrganizationManager orgMan = new OrganizationManager();
		OrganizationForm orgForm = (OrganizationForm) form;
		Map params = new HashMap();
		HttpSession session = request.getSession(true);
		orgForm.getOrgBean().setSessionUserDomain(
				(String) session.getAttribute("username"));

		if (orgForm.getPage() == null) {
			orgForm.setPage(1);
		}

		if ("new".equals(orgForm.getTask())) {
			return mapping.findForward("New");
		}
		if ("save".equals(orgForm.getTask())) {
			if ((orgMan.countRoleSPV(orgForm.getOrgBean().getHeadDomain()) == 0)) {
				if (orgMan.submitInsert(orgForm.getOrgBean())) {
					orgMan.insertRole(orgForm.getOrgBean());
					orgMan.insertRoleSPV(orgForm.getOrgBean());
					orgForm.setMessage("Insert Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Insert Business Unit Failed!");
					orgForm.setColor("red");
				}
			} else {
				if (orgMan.submitInsert(orgForm.getOrgBean())) {
					orgMan.insertRole(orgForm.getOrgBean());
					orgForm.setMessage("Insert Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Insert Business Unit Failed!");
					orgForm.setColor("red");
				}
			}

		}
		if ("edit".equals(orgForm.getTask())) {
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.trim()));
			orgForm.setHeadDomain(orgForm.getOrgBean().getHeadDomain());
			orgForm.setCountChild(orgMan.countChildOrganizations(orgForm
					.getOrganizationCode().trim()));
			orgMan.deleteRole(orgForm.getHeadDomain());
			return mapping.findForward("Edit");
		}
		if ("saveEdit".equals(orgForm.getTask())) {
			orgForm.setCountChild(orgMan.countChildOrganizations(orgForm
					.getOrgBean().getOrganizationCode()));
			if (orgForm.getCountChild() == 0) {
				if (orgMan.submitEdit(orgForm.getOrgBean())) {
					orgMan.insertRole(orgForm.getOrgBean());
					orgMan.updateReportAssignment(orgForm.getOrgBean());
					orgForm.setMessage("Edit Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Edit Business Unit Failed!");
					orgForm.setColor("red");
				}
			} else {
				if (orgMan.submitEditWithChild(orgForm.getOrgBean())) {
					orgMan.insertRole(orgForm.getOrgBean());
					orgMan.updateReportAssignment(orgForm.getOrgBean());
					orgForm.setMessage("Edit Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Edit Business Unit Failed!");
					orgForm.setColor("red");
				}
			}

		}
		if ("delete".equals(orgForm.getTask())) {
			orgForm.setPage(1);
			params.put("organization_code", orgForm.getOrganizationCode()
					.trim());
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.trim()));
			orgForm.setHeadDomain(orgForm.getOrgBean().getHeadDomain());
			if (orgMan.countDirectReportProject(orgForm.getHeadDomain()) == 0) {
				if (orgMan.deleteOrganization(orgForm.getOrganizationCode()
						.trim())) {
					orgMan.updateAssignment(orgForm.getOrgBean());
					orgMan.deleteRoleSPV(orgForm.getHeadDomain());
					orgMan.deleteRole(orgForm.getHeadDomain());
					orgForm.setMessage("Delete Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Delete Business Unit Failed!");
					orgForm.setColor("red");
				}

			} else {
				if (orgMan.deleteOrganization(orgForm.getOrganizationCode()
						.trim())) {
					orgMan.updateAssignment(orgForm.getOrgBean());
					orgMan.deleteRole(orgForm.getHeadDomain());
					orgMan.deleteOrganization(orgForm.getOrganizationCode()
							.trim());
					orgForm.setMessage("Delete Business Unit Successfull!");
					orgForm.setColor("green");
				} else {
					orgForm.setMessage("Delete Business Unit Failed!");
					orgForm.setColor("red");
				}
			}
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
		if ("back".equals(orgForm.getTask())) {
			orgForm.setPage(1);
		}
		params.put("start", (orgForm.getPage() - 1) * 10 + 1);
		params.put("end", (orgForm.getPage() * 10));
		params.put("category", orgForm.getSearchCategory());
		params.put("keyword", orgForm.getSearchKeyword());

		if ("structure".equals(orgForm.getTask())) {
			orgForm.setPage(1);

			orgForm.setMode("structure");
			orgForm.setSearchKeyword("");
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.trim()));
			params.put("organization_code", orgForm.getOrganizationCode()
					.trim());
			params.put("head_domain", orgForm.getOrgBean().getHeadDomain());
			orgForm.setListMemberOrganizations(orgMan
					.searchMemberOrganizations(params));
			orgForm.setCountRecord(orgMan.countMemberOrganizations(params));

			if (orgForm.getCountRecord() == 0) {
				orgForm.setMaxpage(1);
			} else if (orgForm.getCountRecord() % 10 == 0) {
				orgForm.setMaxpage((int) Math.ceil(orgForm.getCountRecord() / 10));
			} else {
				orgForm.setMaxpage(((int) Math.ceil(orgForm.getCountRecord() / 10)) + 1);
			}

			return mapping.findForward("Structure");
		}

		if ("structure".equals(orgForm.getMode())) {
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.trim()));
			params.put("organization_code", orgForm.getOrganizationCode()
					.trim());
			params.put("head_domain", orgForm.getOrgBean().getHeadDomain());
			orgForm.setListMemberOrganizations(orgMan
					.searchMemberOrganizations(params));
			orgForm.setCountRecord(orgMan.countMemberOrganizations(params));

			if (orgForm.getCountRecord() == 0) {
				orgForm.setMaxpage(1);
			} else if (orgForm.getCountRecord() % 10 == 0) {
				orgForm.setMaxpage((int) Math.ceil(orgForm.getCountRecord() / 10));
			} else {
				orgForm.setMaxpage(((int) Math.ceil(orgForm.getCountRecord() / 10)) + 1);
			}
			return mapping.findForward("Structure");
		}

		orgForm.setListOrganizations(orgMan.searchOrganizations(params));
		orgForm.setCountRecord(orgMan.countOrganizations(params));

		if (orgForm.getCountRecord() == 0) {
			orgForm.setMaxpage(1);
		} else if (orgForm.getCountRecord() % 10 == 0) {
			orgForm.setMaxpage((int) Math.ceil(orgForm.getCountRecord() / 10));
		} else {
			orgForm.setMaxpage(((int) Math.ceil(orgForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListOrganization");
	}
}
