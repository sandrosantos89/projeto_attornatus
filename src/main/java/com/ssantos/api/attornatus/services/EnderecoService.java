package com.ssantos.api.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssantos.api.attornatus.domain.Endereco;
import com.ssantos.api.attornatus.exceptions.ObjectNotFoundException;
import com.ssantos.api.attornatus.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco update(Long id, Endereco obj) {
		Endereco newObj = findById(id);
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setCep(obj.getCep());
		newObj.setNumero(obj.getNumero());
		newObj.setCidade(obj.getCidade());
		newObj.setEnderecoPrincipal(obj.getEnderecoPrincipal());
		newObj.setPessoa(obj.getPessoa());;
		return repository.save(newObj);
	}

	public Endereco create(Endereco obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	};
}
