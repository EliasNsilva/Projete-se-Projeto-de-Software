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

    public static void intercambio(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto o usuário pertence?\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.getDescricao());
        }
        Projeto proj = null;

        try {
            int p = input.nextInt();
            proj = projetos.get(p);
        } catch (Exception e) {
            System.out.println("Digite somente o número referente a opção\n");
        }

        System.out.print("Digite o cpf do Usuario que seja adicionar: ");
        String cpf = input.next();
        Usuario user = buscaPorCpf(cpf, proj.getUsuarios());

        if(user == null){
            System.out.println("Usuário não encontrado");
        }
        else{
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto p2: projetos){
                System.out.printf("%d- %s\n", p2.id, p2.getDescricao());
            }
            Projeto proj2 = null;

            try {
                int p = input.nextInt();
                proj2 = projetos.get(p);
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }

            System.out.println("Qual atividade deseja adicionar o usuário?\n");

            for(Atividade i: proj2.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
            Atividade ativ = null;
            
            try {
                int ativ_res = input.nextInt();
                ativ = proj2.ativs.get(ativ_res);
            } catch (Exception e) {
                System.out.println("Digite somente o número referente a opção\n");
            }

            ativ.getProfissionais().add(user);

            System.out.println("Adicione as tarefas do usuário");

            Criar.addTarefas(ativ.getProfissionais());
        }
    }

    public static void bolsas(ArrayList<Projeto> projetos){
        System.out.println("Selecione um projeto\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.getDescricao());
        }
        Projeto proj = null;

        try {
            int p = input.nextInt();
            proj = projetos.get(p);
        } catch (Exception e) {
            System.out.println("Digite somente o número referente a opção\n");
            return;
        }

        System.out.printf("Qual tipo de usuário deseja pagar?:\n");
        System.out.println("1- Alunos de Graduação\n2- Alunos de mestrado\n3- Alunos de doutorado");
        System.out.println("4- Professores\n5- Pesquisadores\n6- Desenvolvedores\n7- Testadores\n8- Analistas\n9- Técnicos");
        String cargo = "";
        int res = 0;

        try {
            res = input.nextInt();
        } catch (Exception e) {
            System.out.println("Digite somente o número referente a opção\n");
        }

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
                System.out.println("Opção inválida");
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
            System.out.println(proj);

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
                    System.out.printf("\n");
                    System.out.printf("    Tarefa %d\n", tf.id);
                    System.out.printf("    Descrição: %s\n", tf.descricao);
                    System.out.printf("    Responsável %s\n", tf.profissonal.getNome());
                }
                System.out.println("___________________________");
            }
            System.out.println("###########################################");
        }
    }

    
}
