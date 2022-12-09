
public class BilheteFidelidade extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576135948521175457L;
	public BilheteFidelidade(Voo v) {
		super(v);
	}
	public BilheteFidelidade() {
	}
	@Override
	public int GerarPontos(){
        return 0;
    }
	@Override
	public double CalcularValor(){
	    	return 0;
	        
	    }

}
