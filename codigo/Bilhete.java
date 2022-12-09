import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Bilhete implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<Voo> reserva;
    private String tipo; // Tipo verificar se precisa
    private LocalDate data=LocalDate.now();
    /**
     * Método construtor
     */
    public Bilhete(Voo v) {
        // this.tipo = tipo;
        this.reserva = new ArrayList<Voo>();
        this.AddVoo(v);
        v.reservar(this);
    }
    public Bilhete() {
        // this.tipo = tipo;
        this.reserva = new ArrayList<Voo>();
    }

    /**
     * Metodo para adicionar voo para uma Array list;
     */
    public void AddVoo(Voo voo) {
        this.reserva.add(voo);
        voo.reservar(this);
    }

    /**
     * Metodo para adicionar voo, recebe o ponteiro de um voo para remove-lo da
     * lista;
     */
    public void RemoverVoo(Voo voo) {
        this.reserva.remove(voo);
    }

    /**
     * Retorna as informa�oes dos voos adicionados;
     */
    public String ImprimirBilhete() {
        StringBuilder reservaDescricao = new StringBuilder();
        for (Voo v : this.reserva) {
            // reservaDescricao.append(" " + v.informacoesDoVoo());
            reservaDescricao.append(" " + v.informacoesDoVoo() + "aa");
        }
        return reservaDescricao.toString();
    }

    /**
     * Retorna o valor total do bilhete que � calculado pelo velor base do bilhete x
     * 1.1 se s� conter 1 elemento e valor do bilhete mais caro + outros bilhetes x
     * 0.5 se tiver mais de 1 elemento. ;
     */
    public double CalcularValor() {
        Comparator<Voo> porPreco = Comparator
                .comparing(Voo::getValorBase);
        this.reserva.sort(porPreco);
        if (this.reserva.size() > 1) {
            double total = this.reserva.get(0).getValorBase();
            for (int count = 1; count <= this.reserva.size() - 1; count++) {
                total = total + this.reserva.get(count).getValorBase() * 0.5;
            }
            return total;
        } else if (this.reserva.size() == 0)
            return 0;
        return this.reserva.get(0).getValorBase() * 1.1;

    }

    /**
     * Gera ponto usando o calcular valor e multiplica por 500 o piso da divis�o
     * deste por 500;
     */
    public int GerarPontos() {
        return Math.floorDiv((int) CalcularValor(), 500) * 500;
    }

    public String getTIPO() {
        return this.tipo;
    }



	public void setTIPO(String tipo) {
        this.tipo = tipo;
    }

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<Voo> getReserva(){
		return this.reserva;
	}
}
