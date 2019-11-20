
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
    public void printPre() {
        System.out.print(root.getNum() + ", ");
        if(root.getLeft() != null) {
            root.getLeft().printPre();
        }
        if(root.getRight() != null) {
            root.getRight().printPre();
        }
    }
    public void printOrder() {
        if(root.getLeft() != null ) {
            root.getLeft().printOrder();
        }
        System.out.print(root.getNum() + ", ");
        if(root.getRight() != null) {
            root.getRight().printOrder();
        }
    }
    public void printPost() {
        if(root.getLeft() != null) {
            root.getLeft().printPost();
        }
        if(root.getRight() != null) {
            root.getRight().printPost();
        }
        System.out.print(root.getNum() + ", ");
    }
    public void printLevel() {
        System.out.print(root.getNum() + ", ");
        boolean left=false;
        boolean right=false;
        if(root.getLeft() != null) {
            System.out.print(root.getLeft().getNum() + ", ");
            left=true;
        }
        if(root.getRight() != null) {
            System.out.print(root.getRight().getNum() + ", ");
            right=true;
        }
        if(left) {
            root.getLeft().printLeveldoer(false);
        }
        if(right){
            root.getRight().printLeveldoer(false);
        }
        if(left) {
            root.getLeft().printLeveldoer(true);
        }
        if(right) {
            root.getRight().printLeveldoer(true);
        }
    }
}

