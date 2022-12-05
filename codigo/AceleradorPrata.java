import java.io.Serializable;

public class AceleradorPrata implements Acelerador,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627097273698882896L;

	@Override
	public double multiplicar(Bilhete bilhete) {
		return bilhete.GerarPontos()*1.5;
	}

}
