import java.util.ArrayList;
import java.util.Scanner;

public class Atividade {
    public int id;
    public String status;
    public String descricao;
    public String data_inicio;
    public String data_final;
    public Usuario responsavel; 
    private ArrayList<Usuario> profissionais;
    public ArrayList<Tarefas> tarefas;
    
    public Atividade(int id, String status, String descricao, String data_inicio, String data_final, Usuario responsavel, ArrayList<Tarefas> tarefas) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.responsavel = responsavel;
        this.tarefas = tarefas;
    }

    public String getDescricao(){
        return descricao;
    }
    public String getDataInicio(){
        return data_inicio;
    }
    public String getDataFinal(){
        return data_final;
    }
    public ArrayList<Usuario> getProfissionais(){
        return profissionais;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setDataFinal(String data_final){
        this.data_final = data_final;
    }
    public void setDataInicio(String data_inicio){
        this.data_inicio = data_inicio;
    }
    public ArrayList<Usuario> setProfissionais(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> profs = new ArrayList<Usuario>();
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Digite quantos Usuarios seram inseridos: ");

        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario part = Sistema.buscaPorCpf(part_cpf, Usuarios);
            if (part == null){
                System.out.println("Usuário não existente, tente novamente!");
                i -= 1;
            }
            else{
                profs.add(part);
            }
        }
        this.profissionais = profs;

        return profs;
    } 
}