package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cpf;
        System.out.print("Informe o CPF: ");
        cpf = in.next();
        while (!checaCPF(cpf)) {
            System.out.println("CPF inválido.");
            System.out.print("Informe o CPF: ");
            cpf = in.next();
        }
        cpf = formataCPF(cpf);
        System.out.println("O CPF é: " + cpf);
    }

    public static boolean checaCPF(String cpf) {
        boolean validade = true;
        int tamanho = cpf.length();
        char digito;
        if(tamanho != 11) {
            validade = false;
        }
        else {
            for(int i = 0; i < tamanho; i++) {
                digito = cpf.charAt(i);
                if(!Character.isDigit(digito)) {
                    validade = false;
                    break;
                }
            }
        }
        return validade;
    }

    public static String formataCPF(String cpf) {
        String cpfForm = "";
        int tamanho = cpf.length();
        for(int i = 0; i < tamanho; i++) {
            cpfForm += cpf.charAt(i);
            if(i == 2 || i == 5) {
                cpfForm += '.';
            }
            if(i == 8){
                cpfForm += '-';
            }
        }
        return cpfForm;
    }
}
