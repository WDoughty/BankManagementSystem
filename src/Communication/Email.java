package Communication;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email implements EmailInterface {

    public boolean SendEmail(String to, String update){
        String username = "bankmanagementtest@gmail.com";
        String password = "bankManagementTest";
        String host = "smtp.gmail.com";

        Properties props = System.getProperties();
        props.put("mail.host",host);
        props.put("mail.transport.protocol","smtp");
        //props.put("mail.stmp.port","587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");



        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Bank Management System");
            message.setText(update);
            Transport t = session.getTransport("smtps");
            //t.connect();
            t.connect(host,username,password);
            t.sendMessage(message,message.getAllRecipients());


        } catch (AddressException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
