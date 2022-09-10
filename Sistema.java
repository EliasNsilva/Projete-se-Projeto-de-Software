import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    static Scanner input = new Scanner(System.in);
    static Usuario user;
    
    public static void main(String[] args) {
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        
        while(true){
            System.out.println("Bem vindo ao Projete-se!\n Escolha uma opção\n1 - Criar usuario\n2- logar\n3- criar projeto");
            String i = input.next();
            switch (i) {
                case "1":
                    System.out.println("Insira as informação para criar um usuário");
                    criarUsuario(Usuarios);
                    break;
                case "2":
                    user = login(Usuarios);
                    break;
                case "3":
                    // if(user.getCargo().equals("coordenador")){
                    //     criarProjeto(projetos, Usuarios);
                    // }
                    // else{
                    //     System.out.println("Somente coordenadores podem criar projetos"); // É ISSO MESMO?
                    // }
                    // break;
                    criarProjeto(projetos, Usuarios);
                default:
                    break;
            }
        }
    }

    public static void criarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> Usuarios) {
        System.out.print("Insira a descrição do projeto: ");
        String descricao = input.next( );

        System.out.print("Insira a data de início do projeto: ");
        String data_inicio = input.next();

        System.out.print("Insira a data de termino do projeto: ");
        String data_final = input.next();

        System.out.print("Insira o cpf do coordenador do projeto: ");
        String coordenador_cpf = input.next();
        Usuario coordenador= buscaPorCpf(coordenador_cpf, Usuarios);

        ArrayList<Usuario> part_proj = addUsuario(Usuarios);

        ArrayList<Atividade> ativ_proj = addAtividades(Usuarios);
        
        Projeto pj = new Projeto(projetos.size(), "Em processo de criação", descricao, data_inicio, data_final, coordenador, part_proj, ativ_proj,"1 ano");

        projetos.add(pj);

        exibirProjetos(projetos);
    }

    public static Usuario criarUsuario(ArrayList<Usuario> Usuarios) {
        System.out.print("Digite o cpf: ");
        String cpf = input.next();
        
        System.out.print("Digite o senha: ");
        String senha = input.next();
        
        System.out.print("Digite o nome: ");
        String nome = input.next( );
        
        System.out.printf("Digite o cargo: ");
        String cargo = input.next();

        System.out.printf("Digite o valor da bolsa: ");
        String bolsa = input.next();

        Usuario part = new Usuario(cpf, senha, nome, cargo, bolsa);
        Usuarios.add(part);

        return part;
    }

    public static Atividade criarAtividades(ArrayList<Atividade> atividades, ArrayList<Usuario> Usuarios) {
        System.out.print("Digite o descrição: ");
        String desc = input.next();
        
        System.out.print("Insira a data de início da atividade: ");
        String dt_inicio = input.next();

        System.out.print("Insira a data de termino da atividade: ");
        String dt_final = input.next();

        System.out.print("Insira o cpf do responsavel pela atividade: ");
        String resp_cpf = input.next();
        Usuario resp= buscaPorCpf(resp_cpf, Usuarios);

        ArrayList<Usuario> profs = addUsuario(Usuarios);

        ArrayList<Tarefas> tarefas = addTarefas(Usuarios);

        Atividade ativ = new Atividade(atividades.size(), desc, dt_inicio, dt_final, resp, tarefas, profs);

        return ativ;
    }

    
    public static ArrayList<Usuario> addUsuario(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> part_proj = new ArrayList<Usuario>();
        System.out.print("Digite o quantos Usuarios seram inseridos: ");
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario part = buscaPorCpf(part_cpf, Usuarios);
            part_proj.add(part);
        }
        return part_proj;
    }

    public static ArrayList<Atividade> addAtividades(ArrayList<Usuario> Usuarios){
        ArrayList<Atividade> ativ_proj = new ArrayList<Atividade>();
        System.out.print("Digite o quantas atividades seram inseridas: ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            Atividade ativ = criarAtividades(ativ_proj, Usuarios);
            ativ_proj.add(ativ);
        }
        return ativ_proj;
    }
    
    public static ArrayList<Tarefas> addTarefas(ArrayList<Usuario> Usuarios){
        ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
        System.out.print("Digite o quantas tarefas seram inseridas: ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            System.out.print("Digite o descrição: ");
            String desc = input.next();

            System.out.print("Digite o cpf da pessoa que realizará a tarefa: ");
            String cpf = input.next();

            Tarefas tf = new Tarefas(desc, cpf); 
            tarefas.add(tf);
        }
        return tarefas;
    }

    public static Usuario buscaPorCpf(String cpf, ArrayList<Usuario> Usuarios){
        for (Usuario i : Usuarios){
            if (i.getCpf().equals(cpf)){
                return i;
            }
        }
        return null;
    }

    public static void exibirProjetos(ArrayList<Projeto> projetos){
        System.out.println("Projetos cadastrados:\n");
        for (Projeto p : projetos){
            System.out.printf("Descrição : %s\n", p.descricao);
            System.out.printf("Data de Inicio : %s\n", p.data_inicio);
            System.out.printf("Data de termino : %s\n", p.data_final);
            System.out.printf("Status : %s\n", p.status);
        }
    }

    public static Usuario login(ArrayList<Usuario> Usuarios){
        System.out.print("Digite o cpf: ");
        String loginCpf = input.next();
        
        Usuario user = buscaPorCpf(loginCpf, Usuarios);
        
        if(user == null){
            System.out.println("Usuário não encontrado, tente novamente");
            login(Usuarios);
        }
        else{
            System.out.print("Digite o senha: ");
            String loginSenha = input.next();
            //String senha = new String(user.senha);
            if(loginSenha.equals(user.senha)){
                return user;
            }
            else{
                System.out.println("Senha errada, tente de novo!");
                login(Usuarios);
            }
        }
        return null;
    }
}