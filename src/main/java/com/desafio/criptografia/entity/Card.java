package com.desafio.criptografia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userDocument;
	private String creditCardToken;
	private Long value;
	
	public Card() {
	}
	
	public Card(Long id, String userDocument, String creditCardToken, Long value) {
		this.id = id;
		this.userDocument = userDocument;
		this.creditCardToken = creditCardToken;
		this.value = value;
	}
	
	public Card(String userDocument, String creditCardToken, Long value) {
		this.userDocument = userDocument;
		this.creditCardToken = creditCardToken;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserDocument() {
		return userDocument;
	}

	public void setUserDocument(String userDocument) {
		this.userDocument = userDocument;
	}

	public String getCreditCardToken() {
		return creditCardToken;
	}

	public void setCreditCardToken(String creditCardToken) {
		this.creditCardToken = creditCardToken;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
	

}
