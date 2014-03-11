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

		if("New".equals(mForm.getTask())){
			return mapping.findForward("New");
		}
		else if("Appraisal".equals(mForm.getTask())){
			System.out.println("appraisal insert");
			mMan.Insert(mForm.getAppraisalBean());
			mForm.setListSpecialAppraisal(mMan.getAll());	
			return mapping.findForward("ListSpecialAppraisal");
		}
		else if("Cancel".equals(mForm.getTask())){
			mForm.setListSpecialAppraisal(mMan.getAll());	
			return mapping.findForward("ListSpecialAppraisal");
		}
		else if("View".equals(mForm.getTask())){
			System.out.println("Task View : "+mForm.getTask());
			System.out.println("Task Param : "+mForm.getParam());
			mForm.setAppraisalBean(mMan.getUserDomain(mForm.getParam()));
			return mapping.findForward("View");
		}
		else if("Back".equals(mForm.getTask())){
			mForm.setListSpecialAppraisal(mMan.getAll());	
			return mapping.findForward("ListSpecialAppraisal");
		}
		
		if ("search".equals(mForm.getTask())) {
			System.out.println("A"+mForm.getSearchCategory());
			System.out.println("OP"+mForm.getSearchKeyword());
			params.put("start", 1);
			params.put("end", 10);
			params.put("category", "employeeName");
			params.put("keyword", mForm.getSearchKeyword());
			
			mForm.setListSpecialAppraisal(mMan.searchSpecialAppraisal(params));
			return mapping.findForward("ListSpecialAppraisal");
			}

		return mapping.findForward("ListSpecialAppraisal");
	}
}
