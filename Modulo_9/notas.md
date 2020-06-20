# Tópicos

 - Maven (vídeo)

 - Deploy de Aplicações (vídeo)
 
 - DevOps CI/CD (vídeo)
 
 - [O que é DevOps?](https://www.redhat.com/pt-br/topics/devops)
 
 - [O que é CI/CD?](https://www.redhat.com/pt-br/topics/devops/what-is-ci-cd)
 
 - [Heroku Cloud Application Platform](https://dashboard.heroku.com/login)
 
 - [Welcome to Apache Maven](https://maven.apache.org)
 
 - [Processo de build com o Maven](http://blog.caelum.com.br/processo-de-build-com-o-maven)
 
 - Quiz Deploy aplicações Java
 
 - Feedback semanal
 

## Build

Empacotar ".class" -> JAR, WAR

 - JAR: "junta os ".class" em um único arquivo e guarda metadados relativos a configuração da aplicação

 - WAR: utilizado para deploy em servidores WEB, além de juntar os ".class" também guarda arquivos web como HTML, CSS, Javascript, etc...

Ferramentas de build
  Gera WARs, JARs
  Gerenciamento de dependências
  Automação de build

## Apache Maven

Project Object Model (POM)

Goals (tarefas)

  - clean: **remove** arquivos gerados por **builds antigos**
  
  - package: **builda** seu projeto e disponibiliza o artefato final na **pasta target**
  
  - install: **igual ao package** só que **também** disponiliza o jar no **repositório local**

Cada goal roda vários passos para construir sua aplicação, chamamos a execução de todas essas etapas em ordem de **Ciclo de Vida**.

## Ciclo de vida do build (varia de acordo com a goal que está executando)

  - validate: valida se o projeto está correto e com tudo necessário
  
  - compile: compila todo o código fonte
  
  - test: roda os testes unitários
  
  - package: empacota o codigo no formato esperado
  
  - verify: executa verificações para definir a validade do código de acordo com critérios de qualidade pré-estabelecidos
  
  - install: instala o pacote no repositório local
  
  - deploy: copia o pacote para o repositório remoto
  
Maven -> plugins -> Goals acima: "**Core Plugin**"

Podemos utilizar goals de outros plugins.

**spring-boot-maven-plugin**: empacota aplicação Spring Boot

pom.xml

Quando não tem a versão declarada da dependência, usa a versão do parent:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Definindo o plugin que será utilizado, no caso "spring-boot-maven-plugin":

```xml
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

Definindo o escopo da dependência:

```xml
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```

No **IntelliJ na aba "Maven Projects"** é possível ver toda a **árvore de dependências** gerenciadas pelo Maven, assim como os **Plugins** e o **Lifecycle**.

  - Pode selecionar algum item do **Lifecycle** e dar o play de dentro desta aba.
  
No **terminal**: 

  mvn install // (goal do "plugin core" não precisa passar o nome-do-plugin:goal)


## Executável do Spring

Gera um **.jar**

  Tomcat embarcado/embedded

Executar:

    cd target/
	java -jar nome-do-projeto.jar
	
Um **arquivo .war** precisaria de um servidor por fora -> é possível trabalhar desta forma também, o deploy ocorre em um servidor a parte.	

Usar o "**mvn clean**": para evitar problemas com alguns plugins

## Deploy de Aplicações

Máquina virtual, física ou cloud

## Cloud Server

Iaas (Infrastructure as a Service)

Exemplos: Amazon, Google, Microsoft, Heroku, etc...

## Heroku

Acessar o [Dashboard](https://dashboard.heroku.com/apps)

Create new app

Preencher o nome do app \ Create app

Em "Deployment method": selecionar o Github 

Em "Connect to Github": selecionar o repositório e o nome do projeto no Github, clicar em "Search"

Clicar em "Connect"

Selecionar branch para deploy: master, por exemplo

Clicar em "Deploy branch"

Aguardar a conclusão e clicar em "View" quando aparecer a mensagem que o deploy foi concluído com sucesso ("Your app was successfully deployed.").

Heroku links úteis:

 - Deploy JDK != 1.8: [Specifying a Java version](https://devcenter.heroku.com/articles/java-support#specifying-a-java-version)

 - [Create a Java Web Application Using Embedded Tomcat](https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat)

 - [Documentação](https://devcenter.heroku.com/categories/heroku-architecture)

 - [Getting Started on Heroku with Java](https://devcenter.heroku.com/articles/getting-started-with-java)

## DevOps CI/CD

DevOps

 - Desenvolvimento + Operações

 - Para implantação correta da abordagem DevOps: mudança de cultura, processos e ferramentas

 - Disponibilização de serviços de TI rápidos e iterativos

CI/CD: Método para entrega frequente de aplicações para os clientes utilizando automação em diversas etapas do ciclo de desenvolvimento.

<img src="https://www.redhat.com/cms/managed-files/ci-cd-flow-desktop_1.png">

Fonte: [Integração e entrega contínuas: pipeline CI/CD](https://www.redhat.com/pt-br/topics/devops/what-is-ci-cd)


CI: Continuous Integration (Integração Contínua)
 - Continuous Integration: permite a integração automatizada de código desenvolvido por pessoas e/ou times diferentes em um mesmo repositório

CD: Continuous Delivery (Entrega Contínua) e Continuous Deployment (Implantação Contínua)
 - Continuous Delivery: entrega contínua e automatizada de código validado e testado em um repositório pronto para implantação em produção
 - Continuous Deployment: permite a automatização de processo de deploy em si, tornando possível implantações em curtos intervalos
 
Algumas ferramentas:

 - Jenkins
 
 - Heroku
 
 - Amazon Web Services(AWS)
 
 - Docker: criação de conteiners (equaliza os ambientes de desenv e produção)
 
 - Kubernetes: gerenciamento dos containers Docker
 
 - [Bamboo (semelhante ao Jenkins)](https://www.atlassian.com/br/software/bamboo)
   - [Bamboo vs Jenkins: Which CI/CD tool to use?](https://blog.valiantys.com/en/dev-tools-en/jenkins-vs-bamboo)
 
 - [ELK Elasticsearch, Logstash, Kibana](https://www.elastic.co/pt/what-is/elk-stack)
   - Monitoramento é muito importante!
   
 - [Vercel](https://vercel.com): oferece CI/CD

## Quiz Deploy aplicações Java

(em negrito a resposta correta)

- QUESTÃO 1 DE 10: Qual das alternativas a seguir é verdadeira sobre GOALS na terminologia do Maven?

Uma GOAL representa uma tarefa específica que contribui para o build e o gerenciamento de um projeto

Pode estar vinculado a zero ou mais fases de construção.

Uma GOAL não vinculada a nenhuma fase de construção pode ser executada fora do ciclo de vida do build por invocação direta

**Todos os itens acima**

- QUESTÃO 2 DE 10: Qual dos seguintes escopos indica que a dependência está disponível apenas para as fases de compilação e execução de teste?

compile

provided

runtime

**test**

- QUESTÃO 3 DE 10: Quais das afirmativas abaixo sobre o Maven são verdadeiras?

Ele fornece um modelo abrangente para projetos que são reutilizáveis, manuteníveis e mais fáceis de compreender

Maven fornece plugins ou ferramentas que interagem com seu modelo declarativo

**Ambos os itens acima**

Nenhuma das opções acima

- QUESTÃO 4 DE 10: Sobre o Gerenciamento de Dependencias, quais afirmativas abaixo são Verdadeiras?

**O Maven faz o download de suas dependencias de repositorios Maven remotos**

O Maven utiliza um repositorio local por projeto quando há varios projetos na mesma maquina

O Maven sempre baixa todas as dependencias de um projeto novo

**O Maven pode manter varias versões da mesma dependencia no repositorio local**

- QUESTÃO 5 DE 10: Sobre a GOAL package, qual das afirmativas abaixo está INCORRETA?

Executa a compilação do projeto

Executa os testes do projeto

**Gera o artefato e disponibiliza no repositório local**

Faz parte do Core Plugin do Maven

- QUESTÃO 6 DE 10: Sobre o Ciclo de Vida Padrão de Build no Maven, qual dessas alternativas não faz parte dele?

**execute**

verify

package

validate

- QUESTÃO 7 DE 10: Qual das alternativas abaixo é uma goal que NÃO faz parte do Core Plugin do Maven?

clean

install

package

**sql:execute**

- QUESTÃO 8 DE 10: Qual tag do maven permite que o projeto possa "herdar" configurações, incluindo dependências de outro projeto?

	<dependency>

	<parent>
	
	<property>
	
	<repository>
		
Resposta correta: parent

- QUESTÃO 9 DE 10: Sobre o deploy de aplicações Spring Boot, qual alternativa abaixo é VERDADEIRA?

Para aplicações WEB, por padrão o Spring Boot gera um artefato WAR que pode ser implantado em um Servidor Tomcat ou similares

Para aplicações WEB, por padrão o Spring Boot gera um artefato JAR que pode ser implantado em um Servidor Tomcat ou similares

**Para aplicações WEB, por padrão o Spring Boot gera um artefato JAR com um Tomcat embarcado que pode ser implantado diretamente em produção**

Nenhuma das alternativas acima

- QUESTÃO 10 DE 10: Qual alternativa abaixo não faz parte dos objetivos de Continuous Integration?

Automatização de processo do processo de integraçao entre diferentes branchs

Automatização da execução de testes unitários

**Automatização do deploy no ambiente de produção**

Automatização da execução de testes de integração
