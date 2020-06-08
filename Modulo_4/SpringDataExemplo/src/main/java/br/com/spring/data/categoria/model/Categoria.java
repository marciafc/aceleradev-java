package br.com.spring.data.categoria.model;

import br.com.spring.data.livro.model.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String nome;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "LIVRO_CATEGORIA",
            joinColumns= @JoinColumn(name = "idCategoria"),
            inverseJoinColumns = @JoinColumn(name = "idLivro"))
    private List<Livro> livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}