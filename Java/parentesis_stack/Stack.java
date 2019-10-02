package stack;

public class Stack {
    private Element top=null;
    private boolean error=false; 
    public boolean getError() {
        return error;
    }  
    
    public void setError(boolean error) {
		this.error = error;
	}

	public Element getTop() {
        return top;
    }
    public void push(char letter) {
        Element brand=new Element(letter); 
        if(letter == '(') {
            brand.setNext(top); 
            top=brand; 
        } 
        if(letter == ')') {
            error = !pop();
        }
    } 
    public boolean pop() {
        if(top == null) {
            return false; 
            
        }
        else {
            top=top.getNext();
            return true;
        } 
    }
}
