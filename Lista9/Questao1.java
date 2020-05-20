package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase, fraseMen;
        int vogais = 0, tamanho;
        char letra;
        System.out.print("Digite uma frase: ");
        frase = in.nextLine();
        fraseMen = frase.toLowerCase();
        tamanho = fraseMen.length();
        for(int i = 0; i < tamanho; i++) {
            letra = fraseMen.charAt(i);
            if(letra == 'a' || letra == 'à' || letra == 'á' || letra == 'â' || letra == 'ã' || letra == 'e'
                    || letra == 'é' || letra == 'ê' || letra == 'i' || letra == 'í'||
                    letra == 'o' || letra == 'ó' || letra == 'ô' || letra == 'õ' || letra == 'u' || letra == 'ú') {
                vogais++;
            }
        }
        System.out.println("A frase: '" + frase + "' contem " + vogais + " vogais.");
    }
}
