package adins.ace.taps.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LookUpOrganizationAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		out.print("test");
		return null;

		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// String json = gson.toJson(emps);
		// System.out.println("========JSON==============");
		// System.out.println(json);
		// System.out.println("In Action Class..........");
		// System.out.println("==========================");

	}
}
