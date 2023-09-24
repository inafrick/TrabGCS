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
        executaMenu();
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
    
    private void executaMenu(){
        int op;
        do{
            menu();
            System.out.println("\nDigite a opção desejada: ");
            op = entrada.nextInt();
            entrada.nextLine();
            switch(op){
                case 0: 
                    break;
                case 2: 
                    cadastraFuncionario();
            }
        }   while(op!=0);
    }

    private void menu(){
        System.out.println("============= MENU =============");
		System.out.println("[2] Cadastra Funcionário");
    }

    private void cadastraFuncionario(){
        int matricula;
        String nome;
        String departamento;

        System.out.println("\nOpção Selecionada: [2] Cadastra Funcionário.");
        System.out.println("Informe a matrícula do funcionário: ");
        matricula = entrada.nextInt();

        boolean matriculaExistente = false;
        for(Funcionario f : funcionarios){
            if(matricula==f.getMatricula()){
                matriculaExistente = true;
                System.out.println("Erro. Matrícula já pertence a um funcionário cadastrado.");
                break;
            }        
        }

        if(!matriculaExistente){
            entrada.nextLine();
            System.out.println("Informe o nome do funcionário: ");
            nome = entrada.nextLine();
            System.out.println("Informe o departamento do funcionário: ");
            departamento = entrada.nextLine();
                if(!departamentos.contains(departamento)){
                    System.out.println("Departamento não encontrado. Funcionário não cadastrado.");
                }   
                else{
                    Funcionario funcionario = new Funcionario(matricula, nome, departamento);
                    funcionarios.add(funcionario);
                    System.out.println("Funcionário cadastrado. \nMatrícula: "+matricula+" | Nome: "+nome+" | Departamento: " + departamento);
                }
            }
        }


    private void pesquisaRegistroCusto(){

    }

    private void excluiUltimoRegistroCusto(){

    }

    private void painelEstatisticas(){

    }

}
