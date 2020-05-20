package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        char ch;
        boolean validadeNome;
        System.out.print("Digite um nome: ");
        nome = in.nextLine();
        validadeNome = checkNome(nome);
        while (!validadeNome) {
            System.out.println("Nome inválido.");
            System.out.print("Digite um nome válido: ");
            nome = in.nextLine();
            validadeNome = checkNome(nome);
        }
        nome = nome.toUpperCase();
        System.out.println("O nome digitado é: " + nome);
    }

    public static boolean checkNome(String nome) {
        char ch;
        boolean valido = true;
        int tamanho = nome.length();
        for(int i = 0; i < tamanho; i++) {
            ch = nome.charAt(i);
            if(!Character.isLetter(ch) && !Character.isSpaceChar(ch)) {
                valido = false;
                break;
            }
        }
        return valido;
    }
}
