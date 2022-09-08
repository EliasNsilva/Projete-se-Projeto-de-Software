public class Usuario {
    public String cpf;
    public String senha;
    public String nome;
    public String cargo;
    
    public Usuario(String cpf, String nome, String cargo, String senha) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.cargo = cargo;

    }

    public String getCpf(){
        return cpf;
    }
}