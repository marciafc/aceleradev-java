package br.com.curso.aluno;

import br.com.curso.disciplina.Disciplina;
import br.com.curso.usuario.Usuario;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Aluno extends Usuario {

    private Integer numeroMatricula;

    @ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = {@JoinColumn(name = "idAluno")},
            inverseJoinColumns = {@JoinColumn(name = "idDisciplina")}
    )
    private List<Disciplina> disciplinas;

    public Aluno(String login, String cpf, String nome) {
        super(login, cpf, nome);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

}
