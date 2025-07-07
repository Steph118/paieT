/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.EmailConfig;
import enumeration.EmailProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.interfaces.EmailConfigServiceLocal;

/**
 *
 * @author steph18
 */
@ApplicationScoped
@Transactional
public class MailSenderService {

    public static final String TYPE = "text/html; charset=utf-8";
    public static final Logger LOGGER = Logger.getLogger(MailSenderService.class.getName());

    @Inject
    private MailTemplateService mailTemplateService;

    @Inject
    private EmailConfigServiceLocal emailConfigService;

    public void sendMail(EmailProvider provider, String to, String subject, String templateName,
            Map<String, String> variables) {
        Optional<EmailConfig> emailConfig
                = this.emailConfigService.findByActiveAndProvider(provider);
        emailConfig.ifPresentOrElse(
                (config) -> {
                    this.process(config, to, subject, templateName, variables);
                },
                () -> {
                    throw new IllegalStateException("Configuration mail non active ou inexistant pour le fournisseur.");
                }
        );

    }

    private void process(EmailConfig config, String to, String subject, String templateName,
            Map<String, String> variables) {
        try {
            LOGGER.log(Level.INFO, "Process mail starting");
            Session session = this.createSessionConfig(config);
            LOGGER.log(Level.INFO, "Session mail create");
            String htmlContent = this.mailTemplateService.processTemplate(templateName, variables);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.getDefaultFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(htmlContent, TYPE);
            message.setSentDate(new Date());
            LOGGER.log(Level.INFO, "MimeMessage to send");
            Transport.send(message);
            LOGGER.log(Level.INFO, "Mail send...");
        } catch (MessagingException | IOException mex) {
            throw new IllegalStateException(mex);
        }

    }

//    //public static final String FROM = "stephaneatsu18@gmail.com";
//    public static final String USERNAME = "stephaneatsu18@gmail.com";
//    public static final String HOST = "smtp.gmail.com";
//    public static final String PASSWORD = "lgpu lqaf dbyc uuqf ";
//    public static final String TYPE = "text/html; charset=utf-8";
//
//    public static boolean sendMail(String userMail, String subject, String content) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", HOST);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.debug", "true");
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(USERNAME, PASSWORD);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(USERNAME));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
//            message.setSubject(subject);
//            message.setContent(content, TYPE);
//            message.setSentDate(new Date());
//            Transport.send(message);
//            return true;
//        } catch (MessagingException mex) {
//            return false;
//        }
//    }
//
//    public static boolean sendMultipleMail(String subject, String content,
//            List<String> userMails) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", HOST);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.debug", "true");
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(USERNAME, PASSWORD);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(USERNAME));
//            message.setSubject(subject);
//            message.setContent(content, TYPE);
//            message.setSentDate(new Date());
//            for (String userMail : userMails) {
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
//                Transport.send(message);
//            }
//            return true;
//        } catch (MessagingException mex) {
//            return false;
//        }
//    }
    private Session createSessionConfig(EmailConfig config) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", config.getHost());
        properties.put("mail.smtp.auth", config.isAuthEnabled());
        properties.put("mail.smtp.starttls.enable", config.isSslEnabled());
        properties.put("mail.smtp.port", config.getPort());
        properties.put("mail.debug", true);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getUsername(), config.getPassword());
            }
        });
    }
}
