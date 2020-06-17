# Tópicos

 - Clean Code e SOLID (vídeo)

 - TDD (vídeo)
 
 - [Princípios do Código Sólido na orientação a objetos](https://blog.caelum.com.br/principios-do-codigo-solido-na-orientacao-a-objetos)
 
 - [Princípios S.O.L.I.D: o que são e porque projetos devem utilizá-los](https://medium.com/equals-lab/princ%C3%ADpios-s-o-l-i-d-o-que-s%C3%A3o-e-porque-projetos-devem-utiliz%C3%A1-los-bf496b82b299) | [Github com todos exemplos](https://github.com/mariazevedo88/artigo-solid-medium)
 
   - Princípio da Responsabilidade Única (SRP) | [Github](https://github.com/mariazevedo88/artigo-solid-medium/tree/master/src/io/github/mariazevedo88/solid/srp)
   
   - Princípio do Aberto/Fechado (OCP) | [Github](https://github.com/mariazevedo88/artigo-solid-medium/tree/master/src/io/github/mariazevedo88/solid/ocp)
   
   - Princípio da Substituição de Liskov (LSP) | [Github](https://github.com/mariazevedo88/artigo-solid-medium/tree/master/src/io/github/mariazevedo88/solid/lsp)
   
   - Princípio da Segregação de Interfaces (ISP) | [Github](https://github.com/mariazevedo88/artigo-solid-medium/tree/master/src/io/github/mariazevedo88/solid/isp)
   
   - Princípio da Inversão de Dependências (DIP): Quando falamos do OCP, também vimos um exemplo do DIP, mas não falamos exclusivamente dele. Ao fazermos a refatoração da classe CalculadoraDePrecos, ao invés de termos dependência direta das classes concretas TabelaDePrecoAVista e TabelaDePrecoAPrazo para calcular o desconto tabelado do produto e o frete, invertemos e passamos a depender de duas interfaces TabelaDePreco e Frete. Assim, passamos a evoluir e manter apenas as classes concretas, ou seja, os detalhes.

 - [Clean Code: aprenda a manter o seu código limpo!](https://becode.com.br/clean-code)
 
 - [Boas práticas técnica para um código limpo (Clean Code)](https://pt.slideshare.net/rodrigokono/boas-prticas-tcnica-para-um-cdigo-limpo-clean-code)
 
 - [Object Calisthenics](https://williamdurand.fr/2013/06/03/object-calisthenics)
 - [Desenvolva um código melhor com Object Calisthenics](https://medium.com/@rafaelcruz_48213/desenvolva-um-c%C3%B3digo-melhor-com-object-calisthenics-d5364767a9ba)
 
   - [Only One Level Of Indentation Per Method](https://github.com/martensjostrand/EDGE2013_Slides/wiki/One-level-of-indentation-per-method)
   
   - [Don’t Use The ELSE Keyword](https://github.com/martensjostrand/EDGE2013_Slides/wiki/Don%27t-use-the-else-keyword)
   
   - [Wrap All Primitives And Strings](https://github.com/martensjostrand/EDGE2013_Slides/wiki/Wrap-all-primitives-and-strings)
   
   - [First Class Collections](https://github.com/martensjostrand/EDGE2013_Slides/wiki/First-class-collections)
   
   - [One Dot Per Line](https://github.com/martensjostrand/EDGE2013_Slides/wiki/One-dot-per-line)
   
   - [Don’t Abbreviate](https://github.com/martensjostrand/EDGE2013_Slides/wiki/Don%27t-abbreviate)
   
   - [Keep All Entities Small](https://github.com/martensjostrand/EDGE2013_Slides/wiki/Keep-all-entities-small)
   
   - [No Classes With More Than Two Instance Variables](https://github.com/martensjostrand/EDGE2013_Slides/wiki/No-class-with-more-than-two-instance-variables)
   
   - [No Getters/Setters/Properties](https://github.com/martensjostrand/EDGE2013_Slides/wiki/No-getters-setters-properties)
 
 - [Test Driven Development: TDD Simples e Prático](https://www.devmedia.com.br/test-driven-development-tdd-simples-e-pratico/18533)
 
 - [Garantia da qualidade de software com TDD (Test Driven Development)](https://www.knowledge21.com.br/blog/qualidade-de-software-com-tdd-test-driven-development)
    
	Resumo:
 
   - Critérios de Aceitação
   
**Dado que** <Condições necessárias>

**Quando** <evento>
	
**Então** <resultado>   
	
```
// Compras menores do que R$ 500,00 permanecem como são hoje, não tem desconto. 
// Compras acima de R$ 500,00 ganham um desconto de 10%.

	Critério de Aceitação 01
	Dado que o cliente fez uma compra de R$ 499,99
	Quando fechar a compra
	Então não recebe desconto E o valor final da compra é R$ 499,99.

	Critério de Aceitação 02
	Dado que o cliente fez uma compra de R$ 500,00
	Quando fechar a compra
	Então recebe um desconto de 10% E o valor final da compra passa a ser R$ 450,00.
```
   - TDD - [Exemplo Github](https://github.com/avelinoferreiragf/K21-CSD)
     - Red, Green, Refactor
   
   - Teste 
     - Arrange Act Assert (AAA)
	   - Arrange é a parte de arranjo, preparação do teste
	   - Act é a ação
	   - Assert é a afirmação
	   
	 - 1, 2, N
	 
```java	 
@Test
public void darDescontoDe5PorCentoAbaixoDe500Reais() {

	// Arrange
	CalculadoraDescontos calculadoraDescontos = new CalculadoraDescontos();
	double valorCompra = 499.99;
	double valorEsperadoAposCalculo = 474.99;

	//Act
	double valorRetornadoAposCalculo = calculadoraDescontos.calcular(valorCompra);

	// Assert
	assertEquals(valorEsperadoAposCalculo, valorRetornadoAposCalculo, 0.001);
}	 
``` 
 - [Introdução ao desenvolvimento guiado por teste (TDD) com JUnit](https://www.devmedia.com.br/introducao-ao-desenvolvimento-guiado-por-teste-tdd-com-junit/26559)
 
 - Desafios:
   - Refatorando Formas de Pagamento
     - [Outro exemplo de implementação com Strategy](https://pt.wikipedia.org/wiki/Strategy)
   
 - Feedback semanal
 
 
## Clean Code

 - Simples
 
 - Legível
   - Código coeso: faz o que se propõem, o que é da sua responsabilidade

 - Testável

 - Constante estado de refatoração
 
 - SOLID
 
   - Single Responsability Principle (princípio da responsabilidade única)     
	 - Coesão (uma classe tem uma e apenas uma razão para mudar)
	 - Classes especializadas
	 - Evitar GOD classes (classes "Deus" - sabe demais ou faz demais)
	 - Dois comportamentos podem pertencer a mesma responsabilidade se ambos mudam juntos
   
   - Open Closed Principle (princípio do aberto/fechado)
     - As clases devem ser ABERTAS a extensões porém FECHADAS para modificações
	 - Evitar que as classes precisem ter seu código alterado para que um comportamento seja alterado
	 - Devemos favorecer a mudança de comportamentos através de mecanismos como COMPOSIÇÃO, HERANÇA e INTERFACES
   
   - Liskov Substitution Principle (princípio da substituição de Liskov)
     - Os subtipos devem poder ser substituídos por qualquer um dos tipos base
	 - Princípio que nos orienta a pensar bem antes de escolher a herança como solução
	 - Necessário analisar pré e pós condições definidas pela super classe
	   - Pré condição: entrada, parâmetros, ...
	   - Pós condição: resultado, retorno, ...
   
   - Interface Segregation Principle (princípio de segregação de interfaces)
     - Muitas interfaces específicas são melhores que interfaces generalistas
	 - Coesão de interfaces
   
   - Dependency Inversion Principle (princípio da inversão de dependência)
     - Reduzir o acoplamento entre as classes
	 - Depender de abstrações e não de tipos concretos
	 - Abstrações não devem depender de detalhes e sim o inverso
	 - Módulos de alto nível não devem depender de módulos de baixo nível	
 
 - Requer prática
 
### Mapa mental Clean Code e SOLID

<img src="https://ik.imagekit.io/wmdxyyoe83/AceleraDevModulo8Aula1-Luisa_Azevedo_VHbW-RWD4.png">
Fonte: Luisa Azevedo (colega do AceleraDev Java)
 
## TDD

 - Red
 - Green
 - Refactor

## Principais ferramentas de testes unitários em Java

 - JUnit
 - Mockito
 - Hamcrest

### Projeto

Projeto do módulo 4 - [SpringDataExemplo](../Modulo_4)

pom.xml
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
	<exclusions>
		<exclusion>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
		</exclusion>
	</exclusions>
</dependency>

```

```java
@RunWith(MockitoJUnitRunner.class) // Vai usar o Mockito
public class LivroServiceImplTest {

	@InjectMocks // Injetando mock da classe que contém os métodos que vai testar
	private LivroServiceImpl livroServiceImpl;

	@Mock //  Mock do respository
	private LivroRepository livroRepository;

	@Test
	public void testFindMaiorMediaAvaliacao() {
		mockFindLivrosComAvaliacao();
		assertEquals(new Integer(4), livroServiceImpl.findByMaiorMediaAvaliacao().getMediaAvaliacoes());
	}

	private void mockFindLivrosComAvaliacao() {
		Livro livro = mock(Livro.class);
		when(livro.getMediaAvaliacoes()).thenReturn(4);
		when(this.livroRepository.findComAvaliacao()).thenReturn(Arrays.asList(livro));
	}

}
```