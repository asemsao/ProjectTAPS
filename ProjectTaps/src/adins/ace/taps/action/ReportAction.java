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

import adins.ace.taps.bean.report.ReportBean;
import adins.ace.taps.form.employee.EmployeeForm;
import adins.ace.taps.form.report.ReportForm;
import adins.ace.taps.manager.EmployeeManager;
import adins.ace.taps.manager.ReportManager;

public class ReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReportForm rForm = (ReportForm) form;
		ReportManager rMan = new ReportManager();
		
		String orgCode = "MAN";
		String orgName = "MANAJEMEN";
		String orgLevel = "0";
		
		if ("view".equals(rForm.getTask())) {
			Map h = new HashMap();
			System.out.println(rForm.getPeriode());
			System.out.println(rForm.getReportMonth());
			System.out.println(rForm.getReportPeriode());
			System.out.println(rForm.getReportYear());
			if (rForm.getParam2()!=null) {
				//System.out.println("not null  "+mForm.getParam2());
				if (rForm.getParam2().equals("0") || rForm.getParam2().equals("1")) {
					h = new HashMap();
					h.put("orgCode", rForm.getParam().replaceAll(" ",""));
					h.put("orgLevel", rForm.getParam2());
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					if (rForm.getParam2().equals("1")) {
						ReportBean rBean = new ReportBean();
						rBean = rMan.getHeadOrganization(h);
						//System.out.println(rBean.getOrganizationParent());
						rForm.setParam4(rBean.getOrganizationParent());
						rForm.setParam5(rBean.getOrganizationParentName());
					}					
					rForm.setListReports(rMan.getReportLevel1(h));
					return mapping.findForward("View");
				} else
				if (rForm.getParam2().equals("2")) {
					h = new HashMap();
					h.put("orgCode", rForm.getParam().replaceAll(" ",""));
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					ReportBean rBean = new ReportBean();
					rBean = rMan.getHeadOrganization(h);
					rForm.setParam4(rBean.getOrganizationParent());
					rForm.setParam5(rBean.getOrganizationParentName());
					rForm.setListReports(rMan.getReportLevel2(h));
					return mapping.findForward("ViewLevel2");
				}
			} else {
				//System.out.println("nullll");
				if (orgLevel=="0" || orgLevel=="1") {
					h = new HashMap();
					h.put("orgCode", orgCode);
					h.put("orgLevel", orgLevel);
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					rForm.setParam2(orgLevel);
					rForm.setParam3(orgName);
					rForm.setListReports(rMan.getReportLevel1(h));
					return mapping.findForward("View");
				} else
				if (orgLevel=="2") {
					h = new HashMap();
					h.put("orgCode", orgCode);
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					rForm.setParam2(orgLevel);
					rForm.setParam3(orgName);
					rForm.setListReports(rMan.getReportLevel2(h));
					return mapping.findForward("ViewLevel2");
				}
			}
			
			
		}
		
		if ("printReportDept".equals(rForm.getTask())) {
			return mapping.findForward("PrintReportDept");
		}
		if ("printReportBU".equals(rForm.getTask())) {
			return mapping.findForward("PrintReportBU");
		}
		if ("printReportBOM".equals(rForm.getTask())) {
			return mapping.findForward("PrintReportBOM");
		}
		
		return mapping.findForward("Back");
	}
}
