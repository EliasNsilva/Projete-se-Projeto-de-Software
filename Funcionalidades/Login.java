package Funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Usuario;

public class Login {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void recuperarSenha(ArrayList<Usuario> Usuarios){
        System.out.println("Recuperação de senha");
        System.out.print("Digite o cpf: ");
        String loginCpf = input.next();

        Usuario user = Utilidades.buscaPorCpf(loginCpf, Usuarios);
        
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
        System.out.println("1- Login\n2- Logout");
        String res = input.next();
        switch (res) {
            case "1":
            System.out.print("Digite o cpf ou ''eita'' Caso tenha esquecido a senha:\n");
            String loginCpf = input.next();
    
            if(loginCpf.equals("eita")){
                recuperarSenha(Usuarios);
                login(Usuarios);
            }
            else{
                Usuario user = Utilidades.buscaPorCpf(loginCpf, Usuarios);
                
                if(user == null){
                    System.out.println("Usuário não encontrado, tente novamente");

                }
                else{
                    System.out.print("Digite o senha: ");
                    String loginSenha = input.next();
        
                    if(loginSenha.equals(user.getSenha())){
                        System.out.println("\nLogado!\n");
                        return user;
                    }
                    else{
                        System.out.println("Senha errada, tente de novo!");
                    }
                }
            }
                break;
            case "2":
                return null;
        
            default:
                break;
        }
        return null;
    }
}
