package br.com.curso;

import br.com.curso.aluno.Aluno;
import br.com.curso.aluno.dao.AlunoDAO;
import br.com.curso.disciplina.Disciplina;
import br.com.curso.disciplina.dao.DisciplinaDAO;
import br.com.curso.exception.LimiteAlunosAlcancadoException;
import br.com.curso.professor.Professor;
import br.com.curso.professor.dao.ProfessorDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrincipalJpa {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso");
        EntityManager manager = factory.createEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(manager);
        ProfessorDAO professorDAO = new ProfessorDAO(manager);
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(manager);

       /*
        alunoDAO.save(new Aluno("login1", "1234", "Aluno1"));
        alunoDAO.save(new Aluno("login2", "5678", "Aluno2"));

        Aluno aluno = new Aluno("login3", "9123", "Aluno a remover");
        alunoDAO.save(aluno);

        alunoDAO.findAll().forEach(alunoEncontrado -> System.out.println(alunoEncontrado.getNome()));

        alunoDAO.delete(aluno);

        System.out.println("Após remover aluno");
        alunoDAO.findAll().forEach(alunoEncontrado -> System.out.println(alunoEncontrado.getNome()));

        */

        System.out.println("Inserindo mais alunos");
        Aluno aluno1 = new Aluno("login3", "4523", "Aluno3");
        alunoDAO.save(aluno1);
        Aluno aluno2 = new Aluno("login4", "6738", "Aluno4");
        alunoDAO.save(aluno2);
        alunoDAO.findAll().forEach(alunoEncontrado ->
                    System.out.println(
                            alunoEncontrado.getNome() +
                            " Matrícula: " + alunoEncontrado.getNumeroMatricula()));

        System.out.println("Atualizando a matrícula de 2 alunos");
        aluno1.setNumeroMatricula(98);
        alunoDAO.save(aluno1);
        aluno2.setNumeroMatricula(99);
        alunoDAO.save(aluno2);
        alunoDAO.findAll().forEach(alunoEncontrado ->
                System.out.println(
                        alunoEncontrado.getNome() +
                                " Matrícula: " + alunoEncontrado.getNumeroMatricula()));

        System.out.println("Inserindo Professor");
        Professor professor1 = new Professor("professor_login1", "0923", "Professor de Matemática");
        Professor professor2 = new Professor("professor_login2", "0924", "Professor de Literatura");
        professorDAO.save(professor1);
        professorDAO.save(professor2);

        System.out.println("Inserindo Disciplina");
        Disciplina matematica = new Disciplina("Matemática", professor1);
        Disciplina literatura = new Disciplina("Literaratura", professor2);
        disciplinaDAO.save(matematica);
        disciplinaDAO.save(literatura);
        disciplinaDAO.findAll().forEach(disc ->
                System.out.println(
                        disc.getNome() +
                                " \n   Professor: " + disc.getProfessor().getNome()));

        System.out.println("Matriculando 2 alunos em Matemática");
        try {
            matematica.matricular(aluno1);
        } catch (LimiteAlunosAlcancadoException e) {
            System.out.println(e.getMessage());
        }

        try {
            matematica.matricular(aluno2);
        } catch (LimiteAlunosAlcancadoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Matriculando 1 aluno em Literatura");
        try {
            literatura.matricular(aluno1);
        } catch (LimiteAlunosAlcancadoException e) {
            System.out.println(e.getMessage());
        }

        disciplinaDAO.save(matematica);
        disciplinaDAO.save(literatura);

        System.out.println("Alunos em Matemática");
        alunoDAO.findAlunosPorDisciplina(matematica).forEach(aluno -> System.out.println(aluno.getNome()));

        System.out.println("Alunos em Literatura");
        alunoDAO.findAlunosPorDisciplina(literatura).forEach(aluno -> System.out.println(aluno.getNome()));

        System.out.print("O aluno " + aluno1.getNome()
                + " está matriculado em quantas disciplinas? ");
        System.out.println(alunoDAO.getNumeroDisciplinasMatriculadas(aluno1.getId()));

        System.out.print("O aluno " + aluno2.getNome()
                + " está matriculado em quantas disciplinas? ");
        System.out.println(alunoDAO.getNumeroDisciplinasMatriculadas(aluno2.getId()));

        factory.close();
    }

}
