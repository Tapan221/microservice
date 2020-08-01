package com.example.covid19.mailService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.covid19.model.Contributer;
import com.example.covid19.model.Donation;

@Component
public class SendMail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMailtoAllContributers(String toMails, Donation donation) {
		try {			
			SimpleMailMessage mailMessgae = new SimpleMailMessage();
			mailMessgae.setFrom("noreply@covid19helpingHand.com");
			mailMessgae.setSubject("Donation made towards COVID19 sufferers");
			mailMessgae.setText("Dear All,"+"\n\n"
			+"We made a donation to Mr/Mrs " +donation.getDname()+" of rupees "+donation.getDamount()+" on "+ donation.getDdate()
			+".\n\n"+"Reason for Donation:\n"+donation.getDreason()+"\n\n"+"Donation Details:"+"\n"+
			"DONATION TO: "+donation.getDname()+"\n"+
			"DONATION AMOUNT: "+donation.getDamount()+"\n"+
			"CONTACT Details: "+donation.getDphone()+"\n"+
			"PAYMENT URL: "+donation.getDpaymentUrls()+"\n\n"+
			"Best Regards\n"+
			"HELPING HANDS GROUP"
					);						
			String[] allMails = toMails.split(",");			
			for(String mail: allMails) {
				mailMessgae.setTo(mail);
				javaMailSender.send(mailMessgae);
			}
			System.out.println("mail sent to all mailing groups");			
		}catch (Exception e) {
			System.out.print(e.fillInStackTrace());
			System.out.println("Error in Sending mails");
		}
		finally {			
		}	
	}	
	public void sendMailtoIndivisualContributer(Contributer contributer)  {
		try {			
			SimpleMailMessage mailMessgae = new SimpleMailMessage();
			mailMessgae.setFrom("noreply@covid19helpingHand.com");
			mailMessgae.setTo(contributer.getMail());
			mailMessgae.setSubject("Thanks for your Contribution towards COVID19 sufferers");				
			mailMessgae.setText("Dear "+contributer.getName()+"\n"+"\n"
					+"We have received a payment of Rs "+contributer.getAmount()+".\n"
					+"Your small contribution makes a big difference....."+"\n"+"\n"
					+"Best Regards"+"\n"
					+"HELPING HANDS GROUP");	
			javaMailSender.send(mailMessgae);
			
		}catch (Exception e) {
			System.out.print(e.fillInStackTrace());
			System.out.println("Mail did not sent");
		}
		finally {
			
		}	
	}
	
	
	
	
}
