package com.desafio.criptografia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.criptografia.entity.Card;
import com.desafio.criptografia.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;

	private BCryptPasswordEncoder cripto = new BCryptPasswordEncoder();

	public ResponseEntity<?> createdCard(Card card) {
		if (!card.getUserDocument().isEmpty() && !card.getCreditCardToken().isEmpty() && card.getValue() != null) {
			Card instCard = new Card(cripto.encode(card.getUserDocument()), cripto.encode(card.getCreditCardToken()),
					card.getValue());
			return new ResponseEntity<>(cardRepository.save(instCard), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error while created card", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> readCards(){
		
		List<Card> read = cardRepository.findAll();
		if(!read.isEmpty()) {
			return new ResponseEntity<>(read, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<?> updateCard(Card card){
		Card search = cardRepository.findById(card.getId()).orElse(null);
		if(search != null) {
			search.setUserDocument(cripto.encode(card.getUserDocument()));
			search.setCreditCardToken(cripto.encode(card.getCreditCardToken()));
			search.setValue(card.getValue());
			return new ResponseEntity<>(cardRepository.save(search), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public void deleteCard(Long id) {
		cardRepository.deleteById(id);
	}

}
