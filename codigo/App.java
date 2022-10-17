import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner ler = new Scanner(System.in);

    public static int menu(){
        System.out.println("TP");
        System.out.println("Alunos: João / Gabriel");

        System.out.println("======================================");
        System.out.println("1 - ");
        System.out.println("2 - ");
        System.out.println("3 - ");
        System.out.println("0 - Sair");
        System.out.println("Digite sua opção:");

        try{
            int opcao = ler.nextInt();
            ler.nextLine();
            return opcao;
        } catch (InputMismatchException ie){
            return -1;
        }
    }
    public static void main(String[] args) {


        int opcao;
        do{
            opcao = menu();
            switch(opcao){
                case 1:
                
                break;
                case 2:
                
                break;
                case 3:
                
                break;

            }
        }while(opcao != 0);
        ler.close();
    }
}