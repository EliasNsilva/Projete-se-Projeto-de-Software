public class Usuario {
    public String cpf;
    public String senha;
    public String nome;
    public String cargo;
    public String bolsa;
    
    public Usuario(String cpf, String nome, String cargo, String senha, String bolsa) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.cargo = cargo;
        this.bolsa = bolsa;
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
}