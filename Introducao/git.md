# Comandos Git

Realizar o curso [Git e Github para iniciantes da Udemy](https://www.udemy.com/course/git-e-github-para-iniciantes/)

[Diferenças entre o Subversion e o Git
](https://help.github.com/pt/github/importing-your-projects-to-github/what-are-the-differences-between-subversion-and-git)

A principal diferença entre [Git](https://git-scm.com/) e qualquer outro **VCS (Subversion e similares)** é a maneira Git trata seus dados. Conceitualmente, a maioria dos outros sistemas armazenam informação como uma **lista de mudanças nos arquivos**. Estes sistemas (CVS, Subversion, Perforce, Bazaar, e assim por diante) tratam a informação como um conjunto de arquivos e as mudanças feitas a cada arquivo ao longo do tempo.

**Git** não trata nem armazena seus dados desta forma. Em vez disso, Git trata seus dados mais como um **conjunto de imagens de um sistema de arquivos** em miniatura. Toda vez que você fizer um commit, ou salvar o estado de seu projeto no Git, ele basicamente tira uma **foto de todos os seus arquivos** e armazena uma referência para esse conjunto de arquivos. Para ser eficiente, se os **arquivos não foram alterados**, Git não armazena o arquivo novamente, apenas um **link para o arquivo** idêntico anterior já armazenado. Git trata seus dados mais como um fluxo do estado dos arquivos.

### Fonte: [Imagens, Não Diferenças](https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-O-B%C3%A1sico-do-Git)

## Configurando o Git

 - git config do sistema

 - git config do projeto

 - git config do usuário

 ## git config do usuário

    # Nome do usuário
    git config --global user.name "Nome Sobrenome"

    # Email do usuário
    git config --global user.email "email@..."

    # Definir o editor padrão do Git (no exemplo, para o Visual Studio Code)
    git config --global core.editor vscode

    # Saber o valor configurado
    git config chave
    Exemplo: git config user.email

    # Saber TODOS os valores configurados
    git config --list

## Inicializando o repositório

    # Criando o diretório
    mkdir nome-projeto

    # Acessar a pasta do projeto
    cd nome-projeto 

    # Inicializar o repositório Git
    git init

    # Visualizar todos arquivos, inclusive a pasta .git (oculto)
    ls -la

    # Conteúdo da pasta .git
    config: configurações do repositório
    HEAD: qual branch padrão que ele está
    branches: quais são os branches do projeto
    description: descrição do projeto
    hooks: gatilhos para ações durante o projeto

Como utilizar o editor vi

    $ vi nome_arquivo.txt <ENTER>
    apertar letra "i" -> entra no modo de inserção
    escrever o texto desejado
    apertar tecla ESC
    apertar :wq <ENTER>

    Explicação :wq
    : -> vai iniciar algum comando
    w -> escrever
    q -> sair

[Editor VI - Guia de Referência](https://aurelio.net/curso/material/vim-ref.html)





    







