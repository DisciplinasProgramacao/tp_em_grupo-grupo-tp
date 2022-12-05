import java.io.Serializable;

public class AceleradorPreto implements Acelerador,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7409885671289559576L;

	@Override
	public double multiplicar(Bilhete bilhete) {
		return bilhete.GerarPontos()*1.25;
	}

}
