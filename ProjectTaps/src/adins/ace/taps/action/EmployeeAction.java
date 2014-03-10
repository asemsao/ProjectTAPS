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

import adins.ace.taps.form.employee.EmployeeForm;
import adins.ace.taps.manager.EmployeeManager;

public class EmployeeAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm mForm = (EmployeeForm) form;
		EmployeeManager mMan = new EmployeeManager();
		Map params = new HashMap();
		if (mForm.getPage() == null) {
			mForm.setPage(1);
		}
		
		if ("edit".equals(mForm.getTask())) {
			System.out.println("edit");
			return mapping.findForward("Edit");
		}
		else if("new".equals(mForm.getTask())){
			return mapping.findForward("New");
		}
		else if("cancel".equals(mForm.getTask())){
			return mapping.findForward("ListEmployee");
		}
		else if("saveNewEmployee".equals(mForm.getTask())){
			boolean flag=false;
			flag = mMan.insertNewEmployee(mForm.getNewEmployee());
			System.out.println(flag);
		}
		
		if ("first".equals(mForm.getTask())
				|| "first-ajax".equals(mForm.getTask())) {
			mForm.setPage(1);
		}

		if ("last".equals(mForm.getTask())
				|| "last-ajax".equals(mForm.getTask())) {
			mForm.setPage(mForm.getMaxpage());
		}

		if ("prev".equals(mForm.getTask())
				|| "prev-ajax".equals(mForm.getTask())) {
			if (mForm.getPage() > 1) {
				mForm.setPage(mForm.getPage() - 1);
			}
		}
		if ("next".equals(mForm.getTask())
				|| "next-ajax".equals(mForm.getTask())) {
			if (mForm.getPage() < mForm.getMaxpage()) {
				mForm.setPage(mForm.getPage() + 1);
			}
		}

		if ("search".equals(mForm.getTask())) {
			mForm.setPage(1);
		}
		
		params.put("start", (mForm.getPage() - 1) * 10 + 1);
		params.put("end", (mForm.getPage() * 10));

		mForm.setListEmployees(mMan.getAllEmployees(params));
		mForm.setCountRecord(mMan.countEmployees(params));
		if (mForm.getCountRecord() % 10 == 0) {
			mForm.setMaxpage((int) Math.ceil(mForm.getCountRecord() / 10));
		} else {
			mForm.setMaxpage(((int) Math.ceil(mForm.getCountRecord() / 10)) + 1);
		}
		return mapping.findForward("ListEmployee");
	}
}
