/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

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
		
		mForm.setListSpecialAppraisal(mMan.getAll());	
		
		if ("detail".equals(mForm.getTask())) {
			return mapping.findForward("Detail");
		}
		if("new".equals(mForm.getTask())){
			return mapping.findForward("New");
		}
		if("cancel".equals(mForm.getTask())){
			return mapping.findForward("ListSpecialAppraisal");
		}
		
		return mapping.findForward("ListSpecialAppraisal");
	}
}
