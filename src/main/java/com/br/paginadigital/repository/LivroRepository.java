package com.br.paginadigital.repository;

import com.br.paginadigital.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    public List<Livro> findAllByTituloContainingIgnoreCase(String titulo);
}
