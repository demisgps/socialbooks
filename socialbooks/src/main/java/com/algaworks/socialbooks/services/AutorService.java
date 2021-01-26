package com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutorRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository autorRepository;
	
	public List<Autor> listar() {
		return autorRepository.findAll();
	}
	
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autorRepository.findById(autor.getId()).orElse(null);
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe!");
				
			}	
		}
		return autorRepository.save(autor);
	}
	
	
	public Autor buscar(Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		
		if(!autor.isPresent()) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado");
		}
		return autor.get();
	}
}
