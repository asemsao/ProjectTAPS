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
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		if ("wizard".equals(erForm.getTask())) {
			erForm.setListRole(erMan.searchListRole());
			return mapping.findForward("WizardManageRole");
		}

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
		if ("insert".equals(erForm.getTask())) {
			String empName = erMan.getEmpName(erForm.getParam());
			if (erMan.insertRoleAdmin(erForm.getParam())) {
				erForm.setMessage(empName + " granted as administrator");
				erForm.setMessagecolor("green");
			} else {
				erForm.setMessage("Failed to grant " + empName
						+ " as administrator");
				erForm.setMessagecolor("red");
			}

			String json = gson.toJson(erForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}
		if ("delete".equals(erForm.getTask())) {
			String empName = erMan.getEmpName(erForm.getParam());
			if (erMan.deleteRoleAdmin(erForm.getParam())) {
				erForm.setMessage(empName + " revoked as administrator");
				erForm.setMessagecolor("green");
			} else {
				erForm.setMessage("Failed to revoke " + empName
						+ " as administrator");
				erForm.setMessagecolor("red");
			}
			String json = gson.toJson(erForm);
			PrintWriter out = response.getWriter();
			out.print(json);

			return null;
		}
		if ("updateRoleMenu".equals(erForm.getTask())) {
			Map params = new HashMap();
			params = gson.fromJson(request.getParameter("params"),
					HashMap.class);
			params.put("roleId", params.get("roleId").toString());
			String roleName = erMan
					.getRoleName(params.get("roleId").toString());
			if (erMan.deleteRoleMenu(params)) {
				String message = "";
				for (String item : (Iterable<String>) params.get("listMenu")) {
					params.put("menuId", item);
					String menuName = erMan.getMenuName(item);
					if (erMan.insertRoleMenu(params)) {
						message += menuName + " add to role " + roleName
								+ "<br />";
					} else {
						message += "Oops, there is something wrong to add"
								+ menuName + " to role " + roleName + "<br />";
					}

				}
				erForm.setMessage(message);
				erForm.setMessagecolor("green");
			} else {
				erForm.setMessage("Ooops, there is something wrong.");
				erForm.setMessagecolor("red");
			}
			String json = gson.toJson(erForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}

		Map params = new HashMap();
		
		//List Member Paging

		if (erForm.getPage() == null) {
			erForm.setPage(1);
		}

		if ("first".equals(erForm.getMode())) {
			erForm.setPage(1);
		}

		if ("last".equals(erForm.getMode())) {
			erForm.setPage(erForm.getMaxpage());
		}

		if ("prev".equals(erForm.getMode())) {
			if (erForm.getPage() > 1) {
				erForm.setPage(erForm.getPage() - 1);
			}
		}
		if ("next".equals(erForm.getMode())) {
			if (erForm.getPage() < erForm.getMaxpage()) {
				erForm.setPage(erForm.getPage() + 1);
			}
		}

		if ("search".equals(erForm.getMode())) {
			erForm.setPage(1);
		}
		
		//Employee Role Paging
		
		if (erForm.getPageER() == null) {
			erForm.setPageER(1);
		}

		if ("firstER".equals(erForm.getMode())) {
			erForm.setPageER(1);
		}

		if ("lastER".equals(erForm.getMode())) {
			erForm.setPageER(erForm.getMaxpageER());
		}

		if ("prevER".equals(erForm.getMode())) {
			if (erForm.getPageER() > 1) {
				erForm.setPageER(erForm.getPageER() - 1);
			}
		}
		if ("nextER".equals(erForm.getMode())) {
			if (erForm.getPageER() < erForm.getMaxpageER()) {
				erForm.setPageER(erForm.getPageER() + 1);
			}
		}

		if ("searchER".equals(erForm.getMode())) {
			erForm.setPageER(1);
		}
		
		params.put("startER", (erForm.getPageER() - 1) * 10 + 1);
		params.put("endER", (erForm.getPageER() * 10));
		params.put("searchCategoryER", erForm.getSearchCategoryER());
		params.put("searchKeywordER", erForm.getSearchKeywordER());

		erForm.setCountRecordER(erMan.countRecordER(params));

		if (erForm.getCountRecordER() % 10 == 0) {
			erForm.setMaxpageER((int) Math.ceil(erForm.getCountRecordER() / 10));
		} else {
			erForm.setMaxpageER(((int) Math.ceil(erForm.getCountRecordER() / 10)) + 1);
		}
		
		if ("listMember".equals(erForm.getTask())) {
			params.put("start", (erForm.getPage() - 1) * 10 + 1);
			params.put("end", (erForm.getPage() * 10));
			params.put("category", erForm.getSearchCategory());
			params.put("keyword", erForm.getSearchKeyword());

			params.put("roleId", erForm.getParam());
			erForm.setCountRecord(erMan.countMember(params));

			if (erForm.getCountRecord() % 10 == 0) {
				erForm.setMaxpage((int) Math.ceil(erForm.getCountRecord() / 10));
			} else {
				erForm.setMaxpage(((int) Math.ceil(erForm.getCountRecord() / 10)) + 1);
			}
			erForm.setRoleName(erMan.getRoleName(erForm.getParam()));
			erForm.setListMember(erMan.searchListMember(params));
			return mapping.findForward("ListMemberRole");
		}

		if ("home".equals(erForm.getTask())) {
			erForm.setListRole(erMan.searchListRole());
			erForm.setListEmployeeRole(erMan.searchListEmployeeRole(params));
			return mapping.findForward("ListRole");
		}
		
		erForm.setListRole(erMan.searchListRole());
		erForm.setListEmployeeRole(erMan.searchListEmployeeRole(params));
		return mapping.findForward("ListRole");
	}
}
