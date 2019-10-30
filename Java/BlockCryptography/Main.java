import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Crypto c=new Crypto();
    	Scanner let=new Scanner(System.in); 
    	String key="";
    	String word="";
    	int blocksize=-4343344;
    	System.out.println("esse e um programa que ira criptografar baseado me chaes de palavras digitadas pelo o usuario");
    	for(int i=0;true;i++) { 
    		if(i ==0) {
    			System.out.println("por favor digite a chave"); 
    			key=let.nextLine(); 
    			System.out.println("por favor digite o tamanho do bloco");
    			blocksize=let.nextInt();
    		}
    		System.out.println("escolha uma das opcoes abaixo"); 
    		System.out.println("1-criptografar uma palavra");
    		System.out.println("2-descriptografar uma palavra");
    		System.out.println("3-alterar a chave");
    		System.out.println("4-alterar o tamanho do bloco");
    		System.out.println("5-sair");
    		int choice=let.nextInt();
    		if(choice == 1) {
    			let.nextLine();
    			System.out.println("digite a palavra a ser criptografada");
    			word=let.nextLine(); 
    			c.crypto(word, key, blocksize);
    		} 
    		if(choice == 2) {
    			let.nextLine();
    			System.out.println("digite a palavra a ser decriptografada");
    			word=let.nextLine(); 
    			c.Decrypto(word, key, blocksize);
    		} 
    		if(choice == 3) {
    			let.nextLine();
    			System.out.println("digite a nova chave");
    			key=let.nextLine();
    		} 
    		if(choice == 4) {
    			System.out.println("digite o novo tamanho do bloco");
    			blocksize=let.nextInt();
    		}
    		if(choice == 5) {
    			break;
    		}
    	}
    	System.out.println("the end");
    }
}
