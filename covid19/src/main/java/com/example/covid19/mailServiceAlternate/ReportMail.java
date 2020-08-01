package com.example.covid19.mailServiceAlternate;

import java.util.ArrayList;
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Component;
 
@Component 
public class ReportMail {  
 
    private MimeMessage message = null;
    private Session emailSession = null;
    private MimeBodyPart textPart = null;
    private ArrayList<MimeBodyPart> attachmentArray = null;
 
    public void sendMailer(String[] mailToId, String subject, String mailServer1,
            int mailPort, String mailAdmin) {
        Properties mailProperties = null;
        mailProperties = new Properties();
 
        String adminEmailId = mailAdmin;
        String mailServer = mailServer1;
        mailProperties.put("mail.transport.protocol", "smtp");
        //mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.host", mailServer);
        mailProperties.put("mail.from", adminEmailId);
        mailProperties.put("mail.smtp.port", mailPort);
        mailProperties.put("mail.to", mailToId);
        mailProperties.put("mail.smtp.starttls.enable", true);
        mailProperties.put("mail.smtp.starttls.required", true);
        mailProperties.put("mail.username", adminEmailId);
        mailProperties.put("mail.password", "Siemens@12345");
 
 
        try {
            emailSession = Session.getInstance(mailProperties);
            emailSession.setDebug(false);
 
            message = new MimeMessage(emailSession);
            textPart = new MimeBodyPart();
            attachmentArray = new ArrayList<MimeBodyPart>(2);
            for(int i=0;i<mailToId.length;i++){
                message.addRecipients(RecipientType.TO, mailToId[i]);
            }
            message.setSubject(subject);
            message.setFrom(new InternetAddress(adminEmailId));
 
            setContent("<a href=\"file://tambe3/report/emailable-report.html\""
               + " target=\"_blank\">PCM Automation Report</a>");
            //setContent("test123");
            sendEMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private void setContent(String content) {
        try {
            textPart.setContent(content, "text/html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private boolean sendEMail() throws Exception {
        try {
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(textPart);
            for (int i = 0; i < attachmentArray.size(); i++)
                mp.addBodyPart(attachmentArray.get(i));
 
            /********************
             * 
             */
            // Part two is attachment
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart = new MimeBodyPart();
 
            messageBodyPart.setText("Below is the link for the Test"
               + " Automation report as link & attached Log file. PFA.");
            //mp.addBodyPart(messageBodyPart);
 
            String filename = "logfile.log"; //C:\workspacePCMSanity\PCMSanity\logfile.log
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
 
            mp.addBodyPart(messageBodyPart);
            /**
             * 
             */
            message.setContent(mp);
 
            Transport transport = emailSession.getTransport();
            transport.connect();
            transport.sendMessage(message,
               message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
 
            throw e;
        }
        return true;
    }
}