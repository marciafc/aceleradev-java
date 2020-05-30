# Tópicos

 - Apresentação e introdução a linguagem
 - Métodos, construtores e controles de acesso
 - Arrays, ArrayLists e controler de fluxo
 - [Java - Tipos primitivos](http://www.universidadejava.com.br/materiais/java-tipos-primitivos/)
 - [Explicando os tipos de métodos existentes na programação OO](https://www.devmedia.com.br/metodos/7348)
 - [Controle de Fluxo - Parte l](https://www.devmedia.com.br/controle-de-fluxo-parte-l/5527)
 - [Controle de Fluxo Parte ll](https://www.devmedia.com.br/controle-de-fluxo-parte-ll/5722)
 - [Operadores lógicos e matemáticos da linguagem Java](https://www.devmedia.com.br/operadores-logicos-e-matematicos-da-linguagem-java/25248)
 - [Arraylist Java: Explorando a classe ArrayList no Java](https://www.devmedia.com.br/explorando-a-classe-arraylist-no-java/24298)
- [Gradle | Installation](https://gradle.org/install/)
- [Trabalhando com string: String em Java](https://www.devmedia.com.br/trabalhando-com-string-string-em-java/21737)
- [Tipos de dados por valor e por referência em Java](https://www.devmedia.com.br/tipos-de-dados-por-valor-e-por-referencia-em-java/25293)
- Desafios:
  - Fibonacci
  - Criptografia de Júlio César
  - Calculadora de Salário Líquido
- Feedback semanal  

## Variável primitiva X Variável de referência

Quando declaramos uma **variável primitiva**, estamos associando esta a um espaço na memória que vai guardar o seu valor. 

No caso da **variável de referência**, podemos tê-la apontando para algum lugar vazio (null) ou para algum espaço da memória que guarda os dados de um objeto.

As variáveis primitivas e de referência são guardadas em locais diferentes da memória. **Variáveis primitivas** ficam em um local chamado **stack** e as **variáveis de referência** ficam em um local chamado **heap**. 

Fonte: [Java - Tipos primitivos](http://www.universidadejava.com.br/materiais/java-tipos-primitivos)

## Variáveis

Uma variável é um objeto normalmente localizado na memória utilizado para representar valores, quando declaramos uma variável estamos associando seu nome (identificador) ao local da memória onde está armazenado sua informação, as variáveis em Java podem ser do tipo primitivo ou objeto:

 - Variáveis primitivas: podem ser do tipo byte, short, int, long, float, double, char ou boolean.

 - Variáveis de referência: usada para referenciar um objeto. Quando usamos uma variável de referência definimos qual o tipo do objeto ou um subtipo do tipo do objeto.

Fonte: [Métodos](https://www.devmedia.com.br/metodos/7348)

 O Java possui dois tipos de dados que são divididos em **por valor** (tipos primitivos) e **por referência** (tipos por referência).
 
 Fonte: [Tipos de dados por valor e por referência em Java](https://www.devmedia.com.br/tipos-de-dados-por-valor-e-por-referencia-em-java/25293)

## Passando Parâmetros para um Método

**Passando um Primitivo** : Quando um valor primitivo é passado na chamada de um método, uma **cópia** deste valor é criada e atribuída para o argumento do método responsável por recebê-la. Se o método mudar este valor, apenas o valor do argumento local ao método é afetado. Quando o método terminar sua execução, o valor original da variável utilizada para passar o valor primitivo na chamada do método permanecerá inalterado.

```java
public void incrementa (int num) {
    num++;
    System.out.println("num : " + num);
}

// veja agora
int num = 10;
incrementa (num); //Imprimirá 11
System.out.println("num : " + num); //Imprimirá 10
```

**Passando a Referência de um Objeto** : Quando o tipo passado para o método não for um primitivo mas sim um objeto, esse comportamento muda. Quando passamos um objeto, uma referência ao objeto original é passada ao invés de uma cópia do objeto.

A referência contém o endereço de memória onde está contido o objeto original e qualquer modificação feita pelo método no argumento que recebeu esta referência afetará também o objeto original.

<img src="https://www.devmedia.com.br/imagens/javamagazine/rcpmetodosfig01.jpg">

Fonte: [Métodos](https://www.devmedia.com.br/metodos/7348)

## Controle de fluxo

Um detalhe importante que você não pode esquecer é que na expressão condicional (do FOR) só pode haver UMA, mas você pode ter condições composta.

```java

// Condições compostas:
// x < 10 | (x % 2) == 0

for (int x = 0; x < 10 | (x % 2) == 0; x++) {

    System.out.println(“” + x);

}  
```

Fonte: [Controle de Fluxo Parte ll
](https://www.devmedia.com.br/controle-de-fluxo-parte-ll/5722)

## FOR EACH

```java
Collection alunos = ...;

// Antes do Java 1.5 (SEM for each)
for (Iteractor i = alunos.iterator(); i.hasNext();) {
      Aluno usuário = (Aluno) i.next();
}

// A partir do Java 1.5 (COM for each)
for (Aluno usuário : alunos) {

}
```

Desvantagens:

 - A primeira desvantagem do for-each é que você pode apenas iterar a partir da posição zero para a size(). Não é possível iterar ao contrário, da posição size() para a zero.

 - Outro ponto negativo do loop for-each é que você não pode remover elementos da collection enquanto está realizando a iteração, pois não há uma referência ao iterator para chamar o método remove(). Se você fizer isso irá ocorrer uma ConcurrentModificationException, pois estará tentando remover algo de uma lista que já está sendo utilizada. O mesmo ocorre se você deseja acrescentar informações na Collection, utilizando o método add().
 
 Fonte: [Java 5 – Descrevendo o loop for-each](http://www.mauda.com.br/?p=994)

## BREAK e CONTINUE

Break interrompe, aborta

```java
// O BREAK fez a INTERRUPÇÃO quando o valor de i > 5
int x = 0;
    
for (int i = 0; i < 10; i++) {
    x = i;
    if (i > 5)
        break;
}
    
System.out.println("O ultimo valor de i foi " + x); 

Output:

O ultimo valor de i foi 6
```

Continue apenas "pula"

```java
// Se o número for dividido por 2 possuir um resto igual a 1 quer dizer que ele é impar 
// então "pule-o"
for (int i = 0; i <= 6; i++) {
    
    if ((i % 2) == 1) continue;
    
    System.out.println(i);
} 

Output:

0
2
4
6
```    

Fonte: [Controle de Fluxo Parte ll](https://www.devmedia.com.br/controle-de-fluxo-parte-ll/5722)

## Instruções rotuladas

 As instruções rotuladas servem quando você quer usar laços aninhados e deseja fazer um desvio do fluxo de execução seja ele através de um break ou de um continue. Desta forma você nomeia o laço (label: antes do bloco do laço) e quando for realizado o desvio no fluxo da execução (break ou continue) salta para o nome do laço para o qual o fluxo deverá ser desviado.

```java
rotulo: for (int i = 0; i < 5; i++) {

    for (int j = 0; j < 2; j++) {
        System.out.println("Hello");
        break rotulo;
    }

    System.out.println("CERTIFICACAO");

}

System.out.println("Good-Bye");


Output:

Hello
Good-Bye

```
Fonte: [Controle de Fluxo Parte ll](https://www.devmedia.com.br/controle-de-fluxo-parte-ll/5722)

## Collections em Java

Hierarquia de interfaces e classes da **Java Collections Framework** que são derivadas da interface Collection

<img src="https://arquivo.devmedia.com.br/REVISTAS/easyjava/imagens/1/4/image001.jpg">

Ler mais em [Apostila da Caelum CS-14 Algoritmos e Estruturas de Dados em Java](http://www.professores.uff.br/diomarcesarlobao/wp-content/uploads/sites/85/2017/09/1caelumjava-cs14.pdf)

### Set

Interface que define uma coleção que não permite elementos duplicados. A interface SortedSet, que estende Set, possibilita a classificação natural dos elementos, tal como a ordem alfabética.

- Implementações

    - HashSet – o acesso aos dados é mais rápido que em um TreeSet, mas nada garante que os dados estarão ordenados. Escolha este conjunto quando a solução exigir elementos únicos e a ordem não for importante. Poderíamos usar esta implementação para criar um catálogo pessoal das canções da nossa discografia

    - LinkedHashSet – é derivada de HashSet, mas mantém uma lista duplamente ligada através de seus itens. Seus elementos são iterados na ordem em que foram inseridos. Opcionalmente é possível criar um LinkedHashSet que seja percorrido na ordem em que os elementos foram acessados na última iteração. Poderíamos usar esta implementação para registrar a chegada dos corredores de uma maratona

    - TreeSet – os dados são classificados, mas o acesso é mais lento que em um HashSet. Se a necessidade for um conjunto com elementos não duplicados e acesso em ordem natural, prefira o TreeSet. É recomendado utilizar esta coleção para as mesmas aplicações de HashSet, com a vantagem dos objetos estarem em ordem natural

Fonte: [Java Collections: Como utilizar Collections](https://www.devmedia.com.br/java-collections-como-utilizar-collections/18450)    

Ler mais em [Diferenças entre TreeSet, HashSet e LinkedHashSet em Java](https://www.devmedia.com.br/diferencas-entre-treeset-hashset-e-linkedhashset-em-java/29077)

### List

Define uma coleção ordenada, podendo conter elementos duplicados. Em geral, o usuário tem controle total sobre a posição onde cada elemento é inserido e pode recuperá-los através de seus índices. Prefira esta interface quando precisar de acesso aleatório, através do índice do elemento.

- Implementações

    - ArrayList – é como um array cujo tamanho pode crescer. A busca de um elemento é rápida, mas inserções e exclusões não são. Podemos afirmar que as inserções e exclusões são lineares, o tempo cresce com o aumento do tamanho da estrutura. Esta implementação é preferível quando se deseja acesso mais rápido aos elementos. Por exemplo, se você quiser criar um catálogo com os livros de sua biblioteca pessoal e cada obra inserida receber um número sequencial (que será usado para acesso) a partir de zero

    - LinkedList – implementa uma lista ligada, ou seja, cada nó contém o dado e uma referência para o próximo nó. Ao contrário do ArrayList, a busca é linear e inserções e exclusões são rápidas. Portanto, prefira LinkedList quando a aplicação exigir grande quantidade de inserções e exclusões. Um pequeno sistema para gerenciar suas compras mensais de supermercado pode ser uma boa aplicação, dada a necessidade de constantes inclusões e exclusões de produtos

Fonte: [Java Collections: Como utilizar Collections](https://www.devmedia.com.br/java-collections-como-utilizar-collections/18450)

Ler mais em [Diferença entre ArrayList, Vector e LinkedList em Java](https://www.devmedia.com.br/diferenca-entre-arraylist-vector-e-linkedlist-em-java/29162)

### Queue

Um tipo de coleção para manter uma lista de prioridades, onde a ordem dos seus elementos, definida pela implementação de Comparable ou Comparator, determina essa prioridade. Com a interface fila pode-se criar filas e pilhas.

Fonte: [Java Collections: Como utilizar Collections](https://www.devmedia.com.br/java-collections-como-utilizar-collections/18450)

### Map

Classes e interfaces relacionadas a **mapas**, que não são derivadas de Collection.

<img src="https://arquivo.devmedia.com.br/REVISTAS/easyjava/imagens/1/4/image002.jpg">

Mapeia chaves para valores. Cada elemento tem na verdade dois objetos: uma chave e um valor. Valores podem ser duplicados, mas chaves não. SortedMap é uma interface que estende Map, e permite classificação ascendente das chaves.

 - Implementações:

    - HashMap – baseada em tabela de espalhamento, permite chaves e valores null. Não existe garantia que os dados ficarão ordenados. Escolha esta implementação se a ordenação não for importante e desejar uma estrutura onde seja necessário um ID (identificador). Um exemplo de aplicação é o catálogo da biblioteca pessoal, onde a chave poderia ser o ISBN (International Standard Book Number)

    - TreeMap – implementa a interface SortedMap. Há garantia que o mapa estará classificado em ordem ascendente das chaves. Mas existe a opção de especificar uma ordem diferente. Use esta implementação para um mapa ordenado. Aplicação semelhante a HashMap, com a diferença que TreeMap perde no quesito desempenho;

    - LinkedHashMap – mantém uma lista duplamente ligada através de seus itens. A ordem de iteração é a ordem em que as chaves são inseridas no mapa. Se for necessário um mapa onde os elementos são iterados na ordem em que foram inseridos, use esta implementação. O registro dos corredores de uma maratona, onde a chave seria o número que cada um recebe no ato da inscrição, é um exemplo de aplicação desta coleção

Fonte: [Java Collections: Como utilizar Collections](https://www.devmedia.com.br/java-collections-como-utilizar-collections/18450)

### Como Escolher entre Coleções?

As regras básicas para escolher entre coleções seguem

Primeiro, a aplicação dita se você vai precisar de Lista, Conjunto ou Mapa

 - Se sua aplicação precisar manter duplicatas, use Lista
   - Se precisar fazer muita pesquisa, fuja da lista!
 - Se sua aplicação não precisar manter duplicatas e não usa chaves, use Conjunto
 - Se sua aplicação não precisar manter duplicatas e usa chaves, use Mapa

Depois, se precisar de uma Lista
 - Use ArrayList se acessar por índice for comum (ex. pesquisa binária)
 - Use LinkedList se inserir ou remover elementos do meio com frequência

Se precisar de um Conjunto
 - Use HashSet se não precisar de um conjunto ordenado
 - Use TreeSet se precisar de um conjunto ordenado

Se precisar de um Mapa
 - Use HashMap se não precisar de um mapa ordenado
 - Use TreeMap se precisar de um mapa ordenado

Fonte: [Estruturas de Dados - Tipos de Coleções
](http://www.dsc.ufcg.edu.br/~jacques/cursos/p2/html/ed/colecoes.htm)
