import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner ler = new Scanner(System.in);

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    };

    public static int menu() {
        //limparTela();
        System.out.println("Alunos: João / Gabriel / Gabriel / Vitor");

        System.out.println("======================================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Procurar cliente pelo CPF");
        System.out.println("3 - Comprar bilhete");
        System.out.println("4 - Criar trecho");
        System.out.println("0 - Sair");
        System.out.println("Digite sua opção:");

        try {
            int opcao = ler.nextInt();
            ler.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    public static void main(String[] args) {

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:

                    break;
                case 2:

                    // Empresa.procurarCliente(cpf);
                    break;
                case 3:

                    break;
                case 4:
                    Data dat = new Data(11, 11, 1992);
                    //System.out.println("Criar trecho: ");
                    Trecho tre = new Trecho(1, "Belo Horizonte", "São Paulo");

                    // Classe Voo
                    //System.out.println("Criar voo: ");
                    Voo v = new Voo(dat, tre, 2000);
                    Voo v2 = new Voo(dat, tre, 2000);
                    Voo v3 = new Voo(dat, tre, 2000);
                    //System.out.println(v.informacoesDoVoo());

                    v.AlterarTrecho(1, "São Paulo", "Belo Horizonte");
                    //System.out.println(tre.informacoesDoTrecho());

                    //System.out.println("Cadastrar cliente: ");
                    Empresa.cadastroCliente("Joao", "123", 0, 0);
                    //Empresa.procurarCliente("123");
                    //System.out.println("Comprar Bilhete: ");
                    Cliente cli = new Cliente("Joao", "123", 0, 0);

                    Bilhete teste = new BilhetePromocional(v);
                    
                    System.out.println(cli.comprarBilhete(v));
                    System.out.println(cli.verificarPontos());

                    teste.AddVoo(v);
                    teste.AddVoo(v2);
                    teste.AddVoo(v3);
                    //System.out.println(teste.CalcularValor());
                    //System.out.println(teste.GerarPontos());
                    
                    //System.out.println(teste.CalcularValor()); //110 retorno normal / 0 Fidelidade / 66 Promocional
                    

                    break;

            }
        } while (opcao != 0);
        ler.close();
    }
}