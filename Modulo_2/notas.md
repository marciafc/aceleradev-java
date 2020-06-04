# Tópicos

 - [FP vs. OO](https://blog.cleancoder.com/uncle-bob/2018/04/13/FPvsOO.html) 
 
 - [Programação Orientada a Objetos com Java](https://www.devmedia.com.br/programacao-orientada-a-objetos-com-java/18449)
 
 - [Encapsulamento, Polimorfismo, Herança em Java](https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991)
 
 - [Java Exceptions](https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601)

  - [Entendendo e Aplicando Herança em Java](https://www.devmedia.com.br/entendendo-e-aplicando-heranca-em-java/24544)

  - Orientação, classes e objetos

  - Encapsulamento

  - Exceptions

  - Herança e Polimorfismo

  - Desafios
    - Gerenciador de Times de Futebol
    - Controle de estacionamento
    - Media, Moda e Mediana

  - Feedback semanal

## Java

 **Java** é **compilada** porque isso permite encontrar erros antes de executar o programa e facilita executar os programas mais eficientemente, e é **interpretada** porque isso permite que o mesmo arquivo compilado possa ser executado em qualquer computador ou sistema operacional que tenha um interpretador Java – o que, atualmente, equivale a quase qualquer computador, de smartphones a mainframes.
 
 O **interpretador Java**, além de **interpretar as instruções compiladas**, também é responsável por **retirar da memória objetos que não são mais utilizados**. O algoritmo que executa essa tarefa de “limpeza” é chamado de coletor de lixo, e é um dos grandes atrativos do Java: em linguagens mais tradicionais, como C e C++, o programador é responsável por limpar a memória na mão, o que é uma tarefa tediosa e até perigosa.

 Fonte: [Programação Orientada a Objetos com Java](https://www.devmedia.com.br/programacao-orientada-a-objetos-com-java/18449)

## Encapsulamento, Polimorfismo, Herança em Java

A programação orientada a objeto tem três pilares, **encapsulamento**, **herança** e **Polimorfismo**

Uma **interface** nada mais é do que um bloco de código definindo um tipo e os métodos e atributos que esse tipo deve possuir. Na prática o que acontece é que qualquer classe que quiser ser do tipo definido pela interface deve implementar os métodos dessa interface. 

A **interface** não contém nenhum código de implementação, apenas assinaturas de métodos e/ou atributos que devem ter seu código implementado nas classes que implementarem essa interface. 

A **interface** define um padrão para especificação do comportamento de classes. Porém, os métodos de uma interface são implementados de maneira particular a cada classe; ou seja, permitem expressar comportamento sem se preocupar com a implementação. Uma interface não possui atributos. Uma classe pode implementar várias interfaces, mas pode ter apenas uma superclasse.

Uma **classe abstrata** nada mais é do que uma especificação conceitual para outras classes. Isso que dizer que nunca iremos instanciá-la. Ela apenas fornece um modelo para geração de outras classes. Esta nunca está completa, ou seja, servirá apenas para criação de funcionalidades genéricas de casses filhas. Podemos também chamar as classes abstratas de super classe. 

**Modificadores de acesso**:

<img src="https://www.devmedia.com.br/imagens/Nova%20pasta%20%282%29/pb_30_05_09_pic01.JPG">

 - Private: A única classe que tem acesso ao atributo é a própria classe que o define

 - Package (default): É o modificador padrão quando outro não é definido. Tem acesso a todas as classes que estiverem no mesmo pacote que a classe que possui o atributo.

 - Protected: Esse é o que pega mais gente, ele é praticamente igual ao default, com a diferença de que se uma classe (mesmo que esteja fora do pacote) estende da classe com o atributo protected, ela terá acesso a ele. Então o acesso é por pacote e por herança.

 - Public: Todos tem acesso 

 **Encapsulamento** vem de encapsular, que em programação orientada a objetos significa separar o programa em partes, o mais isolado possível.

 O **Encapsulamento** serve para controlar o acesso aos atributos e métodos de uma classe. 

A **herança** é um mecanismo da Orientação a Objeto que permite criar novas classes a partir de classes já existentes, aproveitando-se das características existentes na classe a ser estendida. 

Com a **herança** é possível criar classes derivadas, subclasses, a partir de classes bases, superclasses. As subclasses são mais especializadas do que as suas superclasses, mais genéricas. As subclasses herdam todas as características de suas superclasses, como suas variáveis e métodos. 

Na Orientação a Objetos as palavras **classe base**, **supertipo**, **superclasse**, **classe pai e classe mãe** são sinônimos, bem como as palavras **classe derivada**, **subtipo**, **subclasse** e **classe filha** também são sinônimos.

Juntamente com a herança deve ser enfatizada a importância do **polimorfismo**, que permite selecionar **funcionalidades** que um programa irá utilizar de forma dinâmica, **durante sua execução**.

**Polimorfismo** é o princípio pelo qual duas ou mais classes derivadas de uma mesma superclasse podem invocar métodos que têm a mesma identificação, assinatura, mas comportamentos distintos, especializados para cada classe derivada, usando para tanto uma referência a um objeto do tipo da superclasse. 

**O overload não é um tipo de polimorfismo**, pois com overload a assinatura do método obrigatoriamente tem que ter argumentos diferentes, requisito que fere o conceito de Polimorfismo.

No caso de **polimorfismo**, é necessário que os **métodos tenham exatamente a mesma identificação**, sendo utilizado o mecanismo de redefinição de métodos, que é o mesmo que **sobrescrita** (override) de métodos em classes derivadas. 

[Qual a finalidade da @Override?](https://pt.stackoverflow.com/questions/22913/qual-a-finalidade-da-override)

**Métodos** declarados como **final** não podem ser redefinidos e, portanto **não são passíveis de invocação polimórfica** da parte de seus descendentes; 

**Métodos** declarados como **private são implicitamente finais**. 

Fonte: 

[Qual é a diferença entre modificadores public, default, protected e private?
](https://pt.stackoverflow.com/questions/23/qual-%C3%A9-a-diferen%C3%A7a-entre-modificadores-public-default-protected-e-private)

[Encapsulamento, Polimorfismo, Herança em Java](https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991)

## Exceções

Erro ≠ Exceção

- Erro: causado por erro DENTRO da JVM. Ex: memória cheia

- Exceção: causado por erro FORA da JVM. Ex: divisão por zero

Hierarquia (em **vermelho são checked exception** e em **amarelo são as unchecked Exception**):

<img src="https://www.oracle.com/technetwork/es/images/img1-5928057.png">

Classe [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html): superclasse de todas as classes de erros

Classe [Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html): superclasse de todas as classes de exceções:

 - Nativas

 - Próprias  // definidas pelo programador

Tipos de Classe de Exceção

- Runtime (unchecked exception)

  - Subclasses de [RuntimeException](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html)

  - Não têm de ser capturadas e tratadas pelos programas

- Não-Runtime (checked exception)
  
  - Subclasses de [Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) (exceto RuntimeException)

  - Têm de ser capturadas e tratadas pelos programas

Cláusulas de Captura e Tratamento

```java
try {

    // código que pode gerar uma exceção

} catch (TipoDeException e) {

    // tratamento da exceção capturada

} finally {

    // o finally é opcional 
    // este bloco sempre será executado
}

// OU

try {

} catch (TipoDeException1 e) {

    // tratamento para o tipo de exceção TipoDeException1

} catch (TipoDeException2 e) {

    // tratamento para o tipo de exceção TipoDeException2
    
} finally {

}

// OU 

try {

} catch (TipoDeException1  | TipoDeException2 e) {

    // mesmo tratamento para TipoDeException1 ou TipoDeException2

} finally {

}
```    

Se há mais de uma cláusula catch elas deverão ser dispostas da subclasse mais específica até a subclasse mais abrangente.

try {} 

catch ([IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) e) {} //IllegalArgumentException é subclasse de RuntimeException.

catch ([RuntimeException](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html) e) {}         //RuntimeException é subclasse de Exception.

catch ([Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) e) {}

Tipos de Exceção

 - Implícitas: lançadas automaticamente pela JVM.

 - Explícitas: lançadas por código definido pelo programador.

Cláusulas throw/throws

As cláusulas **throw** e **throws** podem ser entendidas como ações que **propagam exceções**, ou seja, em alguns momentos existem exceções que não podem ser tratadas no mesmo método que gerou a exceção. 

 - throw: lançar explicitamente exceção dentro de método. Cria um novo objeto de exceção que é lançada.

```java
public static void saque(double valor) {
    if(valor > 400) {
        IllegalArgumentException erro = new IllegalArgumentException();
        throw erro;
    } else {
        System.out.println("Valor retirado da conta: R$"+valor);
    }
}
    
    // OU

public static void saque(double valor) {
    if(valor > 400) {
        throw new IllegalArgumentException();
    } else {
        System.out.println("Valor retirado da conta: R$"+valor);
    }
}
```    
 
 - throws: declara as exceções que podem ser lançadas em determinado método, sendo uma vantagem muitas vezes para outros desenvolvedores que mexem no código, pois serve para deixar de modo explícito o erro que pode acontecer no método, para o caso de não haver tratamento no código de maneira correta.
 
 ```java
 public static int calculaQuociente(int numerador, int denominador) throws ArithmeticException {
    return numerador / denominador;
}
 ```

 O lançamento de exceções não checadas (e erros) não exige que elas sejam declaradas na assinatura do método. A utilização de throws, então, é opcional.

 ```java
 void metodoQualquer() {
    throw new RuntimeException(); //Exceção não checada. throws opcional.
}
 ```

 Enquanto que para exeções checadas a declaração é obrigatória.

```java
 void metodoQualquer1() throws Exception {
    throw new Exception(); // Exceção checada. Requer throws.
}

//NÃO COMPILA
void metodoQualquer2(){
    throw new Exception(); // Exceção checada. Requer throws.
}
```

Métodos para captura de erros

 - printStrackTrace – Imprime uma mensagem da pilha de erro encontrada em um exceção.

 - getStrackTrace – Recupera informações do stracktrace que podem ser impressas através do método printStrackTrace.

 - getMessage – Retorna uma mensagem contendo a lista de erros armazenadas em um exceção no formato String.

Como trabalhar com checked, unchecked ou error:

Quando as **checked Exceptions** devem ser usadas? Use checked Exceptions quando houver um erro recuperável ou um requisito de negócio importante.

A **exceção verificada** mais comum é a **classe Exception**. Duas classes relacionadas da Exception são FileNotFoundException e SQLException. Você é obrigado a manipular ou declarar essas exceções. Você **deve lançar ou capturar a exceção**, caso contrário o código não será compilado.

Quando as **unchecked Exceptions** devem ser usadas? Use unchecked Exceptions **quando não houver recuperação**. Por exemplo, quando a memória do servidor é usada em excesso.

**RuntimeException** é usado para erros quando seu aplicativo **não pode recuperar**. Por exemplo, NullPointerException e ArrayOutOfBoundsException. **Você pode evitar uma RuntimeException com um comando 'if'**. Você não deve lidar com isso ou capturar a Exception.

Há também a **classe Error**. Também é uma **exceção não verificada**. **Nunca tente capturar ou manipular** esse tipo de exceção. Eles **são erros da JVM** e são o tipo mais grave de exceção em Java. Você deve analisar a causa de exceções como essa e corrigir seu código.

Fonte: 

[Java/Exceções](https://pt.wikibooks.org/wiki/Java/Exce%C3%A7%C3%B5es)

[Linguagem JAVA - Exceções](http://www.dei.isep.ipp.pt/~nfreire/JAVA%20-%20Exce%C3%A7%C3%B5es.pdf)

[11 Erros que desenvolvedores Java cometem quando usam Exceptions](https://www.oracle.com/technetwork/pt/articles/java/erros-java-exceptions-5928058-ptb.html)

[Trabalhando com Exceções em Java](https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601)