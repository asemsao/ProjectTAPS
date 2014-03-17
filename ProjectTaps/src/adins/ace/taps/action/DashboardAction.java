package adins.ace.taps.action;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import adins.ace.taps.bean.dashboard.DashboardBean;
import adins.ace.taps.bean.employee.NewEmployeeBean;
import adins.ace.taps.form.dashboard.DashboardForm;
import adins.ace.taps.manager.DashboardManager;

public class DashboardAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DashboardForm dForm = (DashboardForm) form;
		DashboardManager dMan = new DashboardManager();
		
		if("approval".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("claim".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("claimSelf".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("correction".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} else if("correctionSelf".equals(dForm.getTask())){
			return mapping.findForward("ListAssignment");
		} 
		
		if ("getPhoto".equals(dForm.getTask())) {
			DashboardBean bean = new DashboardBean();
			bean = dMan.getPhotoEmployees(dForm.getEmployeeDomain());
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			OutputStream outStream = response.getOutputStream();

			try {
				response.setContentType("image/*");
				try {
					output = new BufferedOutputStream(outStream);
					System.out.println("sampai sini 1");
					byte[] buffer = bean.getProfilePicture();
					if (buffer == null) {
						buffer = extractBytes("/images/user.png");
					}
					System.out.println("sampai sini 2");
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
				System.out.println("catch 2");
			}
		}
		System.out.println(dForm.getTask()+"asadasdasda");
		System.out.println(dForm.getEmployeeDomain()+"dpamasadad");
		dForm.setListTopTen(dMan.searchTopTen());
		dForm.setListTopTenOrganization(dMan.searchTopTenOrganization("CDD"));
		return mapping.findForward("Dashboard");
	}
	
	/*extract image in project resources to byte[]*/
	public byte[] extractBytes (String ImageName) throws IOException {
		File fnew = null;
		fnew = new File(getServlet().getServletContext().getRealPath("/")+"images/user.png");
		
		BufferedImage bufferedImage = ImageIO.read(fnew);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bufferedImage, "png", baos);
	    byte[] res=baos.toByteArray();
	    return res;
	}
}
