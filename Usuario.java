public class Usuario {
    public String cpf;
    public String senha;
    public String nome;
    public String cargo;
    public String bolsa;
    
    public Usuario(String cpf, String senha, String nome, String cargo, String bolsa) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.nome = nome;
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

    public void atualizarSenha(String senha){
        this.senha = senha;
    }
}