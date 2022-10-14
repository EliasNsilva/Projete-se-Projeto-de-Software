package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Tarefas;

public class Remover {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public static void removerProjeto(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto deseja remover?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        projetos.remove(res);

        System.out.println("\nRemovido!\n\n");
    }

    public static void removerAtividade(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a atividade pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        Projeto proj = projetos.get(res);

        System.out.println("Qual ativiade deseja remover?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ = input.nextInt();

        proj.ativs.remove(ativ);

        System.out.println("\nRemovida!\n\n");
    }

    public static void removerTarefa(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a tarefa pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        Projeto proj = projetos.get(res);

        System.out.println("Qual atividade a tarefa pertence?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ = input.nextInt();

        System.out.println("Qual tarefa deseja remover?\n");
        for(Tarefas i: proj.ativs.get(ativ).tarefas){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        proj.ativs.remove(ativ);

        System.out.println("\nRemovida!\n\n");
    }
}
