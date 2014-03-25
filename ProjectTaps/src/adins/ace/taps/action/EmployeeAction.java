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
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.crystaldecisions.proxy.remoteagent.am;

import adins.ace.taps.bean.employee.EmployeeOrganizationBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.configuration.App;
import adins.ace.taps.form.employee.EmployeeForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.LoginManager;
import adins.ace.taps.module.ExtractPhoto;
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

		if ("changePassword".equals(mForm.getTask())
				&& session.getAttribute("username") != null) {
			LoginManager lMan = new LoginManager();
			Map user = new HashMap();
			user.put("username", "devri.rs");
			user.put("password", mForm.getPassword());
			session.setAttribute("messagecolor", "red");
			if (lMan.tryLogin(user)) {
				if (mForm.getNewPassword().equals(
						mForm.getNewPasswordConfirmation())) {
					if (mForm.getNewPassword().length() > 5) {
						user.put("password", mForm.getNewPassword());
						if (mMan.updateLoginEmployee(user)) {
							session.setAttribute("messagecp",
									"Change Password SUCCESSFULL!");
							session.setAttribute("messagecolor", "green");
						} else {
							session.setAttribute("messagecp",
									"Change Password FAILED!");
						}
					} else {
						session.setAttribute("messagecp",
								"Password must be contain min. 6 characters");
					}

				} else {
					session.setAttribute("messagecp",
							"Change Password FAILED! Your Password is Doesn't Match");
				}
			} else {
				session.setAttribute("messagecp",
						"Change Password FAILED! Your Old Password is Incorrect!");
			}
			return mapping.findForward("Dashboard");
		}

		if (mForm.getPage() == null) {
			mForm.setPage(1);
		}

		if ("delete".equals(mForm.getTask())) {
			boolean flag = false;
			flag = mMan.deleteEmployee(mForm.getEmployeeDomain());
			if (flag) {
				mForm.setMessage("Delete Employee Successfull!");
				mForm.setColor("green");
			} else {
				mForm.setMessage("Delete Employee Successfull!");
				mForm.setColor("red");
			}
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
					if (buffer == null) {
						buffer = ExtractPhoto.extractBytes(getServlet()
								.getServletContext().getRealPath("/")
								+ "images/user.png");
					}
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
			String tamp = null;
			String[] temp = null;
			params.put("employeeDomain", mForm.getEmployeeDomain());
			mForm.setNewEmployee(mMan.getEditEmployees(params));
			if (mForm.getNewEmployee().getPhoneNumber() != null) {
				tamp = mForm.getNewEmployee().getPhoneNumber()
						.replaceAll("\\(|\\)|\\-", "-");
				temp = tamp.split("-");
				mForm.getNewEmployee().setPhoneNumberAreaCode(temp[1].trim());
				mForm.getNewEmployee().setPhoneNumberMidNumb(temp[2].trim());
				mForm.getNewEmployee().setPhoneNumberLastNumb(temp[3].trim());
			}
			if (mForm.getNewEmployee().getMobileNumber() != null) {
				tamp = mForm.getNewEmployee().getMobileNumber()
						.replaceAll("\\(|\\)|\\-", "-");
				if (tamp.charAt(0) != '-') {
					tamp = "-" + tamp;
				}
				temp = tamp.split("-");
				mForm.getNewEmployee().setMobileNumberAreaCode(temp[1].trim());
				mForm.getNewEmployee().setMobileNumberMidNumb(temp[2].trim());
				mForm.getNewEmployee().setMobileNumberLastNumb(temp[3].trim());
			}
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
			boolean flagRole = false;
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
			} else {
				filePathUpload = filePathUpload + "/images/user.png";
				File a = new File(filePathUpload);
				FileInputStream fis = new FileInputStream(a);
				mForm.getNewEmployee().setProfilePicture(
						IOUtils.toByteArray(fis));
			}
			mForm.getNewEmployee().setCreateBy(
					session.getAttribute("username").toString());
			mForm.getNewEmployee().setPhoneNumber(
					"("
							+ mForm.getNewEmployee()
									.getPhoneNumberAreaCode().trim()
							+ ")"
							+ mForm.getNewEmployee()
									.getPhoneNumberMidNumb().trim() + "("
							+ mForm.getNewEmployee()
									.getPhoneNumberLastNumb().trim() + ")");
			if(mForm.getNewEmployee().getPhoneNumber().equals("()()")){
				mForm.getNewEmployee().setPhoneNumber("");
			}

			mForm.getNewEmployee().setMobileNumber(
					"("
							+ mForm.getNewEmployee()
									.getMobileNumberAreaCode().trim()
							+ ")"
							+ mForm.getNewEmployee()
									.getMobileNumberMidNumb().trim()
							+ "-"
							+ mForm.getNewEmployee()
									.getMobileNumberLastNumb().trim());

			if(mForm.getNewEmployee().getMobileNumber().equals("()-")){
				mForm.getNewEmployee().setMobileNumber("");
			}

			flag = mMan.insertNewEmployee(mForm.getNewEmployee());
			flagRole = mMan.insertRoleEmp(mForm.getNewEmployee());
			if (flag && flagRole) {
				Map data = new HashMap();
				data.put("username", mForm.getNewEmployee().getEmployeeDomain());
				if (mForm.getPassword() != "") {
					data.put("password", mForm.getPassword());
				} else {
					data.put("password", "employeetaps");
				}
				mMan.insertLoginEmployee(data);

				mForm.setMessage("Add Employee Successfull!");
				mForm.setColor("green");
			} else {
				mForm.setMessage("Add Employee Failed!");
				mForm.setColor("red");
			}
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

			params.put("userDomain", mForm.getNewEmployee().getEmployeeDomain());
			List<EmployeeOrganizationBean> organizationList = mMan
					.checkEmplooyeeOrganization(params);

			if (organizationList.size() == 0) {
				mForm.getNewEmployee().setUpdateBy(
						session.getAttribute("username").toString());
				mForm.getNewEmployee().setPhoneNumber(
						"("
								+ mForm.getNewEmployee()
										.getPhoneNumberAreaCode().trim()
								+ ")"
								+ mForm.getNewEmployee()
										.getPhoneNumberMidNumb().trim() + "("
								+ mForm.getNewEmployee()
										.getPhoneNumberLastNumb().trim() + ")");
				if(mForm.getNewEmployee().getPhoneNumber().equals("()()")){
					mForm.getNewEmployee().setPhoneNumber("");
				}

				mForm.getNewEmployee().setMobileNumber(
						"("
								+ mForm.getNewEmployee()
										.getMobileNumberAreaCode().trim()
								+ ")"
								+ mForm.getNewEmployee()
										.getMobileNumberMidNumb().trim()
								+ "-"
								+ mForm.getNewEmployee()
										.getMobileNumberLastNumb().trim());

				if(mForm.getNewEmployee().getMobileNumber().equals("()-")){
					mForm.getNewEmployee().setMobileNumber("");
				}
				flag = mMan.updateEmployee(mForm.getNewEmployee());
				mForm.setMessage("Edit Employee Successfull!");
				mForm.setColor("green");
			} else {
				if (organizationList
						.get(0)
						.getOrganizationCode()
						.equalsIgnoreCase(
								mForm.getNewEmployee().getBusinessUnit())) {
					mForm.getNewEmployee().setUpdateBy(
							session.getAttribute("username").toString());
					mForm.getNewEmployee().setPhoneNumber(
							"("
									+ mForm.getNewEmployee()
											.getPhoneNumberAreaCode()
									+ ")"
									+ mForm.getNewEmployee()
											.getPhoneNumberMidNumb()
									+ "("
									+ mForm.getNewEmployee()
											.getPhoneNumberLastNumb() + ")");
					mForm.getNewEmployee().setMobileNumber(
							"("
									+ mForm.getNewEmployee()
											.getMobileNumberAreaCode()
									+ ")"
									+ mForm.getNewEmployee()
											.getMobileNumberMidNumb()
									+ "-"
									+ mForm.getNewEmployee()
											.getMobileNumberLastNumb());
					flag = mMan.updateEmployee(mForm.getNewEmployee());
					mForm.setMessage("Edit Employee Successfull!");
					mForm.setColor("green");
				} else {
					mForm.setTask("edit");
					mForm.setMessage(organizationList.get(0)
							.getHeadUserDomain() + " Can't Move To Other BU!");
					mForm.setColor("red");
					return mapping.findForward("Edit");
				}
			}
			if (flag) {
				if ("true".equals(App.getConfiguration("recovery_mode"))) {
					if (mForm.getPassword() != "") {
						Map data = new HashMap();
						data.put("username", mForm.getNewEmployee()
								.getEmployeeDomain());
						data.put("password", mForm.getPassword());
						mMan.updateLoginEmployee(data);
					}
				}
			}
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
