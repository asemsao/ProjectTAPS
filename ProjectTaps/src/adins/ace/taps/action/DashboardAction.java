package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.DashboardManager;

public class DashboardAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DashboardForm dForm = (DashboardForm) form;
		DashboardManager dMan = new DashboardManager();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("taskCode") != null) {
			session.removeAttribute("taskCode");
		}
		Map params = new HashMap();
		String userDomain = "domain3";
		
		if (dForm.getPage() == null) {
			dForm.setPage(1);
		}

		if ("first".equals(dForm.getTask())) {
			dForm.setPage(1);
		}

		else if ("last".equals(dForm.getTask())) {
			dForm.setPage(dForm.getMaxPage());
		}

		else if ("prev".equals(dForm.getTask())) {
			if (dForm.getPage() > 1) {
				dForm.setPage(dForm.getPage() - 1);
			}
		} else if ("next".equals(dForm.getTask())) {
			if (dForm.getPage() < dForm.getMaxPage()) {
				dForm.setPage(dForm.getPage() + 1);
			}
		}

		if ("approval".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", "DOMAIN205");
			dForm.setCountRecord(dMan.countListClaim(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListClaim(params));
			return mapping.findForward("ListAssignment");
		} else if ("claim".equals(dForm.getTask())) {
			params.put("start", (dForm.getPage() - 1) * 10 + 1);
			params.put("end", (dForm.getPage() * 10));
			params.put("category", dForm.getCategory());
			params.put("keyword", dForm.getKeyword());
			params.put("startDate", dForm.getStartDate());
			params.put("endDate", dForm.getEndDate());
			params.put("userDomain", userDomain);
			dForm.setCountRecord(dMan.countListClaim(params));
			if (dForm.getCountRecord() % 10 == 0) {
				dForm.setMaxPage((int) Math.ceil(dForm.getCountRecord() / 10));
			} else {
				dForm.setMaxPage(((int) Math.ceil(dForm.getCountRecord() / 10)) + 1);
			}
			dForm.setListAssignment(dMan.searchListClaim(params));
			return mapping.findForward("ListAssignment");
		} else if ("approvalSelf".equals(dForm.getTask())) {
			return mapping.findForward("ListAssignment");
		} else if ("correction".equals(dForm.getTask())) {
			return mapping.findForward("ListAssignment");
		} else if ("correctionSelf".equals(dForm.getTask())) {
			return mapping.findForward("ListAssignment");
		}

		dForm.setTotalClaim(dMan.searchTotalClaim(userDomain));
		dForm.setTotalRFA(dMan.searchTotalRFA(userDomain));
		dForm.setTotalRFAself(dMan.searchTotalRFASelf(userDomain));
		dForm.setTotalCorrection(dMan.searchTotalCorrection(userDomain));
		dForm.setTotalCorrectionSelf(dMan.searchTotalCorrectionSelf(userDomain));

		dForm.setListTopTen(dMan.searchTopTen());
		dForm.setListTopTenOrganization(dMan.searchTopTenOrganization("CDD"));
		return mapping.findForward("Dashboard");
	}
}
