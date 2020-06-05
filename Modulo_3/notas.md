# Tópicos

 - [Entendendo interfaces em Java](https://www.devmedia.com.br/entendendo-interfaces-em-java/25502) 
 
 - [Java Interface: Aprenda a usar corretamente](https://www.devmedia.com.br/java-interface-aprenda-a-usar-corretamente/28798)

 - [Polimorfismo, Classes abstratas e Interfaces: Fundamentos da POO em Java](https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387)

  - [Conceitos – Classes Abstratas: Programação Orientada a Objetos](https://www.devmedia.com.br/conceitos-classes-abstratas-programacao-orientada-a-objetos/18812)

  - [Conhecendo Java Reflection](https://www.devmedia.com.br/conhecendo-java-reflection/29148)

  - [Entendendo Anotações em Java](https://www.devmedia.com.br/entendendo-anotacoes-em-java/26772)

  - [Java Reflection – Parte I](https://www.devmedia.com.br/java-reflection-parte-i/4888)

  - Interfaces (vídeo)

  - Classes Abstratas (vídeo)

  - Java Reflection (vídeo)

  - Annotations (vídeo)

  - Desafio
    - Utilitário - Calculador de atributos de Classe

  - Feedback semanal 

## Interface

Pode-se dizer, a grosso modo, que uma **interface é um contrato** que quando assumido por uma classe deve ser implementado.

Ao contrário da herança que limita uma classe a herdar somente uma classe pai por vez, é possível que uma classe implemente varias interfaces ao mesmo tempo.

Interface de Marcação:

  - São interfaces que servem apenas para **marcar classes**, de forma que ao realizar os “instanceof” podemos testar um conjunto de classe.

  ```java
public interface Funcionario {
 }

 public class Gerente implements Funcionario {
    private int id;
    private String nome; 
}
 
public class Coordenador implements Funcionario { 
    private int id;
    private String nome;      
}
 
public class Operador implements Funcionario {
    private int id;
    private String nome;     
}

// Uso indevido da Interface de Marcação
public class MeuApp {
     
    public void calcularSalarioParaGerente(Gerente gerente){            
    }
        
    public void calcularSalarioParaCoordenador(Coordenador coordenador) {
    }
    
    public void calcularSalarioParaOperador(Operador operador) {        
    }
 
}

// Usando a interface de marcação
public class MeuApp {
     
    // Juntamos tudo em **apenas um método** utilizando a interface de marcação.
    public void calculaSalarioDeFuncionario(Funcionario funcionario){
         
        if (funcionario instanceof Gerente){
            //calculo para gerente

        } else if (funcionario instanceof Coordenador){
            //calculo para coordenador

        } else if (funcionario instanceof Operador){
            //calculo para operador

        }         
    }  

}
 ```

Fonte: 

[Entendendo interfaces em Java](https://www.devmedia.com.br/entendendo-interfaces-em-java/25502)

[Java Interface: Aprenda a usar corretamente](https://www.devmedia.com.br/java-interface-aprenda-a-usar-corretamente/28798)

## Polimorfismo

O polimorfismo permite que classes abstratas consigam receber comportamentos através de classes concretas.

Fonte: 

[Polimorfismo, Classes abstratas e Interfaces: Fundamentos da POO em Java](https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387)

## Classes abstratas

Pode-se dizer que as classes abstratas servem como **"modelo" para outras classes que dela herdem, não podendo ser instanciada** por si só. 

Para ter um objeto de uma classe abstrata é necessário **criar uma classe mais especializada herdando dela** e então instanciar essa nova classe. 

Os métodos da classe abstrata devem então serem sobrescritos nas classes filhas.

```java
// Classe abstrata
abstract class Conta {
     
    private double saldo;
     
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
     
    public double getSaldo() {
        return saldo;
    }
     
    // Método abstrato (sem implementação) 
    public abstract void imprimeExtrato();
 
}

// Classe concreta
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ContaPoupanca extends Conta {
 
    // Sobrescrita do método abstrato
    @Override
    public void imprimeExtrato() {
        System.out.println("### Extrato da Conta ###");
         
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
        Date date = new Date();
         
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Data: " + sdf.format(date));
         
    }
}

//Classe teste
public class TestaConta {
    public static void main(String[] args) {

        // Instanciar a classe concreta
        Conta cp = new ContaPoupanca();
        cp.setSaldo(2121);
        cp.imprimeExtrato();
    }
}
```

Uma **interface** é **100% abstrata**, ou seja, os seus métodos são definidos como abstract, e as **variáveis** por padrão **são sempre constantes** (static final).

Fonte: 

[Polimorfismo, Classes abstratas e Interfaces: Fundamentos da POO em Java](https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387)

## Java Reflection

O Reflection, em poucas palavras, serve para determinar **métodos e atributos** que serão **utilizados** de determinada classe (que você nem conhece) em **tempo de execução**.

Também é chamado de **programação dinâmica**.

Pacotes **java.lang** e **java.lang.reflect**

```java
Class<ClassDesconhecida> classe = ClassDesconhecida.class;

for (Field atributo : classe.getDeclaredFields()) {
  System.out.println(atributo.getName());      
}
```

Riscos do Java Reflection

  - **Redução de Desempenho**, pois se o código que esta sendo executado for requerido com muita frequência, consequentemente acarretará em uma redução de desempenho.

  - **Problemas por restrição de segurança**, especialmente se executado em um ambiente com regras específicas

  - **Exposição de estrutura interna dos objetos**, pois utilizando este recurso temos acesso a todos os métodos e atributos de determinado objeto, isso pode ser um problema em se tratando de segurança.

Benefícios do Java Reflection

  - Facilidade na manutenção
  - Minimização de Erros
  - Ganho de Produtividade
  - Padronização
  - Extensibilidade

```java
public class Arquivo {
 
    private String nome;
    private String numeroDeCCP;
    private int quantidadeCCP;
    private String hashParaTabelaUnica;
    private boolean realizarCheckSum;
    private boolean converterHash;
    private boolean conjugarNomeENumeroCCP;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumeroDeCCP() {
        return numeroDeCCP;
    }
    public void setNumeroDeCCP(String numeroDeCCP) {
        this.numeroDeCCP = numeroDeCCP;
    }
    public int getQuantidadeCCP() {
        return quantidadeCCP;
    }
    public void setQuantidadeCCP(int quantidadeCCP) {
        this.quantidadeCCP = quantidadeCCP;
    }
    public String getHashParaTabelaUnica() {
        return hashParaTabelaUnica;
    }
    public void setHashParaTabelaUnica(String hashParaTabelaUnica) {
        this.hashParaTabelaUnica = hashParaTabelaUnica;
    }
    public boolean isRealizarCheckSum() {
        return realizarCheckSum;
    }
    public void setRealizarCheckSum(boolean realizarCheckSum) {
        this.realizarCheckSum = realizarCheckSum;
    }
    public boolean isConverterHash() {
        return converterHash;
    }
    public void setConverterHash(boolean converterHash) {
        this.converterHash = converterHash;
    }
    public boolean isConjugarNomeENumeroCCP() {
        return conjugarNomeENumeroCCP;
    }
    public void setConjugarNomeENumeroCCP(boolean conjugarNomeENumeroCCP) {
        this.conjugarNomeENumeroCCP = conjugarNomeENumeroCCP;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (conjugarNomeENumeroCCP ? 1231 : 1237);
        result = prime * result + (converterHash ? 1231 : 1237);
        result = prime
                * result
                + ((hashParaTabelaUnica == null) ? 0 : hashParaTabelaUnica
                        .hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result
                + ((numeroDeCCP == null) ? 0 : numeroDeCCP.hashCode());
        result = prime * result + quantidadeCCP;
        result = prime * result + (realizarCheckSum ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arquivo other = (Arquivo) obj;
        if (conjugarNomeENumeroCCP != other.conjugarNomeENumeroCCP)
            return false;
        if (converterHash != other.converterHash)
            return false;
        if (hashParaTabelaUnica == null) {
            if (other.hashParaTabelaUnica != null)
                return false;
        } else if (!hashParaTabelaUnica.equals(other.hashParaTabelaUnica))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numeroDeCCP == null) {
            if (other.numeroDeCCP != null)
                return false;
        } else if (!numeroDeCCP.equals(other.numeroDeCCP))
            return false;
        if (quantidadeCCP != other.quantidadeCCP)
            return false;
        if (realizarCheckSum != other.realizarCheckSum)
            return false;
        return true;
    }
 
}

// Utilizando Reflection para acessar a classe Arquivo
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
public class Principal {
 
    public static void main(String args[]) {                 
         
        /*
         * Carregamos a classe Arquivo através do Class.forName que nos possibilita
         * carregar uma classe através de uma dada string que deve corresponder ao local
         * onde a classe está, além disso, por padrão a classe é carregada no ClassLoader
         * que está sendo utilizado pela classe que está executando o comando.
         * */
        Object arquivoFromReflection = null;
        try {
            arquivoFromReflection = Class.forName("Arquivo").newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        //Recupera o nome da classe
        System.out.println("Nome da Classe: "+arquivoFromReflection.getClass().getName());
         
        /*
         * A Classe Method do Reflection nos da a possibilidade de manusear
         * todos os métodos dentro do objeto carregado 
         * */
        System.out.println("");
        System.out.println("Métodos: ");
        for(Method m : arquivoFromReflection.getClass().getMethods()){
            System.out.print(m.getName()+", ");
        }
         
        /*
         * Vamos agora capturar os atributos da classe. Temos agora outra classe 
         * muito importante para uso do Reflection, a classe Field. Esta nos permite
         * manusear os campos/fields da nossa classe carregada.
         * */
        System.out.println("");
        System.out.println("Atributos: ");
        for(Field f : arquivoFromReflection.getClass().getDeclaredFields()){
            System.out.print(f.getName()+", ");
        }
         
        /*
         * Perceba que nossa abordagem é bem simples, ou seja, estamos capturando apenas
         * os nomes dos métodos e atributos, mas você pode ir muito além, capturando os 
         modificadores, 
         * tipos, retorno e etc.
         * */
    }
}
```

Uma equipe está precisando acessar o método setSelected(boolean) de um conjunto de JcheckBoxs, os quais estão inseridos dentro de um JPanel. 

Pensem em aproximadamente 100 JCheckBox.

```java
private void ControlSelectedByReflection(JPanel panel){
        
    // Ao receber o contêiner(JPanel), percorremos todos os objetos que estão dentro dele
    // Para cada objeto realizamos uma introspecção dentro do próprio objeto 
    // (em tempo de execução) sem saber qual o tipo concreto 
    for (Object obj : panel.getComponents()) {
            
        // Com o objeto em mãos solicitamos a classe dele com o método obj.getClass()   
        Class cls = obj.getClass();

        try {

            // Com a classe à disposição fazemos uma varredura dentro dela 
            // a procura de um método cujo o nome é setSelected, 
            // responsável por selecionar o JCheckBox
            // Caso não ache, será lançada a exceção NoSuchMethodException
            Method mtd = cls.getMethod("setSelected", new Class[]{boolean.class} );

            // Encontrando o método, o executaremos dentro do objeto real 
            // Caso o método invoke não puder chamar o método em questão(setSelected) 
            // será lançada a exceção IllegalAccessException
            mtd.invoke(obj, new Object[] {true});                

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

Código completo:

```java
import javax.swing.*;
import java.awt.Rectangle;
import java.lang.reflect.Method;
import javax.swing.border.EtchedBorder;
 
public class FormReflection extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JButton jButton = null;
    private JPanel jPanel = null;
    private JCheckBox jCheckBox = null;
    private JCheckBox jCheckBox1 = null;
    private JCheckBox jCheckBox2 = null;
    private JCheckBox jCheckBox3 = null;
    private JCheckBox jCheckBox4 = null;
    private JCheckBox jCheckBox5 = null;

    // ***** Utilização do método com REFLECTION *****
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setBounds(new Rectangle(178, 112, 143, 25));
            jButton.setText("Selecionar Todos");
            jButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {

                    // ***** Chamando o método com REFLECTION *****
                    ControlSelectedByReflection(jPanel);
                }
            });
        }
        return jButton;
    }


    private JPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new JPanel();
            jPanel.setLayout(null);
            jPanel.setBounds(new Rectangle(13, 22, 108, 194));
            jPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            jPanel.add(getJCheckBox(), null);
            jPanel.add(getJCheckBox1(), null);
            jPanel.add(getJCheckBox2(), null);
            jPanel.add(getJCheckBox3(), null);
            jPanel.add(getJCheckBox4(), null);
            jPanel.add(getJCheckBox5(), null);
        }
        return jPanel;
    }
    private JCheckBox getJCheckBox() {
        if (jCheckBox == null) {
            jCheckBox = new JCheckBox();
            jCheckBox.setBounds(new Rectangle(12, 15, 79, 21));
            jCheckBox.setText("Check");
        }
        return jCheckBox;
    }
    private JCheckBox getJCheckBox1() {
        if (jCheckBox1 == null) {
            jCheckBox1 = new JCheckBox();
            jCheckBox1.setBounds(new Rectangle(13, 42, 61, 24));
            jCheckBox1.setText("Check");
        }
        return jCheckBox1;
    }
    private JCheckBox getJCheckBox2() {
        if (jCheckBox2 == null) {
            jCheckBox2 = new JCheckBox();
            jCheckBox2.setBounds(new Rectangle(14, 72, 61, 24));
            jCheckBox2.setText("Check");
        }
        return jCheckBox2;
    }
    private JCheckBox getJCheckBox3() {
        if (jCheckBox3 == null) {
            jCheckBox3 = new JCheckBox();
            jCheckBox3.setBounds(new Rectangle(13, 102, 61, 24));
            jCheckBox3.setText("Check");
        }
        return jCheckBox3;
    }
    private JCheckBox getJCheckBox4() {
        if (jCheckBox4 == null) {
            jCheckBox4 = new JCheckBox();
            jCheckBox4.setBounds(new Rectangle(13, 130, 61, 24));
            jCheckBox4.setText("Check");
        }
        return jCheckBox4;
    }
    private JCheckBox getJCheckBox5() {
        if (jCheckBox5 == null) {
            jCheckBox5 = new JCheckBox();
            jCheckBox5.setBounds(new Rectangle(11, 162, 61, 24));
            jCheckBox5.setText("Check");
        }
        return jCheckBox5;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormReflection thisClass = new FormReflection();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
 
public FormReflection() {
        super();
        initialize();
    }
    private void initialize() {
        this.setSize(435, 258);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJButton(), null);
            jContentPane.add(getJPanel(), null);
        }
        return jContentPane;
    }
     
    // ***** Método com REFLECTION *****
    private void ControlSelectedByReflection(JPanel panel){         
        for (Object obj : panel.getComponents()) {                         
            Class cls = obj.getClass();
            try {
                Method mtd = cls.getMethod("setSelected", new Class[] {boolean.class} );
                mtd.invoke(obj, new Object[] {true});                 
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

 }
```

Fonte: 

[Conhecendo Java Reflection](https://www.devmedia.com.br/conhecendo-java-reflection/29148)

[Java Reflection – Parte I](https://www.devmedia.com.br/java-reflection-parte-i/4888)

## Annotations

Anotações é um recurso usado para anotar classes, campos e métodos, de tal maneira que essas marcações podem ser tratadas pelo compilador, ferramentas de desenvolvimento e bibliotecas.

É útil quando desejamos **anotar código** não simplesmente para documentação, mas de maneira que essas marcações possam ser **verificadas em tempo de compilação**, ou utilizadas por ferramentas, tais como analisadores de código, frameworks de persistência ou de testes unitários, entre outras.

 [JSR 175](https://jcp.org/en/jsr/detail?id=175): afirma que tem havido uma tendência crescente no sentido de se **anotar campos, métodos e classes**, os quais devem ter atributos particulares que indicam que eles devem ser **processados de forma especial por ferramentas de desenvolvimento, de implantação, ou bibliotecas runtime**. O parágrafo da especificação conclui que tais anotações – ou annotations – são chamadas **metadados**.

Antes do Java 5 (também denominado Tiger) ser lançado, o Javadoc – ferramenta usada para gerar documentação da API de Java em HTML – era o recurso usado para definir metadados.

As anotações podem ser empregadas em ferramentas de persistência, a exemplo do Hibernate, e de análise de código, tal como o Findbugs.

 **Anotações marcadoras** – são aquelas que **não possuem membros**. São identificadas apenas pelo nome, sem dados adicionais. Por exemplo, @Test:

 ```java
 @Test
public void testeConjuntoVazio() {
    Collection conjunto = new ArrayList();
    assertTrue(conjunto.isEmpty());
}
 ```

 **Anotações de valor único** – são similares às anteriores, no entanto, **possuem um único membro**, chamado valor. Elas são representadas pelo **nome da anotação e um par nome=valor, ou simplesmente com o valor**, entre parênteses. Em outras palavras, quando a anotação possui um único membro, só é necessário informar o valor, além do nome da anotação. Por exemplo:
 
 ```java
@MinhaAnotacao("valor")
```

**Anotações completas** – são aquelas que **possuem múltiplos membros**. Portanto, neste tipo, devemos usar a sintaxe completa para **cada par nome=valor**. Neste caso, cada par é informado separado do outro por uma vírgula. Por exemplo:

```java
@Version(major=1, minor=0, micro=0)
```

**@Override, @Deprecated e @SuppressWarnings** -> parte do pacote **java.lang**

```java
// Sobrescrita do método
@Override 

// Indicar que um método não deveria mais ser usado (ficou obsoleto)
@Deprecated

// Aplicações criadas antes do advento do Java 5 podem ter algum código 
// que gera alertas (warnings) durante a compilação com esta versão ou posteriores
//
// "Desliga" os warnings
//
// É uma anotação de valor único, onde o valor é um array de String
// 
// unchecked: empregado para suprimir alertas referentes a operações não verificadas
// rawtypes: suprime os warnings referentes à ausência de tipos
// all: suprime todos os alertas
// deprecation: suprime alertas referentes ao uso de código obsoleto
// fallthrough: suprime alertas referentes à falta de break em comandos switch
@SuppressWarnings(value={"unchecked", "rawtypes"})
```

**@Retention, @Documented, @Target e @Inherited** -> parte da API juntamente com as anteriores, e da personalização de tipos anotação, mostrando como criar nossos próprios tipos. Estas são **meta-anotações**, visto que são empregadas para **marcar tipos anotação** e fazem parte do pacote **java.lang.annotation**. 

```java
// As anotações podem estar presentes apenas no código fonte ou no binário 
// de classes ou interfaces. @Retention é usada para escolher entre essas possibilidades.
//
// Suporta três valores:
// - SOURCE: anotações marcadas não estarão no código binário;
// - CLASS: gravar as anotações no arquivo .class, não estarão disponíveis em tempo de execução
// - RUNTIME: anotações estarão disponíveis em tempo de execução
@Retention


// Notação marcadora usada para indicar que os tipos anotação anotados com ela 
// serão incluídos na documentação Javadoc
@Documented

// Ao criar um tipo anotação é possível estabelecer que elementos 
// (construtor, variável local, parâmetro de método e método) de uma classe 
// podem ser anotados com ele.
//
// Suporta os seguintes valores (cada um destinado a definir o elemento que 
// se pretende anotar):
// - CONSTRUCTOR
// - LOCAL_VARIABLE
// - PARAMETER
// - METHOD
@Target 

// Por padrão anotações declaradas em uma classe não são herdadas pelas subclasses. 
// Mas, se for necessário que essa herança ocorra, então o tipo anotação que 
// desejamos que seja herdado deve ser anotado com @Inherited

// Restringe-se apenas a classes. Por exemplo, anotações em interfaces
// não são herdadas pelas classes que as implementam.
@Inherited
```

Todo **tipo anotação é uma subinterface (especialização) de java.lang.annotation.Annotation**, não pode ser genérica e não permite o uso da cláusula extends, ou seja, um tipo anotação não pode explicitamente declarar uma superclasse ou superinterface

```java
//Declaração de um tipo anotação marcadora
/**
 * Anotação marcadora para indicar que um método ou classe
 * está ainda em desenvolvimento
 */ 
public @interface InProgress {
 
}

// Usando a anotação marcadora criada 
// Indica que o método ainda está sendo desenvolvido
public class Funcionario {
    protected double salario;
     
    @InProgress
    public double getTotalSalario(double bonus) {
        // Necessita ser implementado mais tarde
        return 0;
    }
}
```

```java
// Adicionando membros ao tipo anotação
/**
 * Tipo anotação para indicar que uma
 * tarefa precisa ser concluída
 */
public @interface TODO {
    String value();
}

// Utilizando a anotação de valor único
public class Funcionario {
    protected double salario;
     
    @TODO("O salário total do funcionário = salário + bonus")
    public double getTotalSalario(double bonus) {
        return 0;
    }
}

// Também pode-se utilizar a sintaxe completa( @TODO(value="blabla") )
public class Funcionario {
    protected double salario;
     
    @TODO(value="O salário total do funcionário = salário + bonus")
    public double getTotalSalario(double bonus) {
        return 0;
    }
}
```
A declaração **String value()** define o membro do tipo anotação

 - Por convenção, o **nome do único membro** em um tipo anotação com um único elemento deve ser **value**

  - A declaração de um método em um tipo anotação **não pode ter qualquer parâmetro e nem uma cláusula throws** – que indica um lançamento de exceção

  - O método **não deve possuir corpo** – ele é especificado como um método abstrato

  - O **tipo de retorno** do método será o **tipo de dado do elemento**

  - O **tipo de retorno** deve ser um dos seguintes: **primitivos, String, Class, enum ou um array cujo tipo seja um dos precedentes**

```java
//Tipo anotação com mais de um elemento
/**
 * Um TODO voltado para grupos 
 * de desenvolvedores, onde pode-se
 * especificar a pessoa a quem se destina o item 
 */
public @interface groupTODO {
    
    public enum Severity { CRITICAL, IMPORTANT, TRIVIAL, DOCUMENTATION };
    
    // severidade da tarefa a ser executada
    Severity severity( ) default Severity.IMPORTANT;
    
    // o que deve ser feito
    String item( );

    // desenvolvedor encarregado da tarefa
    String assignedTo( );
}

public class Funcionario {
    protected double salario;
     
    @groupTODO(severity=groupTODO.Severity.TRIVIAL,
                item="O salário total do funcionário = salário + bonus",
                assignedTo="Carlos Araújo")
    public double getTotalSalario(double bonus) {
        return 0;
    }
}
```

```java
// Annotation + Reflection
import java.lang.reflect.Field;
 
public class TesteAnotacao {
 
    @Deprecated
    public static int value = 1;
 
    public static void main(String[] args) throws Exception {

        // Acessando o atributo "value"
        Field field = TesteAnotacao.class.getField("value");

        // Verificando via reflection se o campo possui a annotation de deprecated
        // A reflexão funciona apenas com anotações que tenham 
        // sido marcadas @Retention.RUNTIME.
        if (field.isAnnotationPresent(Deprecated.class)) {
            System.out.println("Campo anotado com Deprecated");
        } else {
            System.out.println("Campo não anotado com Deprecated");
        }
    }
}
```
Fonte:

[Entendendo Anotações em Java](https://www.devmedia.com.br/entendendo-anotacoes-em-java/26772)