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
import adins.ace.taps.manager.ProjectManager;

public class TransferProjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TransferProjectForm tpForm = (TransferProjectForm) form;
		ProjectManager pMan = new ProjectManager();
		Map params = new HashMap();

		if (tpForm.getPage() == null) {
			tpForm.setPage(1);
		}

		if ("first".equals(tpForm.getTask())) {
			tpForm.setPage(1);
		}

		if ("last".equals(tpForm.getTask())) {
			tpForm.setPage(tpForm.getMaxpage());
		}

		if ("prev".equals(tpForm.getTask())) {
			if (tpForm.getPage() > 1) {
				tpForm.setPage(tpForm.getPage() - 1);
			}
		}
		if ("next".equals(tpForm.getTask())) {
			if (tpForm.getPage() < tpForm.getMaxpage()) {
				tpForm.setPage(tpForm.getPage() + 1);
			}
		}

		if ("search".equals(tpForm.getTask())) {
			tpForm.setPage(1);
		}
		
		if ("cancel".equals(tpForm.getTask())) {

		}

		params.put("start", (tpForm.getPage() - 1) * 10 + 1);
		params.put("end", (tpForm.getPage() * 10));
		params.put("category", tpForm.getSearchCategory());
		params.put("keyword", tpForm.getSearchKeyword());

		tpForm.setListProject(pMan.searchProject(params));
		tpForm.setCountRecord(pMan.countProject(params));

		if (tpForm.getCountRecord() % 10 == 0) {
			tpForm.setMaxpage((int) Math.ceil(tpForm.getCountRecord() / 10));
		} else {
			tpForm.setMaxpage(((int) Math.ceil(tpForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListTransferProject");
	}
}
