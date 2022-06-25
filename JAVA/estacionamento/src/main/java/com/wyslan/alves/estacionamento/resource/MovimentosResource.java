package com.wyslan.alves.estacionamento.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyslan.alves.estacionamento.model.Movimentacao;
import com.wyslan.alves.estacionamento.service.MovimentosService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class MovimentosResource {
	
	@Autowired
	private MovimentosService service;
	
	@GetMapping
	public Object home() {
		return service.home();
	}
	
	@PostMapping
	public Object salvar(@RequestBody Movimentacao movimentacao) {
		
		movimentacao.setDataEntrada(LocalDate.now());
		movimentacao.setHoraEntrada(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
		
		System.out.println(movimentacao.getHoraEntrada());
		System.out.println(movimentacao.getDataEntrada());
		
		return service.salvar(movimentacao);
		
	}
	
	@GetMapping(path = "/{id_movimento}", produces = "application/json")
	public ResponseEntity<Object> findId(@PathVariable("id_movimento") Long id) {
		try {
			return ResponseEntity.ok(service.findId(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id_movimento}")
	public Object editar(@PathVariable("id_movimento") Long id, @RequestBody @Valid Movimentacao movimentacao) {
		return service.edicao(id, movimentacao);
	}
	
	@GetMapping(path = "/saida/{id_movimento}", produces = "application/json")
	public ResponseEntity<Object> saidaVeiculoInfo(@PathVariable("id_movimento") Long id) {
		try {
			return ResponseEntity.ok(service.findIdSaidaVeiculoInfo(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PutMapping("/saida/{id_movimento}")
	public Object efetuarSaida(@PathVariable("id_movimento") Long id) {
		return service.efetuarSaidaVeiculo(id);
	}
	
	
}
