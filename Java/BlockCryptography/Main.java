import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int blockindex=0;
		String key="";
		String word="";
		System.out.println("este e um programa que ira cripotgrafar palavras baseado em blocos"); 
		Scanner let=new Scanner(System.in);
		Que q=new Que();
		for(int i=0;true;i++) {
			if(i == 0) { 
				System.out.println("por favor digite a palavra que sera a chave"); 
				key=let.nextLine(); 
				System.out.println("por favor digite o tamanho do bloco de criptografia");
				blockindex=let.nextInt();
			} 
			else {
				System.out.println("escolha uma das opcoes abaixo");
				System.out.println("1-criptografar uma palavra"); 
				System.out.println("2-decriptografar uma palavra"); 
				System.out.println("3-alterar chave");
				System.out.println("4-alterar tamanho bloco");
				System.out.println("5-sair");
				int choice=let.nextInt();
				if(choice == 1 ) {
					word="";
					q.empty(); 
					let.nextLine();
					System.out.println("digite a palavra a ser criptografada"); 
					word=let.nextLine(); 
					q.addCrypt(word, key, blockindex); 
					q.show();
				}
				if(choice == 2) {
					q.empty();
					word=""; 
					let.nextLine();
					System.out.println("digite a palavra a ser decriptografada");
					word=let.nextLine();
					q.addDecrypt(word, key, blockindex);
					q.show();
				}
				if(choice == 3) {
					key=""; 
					let.nextLine();
					System.out.println("por favor digite a nova chave");
					key=let.nextLine();
				}
				if(choice == 4) {
					blockindex=0; 
					System.out.println("por favor digite o novo tamanho do block da chave");
					blockindex=let.nextInt();
				}
				if(choice == 5) {
					break;
				}
			}
		}
		System.out.println("obrigado por usar este programa");
	}
}
