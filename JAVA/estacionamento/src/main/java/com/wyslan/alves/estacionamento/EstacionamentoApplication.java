package com.wyslan.alves.estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages =  {"com.wyslan.*"})
@EntityScan(basePackages = {"com.wyslan.alves.estacionamento.model"})
@EnableJpaRepositories(basePackages = {"com.wyslan.alves.estacionamento.repository"})
@EnableTransactionManagement
@EnableWebMvc
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

}
