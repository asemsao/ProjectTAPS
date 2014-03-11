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
import org.apache.struts.upload.FormFile;

import adins.ace.taps.form.employee.EmployeeForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.module.PhotoResizeModule;

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
			params.put("employeeDomain", mForm.getEmployeeDomain());
			mForm.setNewEmployee(mMan.getEditEmployees(params));
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
			//Resize Photo
			PhotoResizeModule resizePhoto = new PhotoResizeModule();
			FormFile filepic = mForm.getProfilePicture();
			String filePathUpload = getServlet().getServletContext().getRealPath("/") +"upload";
			byte[] result = resizePhoto.setResizePhoto(filepic, filePathUpload);
			mForm.getNewEmployee().setProfilePicture(result);
			flag = mMan.insertNewEmployee(mForm.getNewEmployee());
			System.out.println(flag);
		}
		else if("saveEditEmployee".equals(mForm.getTask())){
			boolean flag=false;
			
			System.out.println(flag);
		}
		
		else if ("first".equals(mForm.getTask())
				|| "first-ajax".equals(mForm.getTask())) {
			mForm.setPage(1);
		}

		else if ("last".equals(mForm.getTask())
				|| "last-ajax".equals(mForm.getTask())) {
			mForm.setPage(mForm.getMaxpage());
		}

		else if ("prev".equals(mForm.getTask())
				|| "prev-ajax".equals(mForm.getTask())) {
			if (mForm.getPage() > 1) {
				mForm.setPage(mForm.getPage() - 1);
			}
		}
		else if ("next".equals(mForm.getTask())
				|| "next-ajax".equals(mForm.getTask())) {
			if (mForm.getPage() < mForm.getMaxpage()) {
				mForm.setPage(mForm.getPage() + 1);
			}
		}

		else if ("search".equals(mForm.getTask())) {
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
