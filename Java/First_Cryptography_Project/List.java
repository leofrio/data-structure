
public class List {
	private Element first;
	private Element last;
	private int key;
	public List() {
		first=null;
		last=null;
	} 
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void add(char a) {
		Element brand=new Element(a); 
		brand.set
		if(first==null) {
			first=brand;
			first.setNext(null);
			first.setPrev(null);
			last=first;
		} 
		else {
			last.setNext(brand);
			brand.setPrev(last);
			brand.setNext(null);
			last=brand;
		}
	}
}
