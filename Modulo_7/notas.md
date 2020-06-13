# Tópicos

 - Spring Security (vídeo)

 - Swagger (vídeo)


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

# Configurando escopo, usuário e senha da aplicação de autenticação

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
	
Ao subir a aplicação, será disponibilizada uma URI neste formato:

	POST http://<ip>:<porta>/oauth/token 

## Como gerar o token pelo Postman
	
- POST  http://localhost:8080/oauth/token
	
- Aba "Authorization": selecionar em "Type" o valor "Basic Auth" e preencher **Username e Password com os dados de autenticaçao da aplicação**	
	- Na aba "Header" será gerado um hash ("Authorization")

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo1_fiYT2RJFHn.png">
	
<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo1_hash_HJlFDwgtt.png">
	
- Aba "Body" preencher:	
  - grant_type: maneira que quer que autentique (vem da configuração: security.oauth2.client.scope)

  - username e password: agora é o **usuário e senha do usuário** que deseja se autenticar
    - Neste projeto de exemplo, o usuário foi inserido no banco de dados ao subir a aplicação via /resources/data.sql
		
<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_passo2_R4TfvvaA_K.png">	

Fazendo requisição COM o token:

  - Incluir no "Header" da requisição HTTP, a key "Authorization" com o valor "bearer <access_token>" 
	
	bearer b7eb95fc-25c9-4a60-86c0-0399137828c8

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_autentica_AceMC0CVS10.png">	
	
Fazendo requisição SEM o token:	

<img src="https://ik.imagekit.io/wmdxyyoe83/spring_security_nao_autentica.png_b2ELDmpKSgS.png">	
				
	
## Swagger com SpringFox




