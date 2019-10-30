import java.text.Normalizer;
import java.util.regex.Pattern;

public class Crypto {
	public void crypto(String word,String key,int blocksize) {
		//aqui estaciamos a nossa fila que guardarar os blocos
		Que q=new Que();
		char tester;
		//nestas linhas criamos o index para ser o primeiro,para saber qunato as char precisarao ser criptografadas ou decripotgrafadas
		char lowerbeg='a';
		char capsbeg='A';
		int lowerindex=lowerbeg;
		int capsindex=capsbeg; 
		//aqui temos a string block que e o intermediario ou seja
		//ele vai guardar as caracteres anteriores enquanto espera
		//para ser jogado para a fila
		String block="";
		//aqui colocamos todas as palavras com acento,para que estas possam ser transformadas em suas respectivas palavras sem acentos
		String specialletter = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï  ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";
		//aqui temos uma variavel inteira z que indicara a posicao da chave que o bloco ira emfilar
		//por exemplo se for 0 ele ira pegar a primeira posicao para concautear e etc
		int z=0;
		//temos um if para ver se o tamanho do bloco e menor ou maior que a chave
		if(blocksize < key.length()) {
			//aqui percorremos a palavra toda adicionando o numero de blocos necessarios
			for(int i=0;i < word.length();i++) { 
				//aqui vemos se o z e igual o blocksize se for o caso o reniciamos para 0 
				//para ele poder pegar denvo a primeira posicao e assim repetir ate o final da palavra
				if(z == blocksize) { 
					z=0;
				}
				//aqui vemos se esta na ultima interacao,pois se for o caso
				//ele precisara adicionar mesmo se o bloco estiver incompleto
				if(i == word.length() -1) {
					//temos sempre que verificar se o z(o indice da letra da chave) e o ultimo
					//pois se for precisamos dar um substring diferente
					//e tambem pois esse e o momento de empilhalo na pila caso este nao seja o ultimo
					//temos a variavel doer que pega a letra atual da chave e adiciona no bloco ate empilhar
					if(z == blocksize-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
				}
				else {
					//mesma coisa aqui a unica diferenca e que o bloco e apenas empilhado qnd este e o ultimo 
					//da chave, pois nao e o ultimo
					if(z == blocksize-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer;
					}
					//aqui o z(indice de letra do bloco) aumenta a cada iteracao
					z++;
				} 
			}
		} 
		else { 
			//temos a mesma coisa aqui com a unica diferenca de envez de blocksize temos
			//a key.length() pois se o tamanho do bloco e maior que a palavra o bloco e apenas igual a
			//palavra
			for(int i=0;i < word.length();i++) { 
				if(z == key.length()) { 
					z=0;
				}
				if(i == word.length() -1) {
					if(z == key.length()-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
				} 
				else {
					if(z == key.length()-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer;
					} 
				}
				z++;
			} 
		}
		//aqui dizemos o index que vai dizer qual das palavras do block sera a base da criptografacao
		int index=0; 
		//aqui iniciamos o bloco real size com um valor aleatorio pois este sera modificado depois
		int blockrealsize=7878;
		if(blocksize < key.length()) { 
			//aqui igualamos o o blockrealsize ao blocksize
			blockrealsize=blocksize; 
		} 
		else {
			//e aqui a largura da palavra, pois esse e o caso que o blocksize e maior que a palavra
			blockrealsize=key.length();
		}
		//aqui iniciamos a variavel finalword que no final ira ser concautezanada e virara a palavra criptografada
		String finalWord="";
		//aqui iniciamos o currentblock que sera o block atual tirado da fila
		String currentBlock="";
		for(int i=0;i< word.length();i++) { 
			//se o index for igual ao blockreal size ele renicia pra pegar a primeira letra do bloco denovo
			//pois este condicao significa que ele ja atingiu o final do block
			//reniciamos o currentblock pare ele poder pegar o proximo elemento da fila
			if(index == blockrealsize) {
				index=0; 
				currentBlock ="";
			}
			//aqui temos o bloco pegar o elemento da fila
			if(currentBlock == "" ) { 
				currentBlock=q.deQueue();
			}
			//no comeco do loop nos garantimos que o index sempre sera apenas as letras do block que foram definidas no currentblock e com a fila
			//por isso dizemos que se o index for igual ao blockrealsize este voltara a 0 para pegar denovo a primeira letra do currentblock
			//aqui definimos a letra e o tester e a letra do currentblock que sera a base da criptograficacao
			char letter=word.charAt(i); 
			tester=currentBlock.charAt(index);
			//aqui vemos se o o caracter e uma letra que no caso sera criptografado se nao,nao sera
			if(Character.isLetter(letter) && Character.isLetter(tester)) {
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
					//temos o -1 porque precisamos de um representante de 0 para adicioanr a diferenca
					if(ascii > 122) {
						ascii= (lowerindex-1) + (ascii -122);
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
					//temos o -1 porque precisamos de um representante de 0 para adicioanr a diferenca
					if(ascii > 90) {
						ascii= (capsindex-1) + (ascii - 90);
					}
					letter=(char)ascii;
				}
			} 
			else {
				//como simbolos ou espacos nao devem ser criptografados nada aqui acontece
				//nada acontece
			} 
			//aqui a frase final criptografada e concautenada ao final de toda iteracao
			finalWord += letter;
			index++;
		} 
		System.out.println("a palavra criptografada e: " + finalWord);
	} 
	public void Decrypto(String word,String key,int blocksize) {
		//neste comeco e completamente igual ao "crypto"
		// a unica diferenca e mais embaixo
		Que q=new Que();
		char tester;
		//nestas linhas criamos o index para ser o primeiro,para saber qunato as char precisarao ser criptografadas ou decripotgrafadas
		char lowerbeg='a';
		char capsbeg='A';
		int lowerindex=lowerbeg;
		int capsindex=capsbeg;
		String block="";
		//aqui colocamos todas as palavras com acento,para que estas possam ser transformadas em suas respectivas palavras sem acentos
		String specialletter = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï  ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";
		int z=0;
		if(blocksize <= key.length()) {
			for(int i=0;i < word.length();i++) { 
				if(z == blocksize) { 
					z=0;
				}
				if(i == word.length() -1) {
					if(z == blocksize-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
				} 
				else {
					if(z == blocksize-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer;
					} 
				}
				z++;
			} 
		} 
		else { 
			for(int i=0;i < word.length();i++) { 
				if(z == key.length()) { 
					z=0;
				}
				if(i == word.length() -1) {
					if(z == key.length()-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
				} 
				else {
					if(z == key.length()-1) {
						String doer=key.substring(z); 
						block += doer; 
						block=deAccent(block);
						q.queue(block);
						block="";
					}
					else {
						String doer=key.substring(z, z+1);
						block += doer;
					} 
				}
				z++;
			} 
		}
		int index=0;  
		int blockrealsize=7878;
		if(blocksize < key.length()) { 
			blockrealsize=blocksize; 
		} 
		else {
			blockrealsize=key.length();
		}
		String finalWord="";
		String currentBlock="";
		for(int i=0;i< word.length();i++) { 
			if(index == blockrealsize) {
				index=0; 
				currentBlock ="";
			}
			if(currentBlock == "" ) { 
				currentBlock=q.deQueue();
			}
			//no comeco do loop nos garantimos que o index sempre sera apenas as letras do block que foram definidas no blockindex
			//por isso dizemos que se o index for igual ao blockindex este voltara a 0 para pegar denovo a primeira letra do block
			//aqui definimos a letra e o tester e a letra do block que sera a base da criptograficacao
			char letter=word.charAt(i); 
			tester=currentBlock.charAt(index); 
			//aqui vemos se o o caracter e uma letra que no caso sera criptografado se nao,nao sera
			if(Character.isLetter(letter) && Character.isLetter(tester)) {
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
					//como 122 representa z, precisamos do indice maior que ele(123) para saber a real diferenca do alfabeto
					if(ascii < lowerindex) {
						ascii= 123 - Math.abs(ascii - lowerindex);
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
					//como 90 e Z precisamos do maior dele(91) para de fato saber a diferenca
					if(ascii < capsindex) {
						ascii= 91 - Math.abs(ascii - capsindex);
					}
					letter=(char)ascii;
				}
			} 
			else {
				//como simbolos ou espacos nao devem ser decriptografados nada aqui acontece
				//nada acontece
			}
			index++; 
			finalWord += letter;
		} 
		System.out.println("a palavra descriptografada e: " + finalWord);
	} 
	//aqui temos uma classe estatica que basicamente transforma o acento em sua respectiva letra equivalente
	// ex: ã =a
	public static String deAccent(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	} 
	
}
