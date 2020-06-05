package Programacao_2.Lista13;
import java.util.Scanner;

public class Desafio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        System.out.print("Informe um nomes: ");
        nome = in.nextLine();
        while(!validaNome(nome)) {
            System.out.println("Nome inválido.");
            System.out.print("Informe um nomes: ");
            nome = in.nextLine();
        }
        nome = formataNome(nome);
        System.out.println(nome);
    }

    public static boolean validaNome(String nome) {
        boolean val = true;
        char dig;
        int tam = nome.length();
        for(int i = 0; i < tam; i++) {
            dig = nome.charAt(i);
            if(!Character.isSpaceChar(dig) && !Character.isLetter(dig)) {
                val = false;
                break;
            }
        }
        return val;
    }

    public static String formataNome(String nome) {
        char ant = ' ';
        char at;
        int tam = nome.length();
        String nomeF = "";
        for(int i = 0; i < tam; i++) {
            at = nome.charAt(i);
            if(ant == ' ' && at != ' ') {
                nomeF += Character.toUpperCase(at);
            }
            else if(ant != ' ' && at != ' ') {
                nomeF += Character.toLowerCase(at);
            }
            else if(ant != ' ' && at == ' ') {
                nomeF += at;
            }
            ant = at;
        }
        return nomeF;
    }
}
