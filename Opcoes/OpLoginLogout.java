package Opcoes;

import Classes.Usuario;
import Funcionalidades.Login;
import Main.Sistema;

public class OpLoginLogout implements OpInterface{
    @Override
    public void executar(Usuario user){
        System.out.println("\n#########################\n");
        Sistema.user = Login.login(Sistema.Usuarios);
        System.out.println("\n#########################\n");
    }
}
