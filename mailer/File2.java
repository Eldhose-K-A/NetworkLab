import java.io.*;
import java.net.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class File2{

public static void main(String args[]){
	Scanner sc1 = new Scanner(System.in);
	System.out.print("Enter Sender mail ID : ");
	String from = sc1.nextLine();
	System.out.print("Enter Sender mail ID : ");
	String pass = sc1.nextLine();
	//String pass="password";
	System.out.print("Enter Receiver mail ID : ");
	String r1 = sc1.nextLine();
	String to[] = { r1 };
	System.out.print("Enter Subject : ");
	String subject = sc1.nextLine();
	System.out.print("Enter Body    : ");
	String body = sc1.nextLine();
	sendFromGmail(from,pass,to,subject,body);
}
private static void sendFromGmail(String from,String pass,String[] to,String subject,String body){
	Properties p1 = System.getProperties();
	String host = "smtp.gmail.com";
	p1.put("mail.smtp.starttls.enable","true");
	p1.put("mail.smtp.host",host);
	p1.put("mail.smtp.port","587");
	p1.put("mail.smtp.auth","true");
	p1.put("mail.smtp.user",from);
	p1.put("mail.smtp.password",pass);
	p1.put("mail.smtp.ssl.trust","smtp.gmail.com");

	Session s1 = Session.getDefaultInstance(p1);
	MimeMessage msg = new MimeMessage(s1);

	try{
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] toAddress = new InternetAddress[to.length];

		for(int i=0;i<to.length;++i)
			toAddress[i] = new InternetAddress(to[i]);
		for(int i=0;i<toAddress.length;++i)
			msg.addRecipient(Message.RecipientType.TO,toAddress[i]);


		//msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to[0]));
		msg.setSubject(subject);
		msg.setText(body);
		
		Transport tp1 = s1.getTransport("smtp");
		tp1.connect(host,from,pass);
		tp1.sendMessage(msg,msg.getAllRecipients());
		tp1.close();
	}catch(AddressException ae){
		ae.printStackTrace();
	}catch(MessagingException me){
		me.printStackTrace();
	}
}
}
