import java.time.LocalDate;

public class Ponto {
private double valor;
private Data data;
Ponto(double valor){
	this.valor=valor;
	 LocalDate today = LocalDate.now();
     this.data=new Data(today.getDayOfMonth(), today.getMonthValue());
}
}
