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

    private void cadastraRegistroCusto(){
        System.out.println("Insira valor do custo: ");
        double custo = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Insira a descricao do custo: ");
        String descricao = entrada.nextLine();
        System.out.println("Insira o mês: ");
        int mes = entrada.nextInt();
        System.out.println("Insira o ano: ");
        int ano = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Insira a categoria do custo: ");
        String categoria = entrada.nextLine();
        for(int i = 0; i < departamentos.size(); i++) {
            System.out.println(departamentos.get(i));
        }
        System.out.println(custo+ descricao + ano+ mes+ categoria);

        int verifica = 0;
        while(verifica == 0) {
        System.out.println("Insira o departamento: ");
        String departamento = entrada.nextLine();

        for(int i = 0; i < departamentos.size(); i++) {
            if(departamento.equals(departamentos.get(i))){
                RegistroCusto.add(custo, descricao, ano, mes, categoria, departamento, logado);
                System.out.println("Cadastro feito com sucesso");
                verifica = 1;
                break;
                  }
    
            }

        }

    } 





}
