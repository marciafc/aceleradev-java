package br.com.curso;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrincipalJpa {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso");
        factory.close();
    }
}
