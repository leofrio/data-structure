
public class Tree {
	private Element root;

	public Tree() {
		this.root=null;
	}
	public boolean add(double num) { 
		if(root == null) {
			root=new Element(num); 
			root.setCounter(root.getCounter() + 1);
			return true;
		} 
		else {
			return root.add(num);
		}
	} 
	public Element search(double num){
		if(root == null) { 
			return null;
		}
		else {
			if(root.getNum() == num) { 
				return root;
			}
			else{ 
				return root.search(num);
			}
		}
	}
	
	 
}
