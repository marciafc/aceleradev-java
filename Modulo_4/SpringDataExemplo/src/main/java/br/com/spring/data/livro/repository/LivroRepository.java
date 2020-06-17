package br.com.spring.data.livro.repository;

import br.com.spring.data.categoria.model.Categoria;
import br.com.spring.data.livro.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    Page<Livro> findAll(Pageable pageable);

    List<Livro> findByTitulo(String titulo);

    Page<Livro> findByTituloContaining(String titulo, Pageable pageable);

    List<Livro> findByCategorias(Categoria categoria);

    @Query("from Livro livro where livro.categorias is not empty")
    List<Livro> findComCategoria();


    @Query(value = "select * from LIVRO livro " +
            "INNER JOIN LIVRO_CATEGORIA cl " +
            "ON livro.id = cl.id_livro " +
            "INNER JOIN categoria c " +
            "ON c.id = cl.id_categoria " +
            "where c.nome like %:nomeCategoria%", nativeQuery = true)
    List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("from Livro livro where livro.avaliacoes is not empty")
    List<Livro> findComAvaliacao();
}
