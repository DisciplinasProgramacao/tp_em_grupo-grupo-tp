import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7554396851148570657L;
	// #region atributos
    private double valorBase;
    private LocalDate data=LocalDate.now();
    private Trecho trecho;
    private List<Bilhete> reservasFeitas=new ArrayList<Bilhete>();

    // #endregion

    /**
     * Método construtor
     * 
     * @param data      Data de partida do voo
     * @param trecho    Trecho percorrido pelo voo
     * @param valorBase Valor base do voo
     */
    public Voo(LocalDate data, Trecho trecho, double valorBase) {

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
    public void reservar(Bilhete bilhete) {
    	this.reservasFeitas.add(bilhete);
    }
    public String informacoesDoVoo() {
        StringBuilder informacoes = new StringBuilder("-----\n");
        Data novaData=new Data(this.data.getDayOfMonth(),this.data.getMonthValue(),this.data.getYear());
        informacoes.append(
                this.trecho.informacoesDoTrecho() + " em " + novaData.dataFormatada() + "\n Valor base-" + valorBase);
        return informacoes.toString();
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    public Trecho getTrecho() {
    	return this.trecho;
    }
    public LocalDate getData() {
    	return this.data;
    }
    public List<Bilhete> getReservasFeitas(){
    	return this.reservasFeitas;
    }
}
