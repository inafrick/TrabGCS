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
    private LocalDate dataAtual;


    public Empresa() {
        entrada = new Scanner(System.in);
        funcionarios = new ArrayList<>();
        registros = new ArrayList<>();
        departamentos = new ArrayList<>();
        logado = null;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataAtual = LocalDate.now();
    }

    public void executa() {
        criaDepartamentos();
        criaFuncionarios();
        criaRegistroDeCusto();
        login();

        executaMenu();
    }

    private void criaDepartamentos() {
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


    private void criaFuncionarios() {
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

    private void criaRegistroDeCusto() {
        registros.add(new RegistroCusto("Aquisição", 2500, "Placa de Video", LocalDate.parse("25/09/2023", formatter), "TI", funcionarios.get(1)));
        registros.add(new RegistroCusto("Manutenção", 500, "Maquina de Café", LocalDate.parse("25/08/2023", formatter), "RH", funcionarios.get(2)));

        registros.add(new RegistroCusto("Aquisição", 1500, "Processador", LocalDate.parse("23/09/2023", formatter), "TI", funcionarios.get(3)));
        registros.add(new RegistroCusto("Aquisição", 750, "Projetor", LocalDate.parse("25/09/2023", formatter), "Financeiro", funcionarios.get(4)));

        registros.add(new RegistroCusto("Aquisição", 150, "Cimento", LocalDate.parse("28/03/2021", formatter), "Engenharia", funcionarios.get(5)));
        registros.add(new RegistroCusto("Aquisição", 500, "Grão de Café", LocalDate.parse("29/01/2022", formatter), "Financeiro", funcionarios.get(6)));

        registros.add(new RegistroCusto("Aquisição", 635, "Placa Mãe", LocalDate.parse("15/10/2020", formatter), "TI", funcionarios.get(7)));
        registros.add(new RegistroCusto("Aquisição", 250, "Panfletos", LocalDate.parse("25/09/2023", formatter), "Marketing", funcionarios.get(8)));

        registros.add(new RegistroCusto("Aquisição", 2380, "Placa de Video", LocalDate.parse("08/08/2023", formatter), "Marketing", funcionarios.get(9)));
        registros.add(new RegistroCusto("Manutenção", 2760, "Formatar PCs", LocalDate.parse("21/06/2023", formatter), "TI", funcionarios.get(10)));

        registros.add(new RegistroCusto("Aquisição", 75, "Trena", LocalDate.parse("30/08/2023", formatter), "Engenharia", funcionarios.get(11)));
        registros.add(new RegistroCusto("Aquisição", 5700, "Monitores", LocalDate.parse("19/04/2023", formatter), "TI", funcionarios.get(12)));
    }

    private void login() {
        System.out.println("Selecione o usuario: ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-");
        int cont = 0;
        for (Funcionario aux : funcionarios) {
            System.out.println("[" + cont + "] " + aux.getNome());
            cont++;
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        System.out.println("Digite o numero correspondente: ");
        int num = entrada.nextInt();
        if (num < 0 || num >= cont) {
            throw new IndexOutOfBoundsException();
        }
        if(funcionarios.isEmpty()) throw new IndexOutOfBoundsException();
        else {
            logado = funcionarios.get(num);
            System.out.println("O sistema foi iniciado no usuario de: " + logado.getNome() + "  || com a matricula: " + logado.getMatricula());
        }
    }

    private void executaMenu() {
        int op;
        do {
            menu();
            System.out.println("\nDigite a opção desejada: ");
            op = entrada.nextInt();
            entrada.nextLine();
            switch (op) {
                case 0:
                    System.out.println("Fim do programa.");
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    cadastraFuncionario();
                    break;
                case 3:
                    cadastraRegistroCusto();
                    break;
                case 4:
                    executaMenuRegistros();
                    break;
                case 5:
                    excluiUltimoRegistroCusto();
                    break;
                case 6:
                    painelEstatisticas();
                    break;
                case 7:
                    mostraFuncionarioPorDepartamento();
                    break;
                case 8:
                    mudaDepartamento();
                    break;
                case 9:
                    removeFuncionario();
                    break;
                case 10:
                    criaNovoDepartamento();
                    break;
                case 11:
                    alteraMatricula();
                    break;
                case 12:
                    pesquisarFuncionarioPorMatricula();
                    break;
                case 13:
                    exibirFuncionarios();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (op != 0);
    }

    private void menu() {
        System.out.println("============= MENU =============");
        System.out.println("[0] Sair do Sistema");
        System.out.println("[1] Trocar de Usuário");
        System.out.println("[2] Cadastra Funcionário");
        System.out.println("[3] Cadastra Registro de Custos");
        System.out.println("[4] Pesquisa Registros");
        System.out.println("[5] Remover Ultimo Registro de Custo");
        System.out.println("[6] Mostrar Painel de Estatísticas");
        System.out.println("[7] Escolha um depertamento para visualizar seus funcionarios");
        System.out.println("[8] Transferencia para outro departamento");
        System.out.println("[9] Remover funcionário");
        System.out.println("[10] Cria novo departamento");
        System.out.println("[11] Altera matrícula de funcionário");
        System.out.println("[12] Pesquisa funcionário por matrícula");
        System.out.println("[13] Exibe lista de funcionários");
        System.out.println("================================");

    }

    private void cadastraFuncionario() {
        int matricula;
        String nome;
        String departamento;

        System.out.println("\nOpção Selecionada: [2] Cadastra Funcionário.");
        System.out.print("Informe a matrícula do funcionário: ");
        matricula = entrada.nextInt();

        boolean matriculaExistente = false;
        for (Funcionario f : funcionarios) {
            if (matricula == f.getMatricula()) {
                matriculaExistente = true;
                System.out.println("Erro. Matrícula já pertence a um funcionário cadastrado.");
                break;
            }
        }

        if (!matriculaExistente) {
            entrada.nextLine();
            System.out.print("Informe o nome do funcionário: ");
            nome = entrada.nextLine();
            System.out.print("Informe o departamento do funcionário: ");
            departamento = entrada.nextLine();
            if (!departamentos.contains(departamento)) {
                System.out.println("Departamento não encontrado. Funcionário não cadastrado.");
            } else {
                Funcionario funcionario = new Funcionario(matricula, nome, departamento);
                funcionarios.add(funcionario);
                System.out.println("Funcionário cadastrado. \nMatrícula: " + matricula + " | Nome: " + nome + " | Departamento: " + departamento);
            }
        }
    }



    private void excluiUltimoRegistroCusto() {
        if (!registros.isEmpty()) {
            if (registros.get((registros.size() - 1)).equals(ultimoRegistro)) {
                registros.remove((registros.size() - 1));
                System.out.println("Ultimo registro de custo removido com sucesso.");
            } else
                System.out.println("Ultimo registro de custo já foi removido previamente.");
        } else
            System.out.println("Não há nenhum registro de custo registrado");
    }

    private void painelEstatisticas() {
        System.out.println("\nFuncionário atualmente logado: " + logado.getNome());
        System.out.println("Valor total dos custos do mês atual: R$" + calculaCustoMes(dataAtual.getMonthValue(), dataAtual.getYear()));
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Gastos dos Departamento nos últimos 3 meses:\n");
        calculaTresMesesDepto(dataAtual.minusMonths(3));

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Os 3 funcionários com a maior soma de custos registrados: ");
        for (int i = 0; i < registros.size(); i++) {
            int indiceMaior = i;
            for (int j = i + 1; j < registros.size(); j++) {
                if (registros.get(j).getValor() > registros.get(indiceMaior).getValor()) {
                    indiceMaior = j;
                }
            }
            RegistroCusto registroI = registros.get(i);
            RegistroCusto registroMaior = registros.get(indiceMaior);

            registros.set(i, registroMaior);
            registros.set(indiceMaior, registroI);

        }
        System.out.println("Nome: " + registros.get(0).getFuncionario().getNome() + "\n Custo: " + registros.get(0).getValor() + "\n");
        System.out.println("Nome: " + registros.get(1).getFuncionario().getNome() + "\n Custo: " + registros.get(1).getValor() + "\n");
        System.out.println("Nome: " + registros.get(2).getFuncionario().getNome() + "\n Custo: " + registros.get(2).getValor() + "\n");

    }

    private void executaMenuRegistros(){
        int op;
        do{
            menuPesquisaRegistros();
            System.out.println("\nDigite a opção desejada: ");
            op = entrada.nextInt();
            entrada.nextLine();
            switch(op){
                case 0:
                    break;
                case 1:
                    pesquisaRegistroPorDescricao();
                    break;
                case 2:
                    pesquisaRegistroPorCategoria();
                    break;
                case 3:
                    pesquisaRegistroPorData();
                    break;
                case 4:
                    pesquisaRegistroPorDepartamento();
                    break;
            }
        }   while(op!=0);
    }

    private void menuPesquisaRegistros(){
        System.out.println("============= Pesquisa Registro =============");
        System.out.println("[0] Voltar para o Menu");
        System.out.println("[1] Por descrição");
        System.out.println("[2] Por categoria");
        System.out.println("[3] Por data");
        System.out.println("[4] Por departamento");
    }

    private void pesquisaRegistroPorDescricao(){
        boolean aux = true;
        System.out.println("Digite a descrição para pesquisa: ");
        String descricao = entrada.nextLine();
        System.out.println("Pesquisando registro por descrição ...");
        for (RegistroCusto registro : registros) {
            if (registro.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
                aux = false;
                System.out.println("\nRegistro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento: " + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            }
        }
        if(aux){
            System.out.println("Nenhum registro encontrado para a descrição fornecida!");
        }
    }

    private void pesquisaRegistroPorCategoria(){
        boolean aux = true;
        System.out.println("Digite a categoria para pesquisa: ");
        String categoria = entrada.nextLine();
        System.out.println("Pesquisando registro por categoria ...");
        for (RegistroCusto registro : registros) {
            if (registro.getCategoria().equalsIgnoreCase(categoria)) {
                aux = false;
                System.out.println("Registro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento" + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            }
        }
        if (aux) {
            System.out.println("Nenhum registro encontrado para a categoria fornecida!");
        }
    }

    private void pesquisaRegistroPorData(){
        boolean aux = true;
        System.out.println("Digite a data para pesquisa: ");
        String data = entrada.nextLine();
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        System.out.println("Pesquisando registro por data ...");
        for (RegistroCusto registro : registros) {
            if (registro.getData().equals(dataFormatada)) {
                aux = false;
                System.out.println("\nRegistro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento: " + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            }
        }
        if(aux){
            System.out.println("Nenhum registro encontrado para a data fornecida!");
        }
    }

    private void pesquisaRegistroPorDepartamento(){
        boolean aux = true;
        System.out.println("Digite o nome do departamento para pesquisa: ");
        String departamento = entrada.nextLine();
        System.out.println("Pesquisando registro por departamento ...");
        for (RegistroCusto registro : registros) {
            if (registro.getDepartamento().equalsIgnoreCase(departamento)) {
                aux = false;
                System.out.println("\nRegistro encontrado!");
                System.out.println("----====================----");
                System.out.println("Descrição: " + registro.getDescricao());
                System.out.println("Valor: " + registro.getValor());
                System.out.println("Categoria: " + registro.getCategoria());
                System.out.println("Departamento: " + registro.getDepartamento());
                System.out.println("Funcionário: " + registro.getFuncionario().getNome());
            }
        }
        if(aux){
            System.out.println("Nenhum registro encontrado para o departamento fornecido!");
        }
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

        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println(departamentos.get(i));
        }

        boolean verifica = true;
        while (verifica) {
            System.out.print("Insira o departamento: ");
            String departamento = entrada.nextLine();

            for (int i = 0; i < departamentos.size(); i++) {
                if (departamento.equals(departamentos.get(i))) {

                    RegistroCusto novoRegistro = new RegistroCusto(categoria, custo, descricao, dataFormatada, departamento, logado);
                    registros.add(novoRegistro);
                    ultimoRegistro = novoRegistro;

                    System.out.println("\nCadastro feito com sucesso.");
                    System.out.println("Aquisição de " + descricao + ", R$" + custo + ", " + dataFormatada + ", para o(a) " + departamento + ".");
                    verifica = false;
                    if (!verifica) ;
                    break;

                }

            }
            if (verifica) System.out.println("Departamento não encontrado. Insira novamente.");
        }

    }

    private void mostraFuncionarioPorDepartamento() {
        System.out.println("Escolha um departamento");
        String departamento = entrada.nextLine();

        System.out.println("Funcionários do departamento de " + departamento + ":");

        boolean departamentoEncontrado = false;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDepartamento().equalsIgnoreCase(departamento)) {
                System.out.println("Matrícula: " + funcionario.getMatricula() +
                        " | Nome: " + funcionario.getNome() +
                        " | Departamento: " + funcionario.getDepartamento());
                departamentoEncontrado = true;
            }
        }
        if (!departamentoEncontrado) {
            System.out.println("Não foi encontrado nenhum funcionario no/a " + departamento);
        }
    }

    private void mudaDepartamento() {
        System.out.println("Insira o departamento que deseja ser transferido: ");
        String novoDepart = entrada.nextLine();
        while (!departamentos.contains(novoDepart)) {
            System.out.println("Departamento inválido, tente novamente.");
            novoDepart = entrada.nextLine();
        }
        logado.setDepartamento(novoDepart);
        System.out.println("Departamento alterado com sucesso.");

    }

    private double calculaCustoMes(int mes, int ano) {
        double valorMes = 0;
        for (RegistroCusto aux : registros) {
            LocalDate data = aux.getData();
            if (data.getMonthValue() == mes && data.getYear() == ano) {
                valorMes += aux.getValor();
            }
        }
        return valorMes;
    }

    private void calculaTresMesesDepto(LocalDate data) {
        for (String depto : departamentos) {
            double somaTresMeses = 0;
            System.out.print("Gasto do departamento de " + depto + ": R$ ");
            for (RegistroCusto aux : registros) {
                if (aux.getDepartamento().equals(depto)) {
                    if (aux.getData().isAfter(data)) {
                        somaTresMeses += aux.getValor();
                    }
                }
            }
            System.out.println(somaTresMeses);
        }
    }
    private void removeFuncionario() {
        if (logado != null) {
            System.out.println("Insira a matrícula do funcionário que deseja remover: ");
            int matricula = entrada.nextInt();
            entrada.nextLine();

            boolean remover = false;
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getMatricula() == matricula) {
                    Funcionario funcionarioRemovido = funcionarios.remove(i);
                    System.out.println("Funcionário removido com sucesso");
                    System.out.println("Matrícula: " + funcionarioRemovido.getMatricula() +
                            " | Nome: " + funcionarioRemovido.getNome() +
                            " | Departamento: " + funcionarioRemovido.getDepartamento());
                    remover = true;
                    break;
                }
            }
            if (!remover) {
                System.out.println("Funcionário com a matrícula " + matricula + " não encontrado.");
            }
        } else {
            System.out.println("Nenhum usuário logado. Faça o login antes de remover um funcionário.");

        }
    }





    private void criaNovoDepartamento() {
        boolean verifica = true, verifica2;

        while(verifica) {
            verifica2 = true;
            System.out.println("Insira o nome do novo departamento a ser criado: ");
            String nome = entrada.nextLine();

            if(nome != null){
                for(int i = 0; i < departamentos.size(); i++) {
                    if(nome.equalsIgnoreCase(departamentos.get(i))){
                        System.out.println("Este departamento já existe");
                        verifica2 = false;
                        break;
                    }
                }
            }
            if(verifica2 == true) {
                departamentos.add(nome);
                System.out.println("Departamento criado com sucesso");
                verifica = false;
                break;
            }
        }
    }

    private Funcionario pesquisaFuncionario(int matricula){
        for (Funcionario f: funcionarios){
            if(f.getMatricula() == matricula){
                return f;
            }
        }
        return null;
    }

    private void alteraMatricula(){
        System.out.println("Insira a matrícula atual do funcionário que deseja-se alterar: ");
        int matricula = entrada.nextInt();
        Funcionario f = pesquisaFuncionario(matricula);

        if (f != null) {
            System.out.println("Insira a nova matrícula: ");
            int matriculaNova = entrada.nextInt();

            if(pesquisaFuncionario(matriculaNova) == null) {
                f.setMatricula(matriculaNova);
                System.out.println("Funcionário " + f.getNome() + " do departamento " + f.getDepartamento() + " tem matrícula alterada com sucesso.");
                System.out.println("Nova matrícula: " + f.getMatricula());
            }
            else {
                System.out.println("Funcionário com essa matrícula já existente.");
            }
        } else {
            System.out.println("Não foi possível encontrar funcionário com essa matrícula.");
        }
    }

    public void pesquisarFuncionarioPorMatricula() {
        System.out.println("Digite a matricula: ");
        int matricula = entrada.nextInt();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                System.out.println("Informações do Funcionário:");
                System.out.println("Matrícula: " + funcionario.getMatricula());
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Departamento: " + funcionario.getDepartamento());
                return;
            }
        }
        System.out.println("Funcionário com matrícula " + matricula + " não encontrado.");
    }
    public void exibirFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Matrícula: " + funcionario.getMatricula());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Departamento: " + funcionario.getDepartamento());
            System.out.println("----------------------");
        }

    }
}