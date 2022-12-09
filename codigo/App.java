import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        Scanner arquivo = new Scanner(new File(Arquivo));
        int i = 0;

        String[] cidades = new String[5];
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
        System.out.println("6 - Salvar");
        System.out.println("7 - adicionar informações para teste");

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

        System.out.println("selecione os trechos");
        System.out.println("==========================");
        for (Trecho trecho : trechos) {
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
    public static void teste(Empresa emp,String[] cidades ) throws FileNotFoundException {
    	Random random=new Random();
    	for(int count=0; count < cidades.length * cidades.length ; count++) {
    		int random1=random.ints(0, (cidades.length-1))
    				.findFirst() 
    				.getAsInt();
        	int random2=random.ints(0, (cidades.length-1))
        			.findFirst() 
        			.getAsInt();
        	if(cidades[random1]!=cidades[random2]) {
    		Trecho novoTrecho=new Trecho(emp.getTodosOsTrechos().size(),cidades[random1],cidades[random2]);
    		emp.addTrecho(novoTrecho);
        	}
    		
    	}
    	for(int count=0; count<10;count++) {
    		int random1=random.ints(0,(emp.getTodosOsTrechos().size())-1)
    				.findFirst()
    				.getAsInt();
    		int random2=random.ints(0, 5000)
    				.findFirst()
    				.getAsInt();
    		Voo novoVoo=new Voo(LocalDate.now(),emp.getTodosOsTrechos().get(random1),random2);
    		emp.addVoo(novoVoo);
    	}

			Scanner arquivo = new Scanner(new File("names.txt"));

    	String[] nomesAleatorios=new String[22000];
    	int count=0;
    	while(arquivo.hasNext()) {
    		nomesAleatorios[count]=arquivo.nextLine();
    		count++;
    	}
    	for(int count1=0 ;count1<=500;count1++) {
    		int random1=random.ints(0, (nomesAleatorios.length-1))
    				.findFirst()
    				.getAsInt();
    		int random2=random.ints(0, 300)
    				.findFirst()
    				.getAsInt();
    		emp.cadastroCliente(nomesAleatorios[random1], String.valueOf(count1));
    		for(int count2=0;count2<random2;count2++) {
    			int random3=random.ints(0,emp.getTodosVoo().size()-1)
        				.findFirst()
        				.getAsInt();
    			int random4=random.ints(0,1)
        				.findFirst()
        				.getAsInt();
    			Bilhete novoBilhete =random4==1 ? new Bilhete() : new BilhetePromocional();
    			
    			novoBilhete.AddVoo(emp.getTodosVoo().get(random3));
    			emp.procurarCliente(String.valueOf(count1)).comprarBilhete(novoBilhete);
    		}
    	}
    		

    }
    // #endregion

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        String[] cidades = new String[5];
            cidades = carregarCidades(nomeArq);
        
        LocalDate data = LocalDate.of(1, 1, 1);
        int opcao, num = 0, dia, mes, ano;
        String origem = null, destino = null, nome = null, cpf = null;
        double valor = 500;
        Trecho novoTrecho = null;
        Voo novoVoo = null;

	    	Empresa emp=new Empresa();
   		  try {
   	   		 File f= new File("1.txt");	
   	   		 ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
   	   		 emp=(Empresa) in.readObject();

   		  }
   	     catch(FileNotFoundException ex) {

   		System.out.println("nao encontrou arquivo");
   	}

        do {
            limparTela();
            opcao = menu();
            switch (opcao) {
                case 1: // criar techo
                    num++;
                    while (destino == origem) {
                            opcao = menuOrigem();
                        	limparTela();
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

                        opcao = menuDestino();
                        limparTela();

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
                        
                    novoTrecho = new Trecho(emp.getTodosOsTrechos().size(), origem, destino);
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
                                    	if(clienteEncon.getBilhetesGratis()>0) {
                                        Bilhete novoFidelidade = new BilheteFidelidade(novoVoo);
                                        clienteEncon.comprarBilhete(novoFidelidade);
                                        System.out.println("Bilhete fidelidade adquirido com sucesso!");
                                    	}
                                    	else {
                                    	System.out.println("Cliente sem bilhetes gratis disponivel");
                                    	}

                                        
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
                             String cidade = teclado.nextLine();
                            // 1oo reservas
                             emp.cidadesDataMaior100(dataDigitada, cidade);
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
                case 6:
                	emp.salvarEmpresa();
                	break;
                case 7:
                	System.out.println(cidades[1]);
                	teste(emp,cidades);
                    System.out.println("teste adicionado com sucesso!");

            }
                    
            pausa();
        } while (opcao != 0);

    }
}