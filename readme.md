<h2 align="center">Comandos GIT </h2>

1 – Iniciando um repositório na pasta
Para que os arquivos de uma pasta possam ser upados no Git, é preciso iniciar o repositório. 

> $ git init

<div align="center">
<img src="https://user-images.githubusercontent.com/103793612/194394717-e1fdcc59-1f9e-4c0a-80d7-8d5e7385a586.png" width="300px" />
</div>

2 - Apagando um repositório
Apaga a pasta git (pasta oculta) ou digitar o comando abaixo deleta somente as informações do repositório vinculadas ao git init.

> $ rm -rf .git

<div align="center">
<img src="https://user-images.githubusercontent.com/103793612/194396462-c4ace37f-7d0f-45cc-ad62-3665f96c3a4c.png" width="300px" />
</div>

 
3 -Listando Arquivos Modificados
Esse comando indica o estado do seu repositório. 

> $ git status

<<div align="center">>
<img src=" " width="300px" />
</div>
 
4 – Desfazer de arquivos não monitorados
Se fez alguma besteira no arquivo e não lembra do que fez e ainda não deu GIT ADD, você pode executar o comando abaixo e removerá as alterações para o último commit. 

> git checkout .

<div align="center">
<img src=" " width="300px" />
</div>

Esse comando não apaga novos arquivos. Para apagar novos arquivos que ainda não foram adicionados ao Stage, execute:

> git clean -df

<div align="center">
<img src=" " width="300px" />
</div>
 
5 – Desfazendo/Removendo arquivos do Stage
Se você realmente seguiu com a lambança e executou git add e quer desfazer, use o reset.

> git reset

<div align="center">
<img src=" " width="300px" />
</div>

Para desfazer as modificações, após o reset use o checkout ou clean mostrados anteriormente.

6 - Desfazendo o último commit
Caso você tenha feito alterações e a lambança tenha escorrido pela calça (realizou um commit), calma que ainda dá para desfazer... é necessário usar o revert.

> git revert HEAD

OBS: Será criado um novo commit indicando que o último commit foi desfeito.
OBS²: Esse comando apaga novos arquivos.

<div align="center">
<img src=" " width="300px" />
</div>
 
6 - Renomear Commit
Quem nunca esqueceu ou escreveu algo errado no commit? Esse comando te permite renomear a mensagem do último commit feito:

> $ git commit --amend

<div align="center">
<img src=" " width="300px" />
</div>

7 - Listando Branches
Esse comando lista todas as branches presentes no repositório do seu computador.

> $ git branch


Caso você queira que ele liste também as branches que estão no repositório remoto, adicione -a:

> $ git branch -a

<div align="center">
<img src=" " width="300px" />
</div>
 
8- Criando Branches
Esse comando cria uma branch no repositório do seu computador.

> $ git branch nomeDaBranch

<div align="center">
<img src=" " width="300px" />
</div>

9 - Indo para outra branch
Para mudar para uma outra branch basta usar o comando checkout, passando o nome da branch.

> $ git checkout nomeDaBranch

Se você adicionar -b, uma nova branch será criada.

> $ git checkout -b minha-nova-branch

<div align="center">
<img src=" " width="300px" />
</div>
 
10 - Excluindo branches
Para excluir uma branch local basta executar o comando branch com -d ou -D, passando o nome da branch que você quer apagar.

> git branch -d nome-da-branch
> git branch -D nome-da-branch

A opção -d é mais segura, pois ela só apaga a branch se você já tiver feito merge ou enviado as alterações para seu repositório remoto, evitando perda de código.
A opção -D ignora o estado da sua branch, forçando a sua remoção.
Esse comando apaga apenas a branch local, não removendo branches remotas.

<div align="center">
<img src=" " width="300px" />
</div>
 
Obs: Lembra-se de trocar de branch para um que você não vá deletar para evitar bugs.

11 - Renomeando branches

Para renomear a sua atual branch local, execute o comando branch com a opção -m, passando o novo nome.

> git branch -m novo-nome-da-branch

Se você estiver em uma branch e quiser renomear outra, você deve passar primeiro o nome atual da branch que quer renomear:

> git branch -m nome-atual novo-nome

<div align="center">
<img src=" " width="300px" />
</div>

 
12 - Visualizando o Histórico de Commits

Para visualizar o histórico de commits basta usar o seguinte comando:

> $ git log

<div align="center">
<img src=" " width="300px" />
</div>

 
13 - Exibir branches em um modo mais legível

É possível mandar imprimir o histórico exibindo as branches do repositório com algo mais legível e com cores com um comando. Teremos um resultado parecido com esse:

<div align="center">
<img src=" " width="300px" />
</div>
 
O comando é um pouco comprido:

> git log --all --decorate --oneline --graph

Para decorar tudo o que devemos escrever depois de log, lembre-se de A DOG
-	–all
-	–decorate
-	–oneline
-	–graph

14 - Trabalhando em mais de uma coisa sem fazer commit

Pode haver momentos em que você precisa parar o que está fazendo e começar a trabalhar em outra tarefa. Porém, pode não ser bom fazer o commit de algo que ainda não foi finalizado para depois voltar nele, resultando em um commit que ficará no histórico, mas que possui um código que não funciona. Nós podemos salvar essas alterações feitas mesmo sem precisar realizar um commit para depois voltar a trabalhar nela, o que é chamado de Stash (algo como “esconder” ou “acumular”).

Ao fazer isso, seu repositório voltará ao estado do último commit, e as alterações feitas anteriormente estarão “escondidas”.

14.1 - Salvando modificações em um Stash
Simplesmente execute o comando stash

> $ git stash

Você ainda pode colocar um nome nesse stash:

> $ git stash push -m meu-novo-stash

14.2 - Listando Stashes

Você pode fazer vários stashes. Para listá-los, execute o comando:

> $ git stash list

<div align="center">
<img src=" " width="300px" />
</div>
 
14.3 - Recuperando modificações

Se algo foi salvo no stash, basta executar o seguinte comando para recuperar as alterações que foram jogadas lá:

> $ git stash apply

Isso vai recuperar o código do stash mais recente. Se quiser recuperar um stash mais antigo, basta ver o número do stash que aparece quando o listamos e passar para o seguinte comando:

> $ git stash apply stash@{2}

14.4 - Removendo Stashes

Quando nós recuperamos alterações de um stash, ele continua guardado. Para apagá-lo da pilha, execute o comando drop junto ao nome do stash que você quer remover:

> $ git stash drop stash@{5}

Se você quiser recuperar o código de um stash e já apagá-lo, pode usar o comando pop no lugar do apply.

15 - Juntando alguns pedaços do trabalho

Pode ser que você esteja trabalhando em uma branch e queira fazer o merge do código dela com outra branch, mas não quer juntar o trabalho inteiro, apenas um commit específico. Isso é possível com o Cherry Pick.

> git cherry-pick id-do-commit







