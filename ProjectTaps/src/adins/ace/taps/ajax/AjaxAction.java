package adins.ace.taps.ajax;

import java.io.PrintWriter;
import java.util.ArrayList;
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
		if ("deleteEmployee".equals(ajaxForm.getMode())) {
			params.put("userDomain", ajaxForm.getUserDomain());
			ajaxForm.setHeadOrgStatus(empMan.checkEmplooyeeOrganization(params));
			ajaxForm.setSupervisorStatus(empMan.checkProjectStructure(params));
			ajaxForm.setCheckDeleteEmpoyee(ajaxForm.getHeadOrgStatus().size()+ajaxForm.getSupervisorStatus().size());
			ajaxForm.setListEmployeeReport(asgMan.employeeAssignmentList(params));
			ajaxForm.setCountRecord(asgMan.countEmployeeAssignmentList(params));
		}

		if ("ad".equals(ajaxForm.getMode())) {
			List<ActiveDirectoryBean> listAD = queAD.queryAD();
			List<ActiveDirectoryBean> listAD1 = new ArrayList<ActiveDirectoryBean>();
			List<ActiveDirectoryBean> listADShow = new ArrayList<ActiveDirectoryBean>();
			if ("employeeDomain".equals(ajaxForm.getSearchCategory())) {
				for (int i = 0; i < listAD.size(); i++) {
					System.out.println(ajaxForm.getSearchKeyword().toLowerCase());
					if (listAD.get(i).getUserDomain().toLowerCase().contains(ajaxForm.getSearchKeyword().toLowerCase())) {
						listAD1.add(listAD.get(i));
					}
				}
			} else if ("employeeName".equals(ajaxForm.getSearchCategory())) {
				for (int i = 0; i < listAD.size(); i++) {
					if (listAD.get(i).getFullName().toLowerCase().contains(ajaxForm.getSearchKeyword().toLowerCase())) {
						listAD1.add(listAD.get(i));
					}
				}
			} else {
				listAD1 = listAD;
			}
			if (Integer.parseInt(params.get("end").toString()) > listAD1.size()) {
				params.put("end", listAD1.size());
			}
			listADShow = listAD1.subList(
					Integer.parseInt(params.get("start").toString()) - 1,
					Integer.parseInt(params.get("end").toString()) - 1);
			ajaxForm.setListAD(listADShow);

			ajaxForm.setCountRecord(listAD1.size());
		}

		if ("employees".equals(ajaxForm.getMode())) {
			if(request.getParameter("headBu") != null){
				params.put("headBu", "headBu");
			}
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
		if ("newAssignments".equals(ajaxForm.getMode())) {
			params.put("assignmemtCategory", ajaxForm.getAssignmentCategory());
			params.put("assignmentType", ajaxForm.getAssignmentType());
			ajaxForm.setListEmployeeReport(asgMan.lookUpEmployee(params));
			ajaxForm.setCountRecord(asgMan.countLookUpEmployee(params));
		}
		if ("newSelfAssignments".equals(ajaxForm.getMode())) {
			// nanti dari user domain dari session
			params.put("userDomain", "domain3");
			params.put("assignmemtCategory", ajaxForm.getAssignmentCategory());
			params.put("assignmentType", ajaxForm.getAssignmentType());
			ajaxForm.setListEmployeeReport(asgMan.lookUpEmployee(params));
			ajaxForm.setCountRecord(asgMan.countLookUpEmployee(params));
		}
		if ("comments".equals(ajaxForm.getMode())) {
			params.put("taskCode", ajaxForm.getTaskCode());
			ajaxForm.setHistoryComment(asgMan.searchHistoryComment((params)));
			ajaxForm.setCountRecord(asgMan.countHistoryComment(params));
		}
		if ("projects".equals(ajaxForm.getMode())) {
			ajaxForm.setListProject(prjMan.searchProject(params));
			ajaxForm.setCountRecord(prjMan.countProject(params));
		}
		if (ajaxForm.getCountRecord() % 10 == 0) {
			ajaxForm.setMaxpage((int) Math.ceil(ajaxForm.getCountRecord() / 10));
		} else {
			ajaxForm.setMaxpage(((int) Math.ceil(ajaxForm.getCountRecord() / 10)) + 1);
		}
		
		if(ajaxForm.getMaxpage() == 0){
			ajaxForm.setMaxpage(1);
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
		if ("deleteEmployee".equals(ajaxForm.getTask())) {
			return mapping.findForward("deleteEmployee");
		}
		return null;
	}
}
