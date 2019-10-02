
package stack;

public class Element {
    private char letter;
    private Element next;  
    public Element(char letter) {
        this.letter=letter;
    }
    public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
    this.letter=letter;
    }
    public Element getNext() {
        return next;
    }
    public void setNext(Element next) {
        this.next=next;
    }
    
}
