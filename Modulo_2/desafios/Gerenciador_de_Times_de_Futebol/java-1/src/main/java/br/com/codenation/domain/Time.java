package br.com.codenation.domain;

import java.time.LocalDate;


public class Time {

    private Long id;

    private String nome;

    private LocalDate dataCriacao;

    private String corUniformePrincipal;

    private String corUniformeSecundario;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        setId(id);
        setNome(nome);
        setDataCriacao(dataCriacao);
        setCorUniformePrincipal(corUniformePrincipal);
        setCorUniformeSecundario(corUniformeSecundario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id != null && id != 0) {
            this.id = id;
        } else {
            throw new RuntimeException("O campo id é obrigatório");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("O campo nome é obrigatório");
        }
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        if(dataCriacao != null) {
            this.dataCriacao = dataCriacao;
        } else {
            throw new RuntimeException("O campo dataCriacao é obrigatório");
        }
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        if(corUniformePrincipal != null && !corUniformePrincipal.isEmpty()) {
            this.corUniformePrincipal = corUniformePrincipal;
        } else {
            throw new RuntimeException("O campo corUniformePrincipal é obrigatório");
        }
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        if(corUniformeSecundario != null && !corUniformeSecundario.isEmpty()) {
            this.corUniformeSecundario = corUniformeSecundario;
        } else {
            throw new RuntimeException("O campo corUniformeSecundario é obrigatório");
        }
    }
}
