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
			System.out.println("role : "+orgForm.getOrgBean().getHeadDomain());
			if ((orgMan.countRoleSPV(orgForm.getOrgBean().getHeadDomain()) == 0)) {
				orgMan.startTransaction();
				boolean submit = false;
				boolean roleHBU = false;
				boolean roleSPV = false;
				submit = orgMan.submitInsert(orgForm.getOrgBean());
				roleSPV = orgMan.insertRoleSPV(orgForm.getOrgBean());
				roleHBU = orgMan.insertRole(orgForm.getOrgBean());
				if (submit && roleHBU && roleSPV) {
					orgMan.commitTransaction();
					orgForm.setMessage("Insert Business Unit Successfull!");
					orgForm.setColor("green");

				} else {
					orgMan.rollback();
					orgForm.setMessage("Insert Business Unit Failed!");
					orgForm.setColor("red");
				}
			} else {
				orgMan.startTransaction();
				boolean submit = false;
				boolean roleHBU = false;
				submit = orgMan.submitInsert(orgForm.getOrgBean());
				roleHBU = orgMan.insertRole(orgForm.getOrgBean());
				if (submit && roleHBU) {
					orgMan.commitTransaction();
					orgForm.setMessage("Insert Business Unit Successfull!");
					orgForm.setColor("green");

				} else {
					orgMan.rollback();
					orgForm.setMessage("Insert Business Unit Failed!");
					orgForm.setColor("red");
				}
			}

		}
		if ("edit".equals(orgForm.getTask())) {
			orgForm.setOrgBean(orgMan.getOrgCode(orgForm.getOrganizationCode()
					.trim()));
			orgForm.setHeadDomainBefore(orgForm.getOrgBean().getHeadDomain());
			System.out.println(orgForm.getHeadDomainBefore()
					+ "head before noh");
			orgForm.setCountChild(orgMan.countChildOrganizations(orgForm
					.getOrganizationCode().trim()));
			return mapping.findForward("Edit");
		}
		if ("saveEdit".equals(orgForm.getTask())) {
			System.out.println("CHECK 1");
			orgForm.setCountChild(orgMan.countChildOrganizations(orgForm
					.getOrgBean().getOrganizationCode()));
			if (orgForm.getCountChild() == 0) {
				System.out.println("CHECK 2");
				boolean submit = false;
				boolean updateReportAssignment = false;
				orgMan.startTransaction();
				submit = orgMan.submitEdit(orgForm.getOrgBean());
				System.out.println(orgForm.getHeadDomainBefore()
						+ orgForm.getOrgBean().getHeadDomain());
				if (!orgForm.getHeadDomainBefore().equals(
						orgForm.getOrgBean().getHeadDomain())) {
					System.out.println("CHECK 3");
					boolean deleteHBU = false;
					boolean deleteSPV = false;
					// handleHBU lama
					deleteHBU = orgMan
							.deleteRole(orgForm.getHeadDomainBefore());
					System.out.println("deleteHBU");
					if (orgMan.countDirectReportProjectNoStart(orgForm
							.getHeadDomainBefore()) == 0) {
						System.out.println("deleteRoleSPV");
						deleteSPV = orgMan.deleteRoleSPV(orgForm
								.getHeadDomainBefore());
					} else {
						deleteSPV = true;
						System.out.println("deleteRoleSPV else");
					}
					// handleHBU baru
					boolean insertRoleNewHBU = false;
					boolean insertRoleSPV = false;
					insertRoleNewHBU = orgMan.insertRole(orgForm.getOrgBean());
					System.out.println("insertRoleNewHBU");
					System.out.println(orgMan.countRoleSPVNoStart(
							orgForm.getOrgBean().getHeadDomain()).toString());
					if (orgMan.countRoleSPVNoStart(
							orgForm.getOrgBean().getHeadDomain()).toString() == "0") {
						insertRoleSPV = orgMan.insertRoleSPV(orgForm
								.getOrgBean());
						System.out.println("insertRoleSPV");
					} else {
						insertRoleSPV = true;
						System.out.println("insertRoleSPV else");
					}
					updateReportAssignment = orgMan
							.updateReportAssignment(orgForm.getOrgBean());
					System.out.println("CHECK 4");

					System.out.println(submit && deleteHBU && deleteSPV
							&& insertRoleNewHBU && insertRoleSPV
							&& updateReportAssignment);
					if (submit && deleteHBU && deleteSPV && insertRoleNewHBU
							&& insertRoleSPV && updateReportAssignment) {
						orgMan.commitTransaction();
						orgForm.setMessage("Edit Business Unit Successfull!");
						orgForm.setColor("green");
					} else {
						orgMan.rollback();
						orgForm.setMessage("Edit Business Unit Failed!");
						orgForm.setColor("red");
					}
				} else {
					if (submit) {
						System.out.println("CHECK 5");
						orgMan.commitTransaction();
						orgForm.setMessage("Edit Business Unit Successfull!");
						orgForm.setColor("green");
					} else {
						System.out.println("CHECK 6");
						orgMan.rollback();
						orgForm.setMessage("Edit Business Unit Failed!");
						orgForm.setColor("red");
					}
				}
			} else {
				System.out.println("CHECK without");
				boolean submit = false;
				boolean updateReportAssignment = false;
				orgMan.startTransaction();
				submit = orgMan.submitEditWithChild(orgForm.getOrgBean());
				System.out.println(orgForm.getHeadDomainBefore()
						+ orgForm.getOrgBean().getHeadDomain());
				if (!orgForm.getHeadDomainBefore().equals(
						orgForm.getOrgBean().getHeadDomain())) {
					System.out.println("CHECK 3");
					boolean deleteHBU = false;
					boolean deleteSPV = false;
					// handleHBU lama
					deleteHBU = orgMan
							.deleteRole(orgForm.getHeadDomainBefore());
					System.out.println("deleteHBU");
					if (orgMan.countDirectReportProjectNoStart(orgForm
							.getHeadDomainBefore()) == 0) {
						System.out.println("deleteRoleSPV");
						deleteSPV = orgMan.deleteRoleSPV(orgForm
								.getHeadDomainBefore());
					} else {
						deleteSPV = true;
						System.out.println("deleteRoleSPV else");
					}
					// handleHBU baru
					boolean insertRoleNewHBU = false;
					boolean insertRoleSPV = false;
					insertRoleNewHBU = orgMan.insertRole(orgForm.getOrgBean());
					System.out.println("insertRoleNewHBU");
					System.out.println(orgMan.countRoleSPVNoStart(
							orgForm.getOrgBean().getHeadDomain()).toString());
					if (orgMan.countRoleSPVNoStart(
							orgForm.getOrgBean().getHeadDomain()).toString() == "0") {
						insertRoleSPV = orgMan.insertRoleSPV(orgForm
								.getOrgBean());
						System.out.println("insertRoleSPV");
					} else {
						insertRoleSPV = true;
						System.out.println("insertRoleSPV else");
					}
					updateReportAssignment = orgMan
							.updateReportAssignment(orgForm.getOrgBean());
					System.out.println("CHECK 4");

					System.out.println(submit && deleteHBU && deleteSPV
							&& insertRoleNewHBU && insertRoleSPV
							&& updateReportAssignment);
					if (submit && deleteHBU && deleteSPV && insertRoleNewHBU
							&& insertRoleSPV && updateReportAssignment) {
						orgMan.commitTransaction();
						orgForm.setMessage("Edit Business Unit Successfull!");
						orgForm.setColor("green");
					} else {
						orgMan.rollback();
						orgForm.setMessage("Edit Business Unit Failed!");
						orgForm.setColor("red");
					}
				} else {
					if (submit) {
						System.out.println("CHECK 5");
						orgMan.commitTransaction();
						orgForm.setMessage("Edit Business Unit Successfull!");
						orgForm.setColor("green");
					} else {
						System.out.println("CHECK 6");
						orgMan.rollback();
						orgForm.setMessage("Edit Business Unit Failed!");
						orgForm.setColor("red");
					}
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
