package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase, fraseMen;
        char caractere, c;
        int letras = 0, tamanho;
        System.out.print("Digite uma frase: ");
        frase = in.nextLine();
        fraseMen = frase.toLowerCase();
        tamanho = fraseMen.length();
        System.out.print("Digite um caractere: ");
        caractere = in.next().charAt(0);
        for(int i = 0; i < tamanho; i++) {
            c = fraseMen.charAt(i);
            if(c == caractere) {
                letras++;
            }
        }
        System.out.println("A frase: '" + frase + "' contem " + letras + " caracteres '" + caractere + "'.");
    }
}
