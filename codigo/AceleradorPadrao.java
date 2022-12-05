
public class AceleradorPadrao implements Acelerador {

    @Override
    public double multiplicar(Bilhete bilhete) {
        return bilhete.GerarPontos();
    }

}
