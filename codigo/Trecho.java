import java.io.Serializable;

/**
 * Classe Trecho
 */
public class Trecho implements Serializable {

    // #region atributos
    private int numero;
    private String origem;
    private String destino;

    // #endregion

    /**
     * Método construtor
     * 
     * @param numero  Número do trecho
     * @param origem  Aeroporto de origem
     * @param destino Aeroporto de destino
     */
    public Trecho(int numero, String origem, String destino) {

        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
    }

    /**
     * Retorna a descrição do trecho. Formato:
     * <numero>-<origem> para <destino>.
     * 
     * @return String no formato indicado.
     */
    public String informacoesDoTrecho() {
        StringBuilder descricao = new StringBuilder("-----\n");
        descricao.append(this.numero + "-" + this.origem + " para " + this.destino);
        return descricao.toString();
    }
    public String getDestino() {
    	return this.destino;
    }
    public String getOrigem() {
    	return this.origem;
    }
}
