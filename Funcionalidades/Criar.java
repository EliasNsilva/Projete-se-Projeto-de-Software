package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Atividade;
import Classes.Projeto;
import Classes.Tarefas;
import Classes.Usuario;

public class Criar extends Utilidades{
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public static void criarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> Usuarios) {
        System.out.print("Insira a descrição do projeto: ");
        String descricao = input.next( );
        
        Projeto pj = new Projeto("Em processo de criação", descricao);

        System.out.print("Insira a data de início do projeto (dd/MM/yyyy): ");
        String data_inicio = input.next();
        pj.setDataInicio(data_inicio);
        
        System.out.print("Insira a data de termino do projeto (dd/MM/yyyy): ");
        String data_final = input.next();
        pj.setDataFinal(data_final);
        
        pj.setID(projetos);
        
        pj.setCoordenador(Usuarios);
        
        ArrayList<Usuario> part_proj = pj.setUsuarios(Usuarios);
        part_proj.add(pj.getCoordenador());
        
        ArrayList<Atividade> ativ_proj = addAtividades(part_proj);
        pj.ativs = ativ_proj;
        
        System.out.print("Qual a vigencia das bolsas? ");
        pj.vigencia_bolsa = input.next(); 

        pj.setBolsa();
        
        projetos.add(pj);
    }

    public static Usuario criarUsuario(ArrayList<Usuario> Usuarios) {
        System.out.print("Digite o cpf: ");
        String cpf = input.next();
        
        System.out.print("Digite o senha: ");
        String senha = input.next();
        
        System.out.print("Digite o nome: ");
        String nome = input.next( );
        
        System.out.printf("Qual seu cargo?:\n");
        System.out.println("1- Aluno de Graduação\n2- Aluno de mestrado\n3- Aluno de doutorado");
        System.out.println("4- Professor\n5- Pesquisador\n6- Desenvolvedor\n7- Testador\n8- Analista\n9- Técnico");
        String cargo = input.next();
        
        switch (cargo) {
            case "1":
            cargo = "Aluno de Graduação";
                break;
            case "2":
                cargo = "Aluno de mestrado";
                break;
            case "3":
                cargo = "Aluno de doutorado";
                break;
            case "4":
                cargo = "Professor";
                break;
            case "5":
                cargo = "Pesquisador";
                break;
            case "6":
                cargo = "Desenvolvedor";
                break;
            case "7":
                cargo = "Testador";
                break;
            case "8":
                cargo = "Analista";
                break;
            case "9":
                cargo = "Técnico";
                break;
            default:
                break;
        }

        if (cargo.equals("Aluno de Graduação") || cargo.equals("Aluno de mestrado") || cargo.equals("Aluno de doutorado")){            
            Usuario part = new Usuario(cpf, senha, nome, cargo);
            
            System.out.print("Digite a matricula: ");
            String matricula = input.next( );
            part.setMatricula(matricula);
            
            Usuarios.add(part);

            return part;
        }
        else{
            Usuario part = new Usuario(cpf, senha, nome, cargo);           
            Usuarios.add(part);
            return part;
        }
    }

    public static Atividade criarAtividades(ArrayList<Atividade> atividades, ArrayList<Usuario> Usuarios) {
        System.out.print("\nDigite o descrição da atividade: ");
        String desc = input.next();
        
        ArrayList<Tarefas> tarefas = addTarefas(Usuarios);
        Atividade ativ = new Atividade("Em andamento", desc, tarefas);

        ativ.setResponsavel(Usuarios);
        
        System.out.print("Insira a data de início da atividade (dd/MM/yyyy): ");
        String dt_inicio = input.next();
        ativ.setDataInicio(dt_inicio);

        System.out.print("Insira a data de termino da atividade (dd/MM/yyyy): ");
        String dt_final = input.next();
        ativ.setDataFinal(dt_final);

        ativ.setID(atividades);

        ArrayList<Usuario> profs = ativ.setProfissionais(Usuarios);
        profs.add(ativ.responsavel);

        return ativ;
    }

    public static ArrayList<Atividade> addAtividades(ArrayList<Usuario> Usuarios){
        ArrayList<Atividade> ativ_proj = new ArrayList<Atividade>();
        System.out.print("\nDigite quantas atividades seram inseridas: ");
        int n = 0;
        try {
            n = input.nextInt();
        } catch (Exception e) {
            System.out.println("Certifique-se de digitar somente números");
        }

        for(int i = 0; i < n; i++){
            Atividade ativ = criarAtividades(ativ_proj, Usuarios);
            ativ_proj.add(ativ);
        }
        return ativ_proj;
    }
    
    public static ArrayList<Tarefas> addTarefas(ArrayList<Usuario> Usuarios){
        ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
        System.out.print("\nDigite quantas tarefas seram inseridas: ");

        int n = 0;
        try {
            n = input.nextInt();
        } catch (Exception e) {
            System.out.println("Insira somente números");
        }

        for(int i = 0; i < n; i++){
            System.out.print("Digite o descrição da tarefa: ");
            String desc = input.next();

            System.out.print("Digite o cpf da pessoa que realizará a tarefa: ");
            String cpf = input.next();
            Usuario resp = buscaPorCpf(cpf, Usuarios);

            Tarefas tf = new Tarefas(desc, resp); 
            tf.setID(tarefas);
            tarefas.add(tf);
        }
        return tarefas;
    }
}
