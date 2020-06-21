package br.com.codenation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private Long id;

    private Long idTime;

    private String nome;

    private LocalDate dataNascimento;

    private Integer nivelHabilidade;

    private BigDecimal salario;

    private Boolean isCapitao;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setId(id);
        setIdTime(idTime);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
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

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        if(idTime != null && idTime != 0) {
            this.idTime = idTime;
        } else {
            throw new RuntimeException("O campo idTime é obrigatório");
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento != null) {
            this.dataNascimento = dataNascimento;
        } else {
            throw new RuntimeException("O campo dataNascimento é obrigatório");
        }
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if(nivelHabilidade != null && nivelHabilidade >= 0 && nivelHabilidade <= 100) {
            this.nivelHabilidade = nivelHabilidade;
        } else {
            throw new RuntimeException("O campo nivelHabilidade é obrigatório e deve ser entre 0 e 100");
        }
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if(salario != null) {
            this.salario = salario;
        } else {
            throw new RuntimeException("O campo salario é obrigatório");
        }
    }

    public Boolean getCapitao() {
        return isCapitao;
    }

    public void setCapitao(Boolean capitao) {
        isCapitao = capitao;
    }
}
