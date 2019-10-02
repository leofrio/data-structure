
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack s=new Stack();
        Scanner let= new Scanner(System.in);  
        		System.out.println("digite a expressao");
                String word=let.nextLine();
                for(int i=0;i < word.length();i++) {
                    s.push(word.charAt(i));
                    if(s.getError() ==true) { 
                        break;
                    }
                }
                if(s.getError() == true || s.getTop() != null) {
                    if(s.getError() ==true) {
                        System.out.println("solucao errada pois viola a condicao 2(nao a parentesis de fechar para todos os de abrir)");
                    }
                    else {
                        System.out.println("solucao errada pois viola a condicao 1(numero de parentesis de fechar e abrir nao iguais)");
                    }
                } 
                else {
                    System.out.println("expressao correta pois nao contem erros de parentesis");
                } 
	}
}
