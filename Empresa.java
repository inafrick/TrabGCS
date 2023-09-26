import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {
    private Scanner entrada;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<RegistroCusto> registros;
    private ArrayList<String> departamentos;
    private Funcionario logado;
    private DateTimeFormatter formatter;
    private RegistroCusto ultimoRegistro;

    public Empresa(){
        entrada = new Scanner(System.in);
        funcionarios = new ArrayList<>();
        registros = new ArrayList<>();
        departamentos = new ArrayList<>();
        logado = null;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        if(num<0 || num>= cont){
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
                    break;
                case 4:
                    cadastraRegistroCusto();
                    break;
                case 6:
                    excluiUltimoRegistroCusto();
                    break;
            }
        }   while(op!=0);
    }

    private void menu(){
        System.out.println("============= MENU =============");
		System.out.println("[2] Cadastra Funcionário");
        System.out.println("[4] Cadastra Registro de Custos");
        System.out.println("[6] Remover Ultimo Registro de Custo");
    }

    private void cadastraFuncionario(){
        int matricula;
        String nome;
        String departamento;

        System.out.println("\nOpção Selecionada: [2] Cadastra Funcionário.");
        System.out.print("Informe a matrícula do funcionário: ");
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
            System.out.print("Informe o nome do funcionário: ");
            nome = entrada.nextLine();
            System.out.print("Informe o departamento do funcionário: ");
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
        if(registros.size()!= 0){ 
            if(registros.get((registros.size()-1)).equals(ultimoRegistro)){
                registros.remove((registros.size()-1));
            System.out.println("Ultimo registro de custo removido com sucesso.");
            }   
            else
                System.out.println("Ultimo registro de custo já foi removido previamente.");
            }
        else
            System.out.println("Não há nenhum registro de custo registrado");
    }

    private void painelEstatisticas(){

    }

    private void cadastraRegistroCusto(){
        System.out.print("Insira valor do custo: ");
        double custo = entrada.nextDouble();
        entrada.nextLine();

        System.out.print("Insira a descricao do custo: ");
        String descricao = entrada.nextLine();

        System.out.print("Insira a data (dd/MM/yyyy): ");
        String dataString = entrada.nextLine();
        LocalDate dataFormatada = LocalDate.parse(dataString, formatter);

        System.out.print("Insira a categoria do custo: ");
        String categoria = entrada.nextLine();

        for(int i = 0; i < departamentos.size(); i++) {
            System.out.println(departamentos.get(i));
        }

        boolean verifica = true;
        while(verifica) {
            System.out.print("Insira o departamento: ");
            String departamento = entrada.nextLine();

            for(int i = 0; i < departamentos.size(); i++) {
                if(departamento.equals(departamentos.get(i))) {

                    RegistroCusto novoRegistro = new RegistroCusto(categoria, custo, descricao, dataFormatada, departamento, logado);
                    registros.add(novoRegistro);
                    ultimoRegistro = novoRegistro;

                    System.out.println("\nCadastro feito com sucesso.");
                    System.out.println("Aquisição de " + descricao + ", R$" + custo +  ", " + dataFormatada + ", para o(a) " + departamento + ".");
                    verifica = false;
                    break;
                }
        
            }

        }

    } 





}
