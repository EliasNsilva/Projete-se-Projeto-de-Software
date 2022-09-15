import java.util.ArrayList;

public class Projeto {
    public int id;
    public String status;
    public String descricao;
    public String data_inicio;
    public String data_final;
    public Usuario coordenador;
    public ArrayList<Usuario> Usuarios;
    public ArrayList<Atividade> ativs;
    public int[] bolsas;
    public String vigencia_bolsa;
    
    public Projeto(int id, String status, String descricao, String data_inicio, String data_final, Usuario coordenador,ArrayList<Usuario> Usuarios, ArrayList<Atividade> ativs, int[] bolsas,String vigencia_bolsa) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.coordenador = coordenador;
        this.Usuarios = Usuarios;
        this.ativs = ativs;
        this.bolsas = bolsas;
        this.vigencia_bolsa = vigencia_bolsa;
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
}