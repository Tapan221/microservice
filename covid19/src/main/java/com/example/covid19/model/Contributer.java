package com.example.covid19.model;
import java.io.File;
import java.net.URL;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Contributer {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;	
	private String name;
	private Date date;
	private long amount;
	private String phone;
	private String mail;
	private String paymentUrls;
	
	
	
	public Contributer(int id, String name, Date date, long amount, String phone, String mail, String paymentUrls) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.amount = amount;
		this.phone = phone;
		this.mail = mail;
		this.paymentUrls = paymentUrls;
	}
	
	
	public Contributer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPaymentUrls() {
		return paymentUrls;
	}
	public void setPaymentUrls(String paymentUrls) {
		this.paymentUrls = paymentUrls;
	}
	public double getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Contributer [id=" + id + ", name=" + name + ", date=" + date + ", amount=" + amount + ", phone=" + phone
				+ ", mail=" + mail + ", paymentUrls=" + paymentUrls + "]";
	}
	
	

}
