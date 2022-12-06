package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Usuario;

public class Associar {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void associarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um projeto a um usuário\n2- Associar Usuários a um projeto");
        String escolha = input.nextLine();
        Projeto proj = null;

        switch (escolha) {
            case "1":
                System.out.print("Digite o cpf do Usuario: ");
                String part_cpf = input.next();
                Usuario user = Utilidades.buscaPorCpf(part_cpf, usuarios);

                if(user == null){
                    System.out.println("Usuário não encontrado");
                }
                System.out.println("Qual projeto deseja associar a esse usuario?\n");

                for(Projeto i: projetos){
                    System.out.printf("%d- %s\n", i.id, i.getDescricao());
                }
            
                proj = null;

                try {
                    int p = input.nextInt();
                    proj = projetos.get(p);
                } catch (Exception e) {
                    System.out.println("Digite somente o número referente a opção\n");
                }

                proj.setUsuarios(user);
                break;
            case "2":
                System.out.println("Qual projeto deseja associar?\n");

                for(Projeto i: projetos){
                    System.out.printf("%d- %s\n", i.id, i.getDescricao());
                }

                proj = null;

                try {
                    int p = input.nextInt();
                    proj = projetos.get(p);
                } catch (Exception e) {
                    System.out.println("Digite somente o número referente a opção\n");
                }

                System.out.print("Digite o cpf do Usuario: ");
                String user_cpf = input.next();
                Usuario user2 = Utilidades.buscaPorCpf(user_cpf, usuarios);

                if(user2 == null){
                    System.out.println("Usuário não encontrado");
                }

                proj.setUsuarios(user2);
                break;
        
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public static void associarAtividade(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um atividade a um usuário\n2- Associar Usuários a uma atividade");
        String escolha = input.next();

        if (escolha == "1") {       
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.getDescricao());
            }

            Projeto proj = null;

            try {
                int p = input.nextInt();
                proj = projetos.get(p);
                if (proj.ativs == null){
                    System.out.println("Projeto sem atividades\n");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = Utilidades.buscaPorCpf(part_cpf, proj.getUsuarios());

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
        
            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
        
            Atividade ativ = null;

            try {
                int at = input.nextInt();
                ativ = proj.ativs.get(at);
                
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }

            ativ.getProfissionais().add(user);

        }else if(escolha == "2"){
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.getDescricao());
            }

            Projeto proj = null;

            try {
                int p = input.nextInt();
                proj = projetos.get(p);
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }


            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }

            Atividade ativ = null;

            try {
                int at = input.nextInt();
                ativ = proj.ativs.get(at);
                
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = Utilidades.buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
            else{
                ativ.getProfissionais().add(user);
            }
        }
        else {
            System.out.println("Opção inválida");
        }
    }
}
