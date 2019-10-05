public class List {
	private Element first; 
	private Element last; 
	private int length=0; 
	
	public Element getFirst() {
		return first;
	}
	public void setFirst(Element first) {
		this.first = first;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void addlast(int number) {
		Element brand=new Element(number);
		if(first == null) {
			first=brand;
			last=brand; 
			brand.setNext(null);
		} 
		else {
			last.setNext(brand);
			last=brand;
			last.setNext(null);
		} 
		length++;
	} 
	
	public void show() { 
		Element aux;
		if(first== null) {
		System.out.println("list is empty, please fill it up!");
		}
		else {
			aux=first;
			while(aux != null) { 
				System.out.print(aux.getNumber());
				aux=aux.getNext();
			}
			System.out.println("");
		}
	}
	
	public Element get(int pos) {
		Element aux=first;
		int i=1; 
		while(i < pos) {
			aux=aux.getNext();
			i++;
		}
		return aux;		
	}
}
