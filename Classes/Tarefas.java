package Classes;
import java.util.ArrayList;

import Funcionalidades.GeradorID;

public class Tarefas implements GeradorID <Tarefas>{
    public int id;
    public String descricao;
    public Usuario profissonal;

    public Tarefas(String descricao, Usuario profissional){
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
