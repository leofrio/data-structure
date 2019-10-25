import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int blockindex = 0;
        String key = ""; // Chave utilizada para criptografar ou descriptografar
        String word; // Frase a ser criptografada ou descriptografada
        Scanner let = new Scanner(System.in); // Comando utilizado para receber Strings do usuário
        Que q = new Que(); // Instância de uma nova fila
        boolean start = false;

        while(true) {
            if (!start) {
                System.out.println("Digite a chave: ");
                key = let.nextLine();
                System.out.println("Digite o tamanho do bloco: ");
                blockindex = let.nextInt();
                start = true;
            } else {
                System.out.println("Selecione uma operação: " +
                        "\n- 1) Criptografar uma palavra" +
                        "\n- 2) Descriptografar uma palavra" +
                        "\n- 3) Alterar chave" +
                        "\n- 4) Alterar tamanho do bloco" +
                        "\n- 5) Finalizar programa");

                int choice = let.nextInt();
                if (choice == 1) {
                    q.empty();
                    let.nextLine();
                    System.out.println("Digite a frase que será criptografada: ");
                    word = let.nextLine();
                    q.addCrypt(word, key, blockindex);
                    q.show();
                }

                if (choice == 2) {
                    q.empty();
                    let.nextLine();
                    System.out.println("Digite a frase que será descriptografada: ");
                    word = let.nextLine();
                    q.addDecrypt(word, key, blockindex);
                    q.show();
                }

                if (choice == 3) {
                    let.nextLine();
                    System.out.println("Digite a nova chave: ");
                    key = let.nextLine();
                }

                if (choice == 4) {
                    System.out.println("Digite o novo tamanho do bloco: ");
                    blockindex = let.nextInt();
                }

                if (choice == 5) {
                    System.out.println("Finalizando programa...");
                    return;
                }

                if(choice < 1 || choice > 5) {
                    System.out.println("Operação inválida!");
                }
            }
        }
    }
}
