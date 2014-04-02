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

import com.crystaldecisions.proxy.remoteagent.af;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class ClaimAssignmentAction extends Action {
	//this is action for assignment from employees view
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		
		aForm.getClaimBean().setCommentTo(aForm.getClaimBean().getReportTo());
		aForm.getClaimBean().setCreatedBy(sessionUserDomain);
		boolean comment = false;
		boolean update = false;
		
		if("updateDetailClaim".equals(aForm.getTask())){
			aForm.getClaimBean().setTaskCode(taskCode);
			PrintWriter out = response.getWriter();
			ClaimAssignmentBean bean = new ClaimAssignmentBean();
			bean.setUpdatedBy(sessionUserDomain);
			bean.setManHours(Double.parseDouble(request.getParameter("manHour")));
			bean.setDetailId(Integer.parseInt(request.getParameter("detailId")));
			aMan.editDetailClaimAssignment(bean);
			aMan.getTotalManHours(taskCode);
			out.print("Success");
			return null;
		}
		
		if ("claim".equals(aForm.getTask())) {
			//edit claim + add comment
			aMan.startTransaction();
			aForm.getClaimBean().setStatus("CLAIM");
			if (!("".equals(aForm.getClaimBean().getComment()))) {
				comment = aMan.addHistoryComment(aForm.getClaimBean());
			}
			if (comment){
				aMan.commitTransaction();
			} else {
				aMan.rollback();
			}
//			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("RFA".equals(aForm.getTask())) {
			//request for approval to supervisor, change status to RFA
			aMan.startTransaction();
			aForm.getClaimBean().setStatus("RFA");
			comment = aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", aForm.getClaimBean().getTaskCode());
			paramStatus.put("flag", "INACTIVE");
			update = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));			
			if (comment && update) {
				aMan.commitTransaction();
				Map params = new HashMap();
				params.put("toMail", aForm.getClaimBean().getEmailReceiver());
				params.put("assignmentType", "Assignment");
				params.put("phase", "RFA");
				params.put("taskCode", taskCode);
				params.put("fromEmployee", aForm.getClaimBean().getSenderName());
				params.put("nameReceiver", aForm.getClaimBean().getNameReceiver());
				SendMailTls.SendMail(params);
			} else {
				aMan.rollback();
			}
//			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("cancel".equals(aForm.getTask())) {
//			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}
		
		// Show record assignment
		Map params = new HashMap();
		params.put("taskCode", taskCode);
		params.put("maxDate", App.getConfiguration("max_date"));
		
		aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
		aForm.setClaimBean(aMan.searchRecordClaimAssignment(params));
		aForm.setTotalManhours(aMan.getTotalManHours(taskCode));
		return mapping.findForward("Claim");
	}
}
