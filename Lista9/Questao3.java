package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        int letras = 0, digitos = 0, espacos = 0, simbolos = 0, tamanho;
        char letra;
        System.out.print("Digite uma frase: ");
        frase = in.nextLine();
        tamanho = frase.length();
        for(int i = 0; i < tamanho; i++) {
            letra = frase.charAt(i);
            if(Character.isLetter(letra)) {
                letras++;
            }
            else if(Character.isDigit(letra)) {
                digitos++;
            }
            else if(Character.isSpaceChar(letra)) {
                espacos++;
            }
            else {
                simbolos++;
            }
        }
        System.out.println("A frase: '" + frase + "' contém " + letras + " letras, " + digitos + " dígitos, "
        + espacos + " espaços em branco e " + simbolos + " símbolos.");
    }
}
