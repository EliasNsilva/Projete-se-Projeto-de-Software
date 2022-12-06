package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Usuario;

public class Consultas {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void consultaProj(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        String campo;
        
        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Status\n2- Coordenador");
        String i = input.next();
        
        switch (i) {
            case "1":
                try {   
                    System.out.println("Opções:\n1- Em processo de criação\n2- Iniciado\n3- Em andamento\n4- Concluído\n");
                    int res1 = input.nextInt();
                    String opcoes[] = {"Em processo de criação", "Iniciado", "Em andamento", "Concluído"};
                    campo = opcoes[res1 -1];

                    for(Projeto proj: projetos){
                        if(proj.getStatus().equals(campo)){
                            System.out.println(proj);
                        }
                    }
                } catch (Exception e){
                    System.out.println("Digite somente o número referente a opção\n");
                }
                break;
            case "2":
                System.out.print("Insira o cpf do coordenador:");
                String res2 = input.next();

                for(Projeto proj: projetos){
                    if(proj.getCoordenador().getCpf().equals(res2)){
                        System.out.println(proj);
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }


    public static void consultaAtiv(ArrayList<Projeto> projetos){
        String campo;
        System.out.println("A qual projeto a atividade pertence?");
        
        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.getDescricao());
        }
        
        try {     
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
                            System.out.println(ativ);
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.print("Insira o cpf do responsável:");
                    String res2 = input.next();
    
                    for(Atividade ativ: proj.ativs){
                        if(ativ.responsavel.getCpf().equals(res2)){
                            System.out.println(ativ);
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            System.out.println("Digite somente o número referente a opção\n");
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
                        user.toString();
                        return;
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
                        user.toString();
                        return;
                    }
                }
                break;
            case "3":
                System.out.print("Insira o CPF:");
                String res3 = input.next();
                campo = res3;

                for(Usuario user: usuarios){
                    if(user.getCpf().equals(campo)){
                        user.toString();
                        return;
                    }
                }
                break;
            default:
                break;
        }
        System.out.println("\nUsuário não encontrado");
    }
}
