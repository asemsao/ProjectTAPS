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
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.form.assignment.SelfAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class SelfAssignmentAction extends Action {
	//this is action for self assignment from employees view
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SelfAssignmentForm sForm = (SelfAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		sForm.getSelfAssignBean().setTaskCode(taskCode);
		sForm.getSelfAssignBean().setCommentTo(sForm.getSelfAssignBean().getReportTo());
		sForm.getSelfAssignBean().setCreatedBy(sessionUserDomain);
		boolean comment = false;
		boolean update = false;
		if ("cancel".equals(sForm.getTask())) {
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}else if ("RFA".equals(sForm.getTask())) {
			//request for approval to supervisor, change status to RFA
			//update description or manhours if there's a change
			String tmpDescription="";
			String tmpManHours="";
			String tmpActivityType="";
			String tmpAdhocUserDomain="";
			tmpDescription = request.getParameter("tmpDescription");
			tmpManHours = request.getParameter("tmpManHours");
			tmpActivityType = request.getParameter("tmpActivityType");
			tmpAdhocUserDomain = request.getParameter("tmpAdhocDomain");
			if (sForm.getSelfAssignBean().getActivityType().equals("Routine") || sForm.getSelfAssignBean().getActivityType().equals("Initiative")){
				sForm.getSelfAssignBean().setAdhocUserDomain(null);
			}
			if (!tmpDescription.equals(sForm.getSelfAssignBean().getDescription())) {
				aMan.editDescriptionSelfAssignment(sForm.getSelfAssignBean());
			}
			if (!tmpManHours.equals(Double.toString(sForm.getSelfAssignBean().getManHours()))) {
				aMan.editManHourSelf(sForm.getSelfAssignBean());
			}
			if (!tmpActivityType.equals(sForm.getSelfAssignBean().getActivityType())) {
				aMan.editActivityType(sForm.getSelfAssignBean());
			}
			if (!tmpAdhocUserDomain.equals(sForm.getSelfAssignBean().getAdhocUserDomain())) {
				aMan.editAdhocUserDomain(sForm.getSelfAssignBean());
			}
			aMan.startTransaction();
			sForm.getSelfAssignBean().setCurrentStatus("RFA");
			comment = aMan.addHistorySelfComment(sForm.getSelfAssignBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			sForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));	
			if (comment && update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", sForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Self Assignment");
				params.put("phase", "RFA");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", sForm.getClaimBean().getSenderName());
				params.put("nameReceiver", sForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}
		

//		// Show record self assignment
		Map params = new HashMap();
		params.put("taskCode", taskCode);
		params.put("maxDate", App.getConfiguration("max_date"));
		sForm.setSelfAssignBean(aMan.searchRecordSelfAssignment(params));
		
		/*this session to check assignment type in self_correction.jsp*/
		session.setAttribute("type", sForm.getSelfAssignBean().getAssignmentType());
		
		/*this session to check activity type in self_correction.jsp*/
		session.setAttribute("adhoc", sForm.getSelfAssignBean().getActivityType());
		return mapping.findForward("Correction");
	}
}
