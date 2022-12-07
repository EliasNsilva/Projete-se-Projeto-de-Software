package Opcoes;

import Classes.Usuario;
import Funcionalidades.Utilidades;
import Main.Sistema;

public class OpPagamento implements OpInterface{
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
        Utilidades.bolsas(Sistema.projetos);
        System.out.println("\n#########################\n");
    }
}
