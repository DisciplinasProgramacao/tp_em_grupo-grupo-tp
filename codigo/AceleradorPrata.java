
public class AceleradorPrata implements Acelerador {

	@Override
	public double multiplicar(Bilhete bilhete) {
		return bilhete.GerarPontos()*1.5;
	}

}
