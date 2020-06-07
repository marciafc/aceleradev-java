package br.com.curso.usuario;

import br.com.curso.usuario.interfaces.IUsuarioAutorizavel;

import java.util.List;

public abstract class UsuarioAutorizavel extends Usuario implements IUsuarioAutorizavel {

    public UsuarioAutorizavel(String login, String cpf, String nome) {
        super(login, cpf, nome);
    }

    // Template Method: outra classe tem que implementar uma parte.
    // No caso, getAutorizacoes() e verificarAutorizacaoLogin() - implementação está nas classes filhas
    @Override
    public boolean temAutorizacao() {

        // getAutorizacoes é um Hook Method ("gancho")
        // Vai buscar a implemetação da classe concreta
        List<String> autorizacoes = getAutorizacoes();

        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();

    }

    // classes filhas acessam
    protected abstract List<String> getAutorizacoes();
    protected abstract boolean verificarAutorizacaoLogin();
}
