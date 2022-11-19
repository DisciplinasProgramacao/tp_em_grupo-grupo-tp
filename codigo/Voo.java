public class Voo {
    private double valorBase;
    private Data data;
    private Trecho trecho;

    /**
     * Método construtor
     */
    public Voo(Data data, Trecho trecho, double valorBase){
        /**Adicionar verificação de valor valido */
        this.data = data;
        this.trecho = trecho;
        this.valorBase=valorBase;
    }
    
    public void AlterarTrecho(String novaOrigem, String novoDestino){

    }

    public String informacoesDoVoo(){
        return null;
    }

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}
}
