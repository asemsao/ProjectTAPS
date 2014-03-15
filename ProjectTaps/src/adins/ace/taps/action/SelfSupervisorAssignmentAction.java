package adins.ace.taps.action;

import java.io.PrintWriter;
import java.util.HashMap;
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

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.form.assignment.SelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;

public class SelfSupervisorAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SelfAssignmentForm sForm = (SelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		sForm.getSelfAssignBean().setTaskCode(taskCode);
		sForm.getSelfAssignBean().setCommentTo("domain10");
		sForm.getSelfAssignBean().setCreatedBy("DOMAIN205");
		
//		aForm.getClaimBean().setTaskCode(taskCode);
//		aForm.getClaimBean().setCommentTo("domain10");
//		aForm.getClaimBean().setCreatedBy("DOMAIN205");
		
//		aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
//		aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
		
		sForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(taskCode));
		
		/*this session to check assignment type in self_correction.jsp*/
		session.setAttribute("type", sForm.getSelfAssignBean().getAssignmentType());
		
		/*this session to check activity type in self_correction.jsp*/
		session.setAttribute("adhoc", sForm.getSelfAssignBean().getActivityType());
		return mapping.findForward("Correction");
	}
}
