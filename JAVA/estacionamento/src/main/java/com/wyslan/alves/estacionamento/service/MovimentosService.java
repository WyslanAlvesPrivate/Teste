package com.wyslan.alves.estacionamento.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.wyslan.alves.estacionamento.model.Movimentacao;
import com.wyslan.alves.estacionamento.repository.MovimentacaoRepository;

@Service
public class MovimentosService {

	@Autowired
	private MovimentacaoRepository repository;
	
	public Object home() {
		
		var view = new ModelAndView("index.html");
		
		List<Movimentacao> movimentos = repository.findAll();
		
		List<Movimentacao> garagem = new ArrayList<Movimentacao>(); 
		List<Movimentacao> saiu = new ArrayList<Movimentacao>();;
		
		for(Movimentacao movimento : movimentos) {
			if(movimento.isSaiu() == false) {
				garagem.add(movimento);
			} else {
				saiu.add(movimento);
			}
		}
		
		view.addObject("movimentos", garagem);
		view.addObject("movimentosSaidos", saiu);
	
		return view;
		
	}
	
	public Object findId(Long id) {
		
		var movimentacao = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		
		return movimentacao;
		
	}
	
	public Object edicao(long id, Movimentacao movimentacaoNova) {
		
		var movimentacaoOld = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		
		BeanUtils.copyProperties(movimentacaoNova, movimentacaoOld, "id");
		
		repository.save(movimentacaoOld); 
		
		return home();
		
	}

	public Object salvar(@Valid Movimentacao movimentacao) {
		
		repository.save(movimentacao);
		
		return home();
		
	}

	public Object findIdSaidaVeiculoInfo(Long id) {

		
		/**
		 * obs: o calculo é arrendondado, logo sera contato apenas horas e não minutos
		 */
		
		var movimentacao = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		
		var dataAtual = LocalDate.now();
		
		var horaAtual = LocalTime.now().format(DateTimeFormatter.ofPattern("hh"));
		
		var horaEntradaApenasHora = movimentacao.getHoraEntrada().split(":")[0];
		
		var diasEntreDatas = movimentacao.getDataEntrada().until(dataAtual, ChronoUnit.DAYS);
		
		var horasDeDiasEntreDatas = diasEntreDatas * 24;
		
		var horasTotais = (horasDeDiasEntreDatas 
				+ Integer.parseInt(horaAtual) - Integer.parseInt(horaEntradaApenasHora));
		
		Long valorTotal;
		
		if(horasTotais == 0 || horasTotais == 1) {
			valorTotal = (long) 6;
		}  else {			
			valorTotal = ((horasTotais - 1) * 4) + 6;
		}
		
		movimentacao.setTempoTotal(new BigDecimal(horasTotais));
		movimentacao.setValor(new BigDecimal(valorTotal));
		
		return movimentacao;
	}

	public Object efetuarSaidaVeiculo(Long id) {
		var movimentacaoOld = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		
		movimentacaoOld.setSaiu(true);
		
		repository.save(movimentacaoOld); 
		
		return home();
	}
	
	
	
}
