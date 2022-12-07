package Opcoes;

import Classes.Usuario;
import Funcionalidades.Criar;
import Funcionalidades.Remover;
import Main.Sistema;

public class OpCriarRemover implements OpInterface{
    @Override
    public void executar(Usuario user){
        System.out.println("\n#########################\n");
        System.out.println("1- Criar Usuário\n2- Criar projeto\n3- Remover");

        
        String i = input.next();
        switch (i) {
            case "1":
                System.out.println("Insira as informação para criar um usuário");
                Criar.criarUsuario(Sistema.Usuarios);
                break;
            case "2":
                if(user == null){
                    System.out.println("Por favor, faça login para continuar");
                    return;
                }
                if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                    System.out.println("Sem permissão!");
                    break;
                }
                Criar.criarProjeto(Sistema.projetos, Sistema.Usuarios);
                break;
            case "3":
                if(user == null){
                    System.out.println("Por favor, faça login para continuar");
                    return;
                }
                if(user.getCargo() != "Pesquisador" && user.getCargo() != "Professor"){
                    System.out.println("Sem permissão!");
                    break;
                }
                System.out.println("O que você deseja remover?\n");
                System.out.println("1- Projeto\n2- Atividade\n3- Tarefa");
                String j = input.next();

                switch (j){
                    case "1":
                        Remover.removerProjeto(Sistema.projetos);
                        break;
                    case "2":
                        Remover.removerAtividade(Sistema.projetos);
                        break;
                    case "3":
                        Remover.removerTarefa(Sistema.projetos);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        System.out.println("\n#########################\n");
    }
}
