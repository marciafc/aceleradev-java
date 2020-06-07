package br.com.curso.professor;

import br.com.curso.disciplina.Disciplina;
import br.com.curso.usuario.UsuarioAutorizavel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class Professor extends UsuarioAutorizavel {

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;

    public Professor(String login, String cpf, String nome) {
        super(login, cpf, nome);
    }

    @Override
    public List<String> getAutorizacoes() {
        return Arrays.asList("PROF");
    }

    @Override
    public boolean verificarAutorizacaoLogin() {
        return true;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
