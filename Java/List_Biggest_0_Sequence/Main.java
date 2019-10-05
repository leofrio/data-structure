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
			System.out.print("this is the list: ");
			l.show(); 
			lfunc(l);
		}
		public static void lfunc(List l) {
			int counter=0;
			int posi=0;
			int posf=0;
			int biggest=0;
			int initial=0;
			int finale=0;
			for(int i =1;i < l.getLength();i++) {
				int current=l.get(i).getNumber();
				if(current == 0) {
					if(counter == 0) {
						initial=i;
					} 
					else {
						finale=i; 
					} 
					counter++;
				}
				else {
					counter=0;
				} 
				if(counter >= biggest) {
					biggest=counter; 
					posi=initial;
					posf=finale;
				}
			} 
			System.out.println("remember the first position is 1 not 0");
			System.out.println("the initial postion of the biggest zero sequence is " + posi);
			System.out.println("the final postion of the biggest zero sequence is " + posf); 
		}
}
