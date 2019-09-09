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
		for(int i=1;i < l1.getLength();i++) { 
			for(int j=1;j< l2.getLength();j++) {
				if(exp[i])
			}
		}
		
	}

}
