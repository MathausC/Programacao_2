package Programacao_2.Lista13;
import java.util.Scanner;

public class Frase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int qPalavras;
        System.out.print("Digite uma frase: ");
        frase = in.nextLine();
        while(!validaFrase(frase)) {
            System.out.println("Frase inválida.");
            System.out.print("Digite uma frase: ");
            frase = in.nextLine();
        }
        qPalavras = contaPalavras(frase);
        System.out.println("A frase '" + frase + "' contem " + qPalavras + " palavras.");

    }

    public static boolean validaFrase(String frase) {
        boolean val = true;
        int tam = frase.length();
        char dig;
        for(int i = 0; i < tam; i++) {
            dig = frase.charAt(i);
            if(!Character.isLetter(dig) && dig != ' ' && dig != '.' && dig != ';' && dig != ',' && dig != '?' && dig != '!') {
                val = false;
                break;
            }
        }
        return val;
    }

    public static int contaPalavras(String frase) {
        int qPal = 0;
        int tam = frase.length();
        char dig;
        char digAnt;
        for(int i = 0; i < tam - 1; i++) {
            digAnt = frase.charAt(i);
            dig = frase.charAt(i+1);
            if(Character.isLetter(digAnt) && !Character.isLetter(dig)) {
                qPal++;
            }
            if(i == tam - 2 && Character.isLetter(digAnt) && Character.isLetter(dig)) {
                qPal++;
            }
        }
        return qPal;
    }
}
