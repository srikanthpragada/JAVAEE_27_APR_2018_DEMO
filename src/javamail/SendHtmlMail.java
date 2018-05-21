package javamail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHtmlMail {

   public static void main(String args[])
   {
        Properties props = System.getProperties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            // construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("jerry@demo.com"));
            msg.setRecipient(Message.RecipientType.TO, 
            		new InternetAddress("tom@demo.com"));
            msg.setDataHandler( new DataHandler("<h1>Good Evening</h1>", "text/html"));
            msg.setSubject("Test");
            msg.setSentDate(new Date());
            Transport.send(msg);    // send message
        } catch (Exception ex) {
            System.out.println("<h2>Error --> " + ex.getMessage() + "</h2>");
        }

    }

}
