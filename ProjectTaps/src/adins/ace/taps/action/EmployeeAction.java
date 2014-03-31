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
		
		if (mForm.getPage() == null) {
			mForm.setPage(1);
		}

		if ("delete".equals(mForm.getTask())) {
			if (isTokenValid(request)) {
				boolean flag = false;
				params.put("employeeDomain", mForm.getEmployeeDomain());
				params.put("updateBy", session.getAttribute("username").toString());
				flag = mMan.deleteEmployee(params);
				if (flag) {
					mForm.setMessage("Delete Employee Successfull!");
					mForm.setColor("green");
				} else {
					mForm.setMessage("Delete Employee Successfull!");
					mForm.setColor("red");
				}
				mForm.setEmployeeDomain(null);
				resetToken(request);
			}
		}

		if ("getPhoto".equals(mForm.getTask())) {
			NewEmployeeBean bean = new NewEmployeeBean();
			bean = mMan.getPhotoEmployees(mForm.getEmployeeDomain());
			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			OutputStream outStream = response.getOutputStream();
			byte[] buffer = null;
			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					buffer = bean.getProfilePicture();
					if (buffer == null) {
						buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/") + "images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/") + "images/user.png");
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
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
		
		if ("getPhoto".equals(mForm.getPhoto())) {
			NewEmployeeBean bean = new NewEmployeeBean();
			bean = mMan.getPhotoEmployees(mForm.getEmployeeDomain());
			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			OutputStream outStream = response.getOutputStream();
			byte[] buffer = null;
			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					buffer = bean.getProfilePicture();
					if (buffer == null) {
						buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/") + "images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/") + "images/user.png");
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
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
			return null;
		}

		if ("edit".equals(mForm.getTask())) {
			String tamp = null;
			String[] temp = null;
			params.put("employeeDomain", mForm.getEmployeeDomain());
			mForm.setNewEmployee(mMan.getEditEmployees(params));
			if (mForm.getNewEmployee().getPhoneNumber() != null) {
				tamp = mForm.getNewEmployee().getPhoneNumber();
				mForm.getNewEmployee().setPhoneNumberAreaCode(tamp.substring(0, tamp.indexOf("-")));
				mForm.getNewEmployee().setPhoneNumberMidNumb(tamp.substring(tamp.indexOf("-") + 1,tamp.indexOf("#")));
				mForm.getNewEmployee().setPhoneNumberLastNumb(tamp.substring(tamp.indexOf("#") + 1));
			}
			if (mForm.getNewEmployee().getMobileNumber() != null) {
				tamp = mForm.getNewEmployee().getMobileNumber();
				mForm.getNewEmployee().setMobileNumberAreaCode(tamp.substring(0, tamp.indexOf("-")));
				mForm.getNewEmployee().setMobileNumberMidNumb(tamp.substring(tamp.indexOf("-") + 1));
			}
			saveToken(request);
			return mapping.findForward("Edit");
		}
		if ("new".equals(mForm.getTask())) {
			saveToken(request);
			return mapping.findForward("New");
		}
		if ("cancel".equals(mForm.getTask())) {
			return mapping.findForward("ListEmployee");
		}
		if ("saveNewEmployee".equals(mForm.getTask())) {
			if (isTokenValid(request)) {
				boolean flag = false;
				boolean flagRole = false;
				// Resize Photo
				String filePathUpload = getServlet().getServletContext().getRealPath("/");
				PhotoResizeModule resizePhoto = new PhotoResizeModule();
				if (!mForm.getProfilePicture().getFileName().equals("")) {
					filePathUpload = filePathUpload + "upload";
					FormFile filepic = mForm.getProfilePicture();
					byte[] result = resizePhoto.setResizePhoto(filepic,filePathUpload);
					mForm.getNewEmployee().setProfilePicture(result);
				} else {
					filePathUpload = filePathUpload + "/images/user.png";
					File a = new File(filePathUpload);
					FileInputStream fis = new FileInputStream(a);
					mForm.getNewEmployee().setProfilePicture(IOUtils.toByteArray(fis));
				}
				mForm.getNewEmployee().setCreateBy(session.getAttribute("username").toString());

				// PHONE STANDARISASI
				String phone = "";
				String mobile = "";
				if (mForm.getNewEmployee().getPhoneNumberAreaCode().trim() != null
						|| mForm.getNewEmployee().getPhoneNumberAreaCode().trim().equals("")) {
					phone = mForm.getNewEmployee().getPhoneNumberAreaCode().trim() + "-"
							+ mForm.getNewEmployee().getPhoneNumberMidNumb().trim() + "#";
					if (mForm.getNewEmployee().getPhoneNumberLastNumb().trim() != null
							|| mForm.getNewEmployee().getPhoneNumberLastNumb().trim().equals("")) {
						phone += mForm.getNewEmployee().getPhoneNumberLastNumb().trim();
					}
					mForm.getNewEmployee().setPhoneNumber(phone);
				} else {
					mForm.getNewEmployee().setPhoneNumber("-");
				}

				if (mForm.getNewEmployee().getMobileNumberAreaCode().trim() != null
						|| mForm.getNewEmployee().getMobileNumberAreaCode().trim().equals("")) {
					mobile = mForm.getNewEmployee().getMobileNumberAreaCode().trim() + "-"
							+ mForm.getNewEmployee().getMobileNumberMidNumb().trim();
					mForm.getNewEmployee().setMobileNumber(mobile);
				} else {
					mForm.getNewEmployee().setMobileNumber("-");
				}

				flag = mMan.insertNewEmployee(mForm.getNewEmployee());
				flagRole = mMan.insertRoleEmp(mForm.getNewEmployee());
				if (flag && flagRole) {
					Map data = new HashMap();
					data.put("username", mForm.getNewEmployee().getEmployeeDomain());
					if (mForm.getPassword() != null) {
						if (!mForm.getPassword().equals("")) {
							data.put("password", mForm.getPassword());
						} else {
							data.put("password", "sysadmin");
						}
					} else {
						data.put("password", "sysadmin");
					}
					mMan.insertLoginEmployee(data);

					mForm.setMessage("Add Employee Successfull!");
					mForm.setColor("green");
				} else {
					mForm.setMessage("Add Employee Failed!");
					mForm.setColor("red");
				}
				resetToken(request);
			}
		}
		
		if ("saveEditEmployee".equals(mForm.getTask())) {
			if (isTokenValid(request)) {
				boolean flag = false;
				mForm.getNewEmployee().setTempProfPic(mForm.getProfilePicture());
				if (!mForm.getProfilePicture().getFileName().equals("")) {
					PhotoResizeModule resizePhoto = new PhotoResizeModule();
					FormFile filepic = mForm.getProfilePicture();
					String filePathUpload = getServlet().getServletContext().getRealPath("/") + "upload";
					byte[] result = resizePhoto.setResizePhoto(filepic,filePathUpload);
					mForm.getNewEmployee().setProfilePicture(result);
				}

				params.put("userDomain", mForm.getNewEmployee().getEmployeeDomain());
				List<EmployeeOrganizationBean> organizationList = mMan.checkEmplooyeeOrganization(params);
				if (mMan.countEmplooyeeOrganization(params) == 0) {
					mForm.getNewEmployee().setUpdateBy(session.getAttribute("username").toString());

					// PHONE STANDARISASI
					String phone = "";
					String mobile = "";
					if (mForm.getNewEmployee().getPhoneNumberAreaCode().trim() != null
							|| mForm.getNewEmployee().getPhoneNumberAreaCode().trim().equals("")) {
						phone = mForm.getNewEmployee().getPhoneNumberAreaCode().trim() + "-"
								+ mForm.getNewEmployee().getPhoneNumberMidNumb().trim() + "#";
						if (mForm.getNewEmployee().getPhoneNumberLastNumb().trim() != null
								|| mForm.getNewEmployee().getPhoneNumberLastNumb().trim().equals("")) {
							phone += mForm.getNewEmployee().getPhoneNumberLastNumb().trim();
						}
						mForm.getNewEmployee().setPhoneNumber(phone);
					} else {
						mForm.getNewEmployee().setPhoneNumber("-");
					}

					if (mForm.getNewEmployee().getMobileNumberAreaCode().trim() != null
							|| mForm.getNewEmployee().getMobileNumberAreaCode().trim().equals("")) {
						mobile = mForm.getNewEmployee().getMobileNumberAreaCode().trim() + "-"
								+ mForm.getNewEmployee().getMobileNumberMidNumb().trim();
						mForm.getNewEmployee().setMobileNumber(mobile);
					} else {
						mForm.getNewEmployee().setMobileNumber("-");
					}

					flag = mMan.updateEmployee(mForm.getNewEmployee());
					mForm.setMessage("Edit Employee Successfull!");
					mForm.setColor("green");
				} else {
					if (organizationList.get(0).getOrganizationCode().equalsIgnoreCase(mForm.getNewEmployee().getBusinessUnit())) {
						mForm.getNewEmployee().setUpdateBy(session.getAttribute("username").toString());
						// PHONE STANDARISASI
						String phone = "";
						String mobile = "";
						if (mForm.getNewEmployee().getPhoneNumberAreaCode().trim() != null
								|| mForm.getNewEmployee().getPhoneNumberAreaCode().trim().equals("")) {
							phone = mForm.getNewEmployee().getPhoneNumberAreaCode().trim() + "-"
									+ mForm.getNewEmployee().getPhoneNumberMidNumb().trim() + "#";
							if (mForm.getNewEmployee().getPhoneNumberLastNumb().trim() != null
									|| mForm.getNewEmployee().getPhoneNumberLastNumb().trim().equals("")) {
								phone += mForm.getNewEmployee().getPhoneNumberLastNumb().trim();
							}
							mForm.getNewEmployee().setPhoneNumber(phone);
						} else {
							mForm.getNewEmployee().setPhoneNumber("-");
						}

						if (mForm.getNewEmployee().getMobileNumberAreaCode().trim() != null
								|| mForm.getNewEmployee().getMobileNumberAreaCode().trim().equals("")) {
							mobile = mForm.getNewEmployee().getMobileNumberAreaCode().trim() + "-"
									+ mForm.getNewEmployee().getMobileNumberMidNumb().trim();
							mForm.getNewEmployee().setMobileNumber(mobile);
						} else {
							mForm.getNewEmployee().setMobileNumber("-");
						}

						flag = mMan.updateEmployee(mForm.getNewEmployee());
						mForm.setMessage("Edit Employee Successfull!");
						mForm.setColor("green");
					} else {
						mForm.setTask("edit");
						mForm.setMessage(organizationList.get(0).getHeadUserDomain() + " AS HEAD BU, Can't be Moved!");
						mForm.setColor("red");
						mForm.setEmployeeDomain(mForm.getNewEmployee().getEmployeeDomain());
						return mapping.findForward("Edit");
					}
				}
				if (flag) {
					//if ("true".equals(App.getConfiguration("recovery_mode"))) {
					if ("false".equalsIgnoreCase(session.getAttribute("aDStatus").toString())) {
						Map data = new HashMap();
						if (mForm.getPassword() != null) {
							if (!mForm.getPassword().equals("")) {
								data.put("username", mForm.getNewEmployee().getEmployeeDomain());
								data.put("password", mForm.getPassword());
								mMan.updateLoginEmployee(data);
							}
						}
					}
				}
				resetToken(request);
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
		saveToken(request);
		return mapping.findForward("ListEmployee");
	}
}
