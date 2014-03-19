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
	public static void SendMail(String toMail, String assignmentType, String phase, 
			String taskCode, String fromEmployee, String nameReceiver){
		final String username = App.getConfiguration("mail.name"); 
		final String password = App.getConfiguration("mail.password"); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date()); 
		
		String subject = assignmentType+" - "+taskCode;
		String contentMail = "";
		if (phase.equals("RFA")) {
			contentMail = "Dear "+nameReceiver+",\n\n"+assignmentType+" "+
					taskCode+" has been REQUESTED FOR APPROVAL by "
					+fromEmployee+" on "+date+"\n\n ";
		}else{
			contentMail = "Dear "+nameReceiver+",\n\n"+assignmentType+" "+taskCode+" has been "+phase+"ED by "
					+fromEmployee+" on "+date+"\n\n ";
		}
		String step = "to complete this task \n"+
				"1. Review this task on TAPS \n"+
				"2. Perform the specific activities required for this task\n";
		if (phase.equalsIgnoreCase("reject") || phase.equalsIgnoreCase("approve")) {
				
		}else{
			contentMail = contentMail+step;
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", App.getConfiguration("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", App.getConfiguration("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", App.getConfiguration("mail.smtp.host"));
		props.put("mail.smtp.port", App.getConfiguration("mail.smtp.port"));
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setText(contentMail);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
//			try {
//				throw new Exception("failed to send message");
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
			System.out.println("failed to send message");
		}
	}
}
