/**
 * Classe Trecho
 */
public class Trecho {

    // #region atributos
    private int numero;
    private String origem;
    private String destino;

    // #endregion

    /**
     * Método construtor
     */
    public Trecho(int numero, String origem, String destino) {

        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
    }

    /**
     * Retorna a descrição do trecho. Formato:
     * Origem <origem>, destino <destino>, número do Trecho <numero>
     * 
     * @return String no formato indicado.
     */
    public String informacoesDoTrecho() {
        StringBuilder descricao = new StringBuilder("-----\n");
        descricao.append("Origem " + this.origem + ", destino " + this.destino + ", número do trecho " + numero);
        return descricao.toString();
    }
}
