package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
