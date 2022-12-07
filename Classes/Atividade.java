package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Funcionalidades.GeradorID;
import Funcionalidades.Utilidades;

public class Atividade implements GeradorID <Atividade>{
    public int id;
    public String status;
    public String descricao;
    public LocalDate data_inicio;
    public LocalDate data_final;
    public Usuario responsavel; 
    private ArrayList<Usuario> profissionais;
    public ArrayList<Tarefas> tarefas;
    
    public Atividade(String status, String descricao, ArrayList<Tarefas> tarefas) {
        this.status = status;
        this.descricao = descricao;
        this.tarefas = tarefas;
    }

    public String getDescricao(){
        return descricao;
    }
    public LocalDate getDataInicio(){
        return data_inicio;
    }
    public LocalDate getDataFinal(){
        return data_final;
    }
    public ArrayList<Usuario> getProfissionais(){
        return profissionais;
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public void setID(ArrayList<Atividade> ativs){
        int count = 0;
        for(Atividade i: ativs){
            i.id = count;
            count++;
        }
        this.id = count;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setDataInicio(String data_inicio){
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate data = LocalDate.parse(data_inicio, formato); 
            this.data_inicio = data;
        } catch (Exception e) {
            System.out.println("Formato da data errada!");
        }
    }
    public void setDataFinal(String data_final){
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate data = LocalDate.parse(data_final, formato); 
            this.data_final = data;
        } catch (Exception e) {
            System.out.println("Formato da data errada!");
        }
    }
    public void setResponsavel(ArrayList<Usuario> Usuarios) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        while(true){
            System.out.print("Insira o cpf do responsável pela atividades: ");
            String responsavel_cpf = input.next();
            Usuario user = Utilidades.buscaPorCpf(responsavel_cpf, Usuarios);
            
            if (user != null){
                this.responsavel = user;
                break;
            } 
            else{
                System.out.println("Usuário não existente, tente novamente!");
            }  
        }
    }

    public ArrayList<Usuario> setProfissionais(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> profs = new ArrayList<Usuario>();
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Digite quantos Usuarios seram inseridos: ");

        int n = 0;
        try {
            n = input.nextInt();
        } catch (Exception e) {
            System.out.println("Insira somente números");
        }
        
        for(int i = 0; i < n; i++){
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario part = Utilidades.buscaPorCpf(part_cpf, Usuarios);
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

    @Override
    public String toString() {
        return "Descrição: " + this.descricao + "\nData de Inicio: " + this.data_inicio +
        "\nData Final: " + this.data_final + "\nStatus: " + this.status + 
        "\nResponsável pela atividade: " + this.responsavel.getNome() + "\n";
    }
}