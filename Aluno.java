
public class Aluno extends Usuario{
    private String matricula;

    public Aluno(String cpf, String senha, String nome, String cargo, String matricula) {
        super(cpf, senha, nome, cargo);
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\n    Matricula: " +  this.matricula;
    }
    
}
