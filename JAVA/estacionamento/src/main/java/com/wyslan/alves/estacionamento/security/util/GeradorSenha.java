package com.wyslan.alves.estacionamento.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * gerar alguma senha criptografada
 */
public class GeradorSenha {
    public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}
}
