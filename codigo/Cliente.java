import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private Acelerador acelerador=new AceleradorPadrao();
    private List<Bilhete> bilhetes = new ArrayList<Bilhete>();
    private double totalPontos;
    private int periodo; // Verificar se não tem que ser double ou data

    /**
     * Metodo construtor Cliente.
     * 
     * @param periodo
     * @param totalPontos
     * @param cpf
     * @param nome
     */
    public Cliente(String nome, String cpf, int totalPontos, int periodo) {
        this.nome = nome;
        this.cpf = cpf;
        this.totalPontos = 0;
        this.periodo = 0; // Verificar oque é esse perido.
    }

    public boolean comprarBilhete(Bilhete bilhete) {

        if (bilhete != null) {
            bilhetes.add(bilhete);
            this.totalPontos=this.totalPontos+this.acelerador.multiplicar(bilhete);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Verifica o total de pontos do cliente
     * @return  Total de pontos do cliente
     */
    public double verificarPontos() {
        return this.totalPontos;
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
    	descricao.append("Total de pontos="+this.totalPontos);
    	descricao.append("\n");
    	descricao.append("Bilhetes:");
    	descricao.append("\n");
    	for(Bilhete bilhete : bilhetes) {
    		descricao.append(bilhete.ImprimirBilhete());
        	descricao.append("\n");
    	}
        return descricao.toString();
    }
    public void mudarAcelerador(Acelerador novoAcelerador) {
    	this.acelerador=novoAcelerador;
    }
}
