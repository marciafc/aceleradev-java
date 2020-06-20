# Tópicos

 - Spring Security (vídeo)

 - Swagger (vídeo)

 - [Algaworks - Spring Security e o protocolo OAuth2 na sua API RESTful](https://www.youtube.com/watch?v=UsM2BY20Ux4)

 - [Uma introdução ao OAuth 2](https://www.digitalocean.com/community/tutorials/uma-introducao-ao-oauth-2-pt)

 - [Autenticação com Spring e OAuth2](https://academiadev.gitbook.io/joinville/seguranca/oauth2)
   - [Github](https://github.com/rartner/autenticacao)

 - [Caelum - Modelando APIs REST com Swagger](https://blog.caelum.com.br/modelando-apis-rest-com-swagger/)
   - Contract-First ou API-First Development
   
   - Contract-Last 

 - [Swagger Documentation](https://swagger.io/docs/)  

 - [SpringFox](https://springfox.github.io/springfox/)
   - SpringFox é uma ferramenta open source desenvolvida para integrar projetos Spring Boot com a especificação Swagger. 
   
     A ferramenta fornece as anotações necessárias para a criação da documentação Swagger e uma interface amigável (SpringFox Swagger-UI) para expor as documentações da API Rest.
   
     Após iniciar a aplicação, o endpoint 

   	 http://server:port/v2/api-docs 
	   
     estará disponível e trazendo a documentação em forma de JSON.

     Para melhor visualização, pode ser utilizada a interface amigável fornecida pela biblioteca para visualizar a documentação. 
   
     A documentação estará disponível na url **http://server:port/swagger-ui.html** 
   
     Fonte: [Documentação de APIs utilizando SpringFox
](https://tjf.totvs.com.br/docs/swagger-springfox)

 - [Algaworks - O que é Spring Security?](https://blog.algaworks.com/spring-security/)
   - autenticação via memória, JDBC e JPA (com o UserDetailsService)
   - 3 tipos de login: HTTP Basic, formulário HTML do próprio Spring Security e formulário personalizado
   - incluir permissões para diferentes URLs 
   - [Github](https://github.com/algaworks/artigo-spring-security)

 - [Spring Security Documentação HTML](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)

   - [Spring Security Documentação PDF](https://docs.spring.io/spring-security/site/docs/current/reference/pdf/spring-security-reference.pdf)

 - [Spring Boot 2 And OAuth 2 - User Authorization and Token Revocation](https://pattern-match.com/blog/2019/02/12/springboot2-and-oauth2-authorization-and-revocation/)
 
 - Implementing OAuth2 in Spring

   - [Part 1](http://www.zakariaamine.com/2018-01-27/using-oauth2-in-spring)

   - [Part 2](http://www.zakariaamine.com/2018-03-01/using-oauth2-in-spring-scopes)	 

 - [Projeto Spring Security](https://dzone.com/articles/spring-security-with-oauth2)
   - Neste projeto as classes estão separadas:
     - Resource Server (@EnableResourceServer)
	 - Authorization Server (@EnableAuthorizationServer)
	 - Security Configuration (Autenticação - @EnableWebSecurity)    

 - [Documentação Spring - Exemplo login](https://spring.io/guides/gs/securing-web/)

 - [Spring Security Form Login](https://www.baeldung.com/spring-security-login)

 - [Java EE (Jakarta EE) com Spring Security](https://www.baeldung.com/java-ee-spring-security)
 
 - [OAuth 2.0 - Guia do Iniciante](https://www.brunobrito.net.br/oauth2)
 
   - [OAuth 2 // Dicionário do Programador - Youtube](https://www.youtube.com/watch?v=z-RuvnMlw34)

 - Desafio:
   - Oauth2 com spring

 - Feedback semanal  

## Spring Security com OAuth2

OAuth2: separa as camadas de segurança (autenticação, autorização, resource)
  - Github pode ser o servidor de **autenticação** (usuário e senha válidos) -> Authentication Server
  
  - A aplicação pode ser o servidor de **autorização** (se o usuário tem permissão para acessar a funcionalidade) -> Authorization Server
  
  - API é o **resource** -> Resource Server
  
A mesma aplicação pode ser responsável pelos três papéis.  

## Projeto

Ver projeto [SpringDataExemplo na aula 4](../Modulo_4)

pom.xml
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.security.oauth.boot</groupId>
	<artifactId>spring-security-oauth2-autoconfigure</artifactId>
	<version>2.0.1.RELEASE</version>
</dependency>

```

## Implementando a parte de segurança com Spring Security

```java

// As três anotações abaixo: habilitam a app para ter os três papéis: autenticação, autorização, resource
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SegurancaConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserDetailsService userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		// O que deve ser ignorado pelo Spring Security
		web.ignoring().antMatchers("/v2/api-docs",
			"/configuration/ui",
			"/swagger-resources/**",
			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**");
	}
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		// Configura serviço padrão de userDetail
		// passwordEncoder(..) encoder de senha (criptografia)
		auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder());
	}	
	
	// Aqui configura o password encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
	
		// NoOpPasswordEncoder: não tem criptografia (só para testes)
		return NoOpPasswordEncoder.getInstance();
	}	

}
```

Implementação de **"UserDetailsService"** está em **br.com.spring.data.usuario.service.UsuarioServiceImpl**

Implementação de **"UserDetails"** está em **br.com.spring.data.usuario.model.Usuario**

## Usuário, papéis: getAuthorities()

```java
@Entity
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String login;
	private String password;


	// getAuthorities poderia vir de uma tabela contendo os papéis do usuário (roles)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
	}
}
```

## Configurando escopo, usuário e senha da aplicação de autenticação

application.properties

```
#Oauth2
security.oauth2.client.scope=password
security.oauth2.client.client-id=codenation
security.oauth2.client.client-secret=codenation123

```
O escopo da aplicação será utilizado para geração do hash

	security.oauth2.client.scope=password

Se comentar essas duas linhas e subir a aplicação, o Spring irá gerar o **usuário e senha de autenticação da aplicação**
e irá exibir no console.

	#security.oauth2.client.client-id=codenation
	#security.oauth2.client.client-secret=codenation123

	// Será exibido no console algo assim:
	security.oauth2.client.client-id = 5c3ccc81-d5c3-4d9e-8488-6d9ea52cff39
	security.oauth2.client.client-secret = 862c0b27-4dc0-4a72-b8b7-6eb29ce3555e

## Usuário em memória

Caso nao configure o usuário no banco de dados ou em memória (através do método configure), o Spring irá gerar uma senha para o usuário. Neste caso, usuário é "user" (conforme documentação do Spring) e a senha será gerada pelo Spring e exibida no console.

	// Será exibido no console algo assim:
	Using generated security password: f774a805-43f6-42e9-b51b-9c760d05b3c1

Configurando o usuário em memória na classe SegurancaConfiguration:

```java
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("alexandre").password("123").roles("ADMIN");
	}	
```	
Fonte: [Spring Security e o protocolo OAuth2 na sua API RESTful](https://www.youtube.com/watch?v=UsM2BY20Ux4)

## Testando a aplicação agora com Spring Security

Ao subir a aplicação, será disponibilizada uma URI neste formato:

	POST http://<ip>:<porta>/oauth/token 

## Como gerar o token pelo Postman
	
- POST  http://localhost:8080/oauth/token
	
- Aba "Authorization": selecionar em "Type" o valor "Basic Auth" e preencher **Username e Password com os dados de autenticaçao da aplicação**	(é o que está configurado em "security.oauth2.client.client-id" e "security.oauth2.client.client-secret", respectivamente).
   
- Clicar em "Send"
	- Na aba "Header" será gerado um hash ("Authorization")

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo1_fiYT2RJFHn.png">
	
<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo1_hash_HJlFDwgtt.png">
	
- Aba "Body" preencher:	
  - grant_type: maneira que quer que autentique (é o que está configurado em "security.oauth2.client.scope")

  - username e password: agora é o **usuário e senha do usuário** que deseja se autenticar    
    - Neste projeto de exemplo, o usuário foi inserido no banco de dados ao subir a aplicação via /resources/data.sql.
  
- Clicar em "Send"	
		
<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo2_R4TfvvaA_K.png">	

Fazendo requisição COM o token:

  - Incluir no "Header" da requisição HTTP, a key "Authorization" com o valor "bearer <access_token>" 
	
	bearer b7eb95fc-25c9-4a60-86c0-0399137828c8

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_autentica_AceMC0CVS10.png">	
	
Fazendo requisição SEM o token:	

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_nao_autentica.png_b2ELDmpKSgS.png">	
				
	
## Swagger com SpringFox

- Criar Swagger primeiro e então gerar os endpoints
  - [Exemplo Swagger Petstore](https://editor.swagger.io/)
  - [Swagger: Como gerar uma documentação interativa para API REST](http://www.matera.com/blog/post/swagger-como-gerar-uma-documentacao-interativa-para-api-rest)
  - [Primeiros passos com Swagger - Introdução](https://www.alura.com.br/conteudo/swagger-crie-uma-documentacao-rest)
  - [Swagger Editor](https://swagger.io/tools/swagger-editor/)

- Criar endpoints e então documentar com o Swagger

pom.xml
```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```
Ativar e configurar o Swagger
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// ...
}
```

URI de acesso: 

	http://localhost:8080/swagger-ui.html


O Swagger fornece a chamada vir Curl

	curl -X GET "http://localhost:8080/livro?pageNumber=1&pageSize=1" -H "accept: */*" -H "Content-Type: application/json" -d "\"string\""

Ou via Request URL

	http://localhost:8080/livro?pageNumber=1&pageSize=1

Melhorando a documentação dos métodos do Controller

  - @ApiOperation

  - @ApiResponse
  
  - @ApiResponses

  - @ApiModelProperty

```java
@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	@ApiOperation("Cria um novo livro")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Livro criado com sucesso")})
	public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {

		return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);

	}

	@GetMapping
	@ApiOperation("Lista todos os livros")
	public Iterable<Livro> findAll(@PathParam("nome") String nome, Pageable pageable) {
		
		if (nome != null) {
			return this.livroService.findByNome(nome.toString(), pageable);
		}

		return this.livroService.findAll(pageable);
	}

	@DeleteMapping("/{id}")
	@ApiResponse(code = 200, message = "Livro excluído")
	public void delete(@PathVariable("id") Long id) {

		this.livroService.deleteById(id);

	}

	@GetMapping("/{id}")
	@ApiResponses(value = {
		@ApiResponse(code = 404, message = "Livro não localizado"), 
		@ApiResponse(code = 200, message = "Livro localizado")})
	public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {

		return new ResponseEntity<Livro>(this.livroService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Livro")),HttpStatus.OK);

    }


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@NotBlank(message = "O Título não pode ser vazio")
	@ApiModelProperty(notes = "Título do livro", required = true)
	private String titulo;

	//...
	}		
```

## Atualizando token

Quando quisermos apenas atualizar o token do usuário já conectado, podemos enviar uma requisição para a mesma url, porém da forma

	http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token={REFRESH_TOKEN}, 

sendo REFRESH_TOKEN o mesmo que foi retornado no momento da autenticação do usuário.		

Fonte:

 - [Autenticação com Spring e OAuth2](https://academiadev.gitbook.io/joinville/seguranca/oauth2)
   - [Github](https://github.com/rartner/autenticacao)