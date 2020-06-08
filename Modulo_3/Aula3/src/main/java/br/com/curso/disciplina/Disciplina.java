package br.com.curso.disciplina;

import br.com.curso.aluno.Aluno;
import br.com.curso.exception.LimiteAlunosAlcancadoException;
import br.com.curso.professor.Professor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {

    private static final byte LIMITE = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = {@JoinColumn(name = "idDisciplina")},
            inverseJoinColumns = {@JoinColumn(name = "idAluno")}
    )
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idProfessor")
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) throws LimiteAlunosAlcancadoException {
        if(this.alunos.size() < LIMITE) {
            this.alunos.add(aluno);
        } else {
            throw new LimiteAlunosAlcancadoException("Limite de alunos alcançado. O limite é " + LIMITE);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
