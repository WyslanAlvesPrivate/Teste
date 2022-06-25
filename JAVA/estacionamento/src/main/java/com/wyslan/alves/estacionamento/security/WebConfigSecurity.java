package com.wyslan.alves.estacionamento.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{
	
	@Override // Configura as solicitações de acesso por Http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable() //Desativa as configurações padrão de memória.
		.authorizeRequests().anyRequest().authenticated() //Pertimir / restringir acessos
		.and().formLogin().permitAll() //Permite qualquer usuário a tela de login
		.and().logout().logoutSuccessUrl("/login") // Mapeia URL de Logout e invalida usuário authenticado
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//caso logout for implementado, por agora não nescessario
		
	}
	
	@Override // Cria autenticação do usuário criptografada (sem banco de dados por não nescessidade)
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.withUser("admin")
		.password("$2a$10$5rUTDskUPM6OYKlTubX00.f3ECcwGGols4y8vvHs2LeQ98O6mSJ9e")//12345
		.roles("ADMIN");
	}

}
