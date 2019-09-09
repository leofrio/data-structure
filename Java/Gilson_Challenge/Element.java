
public class Element {
	private int coeficiente;
	private int expoente;
	private Element prox; 
	
	public Element(int coeficiente, int expoente) {
		this.coeficiente = coeficiente;
		this.expoente = expoente;
		this.prox = null;
	}
	public int getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(int coeficiente) {
		this.coeficiente = coeficiente;
	}
	public int getExpoente() {
		return expoente;
	}
	public void setExpoente(int expoente) {
		this.expoente = expoente;
	}
	public Element getProx() {
		return prox;
	}
	public void setProx(Element prox) {
		this.prox = prox;
	}
	
}
