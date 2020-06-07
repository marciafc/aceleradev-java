package br.com.curso.usuario.interfaces;

public interface IUsuarioAutorizavel {

    default boolean temAutorizacao() {
        return true;
    }
}
