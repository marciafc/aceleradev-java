package br.com.curso.disciplina.dao;

import br.com.curso.disciplina.Disciplina;

import javax.persistence.EntityManager;
import java.util.List;

public class DisciplinaDAO {

    private EntityManager manager;

    public DisciplinaDAO(EntityManager manager) {
        this.manager = manager;
    }

    public List<Disciplina> findAll() {
        return manager.createQuery("from Disciplina").getResultList();
    }

    public void save(Disciplina disciplina) {
        manager.getTransaction().begin();
        manager.persist(disciplina);
        manager.getTransaction().commit();
    }
}
