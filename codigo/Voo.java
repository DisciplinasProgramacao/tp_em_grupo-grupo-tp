
public class Voo {
    // #region atributos
    private double valorBase;
    private Data data;
    private Trecho trecho;

    // #endregion

    /**
     * Método construtor
     * 
     * @param data      Data de partida do voo
     * @param trecho    Trecho percorrido pelo voo
     * @param valorBase Valor base do voo
     */
    public Voo(Data data, Trecho trecho, double valorBase) {

        this.data = data;
        this.trecho = trecho;
        this.valorBase = valorBase;
    }

    /**
     * Altera o trecho do voo
     * 
     * @param numero      Número do trecho
     * @param novaOrigem  Aeroporto de origem
     * @param novoDestino Aeroporto de destino
     */
    public void AlterarTrecho(int numero, String novaOrigem, String novoDestino) {
        this.trecho = new Trecho(numero, novaOrigem, novoDestino);
    }

    /**
     * Retorna a descrição do voo. Formato:
     * <numero>-<origem> para <destino> em <data>.
     * valor base-<valorBase>
     * 
     * @return String no formato indicado.
     */
    public String informacoesDoVoo() {
        StringBuilder informacoes = new StringBuilder("-----\n");
        informacoes.append(
                this.trecho.informacoesDoTrecho() + " em " + data.dataFormatada() + "\n Valor base-" + valorBase);
        return informacoes.toString();
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
}
