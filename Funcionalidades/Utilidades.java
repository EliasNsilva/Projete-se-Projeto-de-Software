package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Tarefas;
import Classes.Usuario;

public abstract class Utilidades {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public static Usuario buscaPorCpf(String cpf, ArrayList<Usuario> Usuarios){
        for (Usuario i : Usuarios){
            if (i.getCpf().equals(cpf)){
                return i;
            }
        }
        return null;
    }

    public static void consultaProj(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        String campo;
        
        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Status\n2- Coordenador");
        String i = input.next();
        
        switch (i) {
            case "1":
                System.out.println("Opções: Em processo de criação, Iniciado, Em andamento, Concluído.");
                String res1 = input.next();
                campo = res1;

                for(Projeto proj: projetos){
                    if(proj.getStatus().equals(campo)){
                        System.out.printf("Descrição : %s\n", proj.descricao);
                        System.out.printf("Status : %s\n", proj.getStatus());
                        System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
                        System.out.printf("Data de termino : %s\n", proj.data_final);
                        System.out.printf("Coordenador do projeto %s", proj.getCoordenador().getNome());
                    }
                }
                break;
            case "2":
                System.out.print("Insira o cpf do coordenador:");
                String res2 = input.next();

                for(Projeto proj: projetos){
                    if(proj.getCoordenador().getCpf().equals(res2)){
                        System.out.printf("Descrição : %s\n", proj.descricao);
                        System.out.printf("Status : %s\n", proj.getStatus());
                        System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
                        System.out.printf("Data de termino : %s\n", proj.data_final);
                        System.out.printf("Coordenador do projeto %s", proj.getCoordenador().getNome());
                    }
                }
                break;
            default:
                break;
        }
    }


    public static void consultaAtiv(ArrayList<Projeto> projetos){
        String campo;
        System.out.print("A qual projeto a atividade pertence?");
        
        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }
        
        int i = input.nextInt();
        Projeto proj = projetos.get(i);

        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Status\n2- Responsável");
        String j = input.next();

        switch (j) {
            case "1":
                System.out.println("Opções: Em andamento, Concluído.");
                String res1 = input.next();
                campo = res1;

                for(Atividade ativ: proj.ativs){
                    if(ativ.status.equals(campo)){
                        System.out.printf("Status: %s", ativ.status);
                        System.out.printf("Descrição: %s", ativ.descricao);
                        System.out.printf("Data de Inicio : %s\n", ativ.data_inicio);
                        System.out.printf("Data de termino : %s\n", ativ.data_final);
                        System.out.printf("Responsável %s\n", ativ.responsavel.getNome());
                    }
                }
                break;
            case "2":
                System.out.print("Insira o cpf do responsável:");
                String res2 = input.next();

                for(Atividade ativ: proj.ativs){
                    if(ativ.responsavel.getCpf().equals(res2)){
                        System.out.printf("Status: %s", ativ.status);
                        System.out.printf("Descrição: %s", ativ.descricao);
                        System.out.printf("Data de Inicio : %s\n", ativ.data_inicio);
                        System.out.printf("Data de termino : %s\n", ativ.data_final);
                        System.out.printf("Responsável %s\n", ativ.responsavel.getNome());
                    }
                }
                break;
            default:
                break;
        }
    }

    public static void consultaUsu(ArrayList<Usuario> usuarios){
        String campo;
        
        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Nome\n2- Cargo\n3- CPF");
        String i = input.next();
        
        switch (i) {
            case "1":
                System.out.print("Insira o nome: ");
                String res1 = input.next();
                campo = res1;

                for(Usuario user: usuarios){
                    if(user.getNome().equals(campo)){
                        System.out.printf("Nome : %s\n", user.getNome());
                        System.out.printf("CPF : %s\n", user.getCpf());
                        System.out.printf("Cargo : %s\n", user.getCargo());
                    }
                }
                break;
            case "2":
                System.out.println("Opções: Aluno de Graduação, Aluno de mestrado, Aluno de doutorado, Professor, Pesquisador, Desenvolvedor, Testador, Analista, Técnico");
                System.out.print("Insira o Cargo:");
                String res2 = input.next();
                campo = res2;

                for(Usuario user: usuarios){
                    if(user.getCargo().equals(campo)){
                        System.out.printf("Nome : %s\n", user.getNome());
                        System.out.printf("CPF : %s\n", user.getCpf());
                        System.out.printf("Cargo : %s\n", user.getCargo());
                        break;
                    }
                }
                break;
            case "3":
                System.out.print("Insira o CPF:");
                String res3 = input.next();
                campo = res3;

                for(Usuario user: usuarios){
                    if(user.getCpf().equals(campo)){
                        System.out.printf("Nome : %s\n", user.getNome());
                        System.out.printf("CPF : %s\n", user.getCpf());
                        System.out.printf("Cargo : %s\n", user.getCargo());
                    }
                }
                break;
            default:
                break;
        }
        System.out.print("Qual cpf do usuário que deseja vizualizar?");

        String res = input.next();
        Usuario user = buscaPorCpf(res, usuarios);
        if(user == null){
            System.out.println("Usuário não encontrado");
        }
        else{
            System.out.printf("Nome : %s\n", user.getNome());
            System.out.printf("CPF : %s\n", user.getCpf());
            System.out.printf("Cargo : %s\n", user.getCargo());
        }
    }

    public static void associarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um projeto a um usuário\n2- Associar Usuários a um projeto");
        int escolha = input.nextInt();

        if (escolha == 1) {       
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
            System.out.println("Qual projeto deseja associar a esse usuario?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
        
            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            proj.setUsuarios(user);

        }else if(escolha == 2){
            System.out.println("Qual projeto deseja associar?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }

            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }

            proj.setUsuarios(user);
        }
    }

    public static void associarAtividade(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um atividade a um usuário\n2- Associar Usuários a uma atividade");
        int escolha = input.nextInt();

        if (escolha == 1) {       
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, proj.getUsuarios());

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
        
            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
        
            int at = input.nextInt();

            Atividade ativ = proj.ativs.get(at);
            ativ.getProfissionais().add(user);

        }else if(escolha == 2){
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }

            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
            int ativ_res = input.nextInt();

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
            else{
                Atividade ativ = proj.ativs.get(ativ_res);
                ativ.getProfissionais().add(user);
            }
        }
    }

    public static void intercambio(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto o usuário pertence?\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.descricao);
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.print("Digite o cpf do Usuario que seja adicionar: ");
        String cpf = input.next();
        Usuario user = buscaPorCpf(cpf, proj.getUsuarios());

        if(user == null){
            System.out.println("Usuário não encontrado");
        }
        else{
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto p2: projetos){
                System.out.printf("%d- %s\n", p2.id, p2.descricao);
            }
            int p2 = input.nextInt();
            Projeto proj2 = projetos.get(p2);

            System.out.println("Qual atividade deseja adicionar o usuário?\n");

            for(Atividade i: proj2.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
    
            int ativ_res = input.nextInt();
            Atividade ativ = proj2.ativs.get(ativ_res);

            ativ.getProfissionais().add(user);

            System.out.println("Adicione as tarefas do usuário");

            Criar.addTarefas(ativ.getProfissionais());
        }
    }

    public static void bolsas(ArrayList<Projeto> projetos){
        System.out.println("Selecione um projeto\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.descricao);
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.printf("Qual tipo de usuário deseja pagar?:\n");
        System.out.println("1- Alunos de Graduação\n2- Alunos de mestrado\n3- Alunos de doutorado");
        System.out.println("4- Professores\n5- Pesquisadores\n6- Desenvolvedores\n7- Testadores\n8- Analistas\n9- Técnicos");
        int res = input.nextInt();
        String cargo = "";

        switch (res) {
            case 1:
                cargo = "Aluno de Graduação";
                break;
            case 2:
                cargo = "Aluno de mestrado";
                break;
            case 3:
                cargo = "Aluno de doutorado";
                break;
            case 4:
                cargo = "Professor";
                break;
            case 5:
                cargo = "Pesquisador";
                break;
            case 6:
                cargo = "Desenvolvedor";
                break;
            case 7:
                cargo = "Testador";
                break;
            case 8:
                cargo = "Analista";
                break;
            case 9:
                cargo = "Técnico";
                break;
            default:
                break;
        }

        for(Usuario i: proj.getUsuarios()){
            if(i.getCargo().equals(cargo)){
                i.recebido += proj.bolsas[res-1];
            }
        }
    }

    public static void relatorio(ArrayList<Projeto> projetos){
        System.out.println("\n############ Relatório de projetos ############\n\n");
        
        for(Projeto proj: projetos){
            System.out.printf("Projeto %d\n", proj.id);
            System.out.printf("Descrição : %s\n", proj.descricao);
            System.out.printf("Status : %s\n",proj.getStatus());
            System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
            System.out.printf("Data de termino : %s\n", proj.data_final);
            System.out.printf("Coordenador do projeto %s\n", proj.getCoordenador().getNome());

            System.out.println("  Participantes do projeto:");
            for(Usuario user: proj.getUsuarios()){
                if(proj.getUsuarios() == null){
                    break;
                }
                System.out.printf(user.toString());
                System.out.println("___________________________");
            }
            
            System.out.println("  Atividades do projeto:");
            for(Atividade ativ: proj.ativs){
                if(proj.ativs == null){
                    break;
                }
                System.out.printf("    Atividade %d\n", ativ.id);
                System.out.printf("    Status: %s\n", ativ.status);
                System.out.printf("    Descrição: %s\n", ativ.descricao);
                System.out.printf("    Data de Inicio : %s\n", ativ.data_inicio);
                System.out.printf("    Data de termino : %s\n", ativ.data_final);
                System.out.printf("    Responsável %s\n", ativ.responsavel.getNome());

                for(Tarefas tf: ativ.tarefas){
                    System.out.printf("    Tarefa %d\n", tf.id);
                    System.out.printf("    Descrição: %s\n", tf.descricao);
                    System.out.printf("    Responsável %s\n", tf.profissonal);
                }
                System.out.println("___________________________");
            }
            System.out.println("###########################################");
        }
    }

    public static void recuperarSenha(ArrayList<Usuario> Usuarios){
        System.out.println("Recuperação de senha");
        System.out.print("Digite o cpf: ");
        String loginCpf = input.next();

        Usuario user = buscaPorCpf(loginCpf, Usuarios);
        
        if(user == null){
            System.out.println("Usuário não encontrado, tente novamente");
        }
        else{
            System.out.print("Digite a nova senha: ");
            String novaSenha = input.next();

            System.out.print("Digite a nova senha novamente: ");
            String novaSenhaVer = input.next();

            if(novaSenha.equals(novaSenhaVer)){
                user.atualizarSenha(novaSenha);
                return;
            }
        }
    }

    public static Usuario login(ArrayList<Usuario> Usuarios){
        System.out.print("Digite o cpf ou ''eita'' Caso tenha esquecido a senha:\n");
        String loginCpf = input.next();

        if(loginCpf.equals("eita")){
            recuperarSenha(Usuarios);
            login(Usuarios);
        }
        else{
            Usuario user = buscaPorCpf(loginCpf, Usuarios);
            
            if(user == null){
                System.out.println("Usuário não encontrado, tente novamente");
                login(Usuarios);
            }
            else{
                System.out.print("Digite o senha: ");
                String loginSenha = input.next();
    
                if(loginSenha.equals(user.getSenha())){
                    return user;
                }
                else{
                    System.out.println("Senha errada, tente de novo!");
                    login(Usuarios);
                }
            }
        }
        
        return null;
    }
}