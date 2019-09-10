
public class Lista {
	Element primeiro;
	Element ultimo; 
	private int length;  
	private Element element; 
	public Lista() {
		this.primeiro=null;
		this.ultimo=null;
		this.length=0;
	} 
	
	public int getLength() {
		return length;
	}

	public Element getElement() {
		return element;
	}

	public void add(int coeficiente,int expoente) {
		Element brand= new Element(coeficiente,expoente);
		if(primeiro == null) { 
			primeiro=brand;
			ultimo=brand;
			ultimo.setProx(null);
		}
		else {
			Element aux=primeiro;
			Element ant=null; 
			while(aux != null && expoente < aux.getExpoente()) {
				ant=aux;
				aux=aux.getProx();
			}
			if(aux == primeiro) { 
				brand.setProx(primeiro);
				primeiro=brand;
				
			} else if(aux == null) { 
				ultimo.setProx(brand);
				ultimo=brand;
				ultimo.setProx(null);
			}
			else { 
				ant.setProx(brand);
				brand.setProx(aux);
			}
		} 
		length++;
	}
	public Element get(int pos) {
		
		Element aux = primeiro;
		
		int i = 1;
		
		while(i < pos){
			
			aux = aux.getProx();
			i++;
		} 
		return aux;
	}
}
