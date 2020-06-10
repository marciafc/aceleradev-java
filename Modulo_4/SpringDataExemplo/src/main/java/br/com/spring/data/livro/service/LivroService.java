package br.com.spring.data.livro.service;

import br.com.spring.data.livro.model.Livro;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    List<Livro> findAll(Pageable pageable);

    List<Livro> findByCategoria(Long idCategoria);

    Optional<Livro> findById(Long id);

    Livro save(Livro livro);

    void deleteById(Long id);

    List<Livro> findByNome(String nome, Pageable pageable);

    List<Livro> findByNomeCategoria(String nomeCategoria);

    List<Livro> findComCategorias();
}
