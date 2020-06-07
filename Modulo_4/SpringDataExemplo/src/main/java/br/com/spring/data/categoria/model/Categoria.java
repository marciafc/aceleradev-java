package br.com.spring.data.categoria.model;

import br.com.spring.data.livro.model.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nome;

    @ManyToMany
    private List<Livro> livros;
}
