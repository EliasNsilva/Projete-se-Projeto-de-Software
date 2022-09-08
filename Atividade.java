import java.util.ArrayList;

public class Atividade {
    public int id;
    public int status;
    public String descricao;
    public String data_inicio;
    public String data_final;
    public Usuario responsavel;
    public ArrayList<Usuario> profissionais;
    public String tarefas[];
    
    public Atividade(int id, String descricao, String data_inicio, String data_final, String tarefas[]) {
        this.id = id;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.tarefas = tarefas;
    }
}