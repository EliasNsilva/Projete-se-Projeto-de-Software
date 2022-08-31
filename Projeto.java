import java.util.ArrayList;

public class Projeto {
    public int id;
    public String status;
    public String descricao;
    public String data_inicio;
    public String data_final;
    public Participante coordenador;
    public ArrayList<Participante> participantes;
    public ArrayList<Atividade> ativs;
    //public ArrayList<String> bolsas;
    public String vigencia_bolsa;
    
    public Projeto(int id, String status, String descricao, String data_inicio, String data_final, Participante coordenador,ArrayList<Participante> participantes, String vigencia_bolsa) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.coordenador = coordenador;
        //this.bolsas = bolsas;
        this.participantes = participantes;
        this.vigencia_bolsa = vigencia_bolsa;
    }

}