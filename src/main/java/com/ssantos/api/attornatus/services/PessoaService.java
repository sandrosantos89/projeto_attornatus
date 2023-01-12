package com.ssantos.api.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssantos.api.attornatus.domain.Pessoa;
import com.ssantos.api.attornatus.exceptions.ObjectNotFoundException;
import com.ssantos.api.attornatus.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa update(Long id, Pessoa obj) {
		Pessoa newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setDataNascimento(obj.getDataNascimento());
		return repository.save(newObj);
	}

	public Pessoa create(Pessoa obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	};
}
