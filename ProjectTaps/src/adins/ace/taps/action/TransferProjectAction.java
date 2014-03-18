package adins.ace.taps.action;

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

import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.form.project.TransferProjectForm;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.TransferProjectManager;

public class TransferProjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TransferProjectForm tpForm = (TransferProjectForm) form;
		TransferProjectManager tpMan = new TransferProjectManager();
		OrganizationManager oMan = new OrganizationManager();
		Map params = new HashMap();
		PrintWriter out = response.getWriter();
		
		if ("retrieve".equals(tpForm.getTask())) {
			tpForm.setpBean(tpMan.getProjectById(request.getParameter("projectCode").toString()));
			tpForm.setListMember(tpMan.getAllMemberByProjectId(request.getParameter("projectCode").toString()));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(tpForm);
			out.print(json);
			return null;
		}

		if (tpForm.getPageProject() == null) {
			tpForm.setPageProject(1);
		}

		if ("first".equals(tpForm.getTask())) {
			tpForm.setPageProject(1);
		}

		if ("last".equals(tpForm.getTask())) {
			tpForm.setPageProject(tpForm.getMaxPageProject());
		}

		if ("prev".equals(tpForm.getTask())) {
			if (tpForm.getPageProject() > 1) {
				tpForm.setPageProject(tpForm.getPageProject() - 1);
			}
		}
		if ("next".equals(tpForm.getTask())) {
			if (tpForm.getPageProject() < tpForm.getMaxPageProject()) {
				tpForm.setPageProject(tpForm.getPageProject() + 1);
			}
		}

		if ("search".equals(tpForm.getTask())) {
			tpForm.setPageProject(1);
		}
		
		if ("cancel".equals(tpForm.getTask())) {

		}

		params.put("start", (tpForm.getPageProject() - 1) * 10 + 1);
		params.put("end", (tpForm.getPageProject() * 10));
		params.put("category", tpForm.getSearchCategory());
		params.put("keyword", tpForm.getSearchKeyword());

		tpForm.setListProject(tpMan.searchProject(params));
		tpForm.setCountRecordProject(tpMan.countProject(params));
		
		tpForm.setListOrganization(tpMan.searchOrganization(params));
//		tpForm.setCountRecordOrganization(tpMan.countOrganization(params));
		

		if (tpForm.getCountRecordProject() % 10 == 0) {
			tpForm.setMaxPageProject((int) Math.ceil(tpForm.getCountRecordProject() / 10));
		} else {
			tpForm.setMaxPageProject(((int) Math.ceil(tpForm.getCountRecordProject() / 10)) + 1);
		}

		return mapping.findForward("ListTransferProject");
	}
}
