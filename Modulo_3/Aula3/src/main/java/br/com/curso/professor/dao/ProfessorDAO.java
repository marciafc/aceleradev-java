package br.com.curso.professor.dao;

import br.com.curso.professor.Professor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDAO {

    private EntityManager manager;

    public ProfessorDAO(EntityManager manager) {
        this.manager = manager;
    }

    public List<Professor> findAll() {
        return manager.createQuery("from Professor").getResultList();
    }

    public void save(Professor professor) {
        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();
    }

}
