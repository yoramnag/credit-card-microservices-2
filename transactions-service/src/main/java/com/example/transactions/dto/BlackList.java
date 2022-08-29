package com.example.transactions.dto;

public class BlackList {
	
	private int id;
	
	private String creditCard;

	private String maskCreditCard;
	
	private String environment;

	public BlackList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlackList(int id, String creditCard, String maskCreditCard, String environment) {
		super();
		this.id = id;
		this.creditCard = creditCard;
		this.maskCreditCard = maskCreditCard;
		this.environment = environment;
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
		return "BlackList [id=" + id + ", creditCard=" + creditCard + ", maskCreditCard=" + maskCreditCard
				+ ", environment=" + environment + "]";
	}
	
	

	

}
