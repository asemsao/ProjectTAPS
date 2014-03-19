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
import adins.ace.taps.form.assignment.ClaimAssignmentForm;
import adins.ace.taps.manager.AssignmentManager;
import adins.ace.taps.module.SendMailTls;

public class ClaimAssignmentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClaimAssignmentForm aForm = (ClaimAssignmentForm) form;
		AssignmentManager aMan = new AssignmentManager();
		HttpSession session = request.getSession(true);
		String taskCode = (String) session.getAttribute("taskCode");
		String sessionUserDomain = (String) session.getAttribute("username");
		aForm.getClaimBean().setTaskCode(taskCode);
		aForm.getClaimBean().setCommentTo("domain10");
		aForm.getClaimBean().setCreatedBy(sessionUserDomain);
		
		if("updateDetailClaim".equals(aForm.getTask())){
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
			aForm.getClaimBean().setStatus("CLAIM");
			if (!("".equals(aForm.getClaimBean().getComment()))) {
				aMan.addHistoryComment(aForm.getClaimBean());
			}
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		} else if ("RFA".equals(aForm.getTask())) {
			aForm.getClaimBean().setStatus("RFA");
			aMan.addHistoryComment(aForm.getClaimBean());
			Map paramStatus = new HashMap();
			paramStatus.put("status", "RFA");
			paramStatus.put("updatedBy", sessionUserDomain);
			paramStatus.put("taskCode", taskCode);
			paramStatus.put("flag", "INACTIVE");
			boolean success = aMan.updateStatus(paramStatus);
			/*sending notification on email*/
			aForm.setClaimBean(aMan.emailToSupervisorAssignment(paramStatus));			
			if (success) {
				SendMailTls.SendMail(aForm.getClaimBean().getEmailReceiver(), "Assignment", "RFA", taskCode, aForm.getClaimBean().getSenderName(), aForm.getClaimBean().getNameReceiver());
			}
			session.removeAttribute("taskCode");
			System.out.println(success);
			return mapping.findForward("Cancel");
		} else if ("cancel".equals(aForm.getTask())) {
			session.removeAttribute("taskCode");
			return mapping.findForward("Cancel");
		}

		aForm.setListDetailClaim(aMan.searchListDetailClaim(taskCode));
		aForm.setClaimBean(aMan.searchRecordClaimAssignment(taskCode));
		aForm.setTotalManhours(aMan.getTotalManHours(taskCode));
		return mapping.findForward("Claim");
	}
}
