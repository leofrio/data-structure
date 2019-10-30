import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Crypto c = new Crypto();
            Scanner let = new Scanner(System.in);
            String key = "";
            String word = "";
            int blocksize =- 1;
            for (int i = 0; true; i++) {
                if(i == 0) {
                    System.out.println("Digite a chave para criptografar ou descriptografar: ");
                    key=let.nextLine();
                    System.out.println("Digite o tamanho do bloco: ");
                    blocksize=let.nextInt();
                }

                System.out.println("Selecione uma operação: " +
                        "\n- 1) Criptografar uma frase" +
                        "\n- 2) Descriptografar uma frase" +
                        "\n- 3) Alterar a chave" +
                        "\n- 4) Alterar o tamanho do bloco" +
                        "\n- 5) Finalizar programa");
                int choice = let.nextInt();
                if(choice == 1) {
                    let.nextLine();
                    System.out.println("Digite a frase que será criptografada: ");
                    word = let.nextLine();
                    c.crypto(word, key, blocksize);
                } else if(choice == 2) {
                    let.nextLine();
                    System.out.println("Digite a frase que será descriptografada: ");
                    word = let.nextLine();
                    c.Decrypto(word, key, blocksize);
                } else if(choice == 3) {
                    let.nextLine();
                    System.out.println("Digite a nova chave: ");
                    key = let.nextLine();
                } else if(choice == 4) {
                    System.out.println("Digite o novo tamanho do bloco: ");
                    blocksize = let.nextInt();
                } else if(choice == 5) {
                    break;
                } else {
                    System.out.println("Operação Inválida!");
                }
            }
        }
    }
