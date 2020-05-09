## Instalação (no Linux) - [aula](https://codenation.dev/private-journey/java-online-3/challenge/https-youtu-be-30navgu4pqi)

1) Download do [CLI da Codenation](https://s3-us-west-1.amazonaws.com/codenation-cli/latest/codenation_linux.tar.gz)

2) Descompactar o arquivo codenation_linux.tar.gz

3) Dentro da pasta que descompactou o arquivo, executar os comandos:

```bash
# Mover o arquivo codenation para /usr/local/bin
# Pode acontecer de ser /usr/bin
$ sudo mv codenation /usr/local/bin

# Permissão para executar
$ sudo chmod +x /usr/local/bin/codenation

# Executar o codenation
$ codenation
```
Para instalar no Mac, assistir [esta aula](https://codenation.dev/private-journey/java-online-3/challenge/https-youtu-be-snnf2uyn13s)

Para instalar no Windows, assistir [esta aula](https://codenation.dev/private-journey/java-online-3/challenge/https-youtu-be-huj7a6rneji)


## Como submeter desafio

Clicar em "Iniciar o desafio"

Se é a primeira vez que você está executando o comando, você precisa configurá-lo:

**codenation config -t seu-codigo-usuario**

Para iniciar o desafio basta executar o comando abaixo:

**codenation fetch -c nome-projeto**

Este comando irá baixar o desafio na pasta do seu usuário em seu computador.

Acesse a pasta do desafio:

**cd ~/codenation/nome-projeto**

Instale os requisitos descritos no arquivo README

Resolva o desafio.

### Para realizar os testes locais, basta executar os comandos abaixo:

**cd ~/codenation/nome-projeto**

**codenation test -c nome-projeto**

Os desafios da Codenation se baseiam em testes unitários (todos devem estar passando para realizar a entrega).

### Para submeter seu código para avaliação, execute o comando:

**codenation submit -c nome-projeto**

O comando submit irá gerar um link para solicitar o code review para o mentor ou colegas.

### Manual CLI
Ler [Manual CLI](https://s3-us-west-1.amazonaws.com/codenation-cli/doc/manual.html)