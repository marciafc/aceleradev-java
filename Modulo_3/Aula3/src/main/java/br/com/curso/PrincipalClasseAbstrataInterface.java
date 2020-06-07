package br.com.curso;

import br.com.curso.coordenador.Coordenador;
import br.com.curso.diretor.Diretor;
import br.com.curso.lancadornotas.LancadorNotas;
import br.com.curso.professor.Professor;
import br.com.curso.usuario.UsuarioAutorizavel;
import br.com.curso.usuario.interfaces.IUsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class PrincipalClasseAbstrataInterface {

    public static void main(String[] args) {

        LancadorNotas lancadorNotas = new LancadorNotas();

        UsuarioAutorizavel professor = new Professor("professor_login1", "123456789", "Professor");
        System.out.print("Professor: ");
        lancadorNotas.login(professor);

        UsuarioAutorizavel coordenador = new Coordenador("coordenador_login1", "3543534675643", "Coordenador");
        System.out.print("Coordenador: ");
        lancadorNotas.login(coordenador);

        UsuarioAutorizavel diretor = new Diretor("diretor_login1", "6235267747", "Diretor");
        System.out.print("Diretor: ");
        lancadorNotas.login(diretor);

        // ************************* Instanciar interface? *************************
        // Classe anônima: péssima para legibilidade
        IUsuarioAutorizavel iUsuario = new IUsuarioAutorizavel() {
        };
        System.out.println("Chamando IUsuarioAutorizavel (interface)");
        System.out.println(iUsuario.temAutorizacao());

        // ************************* Instanciar classe abstrata? *************************
        // Idem! E é péssima para legibilidade
        UsuarioAutorizavel usuario = new UsuarioAutorizavel("login", "3435674", "Nome") {
            @Override
            protected List<String> getAutorizacoes() {
                return Arrays.asList("ADMIN");
            }

            @Override
            protected boolean verificarAutorizacaoLogin() {
                return false;
            }
        };
        System.out.println("Chamando UsuarioAutorizavel (classe abstrata)");
        System.out.println(usuario.temAutorizacao());
    }



}
