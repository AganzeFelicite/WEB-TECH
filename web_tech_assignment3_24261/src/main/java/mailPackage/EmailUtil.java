package mailPackage;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.activation.ataHandler;

public class EmailUtil {
    
	public static void sendMail(String emailAddress) throws Exception {
   // Set up email account credentials
      String host = "smtp.gmail.com";
      String username = "katumukunde.anetti@gmail.com";
      String password = "ojtnwsxyboermqka";
      
      // Set up email message properties
      String to = emailAddress;
      String from = "your_email@gmail.com";
      String subject = "Test email";
      String body = "Test JavaMail API.";

      // Set up email session properties
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.port", "587");

      // Create a Session object
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a message object and set its properties
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));
         message.setSubject("Registration is successfull your information is being processed");
         message.setText(body);

         // Send the email message
         Transport.send(message);

         System.out.println("Email sent successfully!");
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
    }
}
