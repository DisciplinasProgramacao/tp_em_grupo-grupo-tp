import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente>,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2028697186596639059L;
	private String nome;
    private String cpf;
    private Acelerador acelerador=new AceleradorPadrao();
    private List<Bilhete> bilhetes = new ArrayList<Bilhete>();
    private List<Ponto> pontosNaoUsados=new ArrayList<Ponto>();
    private List<Ponto> pontosUsados=new ArrayList<Ponto>();
    private List<Ponto> pontosExpirados=new ArrayList<Ponto>();
    private int bilhetesGratis=0;
    private int bilhetesGratisGerados=0;
    private int periodo;

    /**
     * Metodo construtor Cliente.
     * 
     * @param periodo
     * @param totalPontos
     * @param cpf
     * @param nome
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.periodo = 0;
    }

    public boolean comprarBilhete(Bilhete bilhete) {

        if (bilhete != null) {
            bilhetes.add(bilhete);
            for(Voo voo : bilhete.getReserva()) {
            	voo.reservar(bilhete);
            }
            double pontos=this.acelerador.multiplicar(bilhete);
            Ponto novoPonto=new Ponto(pontos);
            this.pontosNaoUsados.add(novoPonto);
            if(this.verificarPontos()>10500) {
            	while(this.verificarPontos()>10500) {
            	double total=10500;
            	while(total>0) {
            		if(total<this.pontosNaoUsados.get(0).getValor()) {
            			this.pontosNaoUsados.get(0).reduzirValor(total);
            			
            		}
            		else {
            			this.pontosUsados.add(this.pontosNaoUsados.get(0));
            			this.pontosNaoUsados.remove(this.pontosNaoUsados.get(0));
            		}
            		total=this.pontosNaoUsados.size()==0 ? 0 : total-this.pontosNaoUsados.get(0).getValor();
            	}
            	this.bilhetesGratis++;
				this.bilhetesGratisGerados++;
            	}
				
            }
           
        	return true;
        	
    }
        else {
        	return false;
        }
    }
        
        

    /**
     * Verifica o total de pontos do cliente
     * @return  Total de pontos do cliente
     */
    public double verificarPontos() {
    	double total=0;
    	for(Ponto ponto : this.pontosNaoUsados) {
    		if(!ponto.verificarValidade())
    			total=total+ponto.getValor();
    	}
        return total;
    }

    /**
     * Retorna dados de um cliente especifico
     */
    public String toString() {
    	StringBuilder descricao=new StringBuilder();
    	descricao.append("nome="+this.nome);
    	descricao.append("\n");
    	descricao.append("Cpf="+this.cpf);
    	descricao.append("\n");
    	descricao.append(this.periodo);
    	descricao.append("\n");
    	descricao.append("Total de pontos="+this.verificarPontos());
    	descricao.append("\n");
    	descricao.append("Bilhetes gratis="+this.bilhetesGratis);
    	descricao.append("\n");
    	descricao.append("Bilhetes gratis gerados="+this.bilhetesGratisGerados);
    	descricao.append("\n");
    	descricao.append("Bilhetes:");
    	descricao.append("\n");
    	for(Bilhete bilhete : bilhetes) {
    		descricao.append(bilhete.ImprimirBilhete());
        	descricao.append("\n");
    	}
        return descricao.toString();
    }
    public void bilhetesUltimos12Meses() {
    	LocalDate hojeMenos12=LocalDate.now().minusMonths(12);
    	this.bilhetes.stream()
    			.filter(bilhete ->bilhete.getData().isAfter(hojeMenos12))
    			.forEach(bilhete->System.out.println(bilhete.ImprimirBilhete()));
    }
    public void mudarAcelerador(Acelerador novoAcelerador) {
    	this.acelerador=novoAcelerador;
    }

	public int getBilhetesGratis() {
		return bilhetesGratis;
	}

	public void setBilhetesGratis(int bilhetesGratis) {
		this.bilhetesGratis = bilhetesGratis;
	}

	public int getBilhetesGratisGerados() {
		return bilhetesGratisGerados;
	}

	public void setBilhetesGratisGerados(int bilhetesGratisGerados) {
		this.bilhetesGratisGerados = bilhetesGratisGerados;
	}
public double totalPontos12Meses() {
	double total=0;
	for(Ponto ponto : this.pontosNaoUsados) {
		if(ponto.verificarValidade())
		total=total+ponto.getValor();
	}
	for(Ponto ponto : this.pontosUsados) {
		if(ponto.verificarValidade())
		total=total+ponto.getValor();
	}
	return total;
}
public double totalGasto() {
	return this.bilhetes.stream()
			.mapToDouble(Bilhete::CalcularValor)
			.sum();
}
public double totalGasto(LocalDate data) {
	return this.bilhetes.stream()
			.filter(cliente->cliente.getData().isAfter(data))
			.mapToDouble(Bilhete::CalcularValor)
			.sum();
}
	@Override
	public int compareTo(Cliente cliente) {
	return (int) (cliente.totalPontos12Meses()-this.totalPontos12Meses());
	}

	public List<Ponto> getPontosExpirados() {
		return pontosExpirados;
	}

	public void setPontosExpirados(List<Ponto> pontosExpirados) {
		this.pontosExpirados = pontosExpirados;
	}
	public List<Bilhete> getBilhetes(){
		return this.bilhetes;
	}
}
