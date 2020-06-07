# Tópicos

 - Modelagem SQL (vídeo)

 - Hibernate JPA (vídeo)

 - Spring Boot (vídeo) 

 - [pgAdmin - PostgreSQL Tools for Windows, Mac, Linux and the Web](https://www.pgadmin.org/download) 
   - [Site do Edivaldo Brito - Como instalar o pgAdmin4 no Ubuntu e derivados](https://www.edivaldobrito.com.br/pgadmin4-no-ubuntu/)

 - [Como Instalar e Utilizar o PostgreSQL no Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/como-instalar-e-utilizar-o-postgresql-no-ubuntu-16-04-pt)  

 - [Instalando Postgresql](https://www.devmedia.com.br/instalando-postgresql/23364)

 - [Learn PostgreSQL from Scratch](https://www.postgresqltutorial.com/)

 - [Guia Completo de Hibernate: Aprenda Hibernate do Básico ao Avançado](https://www.devmedia.com.br/guia/hibernate/38312)

 - Desafio
   - Criando Entidades de Banco de Dados em Java

- Feedback semanal


## Ambiente de desenvolvimento

Instalação do banco de dados Postgres com Docker

    // Instalar o Docker 
    https://docs.docker.com/engine/install/ubuntu/
    
    // Instalar pgAdmin 
    Dica obtida de https://www.edivaldobrito.com.br/pgadmin4-no-ubuntu/
    
    $ sudo apt-get install wget ca-certificates

    $ wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
    
    $ sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
    
    $ sudo apt-get update
    
    $ sudo apt install pgadmin4 pgadmin4-apache2

    // Cria container com o Postgres com nome postgres-container
    // Configura a senha do banco com POSTGRES_PASSWORD
    // Usuário padrão é postgres
    // -d roda em background (daemon)
    // imagem que irá usar e a versão: postgres:9.6-alpine
    // alpine menor distribuição
    $ docker run --name postgres-container -e POSTGRES_PASSWORD=postgres123 -d postgres:9.6-alpine

    // Listar containers 
    $ docker ps

    // Verificar em qual IP o container com o Postgres está rodando
    // Lembrando que "postgres-container" é o nome do container
    // IP está no final, procurar por IPAddress
    $ docker inspect postgres-container
	
	// Acessar pgAdmin pelo browser	 
    http://127.0.0.1:41565/browser

## DDL data definition languagem    

Linguagem de definição de dados

Cria estrutura e modelagem do banco de dados

```sql
CREATE DATABASE

CREATE TABLE

ALTER TABLE

DROP TABLE
```

## Constraints

  - PRIMARY KEY
    - Também pode ser uma chave primária composta

  - FOREIGN KEY

  - UNIQUE

  - NOT NULL

  - DEFAULT

## Relacionamentos

1:1 (um-para-um)

1:N (um-para-muitos) ou N:1 (muitos-para-um)

N:N (muitos-para-muitos)

## Persistência de dados

JDBC

Hibernate (implementação JPA)

JPA (especificação ORM)

## IntelliJ - Transformar o projeto em um projeto Maven

Botão direito em cima do projeto \ Add Framework Support

Selecionar Maven \ clicar em OK

Será criado arquivo pom.xml no projeto

-> Maven (pom.xml): gerenciamento de dependências

-> Gradle (outro gerenciador de dependências): usa Groovy ao invés de xml

## Annotations Hibernate

@Entity: referencia uma tabela no banco de dados

@Inheritance(strategy = InheritanceType.JOINED): herança com estratégia que outras classes herdam desta classe. Existem outras estratégias. [Referência Inheritance](https://docs.oracle.com/javaee/7/tutorial/persistence-intro002.htm)

@Id: mapeia o campo como chave primária. Obrigatório.

@Column(unique = true): mapeia o atributo para não permitir duplicidade (no banco de dados é o UNIQUE)

@Column(nullable = false): mapeia o atributo para não permitir null (no banco de dados é o NOT NULL)

@Column(length = 14): tamanho do campo

@Column(unique = true, nullable = false, length = 14): definindo as regras de unique, not null e tamanho

```java
//classe Disciplina

@ManyToMany
@JoinTable(name = "disciplina_aluno",
            joinColumns = {@JoinColumn(name = "idDisciplina")},
            inverseJoinColumns = {@JoinColumn(name = "idAluno")}
    )
private List<Aluno> alunos = new ArrayList<>();
```
 - @ManyToMany: relacionamento muitos-para-muitos com a tabela de alunos

 - name = "disciplina_aluno" é o nome da tabela que será criada para fazer essa relação N:N
 
 - joinColumns = {@JoinColumn(name = "idDisciplina")}: "idDisciplina" é um dos campos que será criado nessa tabela "disciplina_aluno". Fica em joinColumn por ser da entidade atual (Disciplina)
 
 - inverseJoinColumns = {@JoinColumn(name = "idAluno")}: "idAluno" é um dos campos que será criado nessa tabela "disciplina_aluno". Fica em inverseJoinColumns por ser da OUTRA entidade (Aluno)

```java
//classe Disciplina

@ManyToOne
@JoinColumn(name = "idProfessor")
private Professor professor;
```   
 - @ManyToOne: Professor está vinculado a muitas ou uma disciplina

 - @JoinColumn(name = "idProfessor"): na tabela de Disciplina terá uma chave estrangeira com nome "idProfessor"

 ```java
//classe Professor

// Mapeamento bilateral para poder acessar as disciplinas do Professor

// Um Professor pode ter uma ou mais disciplinas
@OneToMany(mappedBy = "professor")
private List<Disciplina> disciplinas;
 ```

 - mappedBy = "professor" é atributo na classe Disciplina 
   - private Professor professor;   // isso está na classe Disciplina

## Em qual das classes utilizar @ManyToOne e @OneToMany? 
Na classe que representa a entidade que terá a **chave estrangeira**, usar **@ManyToOne**. Na outra classe @OneToMany

```sql
// Classe Disciplina tem @ManyToOne
create table Disciplina (
    id int8 not null,
    // outros campos...
    idProfessor int8, // chave estrangeira
    primary key (id)
)

// Clase Professor tem @OneToMany
create table Professor (
    id int8 not null,
    primary key (id)
)
    
alter table Disciplina 
add constraint FK_nfuaxi5fhpxt8qpp7anl421gg 
foreign key (idProfessor) references Professor
```    

## Projeto de estudo JPA/Hibernate

Criar no Postgres o database com nome "curso"

Ver PrincipalJpa.java (projeto está na [Aula3](../Modulo_3) - evolução do projeto com interface e classe abstrata)

Ao executar a classe que cria o EntityManagerFactory, é possível ver no console as tabelas serem criadas conforme as anotações.
  - Ver arquivo [console_output.txt](../Modulo_3)

## Projeto de estudo Spring Boot + Spring Data

Site [Spring Initializr](https://start.spring.io)
  - Gera projeto inicial

Código-fonte está na pasta "SpringDataExemplo" deste módulo.

```java
// Classe que starta o projeto e deve ficar na raiz
// Se colocar em outro local, deve informar qual package será scanneado
// em @SpringBootApplication(...)

// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## Bean Validations

@NotNull

@NotBlank

@Size

@Min

@Max

## Annotation

Chave primária composta
  - [Qual a diferença entre EmbeddedId e IdClass no Hibernate?](https://pt.stackoverflow.com/questions/307063/qual-a-diferen%C3%A7a-entre-embeddedid-e-idclass-no-hibernate)

```java
  @EmbeddedId 
  

  // OU

  @IdClass(MinhaClasse.class)
```  

### Abordagem @EmbeddedId

 - @Embeddable: informa que não é uma entidade, é embarcada em outra entidade (abordagem @EmbeddedId)

 - Classe mapeada com @Embeddable deve implementar Serializable
    - Boa prática SOBRESCREVER o equals e hashCode (evita warning)
      1) Generate equals and hashCode 
      2) Template: IntelliJ Default
      3) Marcar Accept_subclasses... (MARCAR)
      4) Marcar Use getters...(não precisa marcar)
      5) Next
      6) Marcar todos os campos que estarão no equals
      7) Marcar todos os campos que estarão no hashCode
      8) Marcar os campos não null: não testará campos null no equals e hashCode

## Console web do banco h2

Incluir estas configurações no application.properties:

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2
```

Após executar o projeto "SpringDataExemplo", é possível acessar o banco de dados em:

http://localhost:8080/h2


Fontes:

[Spring Boot With H2 Database](https://www.baeldung.com/spring-boot-h2-database)