package Opcoes;

import Classes.Usuario;
import Funcionalidades.Associar;
import Main.Sistema;

public class OpAssociacao implements OpInterface{
    @Override
    public void executar(Usuario user){
        if(user == null){
            System.out.println("Por favor, faça login para continuar");
            return;
        }
        if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
            System.out.println("Sem permissão!");
            return;
        }
        System.out.println("\n#########################\n");
        System.out.println("1- Associar projeto\n2- Associar atividade");
        String i = input.next();
        switch (i) {
            case "1":
                Associar.associarProjeto(Sistema.projetos, Sistema.Usuarios);
                break;
            case "2":
                Associar.associarAtividade(Sistema.projetos, Sistema.Usuarios); 
            default:
                break;
        }
        System.out.println("\n#########################\n");
    }
}
