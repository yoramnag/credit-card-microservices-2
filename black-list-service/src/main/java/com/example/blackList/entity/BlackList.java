package com.example.blackList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlackList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="credit_card")
	private String creditCard;
	
	@Column(name="mask_credit_card")
	private String maskCreditCard;
	
	private String environment;

	public BlackList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlackList(int id, String creditCard, String maskCreditCard) {
		super();
		this.id = id;
		this.creditCard = creditCard;
		this.maskCreditCard = maskCreditCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getMaskCreditCard() {
		return maskCreditCard;
	}

	public void setMaskCreditCard(String maskCreditCard) {
		this.maskCreditCard = maskCreditCard;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "BlackList [id=" + id + ", creditCard=" + creditCard + ", maskCreditCard=" + maskCreditCard + "]";
	}

}
