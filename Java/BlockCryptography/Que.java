public class Que { 
	private Element first;
	private Element last;
	private int length=0; 
	public int size() {
		return length;
	}
		public void queue(String block) {
			Element brand=new Element(block);
			if(first == null) {
				first=brand;
				last=brand;
			} 
			else {
				last.setNext(brand);
				last=brand;
			} 
			length++; 
		}
	public String deQueue() {
		if(first == null) {
			return "{}?><>?_+}{}?>>?<";
		}
		else {
			Element saver=first;
			first=first.getNext(); 
			length--;
			return saver.getBlock();
		}		
	} 
	public boolean empty() {
		if(first == null) {
			return true;
		}
		else {
			return false;
		}
	}   
	 
}
