package Classes;
import java.util.ArrayList;

import Funcionalidades.GeradorID;

public class Tarefas implements GeradorID <Tarefas>{
    public int id;
    public String descricao;
    public String profissonal;

    public Tarefas(int id, String descricao, String profissional){
        this.id = id;
        this.descricao = descricao;
        this.profissonal = profissional;
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public void setID(ArrayList<Tarefas> tarefas){
        int count = 0;
        for(Tarefas i: tarefas){
            i.id = count;
            count++;
        }
        this.id = count;
    }
}
