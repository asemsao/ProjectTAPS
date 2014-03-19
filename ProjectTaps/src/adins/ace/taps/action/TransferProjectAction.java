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
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession(true);
		TransferProjectForm tpForm = (TransferProjectForm) form;
		TransferProjectManager tpMan = new TransferProjectManager();
		OrganizationManager oMan = new OrganizationManager();
		Map<String, Object> params = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		
		if (tpForm.getPageP() == null) {
			tpForm.setPageP(1);
		}

		if ("firstP".equals(tpForm.getPagingDirection())) {
			tpForm.setPageP(1);
		}

		if ("lastP".equals(tpForm.getPagingDirection())) {
			tpForm.setPageP(tpForm.getMaxPageP());
		}

		if ("prevP".equals(tpForm.getPagingDirection())) {
			if (tpForm.getPageP() > 1) {
				tpForm.setPageP(tpForm.getPageP() - 1);
			}
		}
		if ("nextP".equals(tpForm.getPagingDirection())) {
			if (tpForm.getPageP() < tpForm.getMaxPageP()) {
				tpForm.setPageP(tpForm.getPageP() + 1);
			}
		}
		
		if (tpForm.getPageO() == null) {
			tpForm.setPageO(1);
		}

		if ("firstO".equals(tpForm.getPagingDirection())) {
			tpForm.setPageO(1);
		}

		if ("lastO".equals(tpForm.getPagingDirection())) {
			tpForm.setPageO(tpForm.getMaxPageO());
		}

		if ("prevO".equals(tpForm.getPagingDirection())) {
			if (tpForm.getPageO() > 1) {
				tpForm.setPageO(tpForm.getPageO() - 1);
			}
		}
		if ("nextO".equals(tpForm.getPagingDirection())) {
			if (tpForm.getPageO() < tpForm.getMaxPageO()) {
				tpForm.setPageO(tpForm.getPageO() + 1);
			}
		}
		
		if ("retrieveProject".equals(tpForm.getTask())) {
			tpForm.setpBean(tpMan.getProjectById(request.getParameter("projectCode").toString()));
			json = gson.toJson(tpForm);
			PrintWriter out = response.getWriter();
			out.print(json);
			return null;
		}
		
		if ("retrieveStructure".equals(tpForm.getTask())) {
			tpForm.setpBean(tpMan.getProjectById(request.getParameter("projectCode").toString()));
			tpForm.setListMember(tpMan.getAllMemberByProjectId(request.getParameter("projectCode").toString()));
			tpForm.setOrgCode(request.getParameter("orgCode").toString());
			tpForm.setOrgName(request.getParameter("orgName").toString());
			json = gson.toJson(tpForm);
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
		
		if ("updateTransfer".equals(tpForm.getTask())) {
			params = gson.fromJson(request.getParameter("params"), HashMap.class);
			params.put("orgCode", params.get("orgCode").toString().trim());
			params.put("orgBefore", params.get("orgBefore"));
			params.put("transferDate", params.get("transferDate"));
			params.put("createdBy", session.getAttribute("username"));
			
			String temp = "";
			for (String item : (Iterable<String>) params.get("listMember")) {
				temp += "'" + item + "', ";
			}
			temp = temp.substring(0, temp.length() - 2);
			params.put("listMember", temp);
			boolean flag = tpMan.updateTransfer(params);
			System.out.println("UPDATE : " + flag);
		}

		params.put("startP", (tpForm.getPageP() - 1) * 10 + 1);
		params.put("endP", (tpForm.getPageP() * 10));
		tpForm.setListProject(tpMan.searchProject(params));
		tpForm.setCountRecordP(tpMan.countProject(params));
		
		params.put("startO", (tpForm.getPageO() - 1) * 10 + 1);
		params.put("endO", (tpForm.getPageO() * 10));
		tpForm.setListOrganization(tpMan.searchOrganization(params));		
		tpForm.setCountRecordO(tpMan.countOrganization(params));
		
		if (tpForm.getCountRecordP() % 10 == 0) {
			tpForm.setMaxPageP((int) Math.ceil(tpForm.getCountRecordP() / 10));
		} else {
			tpForm.setMaxPageP(((int) Math.ceil(tpForm.getCountRecordP() / 10)) + 1);
		}
		
		if (tpForm.getCountRecordO() % 10 == 0) {
			tpForm.setMaxPageO((int) Math.ceil(tpForm.getCountRecordO() / 10));
		} else {
			tpForm.setMaxPageO(((int) Math.ceil(tpForm.getCountRecordO() / 10)) + 1);
		}
		
		if ("searchProject".equals(tpForm.getTask())) {
			tpForm.setPageP(1);
			tpForm.setProjectCategory(request.getParameter("projectCategory"));
			tpForm.setProjectKeyword(request.getParameter("projectKeyword"));
			params.put("category", tpForm.getProjectCategory());
			params.put("keyword", tpForm.getProjectKeyword());
			tpForm.setListProject(tpMan.searchProject(params));
			json = gson.toJson(tpForm);
			PrintWriter out = response.getWriter();
			out.write(json);
			return null;
		}
		
		if ("searchOrg".equals(tpForm.getTask())) {
			tpForm.setPageO(1);
			tpForm.setOrgCategory(request.getParameter("orgCategory"));
			tpForm.setOrgKeyword(request.getParameter("orgKeyword"));
			params.put("category", tpForm.getOrgCategory());
			params.put("keyword", tpForm.getOrgKeyword());
			tpForm.setListOrganization(tpMan.searchOrganization(params));
			json = gson.toJson(tpForm);
			PrintWriter out = response.getWriter();
			out.write(json);
			return null;
		}
		
		return mapping.findForward("ListTransferProject");
	}
	
	
}
