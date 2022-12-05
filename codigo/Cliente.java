import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private static List<Bilhete> bilhetes = new ArrayList<Bilhete>();
    private int totalPontos;
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

    public boolean comprarBilhete(Voo v) {

        if (v != null) {
            Bilhete novoBilhete = new Bilhete(v);
            bilhetes.add(novoBilhete);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Verifica o total de pontos do cliente
     * @return  Total de pontos do cliente
     */
    public int verificarPontos() {
        return this.totalPontos;
    }

    /**
     * Retorna dados de um cliente especifico
     */
    public String toString() {
        return this.nome;
    }
}
