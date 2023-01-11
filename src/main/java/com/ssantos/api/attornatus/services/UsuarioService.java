package com.ssantos.api.attornatus.services;

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
	};
}
