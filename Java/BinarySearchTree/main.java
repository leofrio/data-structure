import java.util.Scanner;
public class SuperMain {
    public static void main(String[] args) {
        Scanner let= new Scanner(System.in);
        Tree t= new Tree();
        while(true) {
            System.out.println("choose of the options below");
            System.out.println("1-add a number to the binary search tree");
            System.out.println("2-search for a number in the binary search tree");
            System.out.println("3-print the elements of the tree in order");
            System.out.println("4-print the elements of the tree using pre order");
            System.out.println("5-print the elements of the tree using post order");
            System.out.println("6-print the elements of the tree based on levels");
            System.out.println("7-exit");
            int choice=let.nextInt();
            if(choice == 1) {
                System.out.println("please type the number you want to add to the tree");
                double num=let.nextDouble();
                t.add(num);
                System.out.println("the number was added!");
            }
            if(choice == 2) {
                System.out.println("please type the number you want to search in the tree");
                double num=let.nextDouble();
                Element answer=t.search(num);
                if(answer != null) {
                    System.out.println("yes the number " + answer.getNum() + " is in the trees and theres " + answer.getCounter() + " of them ");
                }
                else {
                    System.out.println("no, the nummber "+ num +" is not on the tree");
                }
            }
            if(choice == 3) {
                t.printOrder();
            }
            if(choice == 4) {
                t.printPre();
            }
            if(choice == 5) {
                t.printPost();
            }
            if(choice == 6) {
                //this one is wrong as of now
                t.printLevel();
            }
            if(choice == 7) {
                break;
            }
        }
        System.out.println("well you left the program congratulations");
    }

}
