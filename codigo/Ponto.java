import java.io.Serializable;
import java.time.LocalDate;

public class Ponto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2981102824839390982L;
	private double valor;
	private LocalDate data;
	Ponto(double valor){
	 this.valor=valor;
	 this.data = LocalDate.now();
}
	public boolean verificarValidade() {
		LocalDate hojeMenos12=LocalDate.now().minusMonths(12);
		if(data.isAfter(hojeMenos12)) {
			return false;
		}
		return true;
}
	public double getValor() {
		return valor;
}
	public double reduzirValor(double valor) {
	this.valor = this.valor-valor;
	return this.valor;
}
}