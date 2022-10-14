package Classes;

public class Usuario {
    private String cpf;
    private String senha;
    private String nome;
    private String cargo;
    public int recebido;
    
    public Usuario(String cpf, String senha, String nome, String cargo) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getCargo(){
        return cargo;
    }
    public String getSenha(){
        return senha;
    }

    public void atualizarSenha(String senha){
        this.senha = senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "    Nome: "+ this.nome + "\n    CPF: " + this.cpf + "\n    Cargo: " + 
        this.cargo + "\n    Recebidos: " + this.recebido + "\n";
    }
}