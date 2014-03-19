/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import adins.ace.taps.bean.employee.NewEmployeeBean;
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
		HttpSession session = request.getSession(true);

		if (mForm.getPage() == null) {
			mForm.setPage(1);
		}
		
		if("delete".equals(mForm.getTask())){
			boolean flag = false;
			flag = mMan.deleteEmployee(mForm.getEmployeeDomain());
			System.out.println(flag);
			mForm.setEmployeeDomain(null);
		}

		if ("getPhoto".equals(mForm.getTask())) {
			NewEmployeeBean bean = new NewEmployeeBean();
			bean = mMan.getPhotoEmployees(mForm.getEmployeeDomain());
			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			OutputStream outStream = response.getOutputStream();

			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					byte[] buffer = bean.getProfilePicture();
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (output != null)
						try {
							output.flush();
							output.close();
						} catch (IOException logOrIgnore) {
							System.err.println(logOrIgnore);
						}
					if (input != null)
						try {
							input.close();
						} catch (IOException logOrIgnore) {
							System.err.println(logOrIgnore);
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("edit".equals(mForm.getTask())) {
			params.put("employeeDomain", mForm.getEmployeeDomain());
			mForm.setNewEmployee(mMan.getEditEmployees(params));
			return mapping.findForward("Edit");
		}
		if ("new".equals(mForm.getTask())) {
			return mapping.findForward("New");
		}
		if ("cancel".equals(mForm.getTask())) {
			return mapping.findForward("ListEmployee");
		}
		if ("saveNewEmployee".equals(mForm.getTask())) {
			boolean flag = false;
			// Resize Photo
			String filePathUpload = getServlet().getServletContext()
					.getRealPath("/");
			PhotoResizeModule resizePhoto = new PhotoResizeModule();
			if (!mForm.getProfilePicture().getFileName().equals("")) {
				filePathUpload = filePathUpload + "upload";
				FormFile filepic = mForm.getProfilePicture();
				byte[] result = resizePhoto.setResizePhoto(filepic,
						filePathUpload);
				mForm.getNewEmployee().setProfilePicture(result);
			}
			else {
				filePathUpload = filePathUpload + "/images/user.png";
				File a = new File(filePathUpload);
				FileInputStream fis = new FileInputStream(a);
				mForm.getNewEmployee().setProfilePicture(
						IOUtils.toByteArray(fis));
			}
			mForm.getNewEmployee().setCreateBy(session.getAttribute("username").toString());
			flag = mMan.insertNewEmployee(mForm.getNewEmployee());
			System.out.println(flag);
		}
		if ("saveEditEmployee".equals(mForm.getTask())) {
			boolean flag = false;
			mForm.getNewEmployee().setTempProfPic(mForm.getProfilePicture());
			if (!mForm.getProfilePicture().getFileName().equals("")) {
				PhotoResizeModule resizePhoto = new PhotoResizeModule();
				FormFile filepic = mForm.getProfilePicture();
				String filePathUpload = getServlet().getServletContext()
						.getRealPath("/") + "upload";
				byte[] result = resizePhoto.setResizePhoto(filepic,
						filePathUpload);
				mForm.getNewEmployee().setProfilePicture(result);
			}
			mForm.getNewEmployee().setUpdateBy(session.getAttribute("username").toString());
			flag = mMan.updateEmployee(mForm.getNewEmployee());
			System.out.println(flag);
		}

		if ("first".equals(mForm.getTask())) {
			mForm.setPage(1);
		}

		if ("last".equals(mForm.getTask())) {
			mForm.setPage(mForm.getMaxpage());
		}

		if ("prev".equals(mForm.getTask())) {
			if (mForm.getPage() > 1) {
				mForm.setPage(mForm.getPage() - 1);
			}
		}
		if ("next".equals(mForm.getTask())) {
			if (mForm.getPage() < mForm.getMaxpage()) {
				mForm.setPage(mForm.getPage() + 1);
			}
		}

		if ("search".equals(mForm.getTask())) {
			mForm.setPage(1);
		}
		params.put("start", (mForm.getPage() - 1) * 10 + 1);
		params.put("end", (mForm.getPage() * 10));
		params.put("category", mForm.getSearchCategory());
		params.put("keyword", mForm.getSearchKeyword());

		mForm.setListEmployees(mMan.searchEmployees(params));
		mForm.setCountRecord(mMan.countEmployees(params));

		if (mForm.getCountRecord() % 10 == 0) {
			mForm.setMaxpage((int) Math.ceil(mForm.getCountRecord() / 10));
		} else {
			mForm.setMaxpage(((int) Math.ceil(mForm.getCountRecord() / 10)) + 1);
		}

		return mapping.findForward("ListEmployee");
	}
}
