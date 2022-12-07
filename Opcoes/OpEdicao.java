package Opcoes;

import Classes.Usuario;
import Funcionalidades.Editar;
import Main.Sistema;

public class OpEdicao implements OpInterface{
    @Override
    public void executar(Usuario user){
        System.out.println("\n#########################\n");

        if(user == null){
            System.out.println("Por favor, faça login para continuar");
            return;
        }

        System.out.println("O que você deseja editar?\n");
        System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
        String i = input.next();

        switch (i){
            case "1":
                if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                    System.out.println("Sem permissão!");
                    break;
                }
                Editar.editarProjeto(Sistema.projetos);
                break;
            case "2":
                if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                    System.out.println("Sem permissão!");
                    break;
                }
                Editar.editarAtividade(Sistema.projetos);
                break;
            case "3":
                Editar.editarUsuario(Sistema.Usuarios);
                break;
            default:
                break;
        }
        System.out.println("\n#########################\n");
    }
}
