import java.time.LocalDate;

public class RegistroCusto {
    private String categoria;
    private double valor;
    private String descricao;
    private LocalDate data;
    private String departamento;
    private Funcionario funcionario;

    public RegistroCusto(String categoria, double valor, String descricao,LocalDate data, String departamento, Funcionario funcionario) {
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    
}
