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
//		Map params = new HashMap();
		mForm.setListSpecialAppraisal(mMan.getAll());	
//		
		if("New".equals(mForm.getTask())){
			return mapping.findForward("New");
		}		
		if("View".equals(mForm.getTask())){
			mForm.setListSpecialAppraisal(mMan.ViewSpecialAppraisal(mForm.getParam()));
			return mapping.findForward("View");
		}
		if("Back".equals(mForm.getTask())){
			return mapping.findForward("ListSpecialAppraisal");
		}
//		if (mForm.getPage() == null) {
//			mForm.setPage(1);
//		}
//		if ("first".equals(mForm.getTask())) {
//			mForm.setPage(1);
//		}
//
//		if ("last".equals(mForm.getTask())) {
//			mForm.setPage(mForm.getMaxpage());
//		}
//
//		if ("prev".equals(mForm.getTask())) {
//			if (mForm.getPage() > 1) {
//				mForm.setPage(mForm.getPage() - 1);
//			}
//		}
//		if ("next".equals(mForm.getTask())) {
//			if (mForm.getPage() < mForm.getMaxpage()) {
//				mForm.setPage(mForm.getPage() + 1);
//			}
//		}
//		params.put("start", (mForm.getPage() - 1) * 10 + 1);
//		params.put("end", (mForm.getPage() * 10));
//		mForm.setListSpecialAppraisal(mMan.searchOrganizations(params));
//		mForm.setCountRecord(mMan.countSpecialAppraisal(params));
//		if (mForm.getCountRecord() % 10 == 0) {
//			mForm.setMaxpage((int) Math.ceil(mForm.getCountRecord() / 10));
//		} else {
//			mForm.setMaxpage(((int) Math.ceil(mForm.getCountRecord() / 10)) + 1);
//		}
		return mapping.findForward("ListSpecialAppraisal");
	}
}
