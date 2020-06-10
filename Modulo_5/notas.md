# Tópicos

 - SQL (vídeo)

 - Hibernate (vídeo)

 - Spring Data DML (vídeo) 

 - [Spring Data Annotations](https://www.baeldung.com/spring-data-annotations)
 
 - 🔝 [Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)

 - [Database auditing JPA](https://www.baeldung.com/database-auditing-jpa)
   - Auditoria com JPA
   - Hibernate Envers
   - Spring Data JPA

 - [JPA Auditing](http://techie-mixture.blogspot.com/2018/01/spring-data-jpa-auditing-auto-save.html)

 - [Spring data JPA Query](https://www.baeldung.com/spring-data-jpa-query)
   - [Query](https://www.baeldung.com/spring-data-jpa-query#select-query)
     1) [JPQL](https://www.baeldung.com/spring-data-jpa-query#1-jpql)
     2) [Native](https://www.baeldung.com/spring-data-jpa-query#2-native)

   - [Define Order in a Query](https://www.baeldung.com/spring-data-jpa-query#define-order-in-a-query)
     1) [Sorting for JPA Provided and Derived Methods](https://www.baeldung.com/spring-data-jpa-query#1-sorting-for-jpa-provided-and-derived-methods)
	 2) [JPQL](https://www.baeldung.com/spring-data-jpa-query#2-jpql)
	 3) [Native](https://www.baeldung.com/spring-data-jpa-query#3-native)

   - [Pagination](https://www.baeldung.com/spring-data-jpa-query#pagination)
     1) [JPQL](https://www.baeldung.com/spring-data-jpa-query#1-jpql-1)
	 2) [Native](https://www.baeldung.com/spring-data-jpa-query#2-native-1)
	 3) [Spring Data JPA Versions Prior to 2.0.4](https://www.baeldung.com/spring-data-jpa-query#3-spring-data-jpa-versions-prior-to-204)

   - [Indexed Query Parameters](https://www.baeldung.com/spring-data-jpa-query#indexed-query-parameters)
     1) [JPQL](https://www.baeldung.com/spring-data-jpa-query#1-jpql-2)
	 2) [Native](https://www.baeldung.com/spring-data-jpa-query#2-native-2)

   - [Named Parameters](https://www.baeldung.com/spring-data-jpa-query#named-parameters)
     1) [JPQL](https://www.baeldung.com/spring-data-jpa-query#1-jpql-3)
	 2) [Native](https://www.baeldung.com/spring-data-jpa-query#2-native-3)

   - [Collection Parameter](https://www.baeldung.com/spring-data-jpa-query#collection-paameter)

   - [Update Queries With @Modifying](https://www.baeldung.com/spring-data-jpa-query#update-queries-with-modifying)
     1) [JPQL](https://www.baeldung.com/spring-data-jpa-query#1-jpql-4)
	 2) [Native](https://www.baeldung.com/spring-data-jpa-query#2-native-4)
	 3) [Inserts](https://www.baeldung.com/spring-data-jpa-query#3-inserts)

   - [Dynamic Query](https://www.baeldung.com/spring-data-jpa-query#dynamic-query)	 
     1) [Dynamic Query](https://www.baeldung.com/spring-data-jpa-query#1-example-of-a-dynamic-query)
	 2) [Custom Repositories and the JPA Criteria API](https://www.baeldung.com/spring-data-jpa-query#2-custom-repositories-and-the-jpa-criteria-api)
	 3) [Extending the Existing Repository](https://www.baeldung.com/spring-data-jpa-query#3-extending-the-existing-repository)
	 4) [Using the Repository](https://www.baeldung.com/spring-data-jpa-query#4-using-the-repository)

   - [Exemplo Github](https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-persistence-simple)	 

  - [Introduction to Query Methods](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/)
     - Query Methods

	 - Returning Values From Query Methods
	   - Basic type
	   - Entity
	   - Guava / Java 8 Optional<T>
	   - List<T>
	   - Stream<T>
	   - Executed asynchronously Future<>

			```java
			import java.util.concurrent.Future;
			import java.util.stream.Stream;
			import org.springframework.data.jpa.repository.Query;
			import org.springframework.data.repository.Repository;
			import org.springframework.data.repository.query.Param;
			import org.springframework.scheduling.annotation.Async;
			
			interface TodoRepository extends Repository<Todo, Long> { 
			
				@Async
				@Query("SELECT t.title FROM Todo t where t.id = :id") 
				Future<String> findTitleById(@Param("id") Long id);
				
				@Async
				@Query("SELECT t.title FROM Todo t where t.id = :id") 
				Future<Optional<String>> findTitleById(@Param("id") Long id);
			
				@Async
				Future<Todo> findById(Long id);
				
				@Async
				Future<Optional<Todo>> findById(Long id);
			
				@Async
				Future<List<Todo>> findByTitle(String title);
				
				@Async
				Future<Stream<Todo>> findByTitle(String title);
			}	   
			```
	 - Passing Method Parameters to Query Methods
 
 - Desafios
   - Criando e manipulando entidades no Banco de dados com Spring
   - Order Service

 - Feedback semanal
 
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

**@ManyToMany OU @OneToMany o default é LAZY** para otimizar. Nestes casos são List e poderia onerar.

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

	//Mantenha como LAZY!
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

Código-fonte está na pasta "SpringDataExemplo" no [Módulo 4](../Modulo_4) evolução do projeto agora com a parte de persistência

Uma classe "Repository" no Spring é similar ao DAO do Hibernate.

Documentação [Repository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/package-summary.html)
 
 - Exemplos: CrudRepository, JpaRepository, etc...

```java
public interface LivroRepository extends CrudRepository<Livro, Long> {

}

// Usa Generics
CrudRepository<Livro, Long>

```

**"LivroRepository"** só por herdar de alguma classe do tipo "XRepository" já tem uma série de métodos prontos.

E o que não tem? Basta seguir a **convenção no nome dos métodos criados no Repository**.

Como criar um método que pesquisa pelo titulo?
  - findByTitulo
  
Convenção: **findByX**, onde X é o atributo que deseja pesquisar

```java
public interface LivroRepository extends CrudRepository<Livro, Long> {
	
	// Gera um select * from livro where titulo = ?	
	List<Livro> findByTitulo(String nome);
	
}	

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String titulo;
}	
```

Como criar através da convenção pesquisas com **LIKE**?
 - findByXContaining, onde X é o atributo que deseja pesquisar

```java
List<Livro> findByTituloContaining(String titulo);
```

## Controller 

 - Objeto JAVA para objeto JSON -> serialização
 
 - Objeto JSON para objeto JAVA -> deserialização
 
 
## Query nativa

```java
@Query(value = "select * from LIVRO livro " +
				"INNER JOIN LIVRO_CATEGORIA cl " +
				"ON livro.id = cl.id_livro " +
				"INNER JOIN categoria c " +
				"ON c.id = cl.id_categoria " +
				"where c.nome like %:nomeCategoria%", nativeQuery = true)
List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);

```

## Criar consulta navegando entre os objetos (isso é top!!!!)

É possível criar consulta **navegando nos objetos** apenas **utilizando a convenção dos nomes**, sem a necessidade de query nativa.

Exemplo navegando pelo **User**

	findBy
		Candidates
			Id
				Acceleration
					Name

Classes:

```java 
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByCandidatesIdAccelerationName(String name);
}

public class User {
	@OneToMany(mappedBy = "id.user")
	private List<Candidate> candidates;
}

public class Candidate {
	@EmbeddedId
	private CandidateId id;

}

public class CandidateId implements Serializable {
	@ManyToOne
	private Acceleration acceleration;
	
}

public class Acceleration {
	private String name;
}

```

Consulta gerada:

```sql
SELECT user0_.id as id1_5_, user0_.created_at as created_2_5_, user0_.email as email3_5_, user0_.full_name as full_nam4_5_, user0_.nickname as nickname5_5_, user0_.password as password6_5_ 
  
FROM users user0_ 

LEFT OUTER JOIN candidate candidates1_ on user0_.id=candidates1_.user_id 

CROSS JOIN acceleration accelerati2_ 

WHERE candidates1_.acceleration_id=accelerati2_.id and accelerati2_.name=?

```
