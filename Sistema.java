import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        ArrayList<Participante> participantes = new ArrayList<Participante>();
        
        while(true){
            System.out.println("Bem vindo ao Projete-se!\n Escolha uma opção\n1 - Criar usuario\n2- logar\n3-sair");
            String i = input.next();
            switch (i) {
                case "1":
                    System.out.println("Insira as informação para criar um usuário");
                    criarUsuario();
                case "2":
                    criarProjeto(projetos, participantes);
                
                default:
                    break;
            }
            // if (i == "1"){
            //     System.out.println("Insira as informação para criar um usuário");
            //     criarUsuario();
            // }
            // if (i == "2"){
            //     criarProjeto(projetos, participantes);
            // }
            // else{
            //     break;
            // }
        }

    }

    public static void criarProjeto(ArrayList<Projeto> projetos, ArrayList<Participante> participantes) {
        System.out.print("Insira a descrição do projeto: ");
        String descricao = input.nextLine();

        System.out.print("Insira a data de início do projeto: ");
        String data_inicio = input.nextLine();

        System.out.print("Insira a data de termino do projeto: ");
        String data_final = input.nextLine();

        System.out.print("Insira o cpf do coordenador do projeto: ");
        String coordenador_cpf = input.nextLine();
        Participante coordenador= buscaPorCpf(coordenador_cpf, participantes);

        ArrayList<Participante> part_proj = addParticipante(participantes);
        
        Projeto pj = new Projeto(1, "Em processo de criação", descricao, data_inicio, data_final, coordenador, part_proj, "1 ano");

        projetos.add(pj);

        exibirProjetos(projetos);
    }

    public static Participante criarUsuario() {
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();

        System.out.print("Digite o cpf: ");
        String cpf = input.nextLine();

        System.out.printf("Digite o cargo: ");
        String cargo = input.nextLine();

        Participante part = new Participante(cpf, nome, cargo);

        return part;
    }

    public static Participante buscaPorCpf(String cpf, ArrayList<Participante> participantes){
        for (Participante i : participantes){
            if (i.getCpf().equals(cpf)){
                return i;
            }
        }
        //return participantes.indexOf(cpf);
        return null;
    }

    public static ArrayList<Participante> addParticipante(ArrayList<Participante> participantes){
        ArrayList<Participante> part_proj = new ArrayList<Participante>();
        System.out.print("Digite o quantos participantes seram inseridos: ");
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Digite o cpf do participante: ");
            String part_cpf = input.nextLine();
            Participante part = buscaPorCpf(part_cpf, participantes);
            part_proj.add(part);
        }
        return part_proj;


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
}