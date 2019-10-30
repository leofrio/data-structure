
public class Element {
	private String  block;
	private Element next;
	
	
	
	public Element(String block) {
		super();
		this.block = block;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public Element getNext() {
		return next;
	}
	
	public void setNext(Element next) {
		this.next = next;
	}
	
}
