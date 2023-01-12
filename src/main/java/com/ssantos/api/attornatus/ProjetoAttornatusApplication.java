package com.ssantos.api.attornatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssantos.api.attornatus.domain.Endereco;
import com.ssantos.api.attornatus.domain.Usuario;
import com.ssantos.api.attornatus.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoAttornatusApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuario;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAttornatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Sandro", "10/04/2022");

		usuario.saveAll(Arrays.asList(u1));
	}

}
