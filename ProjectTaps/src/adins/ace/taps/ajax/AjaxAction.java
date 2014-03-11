package adins.ace.taps.ajax;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adins.ace.taps.manager.EmployeeManager;

public class AjaxAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeManager empMan = new EmployeeManager();

		AjaxForm ajaxForm = (AjaxForm) form;

		PrintWriter out = response.getWriter();
		Map params = new HashMap();

		if (ajaxForm.getPage() == null) {
			ajaxForm.setPage(1);
		}

		if ("first".equals(ajaxForm.getTask())) {
			ajaxForm.setPage(1);
		}

		if ("last".equals(ajaxForm.getTask())) {
			ajaxForm.setPage(ajaxForm.getMaxpage());
		}

		if ("prev".equals(ajaxForm.getTask())) {
			if (ajaxForm.getPage() > 1) {
				ajaxForm.setPage(ajaxForm.getPage() - 1);
			}
		}
		if ("next".equals(ajaxForm.getTask())) {
			if (ajaxForm.getPage() < ajaxForm.getMaxpage()) {
				ajaxForm.setPage(ajaxForm.getPage() + 1);
			}
		}

		// params.put("start", (ajaxForm.getPage() - 1) * 10 + 1);
		// params.put("end", (ajaxForm.getPage() * 10));
		params.put("start", 1);
		params.put("end", 10);
		ajaxForm.setListEmployees(empMan.searchEmployees(params));
		ajaxForm.setCountRecord(empMan.countEmployees(params));
		ajaxForm.setTask("test");
		if (ajaxForm.getCountRecord() % 10 == 0) {
			ajaxForm.setMaxpage((int) Math.ceil(ajaxForm.getCountRecord() / 10));
		} else {
			ajaxForm.setMaxpage(((int) Math.ceil(ajaxForm.getCountRecord() / 10)) + 1);
		}

		System.out.println("test");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(ajaxForm);
		// out.print(json);

		return null;
	}

}
