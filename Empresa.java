import java.util.Scanner;
import java.util.ArrayList;

public class Empresa {
    private Scanner entrada;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<RegistroCusto> registros;
    private ArrayList<String> departamentos;
    private Funcionario logado;

    public Empresa(){
        entrada = new Scanner(System.in);
        funcionarios = new ArrayList<>();
        registros = new ArrayList<>();
        departamentos = new ArrayList<>();
        logado = null;
    }

    public void executa(){
        criaDepartamentos();
        criaFuncionarios();
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

    private void criaFuncionarios(){
        funcionarios.add(new Funcionario(1, "Alice", "RH"));
        funcionarios.add(new Funcionario(2, "Bob", "RH"));

        funcionarios.add(new Funcionario(3, "Carol", "Compras"));
        funcionarios.add(new Funcionario(4, "David", "Compras"));

        funcionarios.add(new Funcionario(5, "Eva", "Vendas"));
        funcionarios.add(new Funcionario(6, "Frank", "Vendas"));

        funcionarios.add(new Funcionario(7, "Grace", "Expedição"));
        funcionarios.add(new Funcionario(8, "Hank", "Expedição"));

        funcionarios.add(new Funcionario(9, "Ivy", "Engenharia"));
        funcionarios.add(new Funcionario(10, "Jack", "Engenharia"));

        funcionarios.add(new Funcionario(11, "Karen", "TI"));
        funcionarios.add(new Funcionario(12, "Liam", "TI"));

        funcionarios.add(new Funcionario(13, "Mia", "Produção"));
        funcionarios.add(new Funcionario(14, "Noah", "Produção"));

        funcionarios.add(new Funcionario(15, "Olivia", "Marketing"));
        funcionarios.add(new Funcionario(16, "Peter", "Marketing"));

        funcionarios.add(new Funcionario(17, "Quinn", "Financeiro"));
        funcionarios.add(new Funcionario(18, "Rachel", "Financeiro"));
    }

    private void login(){
        System.out.println("Selecione o usuario: ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-");
        int cont = 0;
        for(Funcionario aux: funcionarios){
            System.out.println("[" + cont + "] " + aux.getNome());
            cont++;
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        System.out.println("Digite o numero correspondente: ");
        int num = entrada.nextInt();
        if(num<0 || num>cont){
            throw new IndexOutOfBoundsException();
        } else {
            logado = funcionarios.get(num);
            System.out.println("O sistema foi iniciado no usuario de : " + logado.getNome() + " com a matricula: " + logado.getMatricula());
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-");
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
