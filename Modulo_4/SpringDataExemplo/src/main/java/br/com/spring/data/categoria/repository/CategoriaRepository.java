package br.com.spring.data.categoria.repository;

import br.com.spring.data.categoria.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    List<Categoria> findAll();
}