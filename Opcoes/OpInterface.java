package Opcoes;

import java.util.Scanner;

import Classes.Usuario;

public interface OpInterface {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    public void executar(Usuario user);
}
