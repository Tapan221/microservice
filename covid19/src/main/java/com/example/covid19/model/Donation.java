package com.example.covid19.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Donation {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;	
	private String dname;
	private Date ddate;
	private long damount;
	private String dphone;
	private String dmail;
	private String dpaymentUrls;
	private String dreason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	public long getDamount() {
		return damount;
	}
	public void setDamount(long damount) {
		this.damount = damount;
	}
	public String getDphone() {
		return dphone;
	}
	public void setDphone(String dphone) {
		this.dphone = dphone;
	}
	public String getDmail() {
		return dmail;
	}
	public void setDmail(String dmail) {
		this.dmail = dmail;
	}
	public String getDpaymentUrls() {
		return dpaymentUrls;
	}
	public void setDpaymentUrls(String dpaymentUrls) {
		this.dpaymentUrls = dpaymentUrls;
	}
	public String getDreason() {
		return dreason;
	}
	public void setDreason(String dreason) {
		this.dreason = dreason;
	}
	public Donation(int id, String dname, Date ddate, long damount, String dphone, String dmail, String dpaymentUrls,
			String dreason) {
		super();
		this.id = id;
		this.dname = dname;
		this.ddate = ddate;
		this.damount = damount;
		this.dphone = dphone;
		this.dmail = dmail;
		this.dpaymentUrls = dpaymentUrls;
		this.dreason = dreason;
	}
	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Donation [id=" + id + ", dname=" + dname + ", ddate=" + ddate + ", damount=" + damount + ", dphone="
				+ dphone + ", dmail=" + dmail + ", dpaymentUrls=" + dpaymentUrls + ", dreason=" + dreason + "]";
	}

	
	
	

}
