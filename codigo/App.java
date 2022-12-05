import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class App {
    static Scanner teclado = new Scanner(System.in);
    static String nomeArq = "cidades.txt";
    static LocalDate hoje = LocalDate.now();

    // #region utilidades
    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pausa para leitura de mensagens em console
     * 
     */
    static void pausa() {
        System.out.println("\nEnter para continuar.");
        teclado.nextLine();
    }
    // #endregion

    /**
     * Carrega o arquivo de cidades em um array
     * 
     * @param Arquivo Arquivo com as cidades
     * @return array com o nome das cidades
     * @throws IOException Arquivo não encontrado
     */
    private static String[] carregarCidades(String Arquivo) throws IOException {
    	Empresa emp=new Empresa();
        Scanner arquivo = new Scanner(new File(Arquivo));
        int i = 0;

        String[] cidades = new String[10];
        while (arquivo.hasNextLine()) {
            String nome = arquivo.nextLine();
            cidades[i] = nome;
            i++;

        }

        arquivo.close();
        return cidades;
    }

    // #region menus
    /**
     * Menu principal
     * 
     * @return Opção do usuário (int)
     */
    public static int menu() {

        System.out.println();
        System.out.println();

        System.out.println("XULAMBS Airlines");
        System.out.println("==========================");
        System.out.println("1 - Novo Trecho");
        System.out.println("2 - Novo Voo");
        System.out.println("3 - Cadastrar Cliente");
        System.out.println("4 - Menu do cliente");
        System.out.println("5 - Menu da empresa");

        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Menu de seleçao da origem do trecho
     * 
     * @return Opção do usuário (int)
     */
    public static int menuOrigem() {
        String[] cidades = new String[5];
        try {
            cidades = carregarCidades(nomeArq);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println();
        System.out.println();

        System.out.println("Origem");
        System.out.println("==========================");
        System.out.println("1 -" + cidades[0]);
        System.out.println("2 -" + cidades[1]);
        System.out.println("3 -" + cidades[2]);
        System.out.println("4 -" + cidades[3]);
        System.out.println("5 -" + cidades[4]);
        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Menu de seleçao do destino do trecho
     * 
     * @return Opção do usuário (int)
     */
    public static int menuDestino() {
        String[] cidades = new String[5];
        try {
            cidades = carregarCidades(nomeArq);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println();
        System.out.println();

        System.out.println("Destino");
        System.out.println("==========================");
        System.out.println("1 -" + cidades[0]);
        System.out.println("2 -" + cidades[1]);
        System.out.println("3 -" + cidades[2]);
        System.out.println("4 -" + cidades[3]);
        System.out.println("5 -" + cidades[4]);
        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Menu de seleçao de data
     * 
     * @return Opção do usuário (int)
     */
    public static int menuData() {

        System.out.println();
        System.out.println();

        System.out.println("XULAMBS Airlines");
        System.out.println("==========================");
        System.out.println("selecione a data de partida do voo");
        System.out.println("==========================");
        System.out.println("1 - data atual");
        System.out.println("2 - data personalizada");

        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Menu de seleçao de data
     * 
     * @return Opção do usuário (int)
     */
    public static int menuTrecho(List<Trecho> trechos) {

        System.out.println();
        System.out.println();

        System.out.println("selecione o trecho");
        System.out.println("==========================");
        for (Trecho trecho : trechos) {
            int i = 1;
            System.out.println(trecho.informacoesDoTrecho());
        }

        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }
    //
    public static int menuVoos(List<Voo> voos) {

        System.out.println();
        System.out.println();

        System.out.println("selecione o voo");
        System.out.println("==========================");
        for (Voo voo : voos) {
            System.out.println(voo.informacoesDoVoo());
        }

        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * 
     * @return
     */
    public static int menuCliente() {

        System.out.println();
        System.out.println();

        System.out.println("Sistema aéreo");
        System.out.println("==========================");
        System.out.println("Cliente");
        System.out.println("==========================");
        System.out.println("1 - Adicionar cliente");

        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Menu da empresa
     * 
     * @return Opção do usuário (int)
     */
    public static int menuEmpresa() {

        System.out.println();
        System.out.println();

        System.out.println("XULAMBS Airlines");
        System.out.println("==========================");
        System.out.println("1 - Visualizar cliente com mais pontos acumulados");
        System.out.println("2 - Visualizar voos com mais de 100 reservas");
        System.out.println("3 - Visualizar valor total arrecadado");
        System.out.println("4 - Alterar valor base do voo");

        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }
    // #endregion

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        String[] cidades = new String[5];
        try {
            cidades = carregarCidades(nomeArq);
        } catch (Exception e) {
            // TODO: handle exception
        }

        LocalDate data = LocalDate.of(1, 1, 1);
        int opcao, num = 0, dia, mes, ano;
        String origem = null, destino = null, nome = null, cpf = null;
        double valor = 500;
        Trecho novoTrecho = null;
        Voo novoVoo = null;
        Cliente cliente = null;
        List<Cliente> clientes;

        Empresa emp = new Empresa();

        do {
            limparTela();
            opcao = menu();
            switch (opcao) {
                case 1: // criar techo
                    num++;
                    while (destino == origem) {
                        limparTela();
                        opcao = menuOrigem();

                        switch (opcao) {
                            case 1:
                                origem = cidades[0];
                                break;
                            case 2:
                                origem = cidades[1];
                                break;
                            case 3:
                                origem = cidades[2];
                                break;
                            case 4:
                                origem = cidades[3];
                                break;
                            case 5:
                                origem = cidades[4];
                                break;

                        }

                        limparTela();
                        opcao = menuDestino();

                        switch (opcao) {
                            case 1:
                                destino = cidades[0];
                                break;
                            case 2:
                                destino = cidades[1];
                                break;
                            case 3:
                                destino = cidades[2];
                                break;
                            case 4:
                                destino = cidades[3];
                                break;
                            case 5:
                                destino = cidades[4];
                                break;
                        }
                        if (origem == destino) {
                            System.out.println();
                            System.out.println("erro-origem e desttino iguais");
                            System.out.println("selecione novamente");
                        }

                    }
                    novoTrecho = new Trecho(num, origem, destino);
                    emp.addTrecho(novoTrecho);
                    System.out.println();
                    System.out.println("trecho criado.");
                    destino = null;
                    origem = null;
                    break;

                case 2: // criar voo
                    limparTela();
                    if (emp.getTodosOsTrechos().isEmpty()) {
                        System.out.println();
                        System.out.println("erro-Nenhum trecho criado, impossivel criar voo");
                        break;
                    }
                    opcao = menuData();
                    switch (opcao) {
                        case 1: // data local
                            data = hoje;
                            break;
                        case 2: // data manual

                            System.out.println("dia:");
                            dia = teclado.nextInt();
                            teclado.nextLine();

                            System.out.println("mês:");
                            mes = teclado.nextInt();
                            teclado.nextLine();

                            while (data.getYear() < hoje.getYear()) {
                                System.out.println("ano:");
                                ano = teclado.nextInt();
                                teclado.nextLine();

                                data = LocalDate.of(ano, mes, dia);
                                if (data.getYear() < hoje.getYear()) {
                                    System.out.println();
                                    System.out.println("erro-não epossivel viajar para o passado");
                                }
                            }

                            break;
                    }

                    opcao = menuTrecho(emp.getTodosOsTrechos());
                    Trecho trecho = emp.getTodosOsTrechos().get(opcao - 1);

                    novoVoo = new Voo(data, trecho, valor);
                    emp.addVoo(novoVoo);
                    System.out.println();
                    System.out.println("voo criado:");
                    System.out.println(novoVoo.informacoesDoVoo());

                    data = LocalDate.of(1, 1, 1);
                    break;

                case 3:
                    opcao = menuCliente();
                    switch (opcao) {
                        case 1:
                            System.out.println("Nome:");
                            nome = teclado.next();
                            teclado.nextLine();

                            System.out.println("CPF:");
                            cpf = teclado.next();
                            teclado.nextLine();
                            emp.cadastroCliente(nome, cpf);

                            break;
                    }
                    System.out.println("Cliente criado.");
                    break;
                case 4:
                    System.out.println("Informe o cpf:");
                    cpf = teclado.next();
                    teclado.nextLine();
                    if (emp.procurarCliente(cpf) != null) {
                        Cliente clienteEncon = emp.procurarCliente(cpf);
                        System.out.println("1 - Ver dados e pontos ");
                        System.out.println("2 - Comprar bilhete ");
                        System.out.println("3 - Comprar acelerador ");
                        opcao = teclado.nextInt();
                        switch (opcao) {
                            case 1:
                                System.out.println(emp.procurarCliente(cpf));
                                break;
                            case 2:
                                opcao = menuVoos(emp.getTodosVoo());

                                // TIPO DE BILHETE
                                System.out.println("Selecione a categoria do bilhete: ");
                                System.out.println("1 - Regular: ");
                                System.out.println("2 - Promocional: ");
                                System.out.println("3 - Fidelidade: ");
                                opcao = teclado.nextInt();
                                switch (opcao) {
                                    case 1:
                                        Bilhete novoRegular = new Bilhete(novoVoo);
                                        clienteEncon.comprarBilhete(novoRegular);

                                        System.out.println("Bilhete adquirido com sucesso!");
                                        break;
                                    case 2:
                                        Bilhete novoPromocional = new BilhetePromocional(novoVoo);
                                        clienteEncon.comprarBilhete(novoPromocional);

                                        System.out.println("Bilhete promocional adquirido com sucesso!");
                                        break;
                                    case 3:
                                        Bilhete novoFidelidade = new BilheteFidelidade(novoVoo);
                                        clienteEncon.comprarBilhete(novoFidelidade);

                                        System.out.println("Bilhete fidelidade adquirido com sucesso!");
                                        break;
                                }
                                break;
                            case 3:
                                System.out.println("Escolha qual acelerador deseja comprar:");
                                System.out.println("1 - Manter padrão");
                                System.out.println("2 - Acelerador prata");
                                System.out.println("3 - Acelerador preto");
                                opcao = teclado.nextInt();
                                switch(opcao){
                                    case 1:
                                    Acelerador aceleradorPadrao = new AceleradorPadrao();
                                    clienteEncon.mudarAcelerador(aceleradorPadrao);
                                    break;
                                    case 2:
                                    Acelerador aceleradorPrata = new AceleradorPrata();
                                    clienteEncon.mudarAcelerador(aceleradorPrata);
                                    break;
                                    case 3:
                                    Acelerador aceleradorPreto = new AceleradorPreto();
                                    clienteEncon.mudarAcelerador(aceleradorPreto);
                                    break;
                                }
                                break;
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 5:
                    limparTela();
                    opcao = menuEmpresa();

                    switch (opcao) {
                        case 1:
                            System.out.println(emp.maiorPontos12Meses());
                            break;
                        case 2:
                        	 System.out.println("ano:");
                             ano = teclado.nextInt();
                             teclado.nextLine();
                             
                             System.out.println("dia:");
                             dia = teclado.nextInt();
                             teclado.nextLine();

                             System.out.println("mês:");
                             mes = teclado.nextInt();
                             teclado.nextLine();
                             
                             LocalDate dataDigitada=LocalDate.of(ano, mes, dia);
                             
                             System.out.println("Informe a cidade:");
                             String cidade = teclado.next();
                             teclado.nextLine();
                            // 1oo reservas
                             for(Voo voo : emp.cidadesDataMaior100(dataDigitada, cidade)) {
                            	 System.out.println(voo.getData());
                             }
                            break;
                        case 3:
                            // total arrecadado
                        	System.out.println("total arrecadado="+emp.totalArrecadado());
                            break;
                        case 4:
                            System.out.println("insira o valor base");
                            valor = teclado.nextDouble();
                            teclado.nextLine();
                            break;

                    }
                    break;
                    

            }
            pausa();
        } while (opcao != 0);

    }
}