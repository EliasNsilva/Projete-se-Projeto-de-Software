package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Funcionalidades.GeradorID;
import Funcionalidades.Utilidades;

public class Projeto implements GeradorID<Projeto>{
    public int id;
    private String status;
    private String descricao;
    private LocalDate data_inicio;
    private LocalDate data_final;
    private Usuario coordenador;
    private ArrayList<Usuario> Usuarios;
    public ArrayList<Atividade> ativs;
    public int[] bolsas;
    public String vigencia_bolsa;
    
    public Projeto(String status, String descricao) {
        this.status = status;
        this.descricao = descricao;
    }

    public String getStatus(){
        return status;
    }

    public Usuario getCoordenador(){
        return coordenador;
    }

    public ArrayList<Usuario> getUsuarios(){
        return Usuarios;
    }

    public String getDescricao(){
        return descricao;
    }
    public LocalDate getDataFinal(){
        return data_final;
    }
    public LocalDate getDataInicio(){
        return data_inicio;
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public void setID(ArrayList<Projeto> projetos){
        int count = 0;
        for(Projeto i: projetos){
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

    public void setCoordenador(ArrayList<Usuario> Usuarios){
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while(true){
            System.out.print("Insira o cpf do coordenador do projeto: ");
            String coordenador_cpf = input.next();
            Usuario user = Utilidades.buscaPorCpf(coordenador_cpf, Usuarios);
            
            if (user != null){
                this.coordenador = user;
                break;
            } 
            else{
                System.out.println("Usuário não existente, tente novamente!");
            }  
        }
    }

    // OVERLOAD
    public ArrayList<Usuario> setUsuarios(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> part_proj = new ArrayList<Usuario>();
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.print("\nDigite o número de Usuarios que seram inseridos: ");

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
                part_proj.add(part);
            }

        }
        this.Usuarios = part_proj;

        return part_proj;
    }

    // OVERLOAD
    public void setUsuarios(Usuario user){
        this.Usuarios.add(user);
    }

    public void setStatus(Projeto proj, Usuario user){
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        if(proj.status.equals("Em processo de criação")){
            System.out.println("Deseja inicar o projeto?\n\n1- Sim\n2- Não");
            String res = input.next();
            switch (res) {
                case "1":
                    if(proj.descricao != null && proj.data_inicio != null && proj.coordenador != null){
                        this.status = "Iniciado";
                    }
                    else{
                        System.out.println("O projeto não possuí informações suficientes.");
                    }
                    break;
            
                default:
                    break;
            }
        }
        else if(proj.status.equals("Iniciado")){
            System.out.println("Deseja dar andamento ao projeto?\n\n1- Sim\n2- Não");
            String res = input.next();
            switch (res) {
                case "1":
                    if(proj.Usuarios != null ){
                        this.status = "Em andamento";
                    }
                    else{
                        System.out.println("O projeto não possuí informações suficientes.");
                    }
                    break;
            
                default:
                    break;
            }
        }
        else if(proj.status.equals("Em andamento")){
            System.out.println("Deseja concluir o projeto?\n\n1- Sim\n2- Não");
            String res = input.next();
            switch (res) {
                case "1":
                    if(proj.ativs != null && proj.data_final != null){
                        this.status = "Concluído";
                    }
                    else{
                        System.out.println("O projeto não possuí informações suficientes.");
                    }
                    break;
            
                default:
                    break;
            }
        }
    }

    public void setBolsa(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int[] bolsas= new int[9];

        System.out.println("\nDefina o valor das bolsas de cada profissional");

        try {
            System.out.print("Aluno de Graduação: ");
            int valor = input.nextInt();
            bolsas[0] = valor;

            System.out.print("Aluno de mestrado: ");
            valor = input.nextInt();
            bolsas[1] = valor;

            System.out.print("Aluno de doutorado: ");
            valor = input.nextInt();
            bolsas[2] = valor;

            System.out.print("Professor: ");
            valor = input.nextInt();
            bolsas[3] = valor;

            System.out.print("Pesquisador: ");
            valor = input.nextInt();
            bolsas[4] = valor;

            System.out.print("Desenvolvedor: ");
            valor = input.nextInt();
            bolsas[5] = valor;

            System.out.print("Testador: ");
            valor = input.nextInt();
            bolsas[6] = valor;

            System.out.print("Analista: ");
            valor = input.nextInt();
            bolsas[7] = valor;

            System.out.print("Técnico: ");
            valor = input.nextInt();
            bolsas[8] = valor;

        } catch (Exception e) {
            System.out.println("Certifique-se de inserir somente valores númericos");
            setBolsa();
        }
        
        this.bolsas = bolsas;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Descrição: " + this.descricao + "\nData de Inicio: " + this.data_inicio +
        "\nData Final: " + this.data_final + "\nStatus: " + this.status + 
        "\nCoordenador do projeto: " + this.coordenador.getNome() + "\n";
    }
}