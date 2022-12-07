package Opcoes;

import Classes.Usuario;
import Funcionalidades.Utilidades;
import Main.Sistema;

public class OpRelatorio implements OpInterface{
    @Override
    public void executar(Usuario user){
        System.out.println("\n#########################\n");
        Utilidades.relatorio(Sistema.projetos);
        System.out.println("\n#########################\n");
    }
}
