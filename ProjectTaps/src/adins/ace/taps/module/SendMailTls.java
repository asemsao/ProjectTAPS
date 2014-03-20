package adins.ace.taps.module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
	public static void SendMail(Map params) {
		final String username = App.getConfiguration("mail.name");
		final String password = App.getConfiguration("mail.password");

		String toMail = params.get("toMail").toString();
		String assignmentType = params.get("assignmentType").toString();
		String phase = params.get("phase").toString();
		String taskCode = params.get("taskCode").toString();
		String fromEmployee = params.get("fromEmployee").toString();
		String nameReceiver = params.get("nameReceiver").toString();

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

		String user = nameReceiver;
		String linkemp = App.getConfiguration("linkemp");
		String linkspv = App.getConfiguration("linkspv");
		String linktaps = App.getConfiguration("linktaps");

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
		if (phase.equalsIgnoreCase("RFA") && assignmentType.equalsIgnoreCase("self assignment")) {
			contentMail += "Created by";
		} else if (phase.equalsIgnoreCase("RFA") && assignmentType.equalsIgnoreCase("assignment")) {
			contentMail += "Assign to";
		} else {
			contentMail += "Assign by";
		}
		contentMail += "</td>";
		contentMail += "<td>:</td>";
		contentMail += "<td>";
//		if (phase.equalsIgnoreCase("RFA")) {
//			contentMail += "Nama Supervisor";
//		} else {
			contentMail += fromEmployee;
//		}
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
			contentMail += "<a href='" + linkspv
					+ "' target='_blank'>this link</a>";
		} else {
			contentMail += "<a href='" + linkemp
					+ "' target='_blank'>this link</a>";
		}

		contentMail += "&nbsp;or login to <a href='" + linktaps
				+ "' target='_blank'>TAPS</a> ";
		contentMail += "for assignment detail.</p>";

		contentMail += "<p>We hope this information is useful for you.<br>";
		contentMail += "Thank you.</p>";
		contentMail += "<p>Best regards,<br>";
		contentMail += "<b>Timesheet and Performance Score (TAPS)</b><br>";
		contentMail += "PT Adicipta Inovasi Teknologi";
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

			System.out.println("Done to send message");
		} catch (MessagingException e) {
			System.out.println("Failed to send message");
		}
	}
}
