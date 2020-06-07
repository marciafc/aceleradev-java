package br.com.curso.coordenador;

import br.com.curso.usuario.UsuarioAutorizavel;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class Coordenador extends UsuarioAutorizavel {

    private Integer matricula;

    public Coordenador(String login, String cpf, String nome) {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("COORD");
    }

    @Override
    public boolean verificarAutorizacaoLogin() {
        return false;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
