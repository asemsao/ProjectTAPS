package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.project.ProjectBean;
import adins.ace.taps.form.project.TransferProjectForm;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.ProjectManager;

public class TransferProjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TransferProjectForm tpForm = (TransferProjectForm) form;
		ProjectManager pMan = new ProjectManager();
		OrganizationManager oMan = new OrganizationManager();
		Map params = new HashMap();

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

		tpForm.setListProject(pMan.searchProject(params));
		tpForm.setCountRecordProject(pMan.countProject(params));
		
		tpForm.setListOrganization(oMan.searchOrganizations(params));
		tpForm.setCountRecordOrganization(oMan.countOrganizations(params));
		

		if (tpForm.getCountRecordProject() % 10 == 0) {
			tpForm.setMaxPageProject((int) Math.ceil(tpForm.getCountRecordProject() / 10));
		} else {
			tpForm.setMaxPageProject(((int) Math.ceil(tpForm.getCountRecordProject() / 10)) + 1);
		}

		return mapping.findForward("ListTransferProject");
	}
}
