import java.util.Comparator;

public class BilhetePromocional extends Bilhete {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1353127984546912981L;
	private final double PORCENTAGEM_PONTOS = 0.5;
	private final double PORCENTAGEM_VALOR = 0.6;

	public BilhetePromocional(Voo v) {
		super(v);
	}
	public BilhetePromocional() {
	}
	public double CalcularValor() {
		Comparator<Voo> porPreco = Comparator
				.comparing(Voo::getValorBase);
		this.reserva.sort(porPreco);
		if (this.reserva.size() > 1) {
			double total = this.reserva.get(0).getValorBase();
			for (int count = 1; count <= this.reserva.size() - 1; count++) {
				total = total + this.reserva.get(count).getValorBase() * 0.5;
			}
			return total * this.PORCENTAGEM_VALOR;
		} else if (this.reserva.size() == 0)
			return 0;
		return this.reserva.get(0).getValorBase() * 1.1 * this.PORCENTAGEM_VALOR;

	}

	public int GerarPontos() {
		return (int) (Math.floorDiv((int) (CalcularValor()), 500)*500*this.PORCENTAGEM_PONTOS);
	}
}
