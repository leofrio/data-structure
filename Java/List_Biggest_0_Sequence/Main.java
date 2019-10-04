package arnaldo;

import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
			Scanner let=new Scanner(System.in);  
			List l =new List();
			System.out.println("on this program we will tell you the positions of the biggest sequences of 0");
			while(true) {
				System.out.println("type a number to add to the list"); 
				l.addlast(let.nextInt());  
				System.out.print("this is how the list looks right now: " ); 
				l.show(); 
				System.out.println("do you want to add another number to the list?type y for yes and n for no ");
				String choice=let.next(); 
				if(choice.equals("n")) {
					break;
				}
			}
		}
		public static void lfunc(List l) {
			
		}
}
