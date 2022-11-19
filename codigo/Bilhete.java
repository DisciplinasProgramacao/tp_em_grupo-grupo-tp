import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bilhete {
    private List<Voo> reserva;
    private String tipo;
    

    /**
     * MÃ©todo construtor
     */
    public Bilhete(String tipo){
    	this.tipo=tipo;
this.reserva=new ArrayList<Voo>();
    }
    /**
     * Metodo para adicionar voo para uma Array list;
     */
    public void AddVoo(Voo voo){
this.reserva.add(voo);
    }
    /**
     * Metodo para adicionar voo, recebe o ponteiro de um voo para remove-lo da lista;
     */
    public void RemoverVoo(Voo voo){
for(Voo v : this.reserva ) {
	if(v==voo)
		this.reserva.remove(voo);
	
}
    }
    /**
     * Retorna as informaçoes dos voos adicionados;
     */
    public String ImprimirBilhete(){
    	StringBuilder reservaDescricao=new StringBuilder();
    	for(Voo v : this.reserva ) {
    		reservaDescricao.append(" "+v.informacoesDoVoo());
    	}
        return reservaDescricao.toString();
    }
    /**
     * Retorna o valor total do bilhete que é calculado pelo velor base do bilhete x 1.1 se só conter 1 elemento e valor do bilhete mais caro + outros bilhetes x 0.5 se tiver mais de 1 elemento. ;
     */
    public double CalcularValor(){
     	Comparator<Voo> porPreco = Comparator
    			  .comparing(Voo::getValorBase);
     	this.reserva.sort(porPreco);
    	if(this.reserva.size()>1) {
    		double total=0;
    	for(int count=0;count<this.reserva.size()-2;count++) {
    		total=total+this.reserva.get(count).getValorBase()*0.5;
    	}
    	total=total+this.reserva.get(this.reserva.size()-1).getValorBase();
    	}
    	else if(this.reserva.size()==0)
    		return 0;
    	return this.reserva.get(0).getValorBase()*1.1;
        
    }
    /**
     * Gera ponto usando o calcular valor e multiplica por 500 o piso da divisão deste por 500;
     */
    public int GerarPontos(){
        return Math.floorDiv((int) CalcularValor(), 500)*500;
    }

	public String getTIPO() {
		return this.tipo;
	}

	public void setTIPO(String tipo) {
		this.tipo = tipo;
	}
}
