package adins.ace.taps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.DashboardManager;

public class DashboardAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DashboardForm dForm = (DashboardForm) form;
		DashboardManager dMan = new DashboardManager();
		
		if("approval".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("claim".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("claimSelf".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("correction".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("correctionSelf".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} 
		return mapping.findForward(null);
	}
}
