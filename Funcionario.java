public class Funcionario {
    private int matricula;
    private String nome;
    private String departamento;

    public Funcionario(int matricula, String nome, String departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
