import java.util.HashMap;

public class Empresa{

    private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

    
    /**
     * Cadastrar novo cliente
     * @param cpf CPF do novo cliente
     */
    public boolean cadastroCliente(String nome, String cpf, int totalPontos, int periodo){

        Cliente novoCliente = new Cliente(nome, cpf, totalPontos, periodo);
        //Adicionar dados Cliente

        //verificar se já existe cliente pelo cpf
        clientes.get(cpf);

        //Chave e novo cliente
        clientes.put(cpf, novoCliente);
        
        return true;
    }

    public Cliente procurarCliente(String cpf){
        
        return clientes.get(cpf);
    }



}