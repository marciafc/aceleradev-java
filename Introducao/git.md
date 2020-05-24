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
    git config --global core.editor "code --wait"

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

### Exemplo com Merge:

    # Criar pasta
    $ mkdir rebase-merge

    # Acessar pasta
    $ cd rebase-merge

    # Inicializar repositório Git
    $ git init

    # Criar arquivo foo
    $ vi foo

    # Adicionar arq foo
    $ git add foo

    # Commit arq foo
    $ git commit -m "Add foo (master)"

    # Tudo isso ocorreu no branch 'master'
    # Agora vamos criar um outro branch e vamos chamar de 'test'
    $ git checkout -b test

    # Criar arquivo chamado bar
    $ vi bar

    # Adicionar arq bar
    $ git add bar

    # Commit arq bar
    $ git commit -m "Add bar (test)"

    # Ver commits do branch 'test' 
        # Add bar -> veio deste branch
        # Add foo -> veio do master
    $ git log

    # Retornar para a master
    $ git checkout master

    # Ver commits do branch 'master'
        Add foo -> veio do próprio master, não tem o 'Add bar' (pois ele ocorreu no branch 'test')
    $ git log

    # Criar arquivo chamado fizz
    $ vi fizz

    # Adicionar arq fizz
    $ git add fizz

    # Commit arq fizz
    $ git commit -m "Add fizz (master)"

    # Ver commits do branch 'master'
        # Add fizz							-> Não tem o 'Add bar'	(pois ele ocorreu no branch 'test')
        ###################################	'Add bar' teria que entrar aqui pela ordem cronológica
        # Add foo
    $ git log

    # Fazer o merge (vai pegar do branch 'test' e colocar no 'master')
    $ git merge test

    # Apertar <ESC>  (se estiver usando vi)

    # Digitar :wq para salvar e sair (se estiver usando vi)

    # O merge foi realizado do 'test' para dentro do 'master'

    # Ver commits do branch 'master'
        # Merge branch 'test'	-> Ocorreu um commit novo para fazer essa junção
        # Add fizz
        # Add bar				-> Entrou na posição esperada
        # Add foo
    $ git log

    # Olhar o log graficamente (repare o ciclo)
    # O histórico fica linear (git log), a estrutura não fica linear (git log --graph)
    $ git log --graph    

#### Olhando o git log

(se abrir este arquivo .md no preview do editor VSCode aparece colorido)

<pre>(base) <font color="#8AE234"><b>marcialinux@marcialinux-Lenovo-G400s</b></font>:<font color="#729FCF"><b>~/IdeaProjects/git-curso2/rebase-merge</b></font>$ git log
<font color="#C4A000">commit 852e50e7b5ee9c633d7be48debd9743c6ce3afb7 (</font><font color="#34E2E2"><b>HEAD -&gt; </b></font><font color="#8AE234"><b>master</b></font><font color="#C4A000">)</font>
Merge: 4e6d28b d954957
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:26:45 2020 -0300

    Merge branch &apos;test&apos;

<font color="#C4A000">commit 4e6d28bbfaf35fab33056f85036e3bb9cba4f41e</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:26:19 2020 -0300

    Add fizz (master)

<font color="#C4A000">commit d9549572c90ba6b4e4b5a395e6c8584cfd43002b (</font><font color="#8AE234"><b>test</b></font><font color="#C4A000">)</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:25:22 2020 -0300

    Add bar (test)

<font color="#C4A000">commit 12348eb2fdadd15b5f168f96002deff573feb160</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:24:52 2020 -0300

    Add foo (master)
</pre>

#### Olhando o git log --graph 

(se abrir este arquivo .md no preview do editor VSCode aparece colorido)

<pre>(base) <font color="#8AE234"><b>marcialinux@marcialinux-Lenovo-G400s</b></font>:<font color="#729FCF"><b>~/IdeaProjects/git-curso2/rebase-merge</b></font>$ git log --graph
*   <font color="#C4A000">commit 852e50e7b5ee9c633d7be48debd9743c6ce3afb7 (</font><font color="#34E2E2"><b>HEAD -&gt; </b></font><font color="#8AE234"><b>master</b></font><font color="#C4A000">)</font>
<font color="#CC0000">|</font><font color="#4E9A06">\</font>  Merge: 4e6d28b d954957
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> Date:   Sat May 23 22:26:45 2020 -0300
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> 
<font color="#CC0000">|</font> <font color="#4E9A06">|</font>     Merge branch &apos;test&apos;
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> 
<font color="#CC0000">|</font> * <font color="#C4A000">commit d9549572c90ba6b4e4b5a395e6c8584cfd43002b (</font><font color="#8AE234"><b>test</b></font><font color="#C4A000">)</font>
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> Date:   Sat May 23 22:25:22 2020 -0300
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> 
<font color="#CC0000">|</font> <font color="#4E9A06">|</font>     Add bar (test)
<font color="#CC0000">|</font> <font color="#4E9A06">|</font> 
* <font color="#4E9A06">|</font> <font color="#C4A000">commit 4e6d28bbfaf35fab33056f85036e3bb9cba4f41e</font>
<font color="#4E9A06">|/</font>  Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#4E9A06">|</font>   Date:   Sat May 23 22:26:19 2020 -0300
<font color="#4E9A06">|</font>   
<font color="#4E9A06">|</font>       Add fizz (master)
<font color="#4E9A06">|</font> 
* <font color="#C4A000">commit 12348eb2fdadd15b5f168f96002deff573feb160</font>
  Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
  Date:   Sat May 23 22:24:52 2020 -0300
  
      Add foo (master)
</pre>  

## Entendendo o rebase

Deixa os commits de forma linear.

Fast-foward: põem as mudanças para o início da fila.

Pro: evita commit extra, histórico linear (sem o formato de diamante)

Contra: perde ordem cronológica (como coloca o commit para o início da fila, perde a ordem que ocorreu), **muda o histórico**

Deve tomar basta **cuidado com essa mudança de histórico**. Ao mudar o histórico e se outra pessoa estiver trabalhando no mesmo branch, essa pessoa não vai conseguir subir as alterações que fez, vai dar conflito, pois o histórico está diferente.

Rebase deve ser usado com muito cuidado!

[Boa prática] Usar rebase qdo for fazer pull das modificações, assim não tem o risco de fazer mudança no histórico que outras pessoas poderiam estar trabalhando e seriam prejudicadas.

    # Rebase qdo for fazer pull
    $ git pull --rebase

### Exemplo com Rebase (executar após o [Exemplo com Merge](#Exemplo-com-merge))
    # Isso será executado no branch 'master'
    $ git checkout master

    # Criar o arquivo buzz
    $ vi buzz

    # Adicionar o arq buzz
    $ git add buzz

    # Commit arq buzz
    $ git commit -m "Add buzz (master)"

    # Commits do branch 'master'
        # Add buzz
        # Merge branch 'test'
        # Add fizz
        # Add bar
        # Add foo
    $ git log

    # Criar novo branch
    $ git checkout -b rebase-branch

    # Criar o arquivo bla
    $ vi bla

    # Adicionar o arq bla
    $ git add bla

    # Commit arq bla
    $ git commit -m "Add bla (rebase-branch)"

    # Commits do branch rebase-branch
        # Add bla
        # Add buzz
        # Merge branch 'test'
        # Add fizz
        # Add bar
        # Add foo
    $ git log	

    # Segue linear 
    $ git log --graph

    # Trocar para o branch master
    $ git checkout master

    # Commits do branch master
        ##########		-> Não tem o 'Add bla' (foi feito no branch 'rebase-branch')
        # Add buzz		
        # Merge branch 'test'
        # Add fizz
        # Add bar
        # Add foo
    $ git log	

    # Criar o arquivo seila
    $ vi seila

    # Adicionar o arq seila
    $ git add seila

    # Commit arq seila
    $ git commit -m "Add seila (master)"

    # Commits do branch master
        # Add seila
        ##########		-> Não tem o 'Add bla' (foi feito no branch 'rebase-branch')
        # Add buzz		
        # Merge branch 'test'
        # Add fizz
        # Add bar
        # Add foo
    $ git log

    # Rebase com branch rebase-branch
    $ git rebase rebase-branch

    # Commits no branch 'master'
        # Add seila
        # Add bla 
        # Add buzz		
        # Merge branch 'test'
        # Add fizz
        # Add bar
        # Add foo
    $ git log

    # Visualizando em modo gráfico (não criou ciclo)
    $ git log --graph

#### Olhando o git log

(se abrir este arquivo .md no preview do editor VSCode aparece colorido)

<pre>$ git log
<font color="#C4A000">commit 884d7a0c4bf333ef66ac5c1241761d26064e1a03 (</font><font color="#34E2E2"><b>HEAD -&gt; </b></font><font color="#8AE234"><b>master</b></font><font color="#C4A000">)</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 23:56:30 2020 -0300

    Add seila (master)

<font color="#C4A000">commit f7d3a2b43ea65573887ffe6136c77f98b79dfbe9 (</font><font color="#8AE234"><b>rebase-branch</b></font><font color="#C4A000">)</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 23:49:40 2020 -0300

    Add bla (rebase-branch)

<font color="#C4A000">commit a56a813ac9df4d0efcade6a6086c87fe51528153</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 23:47:38 2020 -0300

    Add buzz (master)

<font color="#C4A000">commit 852e50e7b5ee9c633d7be48debd9743c6ce3afb7</font>
Merge: 4e6d28b d954957
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:26:45 2020 -0300

    Merge branch &apos;test&apos;

<font color="#C4A000">commit 4e6d28bbfaf35fab33056f85036e3bb9cba4f41e</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:26:19 2020 -0300

    Add fizz (master)

<font color="#C4A000">commit d9549572c90ba6b4e4b5a395e6c8584cfd43002b (</font><font color="#8AE234"><b>test</b></font><font color="#C4A000">)</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:25:22 2020 -0300

    Add bar (test)

<font color="#C4A000">commit 12348eb2fdadd15b5f168f96002deff573feb160</font>
Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
Date:   Sat May 23 22:24:52 2020 -0300

    Add foo (master)
</pre>

#### Olhando o git log --graph

(se abrir este arquivo .md no preview do editor VSCode aparece colorido)

<pre>$ git log --graph
* <font color="#C4A000">commit 884d7a0c4bf333ef66ac5c1241761d26064e1a03 (</font><font color="#34E2E2"><b>HEAD -&gt; </b></font><font color="#8AE234"><b>master</b></font><font color="#C4A000">)</font>
<font color="#CC0000">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#CC0000">|</font> Date:   Sat May 23 23:56:30 2020 -0300
<font color="#CC0000">|</font> 
<font color="#CC0000">|</font>     Add seila (master)
<font color="#CC0000">|</font> 
* <font color="#C4A000">commit f7d3a2b43ea65573887ffe6136c77f98b79dfbe9 (</font><font color="#8AE234"><b>rebase-branch</b></font><font color="#C4A000">)</font>
<font color="#CC0000">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#CC0000">|</font> Date:   Sat May 23 23:49:40 2020 -0300
<font color="#CC0000">|</font> 
<font color="#CC0000">|</font>     Add bla (rebase-branch)
<font color="#CC0000">|</font> 
* <font color="#C4A000">commit a56a813ac9df4d0efcade6a6086c87fe51528153</font>
<font color="#CC0000">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#CC0000">|</font> Date:   Sat May 23 23:47:38 2020 -0300
<font color="#CC0000">|</font> 
<font color="#CC0000">|</font>     Add buzz (master)
<font color="#CC0000">|</font>   
*   <font color="#C4A000">commit 852e50e7b5ee9c633d7be48debd9743c6ce3afb7</font>
<font color="#4E9A06">|</font><font color="#C4A000">\</font>  Merge: 4e6d28b d954957
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> Date:   Sat May 23 22:26:45 2020 -0300
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> 
<font color="#4E9A06">|</font> <font color="#C4A000">|</font>     Merge branch &apos;test&apos;
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> 
<font color="#4E9A06">|</font> * <font color="#C4A000">commit d9549572c90ba6b4e4b5a395e6c8584cfd43002b (</font><font color="#8AE234"><b>test</b></font><font color="#C4A000">)</font>
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> Date:   Sat May 23 22:25:22 2020 -0300
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> 
<font color="#4E9A06">|</font> <font color="#C4A000">|</font>     Add bar (test)
<font color="#4E9A06">|</font> <font color="#C4A000">|</font> 
* <font color="#C4A000">|</font> <font color="#C4A000">commit 4e6d28bbfaf35fab33056f85036e3bb9cba4f41e</font>
<font color="#C4A000">|/</font>  Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
<font color="#C4A000">|</font>   Date:   Sat May 23 22:26:19 2020 -0300
<font color="#C4A000">|</font>   
<font color="#C4A000">|</font>       Add fizz (master)
<font color="#C4A000">|</font> 
* <font color="#C4A000">commit 12348eb2fdadd15b5f168f96002deff573feb160</font>
  Author: Marcia Castagna &lt;marciafc.info@gmail.com&gt;
  Date:   Sat May 23 22:24:52 2020 -0300
  
      Add foo (master)
</pre>

#### Quando utilizar cada MERGE ou REBASE?

    Merge: usar quando for casos de pull request, onde é necessário ver que foi unido por conta de uma feature.
    Utilizar quando a feature é adicionada no final e quer ver o histórico (de onde veio).

    Rebase: utilizar enquanto estiver trabalhando, adicionando novos commits e sempre atualizando com outros branches.

    

    

  


