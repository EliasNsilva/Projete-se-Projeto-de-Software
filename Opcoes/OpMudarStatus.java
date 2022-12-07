package Opcoes;

import Classes.Projeto;
import Classes.Usuario;
import Main.Sistema;

public class OpMudarStatus implements OpInterface{
    @Override
    public void executar(Usuario user){
        if(user == null){
            System.out.println("Por favor, faça login para continuar");
            return;
        }

        System.out.println("\n#########################\n");
        System.out.println("De qual projeto deseja alterar o status?");
        for(Projeto k: Sistema.projetos){
            System.out.printf("%d- %s\n", k.id, k.getDescricao());
        }
        
        try {
            int p = input.nextInt();            
            Projeto proj = Sistema.projetos.get(p);

            if(proj.getCoordenador().getCpf() != user.getCpf() && proj.getCoordenador().getCargo() != "Professor"){
                System.out.println("Sem permissão!");
                return;
            }

            proj.setStatus(proj, user);
        } catch (Exception e){
            System.out.println("Digite somente o número referente a opção\n");
        }
        
        System.out.println("\n#########################\n");
    }
}
