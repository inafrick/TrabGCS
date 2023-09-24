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

    private void login(){

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
