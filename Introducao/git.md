# Comandos Git

Realizar o curso [Git e Github para iniciantes da Udemy](https://www.udemy.com/course/git-e-github-para-iniciantes/)

[Diferenças entre o Subversion e o Git
](https://help.github.com/pt/github/importing-your-projects-to-github/what-are-the-differences-between-subversion-and-git)

A principal diferença entre [Git](https://git-scm.com/) e qualquer outro **VCS (Subversion e similares)** é a maneira Git trata seus dados. Conceitualmente, a maioria dos outros sistemas armazenam informação como uma **lista de mudanças nos arquivos**. Estes sistemas (CVS, Subversion, Perforce, Bazaar, e assim por diante) tratam a informação como um conjunto de arquivos e as mudanças feitas a cada arquivo ao longo do tempo.

**Git** não trata nem armazena seus dados desta forma. Em vez disso, Git trata seus dados mais como um **conjunto de imagens de um sistema de arquivos** em miniatura. Toda vez que você fizer um commit, ou salvar o estado de seu projeto no Git, ele basicamente tira uma **foto de todos os seus arquivos** e armazena uma referência para esse conjunto de arquivos. Para ser eficiente, se os **arquivos não foram alterados**, Git não armazena o arquivo novamente, apenas um **link para o arquivo** idêntico anterior já armazenado. Git trata seus dados mais como um fluxo do estado dos arquivos.

###### Fonte: [Imagens, Não Diferenças](https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-O-B%C3%A1sico-do-Git)

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

## Como utilizar o editor vi

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

## Ciclo de vida dos arquivos no Git

Os arquivos no Git sempre se encontram em algum estado: untracked, unmodified, modified e stage. Entender esses estados nos ajuda a saber melhor qual o momento certo de usar cada comando.

[Git: Adicione ciclos de vida aos seus arquivos
](https://blog.4linux.com.br/git-ciclo-de-vida/)

[Recording Changes to the Repository](https://git-scm.com/book/pt-br/v2/Fundamentos-de-Git-Recording-Changes-to-the-Repository)

    # Reporta o status do repositório no momento
    git status

    # Criar arquivo pelo vi
    vi readme.md

    # Após criar o arquivo, agora estará como untracked
    git status

    # Adiciona o arquivo
    git add readme.md

    # Verifica que há novo arquivo (Staging)
    git status

    # Editar o arquivo
    vi readme.md

    # Verifica que o novo arquivo foi editado (Modified)
    # Necessário passar para Staging novamente com "add"
    git status

    # Adicionando o arquivo
    git add readme.md

    # Realizar o commit (snapshot, gera uma versão/hash)
    git commit -m "Comentário relevante do que foi feito"

    # Nada para ser adicionado
    git status

    # Editar novamente o arquivo
    vi readme.md

    # Arquivo foi modificado
    git status

    # Se tentar commitar, sem "add" antes, vai dizer que
    # não tem nada adicionado (não está em Staging)
    git commit -m "Comentário..."

    # Adicionar o arquivo e commitar
    git add readme.md
    git commit -m "Comentário..."

## Visualizando logs

    # Mostra hash do commit, autor, data e hora, mensagem
    git log

    # Mostra mais informações, como de qual branch para qual branch
    git log --decorate

    # Filtra os logs pelo author (não precisa ser o nome completo)
    git log --author="Marcia"

    # Lista em ordem alfabética, quais foram os autores, quantos commits fizeram e quais eles foram
    git shortlog

    Exibe a qtde de commits por author
    git shortlog -sn

    # Mostra em forma gráfica o que que está acontecendo com os branches e versões
    git log --graph

    # Informações detalhadas do que aconteceu naquele commit, quais linhas foram adicionadas
    git show <número hash do commit>

## Visualizando o diff

    # Edite o arquivo
    vi readme.md

    # Mostra diferença antes de adicionar
    git diff

    # Lista os nomes dos arquivos que foram alterados
    git diff --name-only

    # Adiciona o arquivo e já commita no mesmo comando
    git commit -am "Editando o arquivo readme"

## Desfazendo coisas que ainda NÃO foram adicionadas

    # Editar o arquivo
    vi readme.md

    # Visualizar a alteração
    git diff

    # Reseta o arquivo para estado antes da edição
    git checkout <nome do arquivo>
    git checkout readme.md

    # Não terá mais a alteração, retornou ao estado anterior a alteração
    git diff

    # Não há mais alteração
    git status

## Desfazendo coisas que JÁ foram adicionadas

    # Editar o arquivo
    vi readme.md

     # Visualizar a alteração
    git diff

    # Colocar na área de staging
    git add readme.md

    # Arquivo modified
    git status

    # Não encontra mais a diferença, pois já foi adicionado
    git diff

    # Para voltar para o ponteiro que está (remover do staging)
    git reset HEAD readme.md

    # Desfaz a alteração do arquivo
    git checkout readme.md

## Desfazendo alterações que já foram adicionadas E commitadas

Há três tipos de reset:

 - soft: vai matar o commit feito, o arquivo já está em staging com a modificação pronta para ser commitada

 - mixex: mata o commit também, vai voltar arquivos para antes do staging (modified)

 - hard: ignorar commit e tudo o que foi feito, reset bem bruto

[[Git] Os Três Tipos de Reset](https://medium.com/@andgomes/os-tr%C3%AAs-tipos-de-reset-aa220658d9b2)

## Desfazendo alterações que JÁ foram adicionadas E commitadas (SOFT)

    # Editar o arquivo
    vi readme.md

     # Adicionando e commitando
    git commit -am "Alterando ...."

    # Histórico de commits
    git log

    # Desfaz 
    git reset --soft <hash do commit para onde quer voltar>

    # Só fazer o commit
    git commit -m "agora ..."

    # Histórico de commits
    git log

## Desfazendo alterações que JÁ foram adicionadas E commitadas (MIXED)

    # Editar o arquivo
    vi readme.md

     # Adicionando e commitando
    git commit -am "Alterando2 ...."

    # Histórico de commits
    git log

    # Desfaz 
    git reset --mixed <hash do commit para onde quer voltar>

    # Arquivos em modified
    git status

    # Só fazer o commit
    git commit -am "agora commit depois do mixed..."

    # Histórico de commits
    git log

## Desfazendo alterações que JÁ foram adicionadas E commitadas (HARD)

    # Editar o arquivo
    vi readme.md

     # Adicionando e commitando
    git commit -am "Alterando3 ...."

    # Histórico de commits
    git log

    # Desfaz 
    git reset --hard <hash do commit para onde quer voltar>

    # Histórico de commits
    git log

    # Nada alterado
    git status

    # Utilizar com muito cuidado se já tiver subido no repositório remoto (necessário usar FORCE)
    # Irá alterar o histórico de commits
    
