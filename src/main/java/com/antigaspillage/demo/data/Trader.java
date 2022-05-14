package com.antigaspillage.demo.data;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
public class Trader {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private User user;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String location;
	
	private Timestamp addDate;
	
	private String description;
	
	public Trader(User user, String companyName, String location, String description, Timestamp addDate) {
		super();
		this.user = user;
		this.companyName = companyName;
		this.location = location;
		this.description = description;
		this.addDate=addDate;
	}
	
	public Trader() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long idTrader) {
		this.id = idTrader;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getAddDate() {
		return addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
