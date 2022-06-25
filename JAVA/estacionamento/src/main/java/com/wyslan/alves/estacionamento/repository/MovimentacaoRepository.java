package com.wyslan.alves.estacionamento.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wyslan.alves.estacionamento.model.Movimentacao;

@Repository
@Transactional
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	
	
}
