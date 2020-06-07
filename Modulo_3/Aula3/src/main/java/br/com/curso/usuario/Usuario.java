package br.com.curso.usuario;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    public Usuario(String login, String cpf, String nome) {
        this.login = login;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
