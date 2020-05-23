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

[Descartando mudanças locais (antes do stage)](https://githowto.com/pt-BR/undoing_local_changes)

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

[Descartando mudanças no stage (antes do commit)](https://githowto.com/pt-BR/undoing_staged_changes)    

## Desfazendo alterações que já foram adicionadas E commitadas

Há três tipos de reset:

 - soft: vai matar o commit feito, o arquivo já está em staging com a modificação pronta para ser commitada

 - mixed: mata o commit também, vai voltar arquivos para antes do staging (modified)

 - hard: ignorar commit e tudo o que foi feito, reset bem bruto

[[Git] Os Três Tipos de Reset](https://medium.com/@andgomes/os-tr%C3%AAs-tipos-de-reset-aa220658d9b2)

[Desfazendo commits](https://githowto.com/pt-BR/undoing_committed_changes)

[Removendo um commit de um branch](https://githowto.com/pt-BR/removing_commits_from_a_branch)

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
    
## Criando e adicionando uma chave SSH

[Conectar-se ao GitHub com SSH](https://help.github.com/pt/github/authenticating-to-github/connecting-to-github-with-ssh)

[Gerar uma nova chave SSH](https://help.github.com/pt/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

[Adicionar sua chave SSH ao ssh-agent](https://help.github.com/pt/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent#adding-your-ssh-key-to-the-ssh-agent)
    
    # Onde ficam as chaves do ssh
    $ cd ~/.ssh    

    # Gerar chave
    # Só ir dando <enter> para aceitar as opções default
    $ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"

    # Listando as chaves
    $ ls

    # A saída será:
    id_rsa  id_rsa.pub
    
    # Inicie o ssh-agent em segundo plano
    $ eval "$(ssh-agent -s)"

    # Adicione sua chave SSH privada ao ssh-agent
    $ ssh-add ~/.ssh/id_rsa

    # Adicionar a chave no Github
    # A chave que vai no Github é a .pub

    # Obter a chave
    $ cat id_rsa.pub

    # Também obtém a chave
    $ more id_rsa.pub

    # Ou pode abrir no editor de texto
    $ vi id_rsa.pub

    # Copiar a chave para a área de transferência, logar no Github e acessar:
    # Settings \ SSH and GPC Keys \ New SSH key
        Title: Pode ser o identiticador da máquina (Home/Work/etc...)
        Key: Colar a chave gerada

## Ligando repositório local a um remoto
    
    Após criar o repositório no Github, realizar os seguintes passos:

    Para ssh, executar os comandos em formato ssh. Logo abaixo onde diz "Quick setup — if you’ve done this kind of thing before", selecione "SSH". Então, execute um dos passos abaixo.

    - …or create a new repository on the command line: se não tem o repositório local

    - …or push an existing repository from the command line: se já criou 

    # Mostra o repositório remoto
    $ git remote

    # Mais informações sobre o repositório remoto
    $ git remote -v

[Adicionar um projeto existente ao GitHub usando a linha de comando](https://help.github.com/pt/github/importing-your-projects-to-github/adding-an-existing-project-to-github-using-the-command-line)

## Alterar o remote do URL

É possível alterar o remote de HTTPS para SSH ou vice-versa

[Alternar URLs remotes de SSH para HTTPS](https://help.github.com/pt/github/using-git/changing-a-remotes-url#switching-remote-urls-from-ssh-to-https)

[Alternar URLs remotes de HTTPS para SSH](https://help.github.com/pt/github/using-git/changing-a-remotes-url#switching-remote-urls-from-https-to-ssh)

## Enviando alterações para o repositório remoto

Após realizar as alterações, digitar os comandos

    # Adiciona e commita
    $ git commit -am "Alteração em xyz" 

    # Envia para o repositório remoto (chamado 'origin' - nome default) a partir do branch master
    $ git push origin master

## Clonando repositórios remotos

"As URLs de clone de https:// estão disponíveis em todos os repositórios, públicos e privados. Esses URLs funcionam mesmo se você estiver protegido por um firewall ou proxy."

###### Fonte: [Qual URL remote eu devo usar?](https://help.github.com/pt/github/using-git/which-remote-url-should-i-use)

    # É possível clonar pelo endereço https ou ssh    
    $ git clone url-repositorio-remoto.git

    # O parâmetro 'nome-da-pasta' é opcional e caso não informe, será baixado com o mesmo
    # nome que está no repositório remoto
    $ git clone url-repositorio-remoto.git nome-da-pasta

## Fazendo fork de um projeto

Faz cópia do projeto de outro usuário para o seu.

Acesse no Github, o projeto que deseja fazer o fork e clique em "Fork".

## Branch

É um ponteiro móvel que leva a um commit.

    # Criando branch
    $ git checkout -b <nome-do-branch-quero-criar>
    $ git checkout -b testing

    # Informa quais são os branches existentes e qual branch está no momento (em *)
    $ git branch

## Movendo e deletando branches

    # Ir para um branch específico
    $ git checkout <nome-do-branch-quero-ir>
    $ git checkout master

    # Remover um branch (para remover, tem que fazer checkout para outro branch antes)
    $ git branch -D <nome-do-branch-quero-remover>
    $ git branch -D testing

## Entendendo o merge

No **merge** é gerado um commit extra para unir os commits que "andaram" em separado (em outro branch) com o branch que será unificado (por exemplo, a develop). 

Isso acaba criando uma forma de diamante que pode confundir bastante quando vamos olhar os commits.

Pró: É uma operação não destrutiva (irá manter o histórico).

Contra: Commit extra, histórico poluído

Exemplo: estou trabalhando no branch **'my-branch'** e quero fazer **merge** com o branch **'develop'** (onde os demais desenvolvedores estão trabalhando):
    
    # Trocar para o branch da develop
    $ git checkout develop

    # Atualizar o branch da develop
    $ git pull

    # Voltar para o meu branch ('my-branch')
    $ git checkout my-branch

    # Fazer o merge com a develop
    git merge develop

## Entendendo o rebase

Deixa os commits de forma linear.

Fast-foward: põem as mudanças para o início da fila.

Pro: evita commit extra, histórico linear

Contra: perde ordem cronológica (como coloca o commit para o início da fila, perde a ordem que ocorreu), **muda o histórico**

Deve tomar basta **cuidado com essa mudança de histórico**. Ao mudar o histórico e se outra pessoa estiver trabalhando no mesmo branch, essa pessoa não vai conseguir subir as alterações que fez, vai dar conflito, pois o histórico está diferente.

Rebase deve ser usado com muito cuidado!

Usar rebase qdo for fazer pull das modificações, assim não tem o rsico de fazer mudança no histórico que outras pessoas
poderiam estar trabalhando e seriam prejudicadas.

    # Rebase qdo for fazer pull
    $ git pull --rebase

