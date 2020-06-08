package br.com.curso.aluno.dao;

import br.com.curso.aluno.Aluno;
import br.com.curso.disciplina.Disciplina;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

public class AlunoDAO {

    private EntityManager manager;

    public AlunoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Aluno aluno) {
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> findAll() {
        return manager.createQuery("from Aluno").getResultList();
    }

    public void delete(Aluno aluno) {
        manager.getTransaction().begin();
        manager.remove(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> findAlunosPorDisciplina(Disciplina disciplina) {
        Query query = manager.createQuery("from Aluno aluno " +
                "INNER JOIN FETCH aluno.disciplinas as disciplina " +
                "WHERE disciplina = ?1");
        query.setParameter(1, disciplina);
        return query.getResultList();
    }

    public BigInteger getNumeroDisciplinasMatriculadas(Long idAluno) {

        Query nativeQuery = manager.createNativeQuery("SELECT count(iddisciplina) \n" +
                "from disciplina_aluno \n" +
                "where idaluno = ?1");
        nativeQuery.setParameter(1, idAluno);
        return (BigInteger) nativeQuery.getSingleResult();
    }
}
