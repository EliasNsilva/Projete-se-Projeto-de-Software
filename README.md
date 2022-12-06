# Projete-se
Projeto desenvolvido na disciplina projeto de software.

O Projete-se é um sistema de gerenciamento de projetos, permitindo a criação e gerencia dos mesmos.

Funcionalidades implementadas:

1) Criação e remoção;
2) Edição;
3) Associação;
4) Alteração do status;
5) Consultas;
6) Relatório;
7) Intercambio;
8) Pagamento de bolsas:
9) Acesso através de usuário e senha.

Funcionalidade pendente:

10) Permitir operações de undo e redo.

## Como rodar o sistema:

1. ```javac Sistema.java```
2. ```java Sistema```

Code Smells encontrados:

* Duplicated Code
    
    Codigo utilizado para mostrar todos os Projetos e seus Ids, sendo também utilizado para Atividades

    ```Java
        System.out.printf("%d- %s\n", i.id, i.getDescricao());
    ```

* Large Class:

    [Utilidades](/Funcionalidades/Utilidades.java/)

    *Solução*: Extract Class
    
* Primitive Obsession

    Campo [profissonal](/Classes/Tarefas.java), armazenando uma string que é referente a um Usuário
    ```Java
    public class Tarefas implements GeradorID <Tarefas>{
    public int id;
    public String descricao;
    public String profissonal;
    ```

    *Solução*: Replace Data Value with Object

* Speculative Generality
    
    A Classe [Usuário](/Classes/Usuario.java) só pussuí uma sub-classe [Aluno](/Classes/Aluno.java)
    
    *Solução*: Collapse Hierarchy

 
