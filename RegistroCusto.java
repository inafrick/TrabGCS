import java.util.Date;

public class RegistroCusto {
    private String categoria;
    private double valor;
    private String descricao;
    private int ano;
    private int mes;
    private String departamento;
    private Funcionario funcionario;

    public RegistroCusto(String categoria, double valor, String descricao, int ano, int mes, String departamento, Funcionario funcionario) {
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.ano = ano;
        this.mes = mes;
        this.departamento = departamento;
        this.funcionario = funcionario;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

   
    public String getDepartamento() {
        return departamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    
}
