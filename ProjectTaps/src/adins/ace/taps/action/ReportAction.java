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
import adins.ace.taps.form.report.ReportForm;
import adins.ace.taps.manager.OrganizationManager;
import adins.ace.taps.manager.ReportManager;

public class ReportAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReportForm rForm = (ReportForm) form;
		ReportManager rMan = new ReportManager();
		OrganizationManager orgMan = new OrganizationManager();
		HttpSession session = request.getSession(true);
		
		String orgCode;
		orgCode = (String) session.getAttribute("organizationCode");
		String orgName = "";
		orgName = "";
		String orgLevel = "";
		orgLevel = (String) session.getAttribute("organizationLevel");	
		if("getDetail".equals(rForm.getTask()))
		{
			Map param = new HashMap();
			
			param.put("userDomain", rForm.getUserDomain());
			param.put("reportYear",rForm.getReportYear() );
			if("I".equals(rForm.getReportPeriode()))
			{
				rForm.setrBean(rMan.getDetail(param));
				rForm.setRsBean(rMan.getStar1(param));
			}
			else
			{
				rForm.setrBean(rMan.getDetail2(param));
				rForm.setRsBean(rMan.getStar2(param));
			}
			return mapping.findForward("GetDetail");
		}
		if ("1 Months".equals(rForm.getPeriode())) {
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
			Map<String,String> h = new HashMap<String,String>();
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
						
			session.setAttribute("buPrint", rForm.getBuPrint());
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
						
			session.setAttribute("buPrint", rForm.getBuPrint());
			session.setAttribute("yearPrint", rForm.getReportYear());
			
			return mapping.findForward("PrintReportBU");
		}
		if ("printReportBOM".equals(rForm.getTask())) {
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
			
			session.setAttribute("buPrint", rForm.getBuPrint());
			session.setAttribute("yearPrint", rForm.getReportYear());
			
			return mapping.findForward("PrintReportBOM");
		}
		
		
			Map h = new HashMap();
			
			if (rForm.getPage() == null) {
				rForm.setPage(1);
			}
			if ("first".equals(rForm.getTask())) {
				rForm.setPage(1);
			}
			if ("last".equals(rForm.getTask())) {
				rForm.setPage(rForm.getMaxpage());
			}
			if ("prev".equals(rForm.getTask())) {
				if (rForm.getPage() > 1) {
					rForm.setPage(rForm.getPage() - 1);
				}
			}
			if ("next".equals(rForm.getTask())) {
				if (rForm.getPage() < rForm.getMaxpage()) {
					rForm.setPage(rForm.getPage() + 1);
				}
			}
			if ("search".equals(rForm.getTask())) {
				rForm.setPage(1);
			}
			
			
			h.put("start", ((rForm.getPage() - 1) * 10 + 1));
			h.put("end", (rForm.getPage() * 10));
			
			if (rForm.getOrganizationLevel()!=null) {
				
				if (rForm.getOrganizationLevel().equals("0")) {
					h.put("orgCode", rForm.getOrganizationCode().trim());
					h.put("orgLevel", rForm.getOrganizationLevel());
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					if (rForm.getOrganizationLevel().equals("1")) {
						ReportBean rBean = new ReportBean();
						rBean = rMan.getHeadOrganization(h);
						rForm.setParentCode(rBean.getOrganizationParent());
						rForm.setParentName(rBean.getOrganizationParentName());
					}
					rForm.setCountRecord(rMan.countReportManagement(h));
					rForm.setListReports(rMan.getReportLevelManagement(h));
				} else if (rForm.getOrganizationLevel().equals("1")) {
					h.put("orgCode", rForm.getOrganizationCode().trim());
					h.put("orgLevel", rForm.getOrganizationLevel());
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					if (rForm.getOrganizationLevel().equals("1")) {
						ReportBean rBean = new ReportBean();
						rBean = rMan.getHeadOrganization(h);
						rForm.setParentCode(rBean.getOrganizationParent());
						rForm.setParentName(rBean.getOrganizationParentName());
					}
					rForm.setCountRecord(rMan.countReportDivision(h));
					rForm.setListReports(rMan.getReportLevelDivision(h));
				} else	if (rForm.getOrganizationLevel().equals("2")) {
					h.put("orgCode", rForm.getOrganizationCode().trim());
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					ReportBean rBean = new ReportBean();
					rBean = rMan.getHeadOrganization(h);
					rForm.setParentCode(rBean.getOrganizationParent());
					rForm.setParentName(rBean.getOrganizationParentName());
					rForm.setCountRecord(rMan.countReportDepartment(h));
					rForm.setListReports(rMan.getReportLevelDepartment(h));
				}
			} else {
				if (orgLevel.equals("0")) {
					h.put("orgCode", orgCode);
					h.put("orgLevel", orgLevel);
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					rForm.setOrganizationCode(orgCode.toString());
					rForm.setOrganizationLevel(orgLevel.toString());
					rForm.setOrganizationName(orgName);
					rForm.setCountRecord(rMan.countReportManagement(h));
					rForm.setListReports(rMan.getReportLevelManagement(h));
				} else
					if (orgLevel.equals("1")) {
						h.put("orgCode", orgCode);
						h.put("orgLevel", orgLevel);
						h.put("reportYear", rForm.getReportYear());
						h.put("reportPeriode", rForm.getReportPeriode());
						h.put("reportMonth", rForm.getReportMonth());
						rForm.setOrganizationCode(orgCode.toString());
						rForm.setOrganizationLevel(orgLevel.toString());
						rForm.setOrganizationName(orgName);
						rForm.setCountRecord(rMan.countReportDivision(h));
						rForm.setListReports(rMan.getReportLevelDivision(h));
					} else
				if (orgLevel.equals("2")) {
					h.put("orgCode", orgCode);
					h.put("reportYear", rForm.getReportYear());
					h.put("reportPeriode", rForm.getReportPeriode());
					h.put("reportMonth", rForm.getReportMonth());
					rForm.setOrganizationCode(orgCode.toString());
					rForm.setOrganizationLevel(orgLevel.toString());
					rForm.setOrganizationName(orgName);
					rForm.setCountRecord(rMan.countReportDepartment(h));
					rForm.setListReports(rMan.getReportLevelDepartment(h));
				}
			}	
		
		if (rForm.getCountRecord() == 0) {
			rForm.setMaxpage(1);
		} else if (rForm.getCountRecord() % 10 == 0) {
			rForm.setMaxpage((int) Math.ceil(rForm.getCountRecord() / 10));
		} else {
			rForm.setMaxpage(((int) Math.ceil(rForm.getCountRecord() / 10)) + 1);
		}
		return mapping.findForward("ViewLevel2");
	}
}
