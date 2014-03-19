package adins.ace.taps.module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import adins.ace.taps.configuration.App;

public class SendMailTls {
	public static void SendMail(String toMail, String assignmentType,
			String phase, String taskCode, String fromEmployee) {
		final String username = App.getConfiguration("mail.name");
		final String password = App.getConfiguration("mail.password");

		Properties props = new Properties();
		props.put("mail.smtp.auth", App.getConfiguration("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable",
				App.getConfiguration("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", App.getConfiguration("mail.smtp.host"));
		props.put("mail.smtp.port", App.getConfiguration("mail.smtp.port"));

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		String subject = "TAPS - " + assignmentType + " " + taskCode;

		String user = "Meyliana Tanjung";
		String linkemp = "http://localhost:8084/ProjectTaps/employeeReport.do";
		String linkspv = "http://localhost:8084/ProjectTaps/employeeReportSupervisor.do";

		String contentMail = "<html><body>";
		contentMail += "<h3>Dear " + user + "</h3><br>";

		if (phase.equalsIgnoreCase("CLAIM")) {
			contentMail += "<p>You've got a NEW ASSIGNMENT.</p>";
		}
		if (phase.equalsIgnoreCase("CORRECTION")) {
			contentMail += "<p>You've got a CORRECTION for your assignment.</p>";
		}
		if (phase.equalsIgnoreCase("APPROVED")) {
			contentMail += "<p>Congratulation, your assignment has been APPROVED.</p>";
		}
		if (phase.equalsIgnoreCase("REJECTED")) {
			contentMail += "<p>Sorry, your assignment has been REJECTED.</p>";
		}
		if (phase.equalsIgnoreCase("RFA")) {
			contentMail += "<p>You've got a NEW ASSIGNMENT which need approval.</p>";
		}

		contentMail += "<table>";

		contentMail += "<tr>";
		contentMail += "<td colspan=3>";
		contentMail += "This is the assignment's detail";
		contentMail += "</td>";
		contentMail += "</tr>";

		contentMail += "<tr>";
		contentMail += "<td>";
		contentMail += "Task Code";
		contentMail += "</td>";
		contentMail += "<td>:</td>";
		contentMail += "<td>";
		contentMail += assignmentType + " " + taskCode;
		contentMail += "</td>";
		contentMail += "</tr>";

		contentMail += "<tr>";
		contentMail += "<td>";
		if (phase.equalsIgnoreCase("RFA")) {
			contentMail += "Assign to";
		} else {
			contentMail += "Assign by";
		}
		contentMail += "</td>";
		contentMail += "<td>:</td>";
		contentMail += "<td>";
		if (phase.equalsIgnoreCase("RFA")) {
			contentMail += "Nama Supervisor";
		} else {
			contentMail += fromEmployee;
		}
		contentMail += "</td>";
		contentMail += "</tr>";

		contentMail += "<tr>";
		contentMail += "<td>";
		contentMail += "Assignment Date";
		contentMail += "</td>";
		contentMail += "<td>:</td>";
		contentMail += "<td>";
		contentMail += date;
		contentMail += "</td>";
		contentMail += "</tr>";

		contentMail += "</table><br>";

		contentMail += "<p>For more detail, please click in this ";
		if (phase.equalsIgnoreCase("RFA")) {
			contentMail += "<a href='" + linkspv + "' target='_blank'>this</a>";
		} else {
			contentMail += "<a href='" + linkemp + "' target='_blank'>this</a>";
		}
		contentMail += ".</p>";

		contentMail += "<p>We hope this information is useful for you.<br>";
		contentMail += "Thank you.</p>";
		contentMail += "<p>Best regards,<br>";
		contentMail += "<b>Timesheet and Performance Score (TAPS)</b><br>";
		contentMail += "PT Adicipta Inovasi Teknology";
		contentMail += "</p>";
		contentMail += "</body></html>";

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setContent(contentMail, "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			// try {
			// throw new Exception("failed to send message");
			// } catch (Exception e1) {
			// e1.printStackTrace();
			// }
			System.out.println("failed to send message");
		}
	}
}
