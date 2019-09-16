
public class Element {
	private String right="abcdefghijklmnopqrstuvwxyz";
	private char[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int key;
	private char letter; 
	
	public Element(char letter) {
		this.letter = letter;
	}
	private Element next;
	private Element prev; 
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Element getPrev() {
		return prev;
	}
	public void setPrev(Element prev) {
		this.prev = prev;
	}
	public char[] getAlphabet() {
		return alphabet;
	}
	
}
