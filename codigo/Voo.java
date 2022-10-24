public class Voo {
    private static double VALOR_BASE;
    private Data data;
    private Trecho trecho;

    /**
     * Método construtor
     */
    public Voo(Data data, Trecho trecho, double valorBase){
        /**Adicionar verificação de valor valido */
        this.data = data;
        this.trecho = trecho;
        this.VALOR_BASE = valorBase
    }
    
    public void AlterarTrecho(String novaOrigem, String novoDestino){

    }

    public String informacoesDoVoo(){
        return null;
    }
}
