/*http://www.developerscrappad.com/963/java/jndi/java-jndi-ldap-windows-active-directory-authentication-organizational-unit-group-and-other-information-access/
 */

package adins.ace.taps.action;

import java.sql.Savepoint;
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
		HttpSession session = request.getSession(true);
		//rForm.setReportPeriode("I");
		
		if ("view".equals(rForm.getTask())) {
			Map h = new HashMap();
			//System.out.println("periode "+rForm.getPeriode());
			//System.out.println("month "+rForm.getReportMonth());
			//System.out.println("report periode "+rForm.getReportPeriode());
			//System.out.println("year "+rForm.getReportYear());
			
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
					session.setAttribute("buPrint", rForm.getParam().replaceAll(" ",""));
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
					session.setAttribute("buPrint", rForm.getParam().replaceAll(" ",""));
					rForm.setParam4(rBean.getOrganizationParent());
					rForm.setParam5(rBean.getOrganizationParentName());
					rForm.setListReports(rMan.getReportLevel2(h));
					//Savepoint savepoint = rMan.insertSavePoint();
					//rMan.insertSavePoint2(savepoint);
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
					session.setAttribute("buPrint", orgCode);
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
					session.setAttribute("buPrint", orgCode);
					rForm.setListReports(rMan.getReportLevel2(h));
					return mapping.findForward("ViewLevel2");
				}
			}
			
			
		}
		
		if ("1 Months".equals(rForm.getPeriode())) {
			//System.out.println("MASUK 1 MONTHS");
			if ("01".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "January");
			} else if ("02".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "February");
			} else if ("03".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "March");
			} else if ("04".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "April");
			} else if ("05".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "May");
			} else if ("06".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "June");
			} else if ("07".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "July");
			} else if ("08".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "August");
			} else if ("09".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "September");
			} else if ("10".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "October");
			} else if ("11".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "November");
			} else if ("12".equals(rForm.getReportMonth())) {
				session.setAttribute("periodePrint", "December");
			}
			
		}
		
		if ("printReportDept".equals(rForm.getTask())) {
			Map h = new HashMap();
			h.put("prjCode", "");
			if ("6 Months".equals(rForm.getPeriode())) {
				if ("I".equals(rForm.getReportPeriode())) {
					session.setAttribute("periodePrint", "January - June");
					session.setAttribute("periodeReportPrint", "'01','02','03','04','05','06'");
				} else {
					session.setAttribute("periodePrint", "July - December");
					session.setAttribute("periodeReportPrint", "'07','08','09','10','11','12'");
				}
			} else {
				session.setAttribute("periodeReportPrint", "'"+rForm.getReportMonth()+"'");
			}
						
			session.setAttribute("yearPrint", rForm.getReportYear());
			
			return mapping.findForward("PrintReportDept");
		}
		if ("printReportBU".equals(rForm.getTask())) {
			if ("6 Months".equals(rForm.getPeriode())) {
				if ("I".equals(rForm.getReportPeriode())) {
					session.setAttribute("periodePrint", "January - June");
					session.setAttribute("periodeReportPrint", "'01','02','03','04','05','06'");
				} else {
					session.setAttribute("periodePrint", "July - December");
					session.setAttribute("periodeReportPrint", "'07','08','09','10','11','12'");
				}
			} else {
				session.setAttribute("periodeReportPrint", "'"+rForm.getReportMonth()+"'");
			}
						
			session.setAttribute("yearPrint", rForm.getReportYear());
			
			return mapping.findForward("PrintReportBU");
		}
		if ("printReportBOM".equals(rForm.getTask())) {
			//System.out.println("MASUK Print BOM");
			if ("6 Months".equals(rForm.getPeriode())) {
				//System.out.println("MASUK 6 Months");
				if ("I".equals(rForm.getReportPeriode())) {
					//System.out.println("MASUK I");
					session.setAttribute("periodePrint", "January - June");
					session.setAttribute("periodeReportPrint", "'01','02','03','04','05','06'");
				} else {
					session.setAttribute("periodePrint", "July - December");
					session.setAttribute("periodeReportPrint", "'07','08','09','10','11','12'");
				}
			} else {
				//System.out.println("MASUK Moth Print");
				session.setAttribute("periodeReportPrint", "'"+rForm.getReportMonth()+"'");
			}
			
			session.setAttribute("yearPrint", rForm.getReportYear());
			
			return mapping.findForward("PrintReportBOM");
		}
		
		return mapping.findForward("Back");
	}
}
