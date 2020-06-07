package br.com.spring.data.leitor.model;

import br.com.spring.data.avaliacao.model.Avaliacao;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @OneToMany
    private List<Avaliacao> avaliacoes;

    public Leitor(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
