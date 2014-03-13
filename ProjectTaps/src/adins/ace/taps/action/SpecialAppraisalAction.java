/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.form.specialAppraisal.SpecialAppraisalForm;
import adins.ace.taps.manager.SpecialAppraisalManager;

public class SpecialAppraisalAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SpecialAppraisalForm mForm = (SpecialAppraisalForm) form;
		SpecialAppraisalManager mMan = new SpecialAppraisalManager();
		Map params = new HashMap();
		mForm.setListSpecialAppraisal(mMan.getAll());
		System.out.println("test");
		System.out.println(mForm.getTask());
		if (mForm.getPage() == null) {
			mForm.setPage(1);
		}

		if ("New".equals(mForm.getTask())) {
			return mapping.findForward("New");
		} else if ("Appraisal".equals(mForm.getTask())) {
			System.out.println("insert");
			mMan.Insert(mForm.getAppraisalBean());
			mForm.setListSpecialAppraisal(mMan.getAll());
			return mapping.findForward("ListSpecialAppraisal");
		} else if ("Cancel".equals(mForm.getTask())) {
			mForm.setListSpecialAppraisal(mMan.getAll());
			return mapping.findForward("ListSpecialAppraisal");
		} else if ("View".equals(mForm.getTask())) {
			System.out.println("Task View : " + mForm.getTask());
			System.out.println("Task Param : " + mForm.getParam());
			mForm.setAppraisalBean(mMan.getUserDomain(mForm.getParam()));
			return mapping.findForward("View");
		} else if ("Back".equals(mForm.getTask())) {
			mForm.setListSpecialAppraisal(mMan.getAll());
			return mapping.findForward("ListSpecialAppraisal");
		} else if ("first".equals(mForm.getTask())) {
			System.out.println("cek");
			mForm.setPage(1);
		} else if ("last".equals(mForm.getTask())) {
			mForm.setPage(mForm.getMaxpage());
		} else if ("prev".equals(mForm.getTask())) {
			if (mForm.getPage() > 1) {
				mForm.setPage(mForm.getPage() - 1);
			}
		} else if ("next".equals(mForm.getTask())) {
			if (mForm.getPage() < mForm.getMaxpage()) {
				mForm.setPage(mForm.getPage() + 1);
			}
		}

		if ("search".equals(mForm.getTask())) {
			mForm.setPage(1);
		}
		params.put("start", (mForm.getPage() - 1) * 10 + 1);
		params.put("end", (mForm.getPage() * 10));
		params.put("category", "employeeName");
		params.put("keyword", mForm.getSearchKeyword());

		mForm.setListSpecialAppraisal(mMan.searchSpecialAppraisal(params));
		mForm.setCountRecord(mMan.countSpecialAppraisal(params));

		if (mForm.getCountRecord() % 10 == 0) {
			mForm.setMaxpage((int) Math.ceil(mForm.getCountRecord() / 10));
		} else {
			mForm.setMaxpage(((int) Math.ceil(mForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListSpecialAppraisal");
	}
}
