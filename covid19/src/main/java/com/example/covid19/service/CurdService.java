package com.example.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.example.covid19.mailService.SendMail;
import com.example.covid19.mailServiceAlternate.ReportMail;
import com.example.covid19.model.Contributer;
import com.example.covid19.model.Donation;
import com.example.covid19.repository.CrudRepository;
import com.example.covid19.repository.DonationRepository;

@Service
@PropertySource("classpath:project.properties")
public class CurdService {
	
	@Autowired
	private CrudRepository crudRepository;
	
	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private SendMail sendMail;
	
	@Autowired
	private ReportMail reportMail;
	@Value("${maillingLists}")
	private String mailList; 
	private String subject="COVID 19 Helping Hand";
	private String mailServer ="smtp.gmail.com";
	private int mailPort =587;
	private String mailAdmin="tapanachary.44@gmail.com";
	

	
	//Contribution services
	public Contributer saveContributerDetails(Contributer contributer){						
		Contributer response = crudRepository.save(contributer);
		
		if((response!=null) && response.getMail().equals(contributer.getMail())) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					sendMail.sendMailtoIndivisualContributer(contributer);	 			
				}			
			});
			t1.start(); 
		}
		return response;
	}
	
	public List<Contributer> getAllContributerDetails() {
		return crudRepository.findAll();		
	}
	
	
	//Donation services
	
	public Donation saveDonationDetails(Donation donation) {
		Donation response = donationRepository.save(donation);
		if((response!=null) && response.getDname().equals(donation.getDname())) {
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					sendMail.sendMailtoAllContributers(mailList.toString(), donation);	 			
				}			
			});
			t2.start(); 
		}
		return response;		
	}
	
	public List<Donation> getAllDonationDetails(){
		return donationRepository.findAll();
		
	}
	
	public List<Contributer> getIndivisualContribution(String email){
		return crudRepository.findByMail(email);			
	}

}
