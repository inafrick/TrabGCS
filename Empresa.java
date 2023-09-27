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

    private void pesquisaRegistroPorCategoria(){
        System.out.println("Digite a categoria para pesquisa: ");
        String categoria = entrada.nextLine();
        System.out.println("Pesquisando registro por categoria ...");
        for (RegistroCusto registro : registros) {
            if (registro.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("Regristro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento" + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            } else {
                System.out.println("Nenhum registro encontrado para a categoria fornecida!");
            }
        }
    }

    private void pesquisaRegistroPorDescricao(){
        System.out.println("Digite a descrição para pesquisa: ");
        String descricao = entrada.nextLine();
        System.out.println("Pesquisando registro por descricao ...");
        for (RegistroCusto registro : registros) {
            if (registro.getDescricao().equalsIgnoreCase(descricao)) {
                System.out.println("Regristro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento" + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            } else {
                System.out.println("Nenhum registro encontrado para a descrição fornecida!");
            }
        }
    }

    private void pesquisaRegistroPorDepartamento(){
        System.out.println("Digite o nome do departamento para pesquisa: ");
        String departamento = entrada.nextLine();
        System.out.println("Pesquisando registro por departamento ...");
        for (RegistroCusto registro : registros) {
            if (registro.getDepartamento().equalsIgnoreCase(departamento)) {
                System.out.println("Regristro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento" + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            } else {
                System.out.println("Nenhum registro encontrado para o departamento fornecido!");
            }
        }
    }

}
