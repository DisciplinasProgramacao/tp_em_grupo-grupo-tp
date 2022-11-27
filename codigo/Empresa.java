import java.util.HashMap;

public class Empresa{

    static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

    
    public static void cadastroCliente(){

        Cliente novoCliente = new Cliente();
        //Adicionar dados Cliente

        //Chave e novo cliente
        clientes.put("123.123.123.12", novoCliente);
    }

    public static Cliente procurarCliente(String cpf){
        return clientes.get(cpf);
    }



}