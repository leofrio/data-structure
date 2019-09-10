
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner let=new Scanner(System.in);
		Lista l1=new Lista();
		Lista l2=new Lista();
		Lista l3=new Lista();
		System.out.println("nesse programa voce fornecerar dois polinomios e daremos a soma dele");
		for(int i=0;true;i++) {
			System.out.println("digite o coeficiente do termo do primeiro polinomio");
			int coef=let.nextInt();
			System.out.println("digite o expoente do coeficiente " + coef);
			int exp=let.nextInt();
			l1.add(coef, exp);
			System.out.println("deseja inserir outro termo?digite sim para digitar e nao(sem acento) para parar");
			String ans=let.next();
			if(ans.equals("nao")) { 
				break;
			}
		}
		System.out.println("agora vamos para o segundo polinomio"); 
		for(int i=0;true;i++) {
			System.out.println("digite o coeficiente do termo do segundo polinomio");
			int coef=let.nextInt();
			System.out.println("digite o expoente do coeficiente " + coef);
			int exp=let.nextInt();
			l2.add(coef, exp);
			System.out.println("deseja inserir outro termo?digite sim para digitar e nao(sem acento) para parar");
			String ans=let.next();
			if(ans.equals("nao")) { 
				break;
			} 
		}  
		for(int i=1;i <= l1.getLength();i++) {  
			int counter=0;
			for(int j=1;j <= l2.getLength();j++) {
				if(l1.get(i).getExpoente() == l2.get(j).getExpoente()) {
					l1.get(i).setCoeficiente(l1.get(i).getCoeficiente() + l2.get(j).getCoeficiente()); 
					counter++;
					
				} 
			}
			if(counter ==0) {  
				l1.get(i).setCoeficiente(l1.get(i).getCoeficiente());
				l1.get(i).setExpoente(l1.get(i).getExpoente());
			}
		}
		for(int j=1;j <= l2.getLength();j++) {
			for(int i=1;i <= l1.getLength();i++) {
				if(l2.get(j).getExpoente() == l1.get(i).getExpoente()) {
					break;
				} 
				if(i == l1.getLength()) {
					l1.add(l2.get(j).getCoeficiente(), l2.get(j).getExpoente()); 
					break;
				}
			}
		}
		for(int i =1;i <= l1.getLength();i++) {  
			if(l1.get(i).getExpoente() == 0) {  
				System.out.print(l1.get(i).getCoeficiente());
			} 
			else {
				if(i == l1.getLength()) {
					System.out.print(l1.get(i).getCoeficiente() + "x^" + l1.get(i).getExpoente() );
				} 
				else {
					if(l1.get(i).getExpoente() == 1) {
						System.out.print(l1.get(i).getCoeficiente() + "x" + " +");
					} 
					else {
						System.out.print(l1.get(i).getCoeficiente() + "x^" + l1.get(i).getExpoente() + " +");
					}
				}
			}	
		}
		
	} 

}
