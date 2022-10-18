package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Usuario;

public class Editar extends Utilidades{
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public static void editarProjeto(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto deseja editar?\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.getDescricao());
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.println("Qual campo deseja editar?\n1- Descrição\n2- Data inicio\n3- Data Final");
        String j = input.next();
        switch (j) {
            case "1":
                System.out.print("Mudar descrição: ");
                String res1 = input.next();
                proj.setDescricao(res1);
                break;
            case "2":
                System.out.print("Mudar Data inicio: ");
                String res2 = input.next();
                proj.setDataInicio(res2);
                break;
            case "3":
                System.out.print("Mudar Data final: ");
                String res3 = input.next();
                proj.setDataFinal(res3);
                break;
            default:
                break;
        }
    }

    public static void editarAtividade(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a atividade pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.getDescricao());
        }

        int res = input.nextInt();
        Projeto proj = projetos.get(res);

        System.out.println("Qual atividade deseja editar?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ_res = input.nextInt();
        Atividade ativ = proj.ativs.get(ativ_res);

        System.out.println("Qual campo deseja editar?\n1- Descrição\n2- Data inicio\n3- Data Final");
        String j = input.next();
        switch (j) {
            case "1":
                System.out.print("Mudar descrição: ");
                String res1 = input.next();
                ativ.setDescricao(res1);
                break;
            case "2":
                System.out.print("Mudar Data inicio: ");
                String res2 = input.next();
                ativ.setDataInicio(res2);
                break;
            case "3":
                System.out.print("Mudar Data final: ");
                String res3 = input.next();
                ativ.setDataFinal(res3);
                break;
            default:
                break;
        }
    }

    public static void editarUsuario(ArrayList<Usuario> Usuarios){
        System.out.print("Digite o cpf do usuário: ");
        String loginCpf = input.next();

        Usuario user = buscaPorCpf(loginCpf, Usuarios);
        
        if(user == null){
            System.out.println("Usuário não encontrado, tente novamente");
        }else{
            System.out.println("Qual campo deseja editar?\n1- Nome\n2- Cargo\n3- CPF");
        
            String i = input.next();

            switch (i) {
                case "1":
                    System.out.print("Mudar Nome para: ");
                    String res1 = input.next();
                    user.setNome(res1);
                    break;
                case "2":
                    System.out.print("Mudar cargo para: ");
                    String res2 = input.next();
                    user.setCargo(res2);
                    break;
                case "3":
                    System.out.print("Mudar CPF para: ");
                    String res3 = input.next();
                    user.setCpf(res3);
                    break;
                default:
                    break;
            }
        }
    }

}
