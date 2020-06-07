package br.com.curso.diretor;

import br.com.curso.usuario.UsuarioAutorizavel;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
public class Diretor extends UsuarioAutorizavel {

    private String dataCargo;

    public Diretor(String login, String cpf, String nome) {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("ADMIN");
    }

    @Override
    public boolean verificarAutorizacaoLogin() {
        return true;
    }

    public String getDataCargo() {
        return dataCargo;
    }

    public void setDataCargo(String dataCargo) {
        this.dataCargo = dataCargo;
    }
}
