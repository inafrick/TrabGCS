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
        RegistroCusto r1 = new RegistroCusto("categoria", 111.11, "Compras de carro", "Compras", new Funcionario(0, "nome", "TI"));
        RegistroCusto r2 = new RegistroCusto("categoria", 222.22, "Funcionario novo", "RH", new Funcionario(0, "nome", "TI"));
        registros.add(r1);
        registros.add(r2);
        criaDepartamentos();
        login();
        System.out.println(registros.size());
//        System.out.println("Digite o nome do departamento para pesquisa: ");
//        String dp = entrada.nextLine();

        pesquisaDepartamento();
    }

    private void criaDepartamentos(){
        System.out.println("Criando departamentos ...");
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
    private void pesquisaDepartamento(){
        String x = "Compras";
        System.out.println("Pesquisando departamento ...");
        for (RegistroCusto registro : registros) {
            if (registro.getDepartamento().equals(x)) {
                System.out.println("Regristro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento" + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            } else {
                System.out.println("Nenhum registro encontrado!");
            }
        }
    }

}
