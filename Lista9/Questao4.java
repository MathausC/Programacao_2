package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String frase;
        String fraseCrip = "";
        int tamanho;
        char letra;
        System.out.print("Digite uma frase a ser criptografada: ");
        frase = in.nextLine();
        tamanho = frase.length();
        for(int i = 0; i < tamanho; i++) {
            letra = frase.charAt(i);
            switch (letra){
                case 'a': letra = '@'; break;
                case 'e': letra = '$'; break;
                case 'i': letra = '&'; break;
                case 'o': letra = '*'; break;
                case 'u': letra = '#';break;
                default: letra = letra; break;
            }
            fraseCrip += letra;
        }
        System.out.println("Sua frase criptografada é: " + fraseCrip);

    }
}
