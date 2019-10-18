import java.text.Normalizer;
import java.util.regex.Pattern;

public class Que { 
	private Element first;
	private Element last;
	private int length=0; 
	private String key;
	private int blocksize;
	private String block;
	public int size() {
		return length;
	}
	
	//aqui pedimos como paramentro a palavra,a chave e o tamnho do bloco
	public void addCrypt(String word,String key,int blocksize) {
		char tester;
		//nestas linhas criamos o index para ser o primeiro,para saber qunato as char precisarao ser criptografadas ou decripotgrafadas
		char lowerbeg='a';
		char capsbeg='A';
		int lowerindex=lowerbeg;
		lowerindex -= 1; 
		int capsindex=capsbeg;
		capsindex -= 1; 
		//aqui colocamos todas as palavras com acento,para que estas possam ser transformadas em suas respectivas palavras sem acentos
		String specialletter = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ğ Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü İ Ş ß à á â ã ä å æ ç è é ê ë ì í î ï  ğ ñ ò ó ô õ ö ø ù ú û ü ı ş ÿ ";
		//aqui reniciamos o block para caso se for adicionado tudo outra vez este nao seja o mesmo
		block="";
		this.blocksize=blocksize;
		this.key=key;  
		key=deAccent(key);
		//aqui dizemos o index que vai dizer qual das palavras do block sera a base da criptografacao
		int index=0;
		for(int i=0;i < blocksize;i++) { 
			//aqui cautatectamos a string bloco para que essa seja fisica e constante durante o processo da criptograficacao 
				block += key.substring(i, i+1);
		}
		for(int i=0;i< word.length();i++) {
			//no comeco do loop nos garantimos que o index sempre sera apenas as letras do block que foram definidas no blockindex
			//por isso dizemos que se o index for igual ao blockindex este voltara a 0 para pegar denovo a primeira letra do block
			if(index == blocksize) {
				index=0;
			}
			//aqui definimos a letra e o tester e a letra do block que sera a base da criptograficacao
			char letter=word.charAt(i); 
			tester=block.charAt(index);
			//aqui vemos se o o caracter e uma letra que no caso sera criptografado se nao,nao sera
			if(Character.isLetter(letter)) {
				for(int j=0; j < specialletter.length();j++) {
					//aqui vemos se a letra e uma letra com acento
					if(letter == specialletter.charAt(j)) {
						String aux=Character.toString(letter); 
						//se for chamamos a classe estatica deaccent que basicamente tira o acento da palavra
						aux=deAccent(aux); 
						letter=aux.charAt(0);
					} 
				}
				//aqui vemos se a letra e maiuscula ou minuscula
				if(Character.isLowerCase(letter)) { 
					
					//aqui convertemos a char para a tebela ascii
					int ascii=letter;
					//aqui convertemos o tester a tabela ascii e o transformamos para letra minuscula
					int testerasc=Character.toLowerCase(tester);
					//aqui vemos quanto que a palavra precisa ser criptografada vendo sua distancia da posicao 0
					int amount=testerasc - lowerindex;
					ascii += amount; 
					//122 e o representante de z na tabela ascii por isso se este passar dessas fazemos com que ela volte ao a e adicione oque a diferenca
					if(ascii > 122) {
						ascii= (lowerindex) + (ascii -122);
					}
					//aqui convertemos o numero em tabela ascii de volta para a char letter
					letter=(char)ascii;
				} 
				else {
					//a mesma coisa vai para a maiuscula com a diferenca que seu index e o caps index
					//aqui convertemos o tester a tabela ascii e o transformamos para letra maiuscula
					int testerasc=Character.toUpperCase(tester);
					int ascii=letter; 
					int amount=testerasc - capsindex;
					ascii += amount; 
					//e que o 90 representa o Z na tabela ascii, por isso qnd chega nele esta volta ao A e adicione a diferenca
					if(ascii > 90) {
						ascii= (capsindex) + (ascii - 90);
					}
					letter=(char)ascii;
				}
			} 
			else {
				//como simbolos ou espacos nao devem ser criptografados nada aqui acontece
				//nada acontece
			}
			//aqui basicamente e a estrutura basica da fila, e a fila ja adiciona a letra criptografada
			Element brand=new Element(letter);
			if(first == null) {
				
				first=brand;
				last=brand;
			} 
			else {
				last.setNext(brand);
				last=brand;
			} 
			index++;
			length++; 
		}
	}  
	//aqui pedimos como paramentro a palavra,a chave e o tamnho do bloco
		public void addDecrypt(String word,String key,int blocksize) {
			char tester;
			//nestas linhas criamos o index para ser o primeiro,para saber qunato as char precisarao ser criptografadas ou decripotgrafadas
			char lowerbeg='a';
			char capsbeg='A';
			int lowerindex=lowerbeg;
			lowerindex -= 1; 
			int capsindex=capsbeg;
			capsindex -= 1; 
			//aqui colocamos todas as palavras com acento,para que estas possam ser transformadas em suas respectivas palavras sem acentos
			String specialletter = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğñòóôõöøùúûüışÿ";
			//aqui reniciamos o block para caso se for adicionado tudo outra vez este nao seja o mesmo
			block="";
			this.blocksize=blocksize;
			this.key=key; 
			key=deAccent(key);
			//aqui dizemos o index que vai dizer qual das palavras do block sera a base da criptografacao
			int index=0;
			for(int i=0;i < blocksize;i++) { 
				//aqui cautatectamos a string bloco para que essa seja fisica e constante durante o processo da criptograficacao
				block += key.substring(i, i+1);
			}
			for(int i=0;i< word.length();i++) {
				//no comeco do loop nos garantimos que o index sempre sera apenas as letras do block que foram definidas no blockindex
				//por isso dizemos que se o index for igual ao blockindex este voltara a 0 para pegar denovo a primeira letra do block
				if(index == blocksize) {
					index=0;
				}
				//aqui definimos a letra e o tester e a letra do block que sera a base da criptograficacao
				char letter=word.charAt(i); 
				tester=block.charAt(index); 
				//aqui vemos se o o caracter e uma letra que no caso sera criptografado se nao,nao sera
				if(Character.isLetter(letter)) {
					for(int j=0; j < specialletter.length();j++) {
						//aqui vemos se a letra e uma letra com acento
						if(letter == specialletter.charAt(j)) {
							String aux=Character.toString(letter); 
							//se for chamamos a classe estatica deaccent que basicamente tira o acento da palavra
							aux=deAccent(aux); 
							letter=aux.charAt(0);
						} 
					}
					//aqui vemos se a letra e maiuscula ou minuscula
					if(Character.isLowerCase(letter)) { 
						//aqui convertemos o tester a tabela ascii e o transformamos para letra minuscula
						int testerasc=Character.toLowerCase(tester);
						//aqui convertemos a char para a tebela ascii
						int ascii=letter;  
						//aqui vemos quanto que a palavra precisa ser decriptografada vendo sua distancia da posicao 0
						int amount=testerasc - lowerindex;
						ascii -= amount; 
						//122 e o representante de z na tabela ascii por isso se este passar do A este volta para o z e adiciona a diferenca
						if(ascii < lowerindex+1) {
							ascii= 122 - Math.abs(ascii - lowerindex);
						}
						//aqui convertemos o numero em tabela ascii de volta para a char letter
						letter=(char)ascii;
					} 
					else {
						//aqui convertemos o tester a tabela ascii e o transformamos para letra maiuscula
						int testerasc=Character.toUpperCase(tester);
						//a mesma coisa vai para a maiuscula com a diferenca que seu index e o caps index
						int ascii=letter; 
						int amount=testerasc - capsindex;
						ascii -= amount; 
						//e que o 90 representa o Z na tabela ascii, por isso quando se passa do A este volta para o Z e adiciona a diferenca
						if(ascii < capsindex+1) {
							ascii= 90 - Math.abs(ascii - capsindex);
						}
						letter=(char)ascii;
					}
				} 
				else {
					//como simbolos ou espacos nao devem ser decriptografados nada aqui acontece
					//nada acontece
				}
				//aqui basicamente e a estrutura basica da fila, e a fila ja adiciona a letra criptografada
				Element brand=new Element(letter);
				if(first == null) {
					
					first=brand;
					last=brand;
				} 
				else {
					last.setNext(brand);
					last=brand;
				} 
				index++;
				length++; 
			}
		}
	public void show() {
		if(first == null) {
			System.out.println("the stack is empty please add number to it");
		}
		else { 
			Element aux=first;
			while(aux != null) {  
				System.out.print(aux.getLetter());
				aux=aux.getNext();
			} 
			System.out.println("");
		}
	}
	public void remove() {
		if(first == null) {
			System.out.println("the queue is empty please add a string to it");
		}
		else {
			first=first.getNext();
			length--;
		}		
	} 
	public void empty() {
		first=null; 
		length=0;
	} 
	public static String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
