# Tópicos

 - APIs, HTTP e REST (vídeo)

 - SpringWeb - REST (vídeo)
 
   - [Documentação Spring](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html)
   
   - [Documentação Spring Web](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
 
 - Bean Validation (vídeo)
 
 - HTTP Status Codes e Exception Handler (vídeo)
 
 - 🔝 [All You Need To Know About Bean Validation With Spring Boot](https://reflectoring.io/bean-validation-with-spring-boot)
 
 - [Validation in Spring Boot](https://www.baeldung.com/spring-boot-bean-validation)
 
 - [Using @ResponseStatus to Set HTTP Status Code](https://www.baeldung.com/spring-response-status)
 
 - [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
 
 - [HTTP response status codes](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status)
 
 - [REST: Princípios e boas práticas](http://blog.caelum.com.br/rest-principios-e-boas-praticas)
 
 - Desafios:
    - Criando endpoints com Spring
	
    - Gerador de frases do Monty Python utilizando Spring Boot e JPA

 - Feedback semanal

## Projeto Spring Boot, Spring Data e Spring Web

Projeto [SpringDataExemplo](../Modulo_4/SpringDataExemplo)

Verbos HTTP

 - A ação não fica na URI: **/livros/salvar -> está errado! Quem dá a semântica é o verbo HTTP**
 
   - GET: buscar recurso
 
   - POST: insere o recurso
  
   - PUT: atualizar todo o recurso 
  
   - PATCH: atualizar parte do recurso [PUT vs. PATCH: Pare agora de escolher o errado](https://medium.com/@gabrielrufinoo/put-vs-patch-pare-de-agora-escolher-errado-533b8c6058d9)
 
   - DELETE deletar o recurso
   
## Evite adicionar na URI o formato desejado da representação do recurso

É comum que um serviço REST suporte múltiplos formatos para representar seus recursos, tais como XML, JSON e HTML. 

A informação sobre qual o formato desejado por um cliente ao consultar um serviço REST deve ser feita 
via **Content Negotiation**.

Portanto, evite definir URIs que contenham o formato desejado de um recurso, tais como: 

	http://servicorest.com.br/produtos/xml
	
	http://servicorest.com.br/clientes/112?formato=json

Os três principais formatos suportados pela maioria dos serviços REST são: HTML, XML e JSON

Fonte: [REST: Princípios e boas práticas](https://blog.caelum.com.br/rest-principios-e-boas-praticas)

### Utilize Content Negotiation para o suporte de múltiplas representações

Ao fazer uma chamada ao serviço REST, um cliente pode **adicionar na requisição o cabeçalho accept**, para **indicar ao servidor o formato desejado** da representação do recurso. 

Fonte: [REST: Princípios e boas práticas](https://blog.caelum.com.br/rest-principios-e-boas-praticas)

## HATEOAS (Hypermedia As the Engine Of Application State)

É um modelo simples e elegante com que uma API REST pode ser desenhada para que a mesma permita que aplicações que a consumam navegue entre seus recursos através de links e URLs sem a necessidade de conhecimento denso prévio sobre a API.

	{
		"estados": [
			{
				"id": "1",
				"nome": "Rio de Janeiro",
				"pais": "Brasil",
				"times": "http://apirest.com/api/cidades/1/times"
			},
			{
				"id": "2",
				"nome": "São Paulo",
				"pais": "Brasil",
				"times": "http://apirest.com/api/cidades/2/times"
			}
		]
	}

Fonte: [A importância do HATEOAS em APIs Restful](https://medium.com/@mellomatheuslima/a-import%C3%A2ncia-do-hateoas-em-apis-restful-1ca2dc081288)
 
## Spring Web

[Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content)

[Web on Servlet Stack](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)

```java

// Pageable: paginação (parâmetro page na URI). Exemplo: localhost:8080/livro?nome=Nome&page=0&size=2
// - parâmetro "page" default 20
// - parâmetro "size" tamanho das páginas

@GetMapping
public Iterable<Livro> findAll(@PathParam("nome") String nome, Pageable pageable) {
	if (nome != null) {
		return this.livroService.findByNome(nome.toString(), pageable);
	}
	return this.livroService.findAll(pageable);
}

@GetMapping("/{id}")
public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
	return new ResponseEntity<Livro>(this.livroService.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Livro")),HttpStatus.OK);
}
```

**PathParam   X   PathVariable**

@PathVariable and @PathParam both are used for accessing parameters from URI Template

Differences:

 - As you mention **@PathVariable is from Spring** and **@PathParam is from JAX-RS**.
 
 - @PathParam can use with REST only, where @PathVariable used in Spring so it works in MVC and REST. 
 
Fonte: https://stackoverflow.com/questions/32367501/what-is-the-difference-between-pathparam-and-pathvariable


## Pageable

[Pageable](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Pageable.html)

```java

// Classe LivroServiceImpl: observe o getContent(): tranforma o retorno em uma List<Livro>

@Override
public List<Livro> findByNome(String nome, Pageable pageable) {
	return this.livroRepository.findByTituloContaining(nome, pageable).getContent();
}
```

```java
// classe LivroRepository: Retorna uma Page<Livro> 

Page<Livro> findByTituloContaining(String titulo, Pageable pageable);

```

## Bean Validation

É possível criar constraints personalizadas (Bean Validation):  

  - [Method Constraints with Bean Validation 2.0](https://www.baeldung.com/javax-validation-method-constraints)

  - [All You Need To Know About Bean Validation With Spring Boot](https://reflectoring.io/bean-validation-with-spring-boot/)
  
  - E tem como criar validações com o Spring:
  
    - [Spring - Validation, Data Binding, and Type Conversion](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#validation)


```java

// Colocar a anotação @Valid antes do @RequestBody 

@RestController
@RequestMapping("/livro")
public class LivroController {

	@PostMapping
	public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
		return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);
	}
}	


// Anotações de validação
@Entity
public class Livro {

	@NotNull // não nulo
	@NotBlank(message = "O Título não pode ser vazio")
	private String titulo;

	@Min(0) // Valor mínimo
	@Max(10) // Valor máximo
	@PositiveOrZero // Positivo ou zero
	private Long quantidadeEstoque;
	
	@OneToMany
    @NotEmpty // Não permite lista vazia
    private List<Avaliacao> avaliacoes;
}	

```

Bean Validation - Regex

```java
@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
private String ipAddress;

```

@Validated: a nível de classe.

  - [All You Need To Know About Bean Validation With Spring Boot](https://reflectoring.io/bean-validation-with-spring-boot/)

```java

// Validando um Service

@Service
@Validated
class ValidatingService{

    void validateInput(@Valid Input input){
      // do something
    }

}
```

## Validação (BEAN VALIDATION) não está funcionando

Caso não esteja validando: pode ser que você tenha esquecido de criar os getters e setters.

## Validar variáveis na URI e parâmetros no Request

@PathVariable("id") @Min(5) int id

@RequestParam("param") @Min(5) int param

```java
@Validated
class ValidateParametersController {

	@GetMapping("/validatePathVariable/{id}")
	ResponseEntity<String> validatePathVariable(@PathVariable("id") @Min(5) int id) {
		return ResponseEntity.ok("valid");
	}

	@GetMapping("/validateRequestParameter")
	ResponseEntity<String> validateRequestParameter(@RequestParam("param") @Min(5) int param) { 
		return ResponseEntity.ok("valid");
	}
}
```

## Códigos de status de respostas HTTP

https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status

200 OK: tudo OK

201 Created: quando insere com sucesso

202 Accepted: quando faz uma requisição que foi aceita, mas ainda não tem uma resposta (ex processamento em lote)

204 No Content: pode ser utilizada no delete com sucesso

## Tratamento quando o recurso não exista, retornar um 404

[Documentação ControllerAdvice](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html)

```java

// 404 Not Found: orElseThrow(() -> new ResourceNotFoundException("Livro"))

@GetMapping("/{id}")
public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {

	return new ResponseEntity<Livro>(this.livroService.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Livro")),HttpStatus.OK);
}

// @ControllerAdvice: handler global para um tipo específico de exceção
// Nos exemplos, os métodos estão retornando String, poderia ser uma entidade convertida para json

// @ExceptionHandler(MethodArgumentNotValidException.class): qual exceção vai tratar
// @ResponseStatus(HttpStatus.BAD_REQUEST): qual status code vai ser retornado
// @ResponseBody: o resultado vai no corpo da resposta

@ControllerAdvice
public class LivroControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return ex.getBindingResult().getFieldError().getField() + " - " + ex.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception ex) {
        return "Internal Server Error: " + ex.getMessage();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

}

```

Além do @ControllerAdvice (é um error handler), há outras maneiras de implementar o tratamento de exceções para uma API REST no Spring:

  - [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
  
  - [Using Spring @ResponseStatus to Set HTTP Status Code](https://www.baeldung.com/spring-response-status)

## Teste de integração

```java
// Fonte: https://www.baeldung.com/spring-boot-bean-validation

@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
 
	@MockBean
	private UserRepository userRepository;

	@Autowired
	UserController userController;

	@Autowired
	private MockMvc mockMvc;

	//...
	
	@Test
	public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
	
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
			mockMvc.perform(MockMvcRequestBuilders.post("/users")
			.content(user)
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
			.contentType(textPlainUtf8));
	}	
     
}
```