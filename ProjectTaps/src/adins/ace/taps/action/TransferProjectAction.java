package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.bean.project.StructureProjectBean;
import adins.ace.taps.form.project.TransferProjectForm;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.TransferProjectManager;
import adins.ace.taps.module.ExtractPhoto;

public class TransferProjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TransferProjectForm tpForm = (TransferProjectForm) form;
		TransferProjectManager tpMan = new TransferProjectManager();
		OrganizationManager oMan = new OrganizationManager();
		Map params = new HashMap();
		
		
		if ("retrieveProject".equals(tpForm.getTask())) {
			tpForm.setpBean(tpMan.getProjectById(request.getParameter("projectCode").toString()));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(tpForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}
		
		if ("retrieveStructure".equals(tpForm.getTask())) {
			tpForm.setpBean(tpMan.getProjectById(request.getParameter("projectCode").toString()));
			tpForm.setListMember(tpMan.getAllMemberByProjectId(request.getParameter("projectCode").toString()));
			tpForm.setOrgCode(request.getParameter("orgCode").toString());
			tpForm.setOrgName(request.getParameter("orgName").toString());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(tpForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}
		
		if ("getAssigneePhoto".equals(tpForm.getTask())) {
			StructureProjectBean bean = new StructureProjectBean();
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			OutputStream outStream = response.getOutputStream();
			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					byte[] buffer = bean.getAssigneePhoto();
					if (buffer == null) {
						buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/")+"images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					System.out.println("catch 1");
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
		
		if ("getDirectReportPhoto".equals(tpForm.getTask())) {
			StructureProjectBean bean = new StructureProjectBean();
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			OutputStream outStream = response.getOutputStream();
			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					byte[] buffer = bean.getDirectReportPhoto();
					if (buffer == null) {
						buffer = ExtractPhoto.extractBytes(getServlet().getServletContext().getRealPath("/")+"images/user.png");
					}
					response.reset();
					response.setContentLength(buffer.length);
					outStream.write(buffer);
					outStream.flush();
				} catch (IOException e) {
					System.out.println("catch 1");
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
		
		if ("update".equals(tpForm.getTask())) {
			Gson gson = new Gson();
			Object obj = gson.fromJson(request.getParameter("params"), Object.class);
			params = (Map) obj;
			System.out.println(params);
		}

		if (tpForm.getPageProject() == null) {
			tpForm.setPageProject(1);
		}

		if ("first".equals(tpForm.getTask())) {
			tpForm.setPageProject(1);
		}

		if ("last".equals(tpForm.getTask())) {
			tpForm.setPageProject(tpForm.getMaxPageProject());
		}

		if ("prev".equals(tpForm.getTask())) {
			if (tpForm.getPageProject() > 1) {
				tpForm.setPageProject(tpForm.getPageProject() - 1);
			}
		}
		if ("next".equals(tpForm.getTask())) {
			if (tpForm.getPageProject() < tpForm.getMaxPageProject()) {
				tpForm.setPageProject(tpForm.getPageProject() + 1);
			}
		}

		if ("search".equals(tpForm.getTask())) {
			tpForm.setPageProject(1);
		}
		
		if ("cancel".equals(tpForm.getTask())) {

		}

		params.put("start", (tpForm.getPageProject() - 1) * 10 + 1);
		params.put("end", (tpForm.getPageProject() * 10));
		params.put("category", tpForm.getSearchCategory());
		params.put("keyword", tpForm.getSearchKeyword());

		tpForm.setListProject(tpMan.searchProject(params));
		tpForm.setCountRecordProject(tpMan.countProject(params));
		
		tpForm.setListOrganization(tpMan.searchOrganization(params));
//		tpForm.setCountRecordOrganization(tpMan.countOrganization(params));
		

		if (tpForm.getCountRecordProject() % 10 == 0) {
			tpForm.setMaxPageProject((int) Math.ceil(tpForm.getCountRecordProject() / 10));
		} else {
			tpForm.setMaxPageProject(((int) Math.ceil(tpForm.getCountRecordProject() / 10)) + 1);
		}

		return mapping.findForward("ListTransferProject");
	}
	
	
}
