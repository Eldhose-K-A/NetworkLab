import java.net.*;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import activation.*;

class Mailer{
	public static void main(String args[]){
	try{
		final String emailid="websitedemopage@gmail.com";
		final String password="password";
		final String to="eldhoseka.kuzhimalayil@gmail.com";

		Properties p1 = System.getProperties();
		p1.put("mail.smtp.starttls.enable","true");
		p1.put("mail.smtp.host","smtp.gmail.com");
		p1.put("mail.smtp.port","587");
		p1.put("mail.smtp.auth","true");
		p1.put("mail.smtp.user",emailid);
		p1.put("mail.smtp.password",password);
		p1.put("mail.smtp.ssl.trust","smtp.gmail.com");

		Session s1 = Session.getDefaultInstance(p1);
		MimeMessage msg = new MimeMessage(s1);

		msg.setFrom(new InternetAddress(emailid));
		msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		msg.setSubject("Demo Mail");
		msg.setText("This is a mail from JAVA Program");

		Transport tp1 = s1.getTransport("smtp");
		tp1.connect("smtp.gmail.com",emailid,password);
		tp1.sendMessage(msg,msg.getAllRecipients());
		tp1.close();
		System.out.println("Mail Send!........");

	}catch(Exception e){
		System.out.println("Error\n-------------------------------------------------------------");
		e.printStackTrace();
	}
	}
}
