import java.io.*;
import java.net.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class File3 {

   

    public static void main(String[] args) throws Exception
	{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user gmail id"); // your gmail id (just username before @gmail.com
		String from = (br.readLine());
		System.out.println("Enter the password"); // your gmail password
		String pass = (br.readLine()); 
		System.out.println("Enter the recipient mail");   // full email id of receiver
        String RECIPIENT = (br.readLine());
        String[] to = { RECIPIENT }; // list of recipient email addresses
		System.out.println("Enter subject for mail");
		String subject = (br.readLine());
		System.out.println("Enter body of the mail");
		String body = br.readLine();
        
        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
