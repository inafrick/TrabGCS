import java.util.Scanner;
import java.util.ArrayList;

public class Empresa {
    private Scanner entrada;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<RegistroCusto> registros;
    private ArrayList<String> departamentos;

    public Empresa(){
        entrada = new Scanner(System.in);
        funcionarios = new ArrayList<>();
        registros = new ArrayList<>();
        departamentos = new ArrayList<>();
    }

    public void executa(){
        criaDepartamentos();
        login();
    }

    private void criaDepartamentos(){
        departamentos.add("RH");
        departamentos.add("Compras");
        departamentos.add("Vendas");
        departamentos.add("Expedição");
        departamentos.add("Engenharia");
        departamentos.add("TI");
        departamentos.add("Produção");
        departamentos.add("Marketing");
        departamentos.add("Financeiro");
    }

    private void login(){

    }

    private void cadastraFuncionario(){

    }

    private void pesquisaRegistroCusto(){

    }

    private void excluiUltimoRegistroCusto(){

    }

    private void painelEstatisticas(){

    }

    private void pesquisaDepartamento(Depertamento x){
        system.out.println("Digite o nome do departamento: " + x);
        for (String departamento : departamentos) {
            if (departamento.equals(x)) {
                System.out.println(x);
            }
        }
    }

}
