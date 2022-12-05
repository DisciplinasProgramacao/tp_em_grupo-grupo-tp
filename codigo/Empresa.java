import java.util.HashMap;

public class Empresa{

    static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

    
    /**
     * Cadastrar novo cliente
     * @param cpf CPF do novo cliente
     */
    public static boolean cadastroCliente(String nome, String cpf, int totalPontos, int periodo){

        Cliente novoCliente = new Cliente(nome, cpf, totalPontos, periodo);
        //Adicionar dados Cliente

        //verificar se já existe cliente pelo cpf
        clientes.get(cpf);

        //Chave e novo cliente
        clientes.put(cpf, novoCliente);
        
        return true;
    }

    public static void procurarCliente(String cpf){
        
        System.out.println(clientes.get(cpf));
    }



}