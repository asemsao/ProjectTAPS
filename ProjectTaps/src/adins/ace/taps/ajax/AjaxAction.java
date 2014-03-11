package adins.ace.taps.ajax;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.ProjectManager;

public class AjaxAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AjaxForm ajaxForm = (AjaxForm) form;

		EmployeeManager empMan = new EmployeeManager();
		OrganizationManager orgMan = new OrganizationManager();
		AssignmentManager asgMan = new AssignmentManager();
		ProjectManager prjMan = new ProjectManager();

		PrintWriter out = response.getWriter();
		Map params = new HashMap();

		if (ajaxForm.getPage() == null) {
			ajaxForm.setPage(1);
		}

		if ("first".equals(ajaxForm.getTask())) {
			ajaxForm.setPage(1);
		}

		if ("last".equals(ajaxForm.getTask())) {
			ajaxForm.setPage(ajaxForm.getMaxpage());
		}

		if ("prev".equals(ajaxForm.getTask())) {
			if (ajaxForm.getPage() > 1) {
				ajaxForm.setPage(ajaxForm.getPage() - 1);
			}
		}
		if ("next".equals(ajaxForm.getTask())) {
			if (ajaxForm.getPage() < ajaxForm.getMaxpage()) {
				ajaxForm.setPage(ajaxForm.getPage() + 1);
			}
		}
		if ("search".equals(ajaxForm.getTask())) {
			ajaxForm.setPage(1);
		}

		params.put("start", (ajaxForm.getPage() - 1) * 10 + 1);
		params.put("end", (ajaxForm.getPage() * 10));
		params.put("category", ajaxForm.getSearchCategory());
		params.put("keyword", ajaxForm.getSearchKeyword());

		if ("employees".equals(ajaxForm.getMode())) {
			ajaxForm.setListEmployees(empMan.searchEmployees(params));
			ajaxForm.setCountRecord(empMan.countEmployees(params));
		}
		if ("organizations".equals(ajaxForm.getMode())) {
			ajaxForm.setListOrganizations(orgMan.searchOrganizations(params));
			ajaxForm.setCountRecord(orgMan.countOrganizations(params));
		}
		if ("assignments".equals(ajaxForm.getMode())) {

		}
		if ("projects".equals(ajaxForm.getMode())) {

		}

		if (ajaxForm.getCountRecord() % 10 == 0) {
			ajaxForm.setMaxpage((int) Math.ceil(ajaxForm.getCountRecord() / 10));
		} else {
			ajaxForm.setMaxpage(((int) Math.ceil(ajaxForm.getCountRecord() / 10)) + 1);
		}

		if ("search".equalsIgnoreCase(ajaxForm.getTask())
				|| "first".equalsIgnoreCase(ajaxForm.getTask())
				|| "prev".equalsIgnoreCase(ajaxForm.getTask())
				|| "next".equalsIgnoreCase(ajaxForm.getTask())
				|| "last".equalsIgnoreCase(ajaxForm.getTask())) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(ajaxForm);
			out.print(json);
			return null;
		}

		if ("employees".equals(ajaxForm.getTask())) {
			return mapping.findForward("employees");
		}
		return null;
	}
}
