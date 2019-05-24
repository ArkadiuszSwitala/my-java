package com.company.helper;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

    private Properties props;
    private String username;
    private String password;

    public Mailer() {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        username = "palkarzm@gmail.com";
        password = "nibeben89";
    }

    public void send(String toMail, String message) {
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress("palkarzm@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toMail, false));
            msg.setSubject("Witaj");
            msg.setText(message);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Wiadmość wysłana.");
        } catch (MessagingException e) {
            System.out.println("Błąd wysyłki: " + e);
        }
    }
}
