package com.desafio.criptografia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.criptografia.entity.Card;
import com.desafio.criptografia.service.CardService;

@RestController
@RequestMapping("/")
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@GetMapping
	public ResponseEntity<?> readCards(){
		return cardService.readCards();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createdCard(@RequestBody Card card){
		return cardService.createdCard(card);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCard(@RequestBody Card card){
		return cardService.updateCard(card);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCard(@PathVariable Long id) {
		cardService.deleteCard(id);
	}

}
