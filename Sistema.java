import java.util.Scanner;
import java.util.ArrayList;

/*
Conceitos a serem aplicados:
    Classes - OK
    Overloading
    Overriding
    Modificadores de acesso
    Herança
    Polimorfismo
    Abstract class
    Interface
    Generics - Talvez ok
    Collections
*/ 

// 10) Permitir operações de undo e redo de informações referentes aos projetos,
// atividades e usuários.

public class Sistema {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");;
    static Usuario user;
    
    public static void main(String[] args) {
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        
        while(true){
            System.out.println("\n####################################################");
            System.out.println("############# Bem vindo ao Projete-se! #############");
            System.out.println("####################################################\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Criação e remoção de informações\n2- Edição de informações");
            System.out.println("3- Associação de usuários aos projetos e atividades\n4- Alteração de status");
            System.out.println("5- Consultas\n6- Relatório\n7- Intercambio de usuários\n8- Pagamento de bolsas");
            System.out.println("9- Login\n10- Undo ou redo");
            String i = input.next();
            switch (i) {
                case "1":
                    System.out.println("\n#########################\n");
                    System.out.println("1- Criar Usuário\n2- Criar projeto\n3- Remover");
                    String esc = input.next();
                    switch (esc) {
                        case "1":
                            System.out.println("Insira as informação para criar um usuário");
                            criarUsuario(Usuarios);
                            break;
                        case "2":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            criarProjeto(projetos, Usuarios);
                            break;
                        case "3":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            System.out.println("O que você deseja remover?\n");
                            System.out.println("1- Projeto\n2- Atividade\n3- Tarefa");
                            String j = input.next();

                            switch (j){
                                case "1":
                                    removerProjeto(projetos);
                                    break;
                                case "2":
                                    removerAtividade(projetos);
                                    break;
                                case "3":
                                    removerTarefa(projetos);
                                    break;
                                default:
                                    break;
                            }

                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "2":
                    System.out.println("\n#########################\n");
                    System.out.println("O que você deseja editar?\n");
                    System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
                    String j = input.next();

                    switch (j){
                        case "1":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            editarProjeto(projetos);
                            break;
                        case "2":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                                System.out.println("Sem permissão!");
                                break;
                            }
                            editarAtividade(projetos);
                            break;
                        case "3":
                            if(user == null){
                                System.out.println("Por favor, faça login para continuar");
                                break;
                            }
                            editarUsuario(Usuarios);
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "3":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    System.out.println("1- Associar projeto\n2- Associar atividade");
                    int associar = input.nextInt();
                    if(associar == 1){
                        associarProjeto(projetos, Usuarios);
                    }else if(associar == 2){
                        associarAtividade(projetos, Usuarios);
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "4":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }

                    System.out.println("\n#########################\n");
                    System.out.println("De qual projeto deseja alterar o status?");
                    for(Projeto k: projetos){
                        System.out.printf("%d- %s\n", k.id, k.descricao);
                    }
                    
                    int p = input.nextInt();            
                    Projeto proj = projetos.get(p);

                    if(proj.coordenador.cpf != user.cpf && proj.coordenador.cargo != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }

                    if(proj.status.equals("Em processo de criação")){
                        System.out.println("Deseja inicar o projeto?\n\n1- Sim\n2- Não");
                        int res = input.nextInt();
                        if(res == 1){
                            if(proj.descricao != null && proj.data_inicio != null && proj.coordenador != null){
                                proj.status = "Iniciado";
                            }
                        }
                    }
                    else if(proj.status.equals("Iniciado")){
                        System.out.println("Deseja dar andamento ao projeto?\n\n1- Sim\n2- Não");
                        int res = input.nextInt();
                        if(res == 1){
                            if(proj.Usuarios != null ){
                                proj.status = "Em andamento";
                            }
                        }
                    }
                    else if(proj.status.equals("Em andamento")){
                        System.out.println("Deseja concluir o projeto?\n\n1- Sim\n2- Não");
                        int res = input.nextInt();
                        if(res == 1){
                            if(proj.ativs != null && proj.data_final != null){
                                proj.status = "Concluído";
                            }
                        }
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "5":
                    System.out.println("\n#########################\n");
                    System.out.println("O que deseja consultar?");
                    System.out.println("1- Projeto\n2- Atividade\n3- Usuário");
                    String l = input.next();
                    switch (l) {
                        case "1":
                            consultaProj(projetos, Usuarios); 
                            break;
                        case "2":
                            consultaAtiv(projetos);
                            break;
                        case "3":
                            consultaUsu(Usuarios);
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n#########################\n");
                    break;
                case "6":
                    System.out.println("\n#########################\n");
                    relatorio(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "7":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    intercambio(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "8":
                    if(user == null){
                        System.out.println("Por favor, faça login para continuar");
                        break;
                    }
                    if(user.cargo != "Pesquisador" && user.cargo != "Professor"){
                        System.out.println("Sem permissão!");
                        break;
                    }
                    System.out.println("\n#########################\n");
                    bolsas(projetos);
                    System.out.println("\n#########################\n");
                    break;
                case "9":
                    System.out.println("\n#########################\n");
                    user = login(Usuarios);
                    System.out.println("\n#########################\n");
                    break;
                case "10":
                    System.out.println("\n#########################\n");
                    System.out.println("\n#########################\n");
                    break;
                default:
                    break;
            }
        }
    }

    
    public static void criarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> Usuarios) {
        System.out.print("Insira a descrição do projeto: ");
        String descricao = input.next( );
        
        System.out.print("Insira a data de início do projeto: ");
        String data_inicio = input.next();
        
        System.out.print("Insira a data de termino do projeto: ");
        String data_final = input.next();
        
        System.out.print("Insira o cpf do coordenador do projeto: ");
        String coordenador_cpf = input.next();
        Usuario coordenador= buscaPorCpf(coordenador_cpf, Usuarios);
        
        ArrayList<Usuario> part_proj = addUsuario(Usuarios);
        part_proj.add(coordenador);
        
        ArrayList<Atividade> ativ_proj = addAtividades(part_proj);

        int[] bolsas = definirBolsa();

        System.out.print("Qual a vigencia das bolsas? ");
        String vigencia = input.next();
        
        Projeto pj = new Projeto(projetos.size(), "Em processo de criação", descricao, data_inicio, data_final, coordenador, part_proj, ativ_proj, bolsas, vigencia);
        
        projetos.add(pj);
    }

    public static Usuario criarUsuario(ArrayList<Usuario> Usuarios) {
        System.out.print("Digite o cpf: ");
        String cpf = input.next();
        
        System.out.print("Digite o senha: ");
        String senha = input.next();
        
        System.out.print("Digite o nome: ");
        String nome = input.next( );
        
        System.out.printf("Qual seu cargo?:\n");
        System.out.println("1- Aluno de Graduação\n2- Aluno de mestrado\n3- Aluno de doutorado");
        System.out.println("4- Professor\n5- Pesquisador\n6- Desenvolvedor\n7- Testador\n8- Analista\n9- Técnico");
        String cargo = input.next();
        
        switch (cargo) {
            case "1":
            cargo = "Aluno de Graduação";
                break;
            case "2":
                cargo = "Aluno de mestrado";
                break;
            case "3":
                cargo = "Aluno de doutorado";
                break;
            case "4":
                cargo = "Professor";
                break;
            case "5":
                cargo = "Pesquisador";
                break;
            case "6":
                cargo = "Desenvolvedor";
                break;
            case "7":
                cargo = "Testador";
                break;
            case "8":
                cargo = "Analista";
                break;
            case "9":
                cargo = "Técnico";
                break;
            default:
                break;
        }

        Usuario part = new Usuario(cpf, senha, nome, cargo);
        Usuarios.add(part);

        return part;
    }

    public static int[] definirBolsa(){

        int[] bolsas= new int[9];

        System.out.println("Defina o valor das bolsas de cada profissional");
        
        System.out.print("Aluno de Graduação: ");
        int valor = input.nextInt();
        bolsas[0] = valor;

        System.out.print("Aluno de mestrado: ");
        valor = input.nextInt();
        bolsas[1] = valor;

        System.out.print("Aluno de doutorado: ");
        valor = input.nextInt();
        bolsas[2] = valor;

        System.out.print("Professor: ");
        valor = input.nextInt();
        bolsas[3] = valor;

        System.out.print("Pesquisador: ");
        valor = input.nextInt();
        bolsas[4] = valor;

        System.out.print("Desenvolvedor: ");
        valor = input.nextInt();
        bolsas[5] = valor;

        System.out.print("Testador: ");
        valor = input.nextInt();
        bolsas[6] = valor;

        System.out.print("Analista: ");
        valor = input.nextInt();
        bolsas[7] = valor;

        System.out.print("Técnico: ");
        valor = input.nextInt();
        bolsas[8] = valor;

        return bolsas;
    }

    public static Atividade criarAtividades(ArrayList<Atividade> atividades, ArrayList<Usuario> Usuarios) {
        System.out.print("Digite o descrição: ");
        String desc = input.next();
        
        System.out.print("Insira a data de início da atividade: ");
        String dt_inicio = input.next();

        System.out.print("Insira a data de termino da atividade: ");
        String dt_final = input.next();

        System.out.print("Insira o cpf do responsavel pela atividade: ");
        String resp_cpf = input.next();
        Usuario resp = buscaPorCpf(resp_cpf, Usuarios);

        ArrayList<Usuario> profs = addUsuario(Usuarios);
        profs.add(resp);

        ArrayList<Tarefas> tarefas = addTarefas(Usuarios);

        Atividade ativ = new Atividade(atividades.size(), "Em andamento", desc, dt_inicio, dt_final, resp, tarefas, profs);

        return ativ;
    }

    
    public static ArrayList<Usuario> addUsuario(ArrayList<Usuario> Usuarios){
        ArrayList<Usuario> part_proj = new ArrayList<Usuario>();
        System.out.print("Digite o quantos Usuarios seram inseridos: ");
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario part = buscaPorCpf(part_cpf, Usuarios);

            part_proj.add(part);
        }
        return part_proj;
    }

    public static ArrayList<Atividade> addAtividades(ArrayList<Usuario> Usuarios){
        ArrayList<Atividade> ativ_proj = new ArrayList<Atividade>();
        System.out.print("Digite o quantas atividades seram inseridas: ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            Atividade ativ = criarAtividades(ativ_proj, Usuarios);
            ativ_proj.add(ativ);
        }
        return ativ_proj;
    }
    
    public static ArrayList<Tarefas> addTarefas(ArrayList<Usuario> Usuarios){
        ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
        System.out.print("Digite o quantas tarefas seram inseridas: ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            System.out.print("Digite o descrição: ");
            String desc = input.next();

            System.out.print("Digite o cpf da pessoa que realizará a tarefa: ");
            String cpf = input.next();

            Tarefas tf = new Tarefas(i, desc, cpf); 
            tarefas.add(tf);
        }
        return tarefas;
    }

    public static void removerProjeto(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto deseja remover?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        projetos.remove(res);

        System.out.println("\nRemovido!\n\n");
    }

    public static void removerAtividade(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a atividade pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        Projeto proj = projetos.get(res);

        System.out.println("Qual ativiade deseja remover?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ = input.nextInt();

        proj.ativs.remove(ativ);

        System.out.println("\nRemovida!\n\n");
    }

    public static void removerTarefa(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a tarefa pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();

        Projeto proj = projetos.get(res);

        System.out.println("Qual atividade a tarefa pertence?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ = input.nextInt();

        System.out.println("Qual tarefa deseja remover?\n");
        for(Tarefas i: proj.ativs.get(ativ).tarefas){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        proj.ativs.remove(ativ);

        System.out.println("\nRemovida!\n\n");
    }

    public static Usuario buscaPorCpf(String cpf, ArrayList<Usuario> Usuarios){
        for (Usuario i : Usuarios){
            if (i.getCpf().equals(cpf)){
                return i;
            }
        }
        return null;
    }

    public static void consultaProj(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        String campo;
        
        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Status\n2- Coordenador");
        String i = input.next();
        
        switch (i) {
            case "1":
                System.out.println("Opções: Em processo de criação, Iniciado, Em andamento, Concluído.");
                String res1 = input.next();
                campo = res1;

                for(Projeto proj: projetos){
                    if(proj.status.equals(campo)){
                        System.out.printf("Descrição : %s\n", proj.descricao);
                        System.out.printf("Status : %s\n", proj.status);
                        System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
                        System.out.printf("Data de termino : %s\n", proj.data_final);
                        System.out.printf("Coordenador do projeto %s", proj.coordenador.nome);
                    }
                }
                break;
            case "2":
                System.out.print("Insira o cpf do coordenador:");
                String res2 = input.next();

                for(Projeto proj: projetos){
                    if(proj.coordenador.getCpf().equals(res2)){
                        System.out.printf("Descrição : %s\n", proj.descricao);
                        System.out.printf("Status : %s\n", proj.status);
                        System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
                        System.out.printf("Data de termino : %s\n", proj.data_final);
                        System.out.printf("Coordenador do projeto %s", proj.coordenador.nome);
                    }
                }
                break;
            default:
                break;
        }
    }


    public static void consultaAtiv(ArrayList<Projeto> projetos){
        String campo;
        System.out.print("A qual projeto a atividade pertence?");
        
        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }
        
        int i = input.nextInt();
        Projeto proj = projetos.get(i);

        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Status\n2- Responsável");
        String j = input.next();

        switch (j) {
            case "1":
                System.out.println("Opções: Em andamento, Concluído.");
                String res1 = input.next();
                campo = res1;

                for(Atividade ativ: proj.ativs){
                    if(ativ.status.equals(campo)){
                        System.out.printf("Status: %s", ativ.status);
                        System.out.printf("Descrição: %s", ativ.descricao);
                        System.out.printf("Data de Inicio : %s\n", ativ.data_inicio);
                        System.out.printf("Data de termino : %s\n", ativ.data_final);
                        System.out.printf("Responsável %s\n", ativ.responsavel.nome);
                    }
                }
                break;
            case "2":
                System.out.print("Insira o cpf do responsável:");
                String res2 = input.next();

                for(Atividade ativ: proj.ativs){
                    if(ativ.responsavel.getCpf().equals(res2)){
                        System.out.printf("Status: %s", ativ.status);
                        System.out.printf("Descrição: %s", ativ.descricao);
                        System.out.printf("Data de Inicio : %s\n", ativ.data_inicio);
                        System.out.printf("Data de termino : %s\n", ativ.data_final);
                        System.out.printf("Responsável %s\n", ativ.responsavel.nome);
                    }
                }
                break;
            default:
                break;
        }
    }

    public static void consultaUsu(ArrayList<Usuario> usuarios){
        String campo;
        
        System.out.println("Qual por qual campo deseja buscar?\n");
        System.out.println("1- Nome\n2- Cargo\n3- CPF");
        String i = input.next();
        
        switch (i) {
            case "1":
                System.out.print("Insira o nome: ");
                String res1 = input.next();
                campo = res1;

                for(Usuario user: usuarios){
                    if(user.nome.equals(campo)){
                        System.out.printf("Nome : %s\n", user.nome);
                        System.out.printf("CPF : %s\n", user.cpf);
                        System.out.printf("Cargo : %s\n", user.cargo);
                    }
                }
                break;
            case "2":
                System.out.println("Opções: Aluno de Graduação, Aluno de mestrado, Aluno de doutorado, Professoror, Pesquisador, Desenvolvedor, Testador, Analista, Técnico");
                System.out.print("Insira o Cargo:");
                String res2 = input.next();
                campo = res2;

                for(Usuario user: usuarios){
                    if(user.cargo.equals(campo)){
                        System.out.printf("Nome : %s\n", user.nome);
                        System.out.printf("CPF : %s\n", user.cpf);
                        System.out.printf("Cargo : %s\n", user.cargo);
                    }
                }
                break;
            case "3":
                System.out.print("Insira o CPF:");
                String res3 = input.next();
                campo = res3;

                for(Usuario user: usuarios){
                    if(user.cpf.equals(campo)){
                        System.out.printf("Nome : %s\n", user.nome);
                        System.out.printf("CPF : %s\n", user.cpf);
                        System.out.printf("Cargo : %s\n", user.cargo);
                    }
                }
                break;
            default:
                break;
        }
        System.out.print("Qual cpf do usuário que deseja vizualizar?");

        String res = input.next();
        Usuario user = buscaPorCpf(res, usuarios);
        if(user == null){
            System.out.println("Usuário não encontrado");
        }
        else{
            System.out.printf("Nome : %s\n", user.nome);
            System.out.printf("CPF : %s\n", user.cpf);
            System.out.printf("Cargo : %s\n", user.cargo);
        }
    }

    public static void associarProjeto(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um projeto a um usuário\n2- Associar Usuários a um projeto");
        int escolha = input.nextInt();

        if (escolha == 1) {       
            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
            System.out.println("Qual projeto deseja associar a esse usuario?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
        
            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            proj.Usuarios.add(user);

        }else if(escolha == 2){
            System.out.println("Qual projeto deseja associar?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }

            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            ArrayList<Usuario> lista_usua = addUsuario(usuarios);

            for(Usuario user: lista_usua){
                proj.Usuarios.add(user);
            }
        }
    }

    public static void associarAtividade(ArrayList<Projeto> projetos, ArrayList<Usuario> usuarios){
        System.out.println("1- Associar um atividade a um usuário\n2- Associar Usuários a uma atividade");
        int escolha = input.nextInt();

        if (escolha == 1) {       
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, proj.Usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
        
            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
        
            int at = input.nextInt();

            Atividade ativ = proj.ativs.get(at);
            ativ.profissionais.add(user);

        }else if(escolha == 2){
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto i: projetos){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }

            int res = input.nextInt();
            Projeto proj = projetos.get(res);

            System.out.println("Qual atividade deseja associar?\n");
            for(Atividade i: proj.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
            int ativ_res = input.nextInt();

            System.out.print("Digite o cpf do Usuario: ");
            String part_cpf = input.next();
            Usuario user = buscaPorCpf(part_cpf, usuarios);

            if(user == null){
                System.out.println("Usuário não encontrado");
            }
            else{
                Atividade ativ = proj.ativs.get(ativ_res);
                ativ.profissionais.add(user);
            }
        }
    }

    public static void intercambio(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto o usuário pertence?\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.descricao);
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.print("Digite o cpf do Usuario que seja adicionar: ");
        String cpf = input.next();
        Usuario user = buscaPorCpf(cpf, proj.Usuarios);

        if(user == null){
            System.out.println("Usuário não encontrado");
        }
        else{
            System.out.println("Qual projeto a atividade pertence?\n");

            for(Projeto p2: projetos){
                System.out.printf("%d- %s\n", p2.id, p2.descricao);
            }
            int p2 = input.nextInt();
            Projeto proj2 = projetos.get(p2);

            System.out.println("Qual atividade deseja adicionar o usuário?\n");

            for(Atividade i: proj2.ativs){
                System.out.printf("%d- %s\n", i.id, i.descricao);
            }
    
            int ativ_res = input.nextInt();
            Atividade ativ = proj2.ativs.get(ativ_res);

            ativ.profissionais.add(user);

            System.out.println("Adicione as tarefas do usuário");

            addTarefas(ativ.profissionais);
        }
    }

    public static void bolsas(ArrayList<Projeto> projetos){
        System.out.println("Selecione um projeto\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.descricao);
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.printf("Qual tipo de usuário deseja pagar?:\n");
        System.out.println("1- Alunos de Graduação\n2- Alunos de mestrado\n3- Alunos de doutorado");
        System.out.println("4- Professores\n5- Pesquisadores\n6- Desenvolvedores\n7- Testadores\n8- Analistas\n9- Técnicos");
        int res = input.nextInt();
        String cargo = "";

        switch (res) {
            case 1:
                cargo = "Aluno de Graduação";
                break;
            case 2:
                cargo = "Aluno de mestrado";
                break;
            case 3:
                cargo = "Aluno de doutorado";
                break;
            case 4:
                cargo = "Professor";
                break;
            case 5:
                cargo = "Pesquisador";
                break;
            case 6:
                cargo = "Desenvolvedor";
                break;
            case 7:
                cargo = "Testador";
                break;
            case 8:
                cargo = "Analista";
                break;
            case 9:
                cargo = "Técnico";
                break;
            default:
                break;
        }

        for(Usuario i: proj.Usuarios){
            if(i.cargo.equals(cargo)){
                i.recebido += proj.bolsas[res-1];
            }
        }
    }

    public static void editarProjeto(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto deseja editar?\n");

        for(Projeto p: projetos){
            System.out.printf("%d- %s\n", p.id, p.descricao);
        }
        int p = input.nextInt();
        Projeto proj = projetos.get(p);

        System.out.println("Qual campo deseja editar?\n1- Descrição\n2- Data inicio\n3- Data Final");
        String j = input.next();
        switch (j) {
            case "1":
                System.out.print("Mudar descrição: ");
                String res1 = input.next();
                proj.setDescricao(res1);
                break;
            case "2":
                System.out.print("Mudar Data inicio: ");
                String res2 = input.next();
                proj.setDataInicio(res2);
                break;
            case "3":
                System.out.print("Mudar Data final: ");
                String res3 = input.next();
                proj.setDataFinal(res3);
                break;
            default:
                break;
        }
    }

    public static void editarAtividade(ArrayList<Projeto> projetos){
        System.out.println("Qual projeto a atividade pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();
        Projeto proj = projetos.get(res);

        System.out.println("Qual atividade deseja editar?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ_res = input.nextInt();
        Atividade ativ = proj.ativs.get(ativ_res);

        System.out.println("Qual campo deseja editar?\n1- Descrição\n2- Data inicio\n3- Data Final");
        String j = input.next();
        switch (j) {
            case "1":
                System.out.print("Mudar descrição: ");
                String res1 = input.next();
                ativ.setDescricao(res1);
                break;
            case "2":
                System.out.print("Mudar Data inicio: ");
                String res2 = input.next();
                ativ.setDataInicio(res2);
                break;
            case "3":
                System.out.print("Mudar Data final: ");
                String res3 = input.next();
                ativ.setDataFinal(res3);
                break;
            default:
                break;
        }
    }

    public static void editarUsuario(ArrayList<Projeto> projetos, ArrayList<Usuario> Usuarios){
        System.out.println("Qual projeto a atividade pertence?\n");

        for(Projeto i: projetos){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int res = input.nextInt();
        Projeto proj = projetos.get(res);

        System.out.println("Qual atividade deseja editar?\n");
        for(Atividade i: proj.ativs){
            System.out.printf("%d- %s\n", i.id, i.descricao);
        }

        int ativ_res = input.nextInt();
        Atividade ativ = proj.ativs.get(ativ_res);

        System.out.println("Qual campo deseja editar?\n1- Descrição\n2- Data inicio\n3- Data Final");
        String j = input.next();
        switch (j) {
            case "1":
                System.out.print("Mudar descrição: ");
                String res1 = input.next();
                ativ.setDescricao(res1);
                break;
            case "2":
                System.out.print("Mudar Data inicio: ");
                String res2 = input.next();
                ativ.setDataInicio(res2);
                break;
            case "3":
                System.out.print("Mudar Data final: ");
                String res3 = input.next();
                ativ.setDataFinal(res3);
                break;
            default:
                break;
        }
    }

    public static void editarUsuario(ArrayList<Usuario> Usuarios){
        System.out.print("Digite o cpf do usuário: ");
        String loginCpf = input.next();

        Usuario user = buscaPorCpf(loginCpf, Usuarios);
        
        if(user == null){
            System.out.println("Usuário não encontrado, tente novamente");
        }else{
            System.out.println("Qual campo deseja editar?\n1- Nome\n2- Cargo\n3- CPF");
        
        String i = input.next();

        switch (i) {
            case "1":
                System.out.print("Mudar Nome: ");
                String res1 = input.next();
                user.setNome(res1);
                break;
            case "2":
                System.out.print("Mudar Nome: ");
                String res2 = input.next();
                user.setCargo(res2);
                break;
            case "3":
                System.out.print("Mudar CPF: ");
                String res3 = input.next();
                user.setCpf(res3);
                break;
            default:
                break;
            }
        }
    }


    public static void relatorio(ArrayList<Projeto> projetos){
        System.out.println("\n############ Relatório de projetos ############\n\n");
        
        for(Projeto proj: projetos){
            System.out.printf("Projeto %d\n", proj.id);
            System.out.printf("Descrição : %s\n", proj.descricao);
            System.out.printf("Status : %s\n",proj.status);
            System.out.printf("Data de Inicio : %s\n", proj.data_inicio);
            System.out.printf("Data de termino : %s\n", proj.data_final);
            System.out.printf("Coordenador do projeto %s\n", proj.coordenador.nome);

            System.out.println("  Participantes do projeto:");
            for(Usuario user: proj.Usuarios){
                if(proj.Usuarios == null){
                    break;
                }
                System.out.printf("    Nome : %s\n", user.nome);
                System.out.printf("    CPF : %s\n", user.cpf);
                System.out.printf("    Cargo : %s\n", user.cargo);
                System.out.printf("    Recebidos : %d\n", user.recebido);
                System.out.println("___________________________");
            }
            
            System.out.println("  Atividades do projeto:");
            for(Atividade ativ: proj.ativs){
                if(proj.ativs == null){
                    break;
                }
                System.out.printf("    Atividade %d\n", ativ.id);
                System.out.printf("    Status: %s\n", ativ.status);
                System.out.printf("    Descrição: %s\n", ativ.descricao);
                System.out.printf("    Data de Inicio : %s\n", ativ.data_inicio);
                System.out.printf("    Data de termino : %s\n", ativ.data_final);
                System.out.printf("    Responsável %s\n", ativ.responsavel.nome);

                for(Tarefas tf: ativ.tarefas){
                    System.out.printf("    Tarefa %d\n", tf.id);
                    System.out.printf("    Descrição: %s\n", tf.descricao);
                    System.out.printf("    Responsável %s\n", tf.profissonal);
                }
                System.out.println("___________________________");
            }
            System.out.println("###########################################");
        }
    }

    public static void recuperarSenha(ArrayList<Usuario> Usuarios){
        System.out.println("Recuperação de senha");
        System.out.print("Digite o cpf: ");
        String loginCpf = input.next();

        Usuario user = buscaPorCpf(loginCpf, Usuarios);
        
        if(user == null){
            System.out.println("Usuário não encontrado, tente novamente");
        }
        else{
            System.out.print("Digite a nova senha: ");
            String novaSenha = input.next();

            System.out.print("Digite a nova senha novamente: ");
            String novaSenhaVer = input.next();

            if(novaSenha.equals(novaSenhaVer)){
                user.atualizarSenha(novaSenha);
                return;
            }
        }
    }

    public static Usuario login(ArrayList<Usuario> Usuarios){
        System.out.print("Digite o cpf ou ''eita'' Caso tenha esquecido a senha:\n");
        String loginCpf = input.next();

        if(loginCpf.equals("eita")){
            recuperarSenha(Usuarios);
            login(Usuarios);
        }
        else{
            Usuario user = buscaPorCpf(loginCpf, Usuarios);
            
            if(user == null){
                System.out.println("Usuário não encontrado, tente novamente");
                login(Usuarios);
            }
            else{
                System.out.print("Digite o senha: ");
                String loginSenha = input.next();
    
                if(loginSenha.equals(user.senha)){
                    return user;
                }
                else{
                    System.out.println("Senha errada, tente de novo!");
                    login(Usuarios);
                }
            }
        }
        
        return null;
    }
}