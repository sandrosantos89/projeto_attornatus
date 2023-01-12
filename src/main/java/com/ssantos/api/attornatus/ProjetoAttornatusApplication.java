package com.ssantos.api.attornatus;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssantos.api.attornatus.domain.Endereco;
import com.ssantos.api.attornatus.domain.Pessoa;
import com.ssantos.api.attornatus.repositories.EnderecoRepository;
import com.ssantos.api.attornatus.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoAttornatusApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository usuario;

	@Autowired
	private EnderecoRepository endereco;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAttornatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pessoa p = new Pessoa(null, "Sandro", "10/01/2023");
		Pessoa p2 = new Pessoa(null, "Santos", "12/01/2023");
		
		Endereco ed = new Endereco(null, "Rua teste", "12345-678", "100", "Programação", "Sim", p);
		Endereco ed2 = new Endereco(null, "Rua teste", "12345-678", "100", "Programação", "Não", p2);

		usuario.saveAll(Arrays.asList(p, p2));
		endereco.saveAll(Arrays.asList(ed, ed2));
	}

}
