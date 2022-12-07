package Main;
import java.util.Scanner;

import Classes.Projeto;
import Classes.Usuario;
import Opcoes.*;

import java.util.ArrayList;

public class Sistema{
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    static public Usuario user;

    static public ArrayList<Projeto> projetos = new ArrayList<Projeto>();
    static public ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
    public static void main(String[] args) {
        
        while(true){
            System.out.println("\n####################################################");
            System.out.println("############# Bem vindo ao Projete-se! #############");
            System.out.println("####################################################\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Criação e remoção de informações\n2- Edição de informações");
            System.out.println("3- Associação de usuários aos projetos e atividades\n4- Alteração de status");
            System.out.println("5- Consultas\n6- Relatório\n7- Intercambio de usuários\n8- Pagamento de bolsas");
            System.out.println("9- Login/Logout\n10- Undo ou redo\n0- Sair\n");
            String i = input.next();
            OpInterface op = null;
            
            switch (i) {
                case "1":
                    op = new OpCriarRemover();
                    op.executar(user);
                    break;
                case "2":
                    op = new OpEdicao();
                    op.executar(user);
                    break;
                case "3":
                    op = new OpAssociacao();
                    op.executar(user);
                    break;
                case "4":
                    op = new OpMudarStatus();
                    op.executar(user);                    
                    break;
                case "5":
                    op = new OpConsultar();
                    op.executar(user);    
                    break;
                case "6":
                    op = new OpRelatorio();
                    op.executar(user);    
                    break;
                case "7":
                    op = new OpIntercambio();
                    op.executar(user);   
                    break;
                case "8":
                    op = new OpPagamento();
                    op.executar(user);   
                    break;
                case "9":
                    op = new OpLoginLogout();
                    op.executar(user); 
                    break;
                case "10":
                    System.out.println("\n#########################\n");
                    System.out.println("\n#########################\n");
                    break;
                case "0":
                    System.out.println("\nAté mais! :)");
                    return;
                default:
                    break;
            }
        }
    }
}