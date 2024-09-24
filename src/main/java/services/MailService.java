/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author steph18
 */
public class MailService {

    public static final String FROM = "stephaneatsu18@gmail.com";
    public static final String USERNAME = "stephaneatsu18@gmail.com";
    public static final String HOST = "smtp.gmail.com";
    public static final String PASSWORD = "lgpu lqaf dbyc uuqf ";
    public static final String TYPE = "text/html; charset=utf-8";

    public static boolean sendMail(String userMail, String subject, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.debug", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
            message.setSubject(subject);
            message.setContent(content, TYPE);
            message.setSentDate(new Date());
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            return false;
        }
    }

    public static boolean sendMultipleMail(String subject, String content,
            List<String> userMails) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.debug", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setSubject(subject);
            message.setContent(content, TYPE);
            message.setSentDate(new Date());
            for (String userMail : userMails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
                Transport.send(message);
            }
            return true;
        } catch (MessagingException mex) {
            return false;
        }
    }

}
