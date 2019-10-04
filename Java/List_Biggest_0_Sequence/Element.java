package arnaldo;

public class Element {
	private int number;
	private Element next;
	
	public Element(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	} 
	
}
