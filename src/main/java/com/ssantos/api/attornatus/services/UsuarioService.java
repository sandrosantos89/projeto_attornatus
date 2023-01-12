package com.ssantos.api.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssantos.api.attornatus.domain.Usuario;
import com.ssantos.api.attornatus.exceptions.ObjectNotFoundException;
import com.ssantos.api.attornatus.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario update(Long id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setDataNascimento(obj.getDataNascimento());
		return repository.save(newObj);
	}

	public Usuario create(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	};
}
