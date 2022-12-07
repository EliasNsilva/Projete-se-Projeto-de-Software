package Opcoes;

import Classes.Usuario;
import Funcionalidades.Consultas;
import Main.Sistema;

public class OpConsultar implements OpInterface{
    @Override
    public void executar(Usuario user){
        System.out.println("\n#########################\n");
        System.out.println("O que deseja consultar?");
        System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
        String i = input.next();
        switch (i) {
            case "1":
                Consultas.consultaProj(Sistema.projetos, Sistema.Usuarios); 
                break;
            case "2":
                Consultas.consultaAtiv(Sistema.projetos);
                break;
            case "3":
                Consultas.consultaUsu(Sistema.Usuarios);
                break;
            default:
                break;
        }
        System.out.println("\n#########################\n");
    }
}
