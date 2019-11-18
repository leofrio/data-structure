
public class Element {
	private double num;
	private Element left;
	private Element right; 
	private int counter=0;
	public Element(double num) {
		this.num = num;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public Element getLeft() {
		return left;
	}
	public void setLeft(Element left) {
		this.left = left;
	}
	public Element getRight() {
		return right;
	}
	public void setRight(Element right) {
		this.right = right;
	} 
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public boolean add(double num) {
		if(num == this.num) {
			counter++;
			return false;
		} else if(num < this.num) {
			if(left == null) {
				left=new Element(num);
				left.setCounter(left.getCounter()+ 1);
				return true;
			}
			else { 
				left.add(num);
			}
		} else if(num > this.num) {
			if(right == null) {
				right=new Element(num); 
				right.setCounter(right.getCounter() +1);
				return true;
			} 
			else {
				right.add(num);
			}
		}
		return false;
	} 
	public Element search(double num) {
		Element brand=new Element(num);
		if(this.num == num) {
			brand.setCounter(counter);
			return  brand;
		} else if(num < this.num) {
			if(left == null) {
				return null;
			} 
			else {
				return left.search(num);
			}
		} else if(num > this.num) {
			if(right == null) {
				return null;
			} 
			else {
				return right.search(num);
			}
		}
		return null;
	}
}
