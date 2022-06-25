package com.wyslan.alves.estacionamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	@NotNull(message = "Atributo placa não pode ser nulo")
	@Length(min = 3, max = 20, message = "Modelo nao pode ter mais de 20 caracteres")
	private String placa;//format default: ["AAA-9999", "AAA9A99"]
	
	@Column(length = 80)
	@NotNull(message = "Atributo modelo não pode ser nulo")
	@Length(max = 80, message = "Modelo nao pode ter mais de 80 caracteres")
	private String modelo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Atributo data de entrada não pode ser nulo")
	private LocalDate dataEntrada;
	
	@Column(length = 8)
	@JsonFormat(pattern = "hh:mm:ss", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "hh:mm:ss")
	private String horaEntrada;
	
	/**
	 * coluna dataSaida não faz sentido, um endpoint já resolve
	 */

	
	//por ser tudo arrendondado, não precisamos de um double ou BigDecimal mais usado em valores
	private BigDecimal tempoTotal, valor;

	private boolean saiu = false;
	
	//getters and setters
	public Long getId() {
		return id;
	}public void setId(Long id) {
		this.id = id;
	}public String getPlaca() {
		return placa;
	}public void setPlaca(String placa) {
		this.placa = placa;
	}public String getModelo() {
		return modelo;
	}public void setModelo(String modelo) {
		this.modelo = modelo;
	}public LocalDate getDataEntrada() {
		return dataEntrada;
	}public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}public String getHoraEntrada() {
		return horaEntrada;
	}public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}public BigDecimal getTempoTotal() {
		return tempoTotal;
	}public void setTempoTotal(BigDecimal tempoTotal) {
		this.tempoTotal = tempoTotal;
	}public BigDecimal getValor() {
		return valor;
	}public void setValor(BigDecimal valor) {
		this.valor = valor;
	}public boolean isSaiu() {
		return saiu;
	}public void setSaiu(boolean saiu) {
		this.saiu = saiu;
	}
	//equals and hashCode to id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
