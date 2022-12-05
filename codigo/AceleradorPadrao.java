import java.io.Serializable;

public class AceleradorPadrao implements Acelerador,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6288594730278681697L;

	@Override
	public double multiplicar(Bilhete bilhete) {
		return bilhete.GerarPontos();
	}

}
