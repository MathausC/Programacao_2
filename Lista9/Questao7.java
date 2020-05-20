package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fraseA, fraseB;
        System.out.print("Digite uma sequencia de caracteres: ");
        fraseA = in.nextLine();
        System.out.print("Digite mais uma sequencia de caracteres: ");
        fraseB = in.nextLine();
        if(compararStrings(fraseA, fraseB)) {
            System.out.println("As sequencias são idênticas.");
        }
        else {
            System.out.println("As sequências não são identicas.");
        }
    }
    public static boolean compararStrings(String a, String b) {
        boolean validade = true;
        String aMen = a.toLowerCase();
        String bMen = b.toLowerCase();
        int tamanhoA = aMen.length();
        int tamanhoB = bMen.length();
        if(tamanhoA == tamanhoB) {
            char letraA;
            char letraB;
            for(int i = 0; i < tamanhoA; i++) {
                letraA = aMen.charAt(i);
                letraB = bMen.charAt(i);
                if(letraA != letraB) {
                    validade = false;
                    break;
                }
            }
        }
        else {
            validade = false;
        }
        return validade;
    }
}

