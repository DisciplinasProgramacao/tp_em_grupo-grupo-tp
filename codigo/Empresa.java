import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -281995888107396292L;
	private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    private List<Voo> todosOsVoo=new ArrayList<Voo>();
    private List<Trecho> todosOsTrechos=new ArrayList<Trecho>();
    
    /**
     * Cadastrar novo cliente
     * @param cpf CPF do novo cliente
     */
    public boolean cadastroCliente(String nome, String cpf){

        Cliente novoCliente = new Cliente(nome, cpf);
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
    public Cliente maiorPontos12Meses() {
    	return this.clientes
    			.entrySet()
    			.stream()
    			.max(Map.Entry.comparingByValue()).get().getValue();

}
    public void addVoo(Voo voo) {
    	this.todosOsVoo.add(voo);
    }
    public List<Voo> cidadesDataMaior100(LocalDate data,String destino){
    	return this.todosOsVoo.stream()
    			.filter(voo->voo.getTrecho().getDestino()==destino)
    			.filter(voo->voo.getData()==data)
    			.filter(voo->voo.getReservasFeitas().size()>=100)
    			.toList();
    }
    public double totalArrecadado() {
    	return this.clientes.entrySet()
    			.stream()
    			.map(Map.Entry::getValue)
    			.mapToDouble(Cliente::totalGasto)
    			.sum();
    			
    			
    }
    public void salvarEmpresa() {
    	try {
			FileOutputStream f = new FileOutputStream(new File("empresa.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(this);

			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("empresa.txt"));

			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("arquivo nao encontrado");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }

	public List<Trecho> getTodosOsTrechos() {
		return todosOsTrechos;
	}

	public void addTrecho(Trecho novoTrecho) {
		this.todosOsTrechos.add(novoTrecho);
	}
	public List<Voo> getTodosVoo() {
		return this.todosOsVoo;
	}
}