package com.beingjavaguys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class UserAddress {

	@Id
	@GeneratedValue
	@Column(name = "hId")
	private long h_Id;
	
	@Column(name = "hno")
	private String h_no;
	
	@Column(name = "hlocal")
	private String h_local;
	
	@Column(name = "hstreet")
	private String h_street;
	
	@Column(name = "hcity")
	private String h_city;
	
	@Column(name = "hstate")
	private String h_state;
	
	@Column(name = "hpin")
	private int h_pin;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getH_state() {
		return h_state;
	}
	public void setH_state(String h_state) {
		this.h_state = h_state;
	}
	public int getH_pin() {
		return h_pin;
	}
	public void setH_pin(int h_pin) {
		this.h_pin = h_pin;
	}
	public String getH_city() {
		return h_city;
	}
	public void setH_city(String h_city) {
		this.h_city = h_city;
	}
	public String getH_street() {
		return h_street;
	}
	public void setH_street(String h_street) {
		this.h_street = h_street;
	}
	public String getH_local() {
		return h_local;
	}
	public void setH_local(String h_local) {
		this.h_local = h_local;
	}
	public String getH_no() {
		return h_no;
	}
	public void setH_no(String h_no) {
		this.h_no = h_no;
	}
	public long getH_Id() {
		return h_Id;
	}
	public void setH_Id(long h_Id) {
		this.h_Id = h_Id;
	}

}
