public class Participante {
    public String cpf;
    // public String login;
    // public String senha;
    public String nome;
    public String cargo;
    
    public Participante(String cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getCpf(){
        return cpf;
    }
}