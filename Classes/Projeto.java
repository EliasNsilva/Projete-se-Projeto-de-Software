package Classes;

import java.util.ArrayList;
import java.util.Scanner;

import Funcionalidades.GeradorID;
import Funcionalidades.Utilidades;

public class Projeto implements GeradorID<Projeto>{
    public int id;
    private String status;
    public String descricao;
    public String data_inicio;
    public String data_final;
    private Usuario coordenador;
    private ArrayList<Usuario> Usuarios;
    public ArrayList<Atividade> ativs;
    public int[] bolsas;
    public String vigencia_bolsa;
    
    public Projeto(String status, String descricao, String data_inicio, String data_final) {
        this.status = status;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
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
    public void setDataFinal(String data_final){
        this.data_final = data_final;
    }
    public void setDataInicio(String data_inicio){
        this.data_inicio = data_inicio;
    }

    public Usuario setCoordenador(ArrayList<Usuario> Usuarios){
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Insira o cpf do coordenador do projeto: ");
        String coordenador_cpf = input.next();

        Usuario user = Utilidades.buscaPorCpf(coordenador_cpf, Usuarios);

        if(user == null){
            System.out.println("Usuário não existente, tente novamente!");
            setCoordenador(Usuarios);
        }
        else{
            this.coordenador = user;
            return user;
        }
        return null;
    }

    // OVERLOAD
    public ArrayList<Usuario> setUsuarios(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> part_proj = new ArrayList<Usuario>();
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Digite quantos Usuarios seram inseridos: ");

        int n = input.nextInt();
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
            int res = input.nextInt();
            if(res == 1){
                if(proj.descricao != null && proj.data_inicio != null && proj.coordenador != null){
                    proj.status = "Iniciado";
                }
            }
        }
        else if(proj.status.equals("Iniciado")){
            System.out.println("Deseja dar andamento ao projeto?\n\n1- Sim\n2- Não");
            int res = input.nextInt();
            if(res == 1){
                if(proj.Usuarios != null ){
                    proj.status = "Em andamento";
                }
            }
        }
        else if(proj.status.equals("Em andamento")){
            System.out.println("Deseja concluir o projeto?\n\n1- Sim\n2- Não");
            int res = input.nextInt();
            if(res == 1){
                if(proj.ativs != null && proj.data_final != null){
                    proj.status = "Concluído";
                }
            }
        }
    }

    public void setBolsa(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int[] bolsas= new int[9];

        System.out.println("Defina o valor das bolsas de cada profissional");
        
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

        this.bolsas = bolsas;
    }
}