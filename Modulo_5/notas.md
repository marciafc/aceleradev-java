# Tópicos

 - SQL (vídeo)

 - Hibernate (vídeo)

 - Spring Data DML (vídeo) 

 - []()

## DML Data Manipulation Language

INSERT

UPDATE

DELETE 

## Projeto de estudo JPA/Hibernate

Ver PrincipalJpa.java (projeto está na [Aula3](../Modulo_3) - evolução do projeto agora com a parte de persistência)

Trabalhando com transação

```java

// @Transactional pode ser utilizado com Spring ou o Hibernate puro (precisa outras configurações)
// https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
@Transactional
public void save(Aluno aluno) {	
	manager.persist(aluno);	
}

// OU

public void save(Aluno aluno) {
	manager.getTransaction().begin();
	manager.persist(aluno);
	manager.getTransaction().commit();
}

```

```java
// Se não existe o Aluno, insere
// Caso já existe, atualiza
manager.persist(aluno);
```
 
 ```java
 // HQL (Hibernate Query Language)
 manager.createQuery("from Aluno").getResultList();
 ```

## Carregando com Fetch

 - FetchType.EAGER: carrega o objeto

 - FetchType.LAZY: carrega apenas quando der o get no atributo

Exemplo: 

```java
@ManyToOne(fetch = FetchType.EAGER)
```

**@ManyToOne o default é EAGER**. Sem problemas, pois será apenas UM objeto, não um List.

**@ManyToMany OU **@OneToMany o default é LAZY** para otimizar. Nestes casos são List e poderia onerar.

```java

@Entity
public class Disciplina {

	@ManyToOne
    @JoinColumn(name = "idProfessor")
    private Professor professor;

	@ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = {@JoinColumn(name = "idDisciplina")},
            inverseJoinColumns = {@JoinColumn(name = "idAluno")}
    )
    private List<Aluno> alunos = new ArrayList<>();
	
}

@Entity
public class Professor extends UsuarioAutorizavel {

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;
}
```

## Dica de otimização
 
Onde há List (default é fetch = FetchType.LAZY), ao invés de simplesmente trocar o "fetch" para EAGER, o que pode gerar outros problemas, alterar a query:

```java
public class Disciplina {

	// Mantenha como LAZY!
    @ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = {@JoinColumn(name = "idDisciplina")},
            inverseJoinColumns = {@JoinColumn(name = "idAluno")}
    )
    private List<Aluno> alunos = new ArrayList<>();
}	


public class DisciplinaDAO {

	// Altere APENAS a query que deseja carregar os alunos com INNER JOIN FETCH
	public List<Disciplina> findAll() {
        return manager.createQuery("from Disciplina d INNER JOIN FETCH d.alunos").getResultList();
  }
  
}

```

## HQL X Query nativa

```java
public class AlunoDAO {

	private EntityManager manager;
	
	// HQL
 	public List<Aluno> findAll() {
		return manager.createQuery("from Aluno").getResultList();
	}

	// HQL
	public List<Aluno> findAlunosPorDisciplina(Disciplina disciplina) {
		Query query = manager.createQuery("from Aluno aluno " +
                "INNER JOIN FETCH aluno.disciplinas as disciplina " +
                "WHERE disciplina = ?1");
		query.setParameter(1, disciplina);
		return query.getResultList();
    }

	//NativeQuery
	public BigInteger getNumeroDisciplinasMatriculadas(Long idAluno) {
		Query nativeQuery = manager.createNativeQuery("SELECT count(iddisciplina) \n" +
                "from disciplina_aluno \n" +
                "where idaluno = ?1");
		nativeQuery.setParameter(1, idAluno);
		return (BigInteger) nativeQuery.getSingleResult();
    }	
}
```




 


## Projeto de estudo Spring Boot + Spring Data