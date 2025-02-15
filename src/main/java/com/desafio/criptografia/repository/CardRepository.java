package com.desafio.criptografia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.criptografia.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
