import java.util.Scanner;

import Classes.Projeto;
import Classes.Usuario;
import Funcionalidades.Criar;
import Funcionalidades.Editar;
import Funcionalidades.Remover;
import Funcionalidades.Utilidades;

import java.util.ArrayList;

/*
Conceitos a serem aplicados:
    Classes - OK
    Overloading - OK
    Overriding - OK
    Modificadores de acesso OK
    Herança - OK
    Polimorfismo - OK
    Abstract class - OK
    Interface - OK
    Generics - OK
    Collections - OK
*/ 

// TODO 
//     Melhorar edição de dados
//     Restringir campos de usuário
//     utilizar mais o toString
//     criar logout
//     Testar


// 10) Permitir operações de undo e redo de informações referentes aos projetos,
// atividades e usuários.

public class Sistema extends Utilidades{
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    static Usuario user;
    static Criar criacao = new Criar();
    static Editar edicao = new Editar();
    static Remover remocao = new Remover();
    public static void main(String[] args) {
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        
        while(true){
            System.out.println("\n####################################################");
            System.out.println("############# Bem vindo ao Projete-se! #############");
            System.out.println("####################################################\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Criação e remoção de informações\n2- Edição de informações");
            System.out.println("3- Associação de usuários aos projetos e atividades\n4- Alteração de status");
            System.out.println("5- Consultas\n6- Relatório\n7- Intercambio de usuários\n8- Pagamento de bolsas");
            System.out.println("9- Login\n10- Undo ou redo");
            String i = input.next();
            switch (i) {
                case "1":
                    System.out.println("\n#########################\n");
                    System.out.println("1- Criar Usuário\n2- Criar projeto\n3- Remover");
                    String esc = input.next();
                    switch (esc) {
                        case "1":
                            System.out.println("Insira as informação para criar um usuário");
                            Criar.criarUsuario(Usuarios);
                            break;
                        case "2":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            Criar.criarProjeto(projetos, Usuarios);
                            break;
                        case "3":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            System.out.println("O que você deseja remover?\n");
                            System.out.println("1- Projeto\n2- Atividade\n3- Tarefa");
                            String j = input.next();

                            switch (j){
                                case "1":
                                    Remover.removerProjeto(projetos);
                                    break;
                                case "2":
                                    Remover.removerAtividade(projetos);
                                    break;
                                case "3":
                                    Remover.removerTarefa(projetos);
                                    break;
                                default:
                                    break;
                            }

                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "2":
                    System.out.println("\n#########################\n");
                    System.out.println("O que você deseja editar?\n");
                    System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
                    String j = input.next();

                    switch (j){
                        case "1":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            Editar.editarProjeto(projetos);
                            break;
                        case "2":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            Editar.editarAtividade(projetos);
                            break;
                        case "3":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            Editar.editarUsuario(Usuarios);
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "3":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    System.out.println("1- Associar projeto\n2- Associar atividade");
                    int associar = input.nextInt();
                    if(associar == 1){
                        associarProjeto(projetos, Usuarios);
                    }else if(associar == 2){
                        associarAtividade(projetos, Usuarios);
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "4":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }

                    System.out.println("\n#########################\n");
                    System.out.println("De qual projeto deseja alterar o status?");
                    for(Projeto k: projetos){
                        System.out.printf("%d- %s\n", k.id, k.descricao);
                    }
                    
                    int p = input.nextInt();            
                    Projeto proj = projetos.get(p);

                    if(proj.getCoordenador().getCpf() != user.getCpf() && proj.getCoordenador().getCargo() != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }

                    proj.setStatus(proj, user);
                    
                    System.out.println("\n#########################\n");
                    break;
                case "5":
                    System.out.println("\n#########################\n");
                    System.out.println("O que deseja consultar?");
                    System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
                    String l = input.next();
                    switch (l) {
                        case "1":
                            consultaProj(projetos, Usuarios); 
                            break;
                        case "2":
                            consultaAtiv(projetos);
                            break;
                        case "3":
                            consultaUsu(Usuarios);
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "6":
                    System.out.println("\n#########################\n");
                    relatorio(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "7":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    intercambio(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "8":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    bolsas(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "9":
                    System.out.println("\n#########################\n");
                    user = login(Usuarios);
                    System.out.println("\n#########################\n");
                    break;
                case "10":
                    System.out.println("\n#########################\n");
                    System.out.println("\n#########################\n");
                    break;
                default:
                    break;
            }
        }
    }
}