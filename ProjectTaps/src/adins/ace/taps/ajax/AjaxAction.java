package adins.ace.taps.ajax;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.bean.module.ActiveDirectoryBean;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.ProjectManager;
import adins.ace.taps.module.QueryActiveDirectory;

public class AjaxAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();

		AjaxForm ajaxForm = (AjaxForm) form;

		EmployeeManager empMan = new EmployeeManager();
		OrganizationManager orgMan = new OrganizationManager();
		AssignmentManager asgMan = new AssignmentManager();
		ProjectManager prjMan = new ProjectManager();
		QueryActiveDirectory queAD = new QueryActiveDirectory();

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
		if ("employees2".equals(ajaxForm.getMode())) {
			ajaxForm.setListEmployees2(empMan.searchEmployees(params));
			ajaxForm.setCountRecord(empMan.countEmployees(params));
		}
		if ("employeesOnProject".equals(ajaxForm.getMode())) {
			if ("".equals(ajaxForm.getProjectCode())) {
				ajaxForm.setCountRecord(0);
			} else {
				params.put("project", ajaxForm.getProjectCode());
				ajaxForm.setListEmployeesOnProject(empMan
						.searchEmployeesOnProject(params));
				ajaxForm.setCountRecord(empMan.countEmployeesOnProject(params));
			}
		}
		if ("employeesOnOrganization".equals(ajaxForm.getMode())) {
			// nanti dari session
			ajaxForm.setOrganizationCode("CDD");
			params.put("organization", ajaxForm.getOrganizationCode());
			ajaxForm.setListEmployeesOnOrganization(empMan
					.searchEmployees(params));
			ajaxForm.setCountRecord(empMan.countEmployees(params));
		}
		if ("organizations".equals(ajaxForm.getMode())) {
			ajaxForm.setListOrganizations(orgMan.searchOrganizations(params));
			ajaxForm.setCountRecord(orgMan.countOrganizations(params));
		}
		if ("parentOrganizations".equals(ajaxForm.getMode())) {
			params.put("level", ajaxForm.getLevel() - 1);
			ajaxForm.setListOrganizations(orgMan
					.searchParentOrganizations(params));
			ajaxForm.setCountRecord(orgMan.countParentOrganizations(params));
		}
		if ("assignments".equals(ajaxForm.getMode())) {
			ajaxForm.setListEmployeeReport(asgMan
					.searchEmployeeReportEmployee(params));
			ajaxForm.setCountRecord(asgMan.countEmployeeReportEmployee(params));
		}
		if ("comments".equals(ajaxForm.getMode())) {
			ajaxForm.setHistoryComment(asgMan
					.searchHistoryComment((params)));
			ajaxForm.setCountRecord(asgMan.countEmployeeReportEmployee(params));
		}
		if ("projects".equals(ajaxForm.getMode())) {
			ajaxForm.setListProject(prjMan.searchProject(params));
			ajaxForm.setCountRecord(prjMan.countProject(params));
		}
		if ("ad".equals(ajaxForm.getMode())) {
			if (Integer.parseInt(params.get("end").toString()) > queAD
					.queryAD().size()) {
				params.put("end", queAD.queryAD().size());
			}

			List<ActiveDirectoryBean> listAD = queAD.queryAD().subList(
					Integer.parseInt(params.get("start").toString()) - 1,
					Integer.parseInt(params.get("end").toString()) - 1);
			ajaxForm.setListAD(listAD);
			ajaxForm.setCountRecord(queAD.queryAD().size());
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
		if ("employees2".equals(ajaxForm.getTask())) {
			return mapping.findForward("employees2");
		}
		if ("employeesOnOrganization".equals(ajaxForm.getTask())) {
			return mapping.findForward("employeesOnOrganization");
		}
		if ("employeesOnProject".equals(ajaxForm.getTask())) {
			return mapping.findForward("employeesOnProject");
		}
		if ("organizations".equals(ajaxForm.getTask())) {
			return mapping.findForward("organizations");
		}
		if ("parentOrganizations".equals(ajaxForm.getTask())) {
			return mapping.findForward("organizations");
		}
		if ("assignments".equals(ajaxForm.getTask())) {
			return mapping.findForward("assignments");
		}
		if ("projects".equals(ajaxForm.getTask())) {
			return mapping.findForward("projects");
		}
		if ("ad".equals(ajaxForm.getTask())) {
			return mapping.findForward("ad");
		}
		if ("comments".equals(ajaxForm.getTask())) {
			return mapping.findForward("comments");
		}
		return null;
	}
}
