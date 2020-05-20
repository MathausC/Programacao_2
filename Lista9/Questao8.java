package Programacao_2.Lista9;
import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numeroConta;
        char dig;
        System.out.print("Informe o numero da conta: ");
        numeroConta = in.next();
        if(!verificarNumeroConta(numeroConta)) {
            System.out.println("Numero da conta invalido.");
            System.out.print("Informe o número da conta: ");
            numeroConta = in.next();
        }
        System.out.print("Informe o dígito de verificação: ");
        dig = in.next().charAt(0); in.nextLine();
        if(verificarDigito(numeroConta, dig)) {
            System.out.println("Digito válido.");
        }
        else {
            System.out.println("Digito inválido");
        }
    }
    public static boolean verificarNumeroConta(String numero) {
        boolean validade = true;
        int tamanho = numero.length();
        if(tamanho == 6) {
            char digito;
            for(int i = 0; i < tamanho; i++) {
                digito = numero.charAt(i);
                if(!Character.isDigit(digito)) {
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

    public static boolean verificarDigito(String numero, char dig) {
        boolean validade = true;
        if(!verificarNumeroConta(numero)) {
            validade = false;
        }
        else {
            int digitoValido = calculaDigitoValido(numero);
            int digitoInformado = convertCharEmInt(dig);
            if(digitoInformado != -1 || dig == 'x') {
                if(digitoValido >= 0 && digitoValido <= 9) {
                    if(digitoValido != digitoInformado) {
                        validade = false;
                    }
                }
                if(digitoValido == 10 && dig != 'x') {
                    validade = false;
                }
            }
            else {
                validade = false;
            }
        }
        return validade;
    }

    private static int calculaDigitoValido(String numero) {
        char digito;
        int valorInterm = 0;
        int tamanho = numero.length();
        for(int i = 0; i < tamanho; i++) {
            digito = numero.charAt(i);
            valorInterm += Math.pow(convertCharEmInt(digito), i);
        }
        int digitoValido = valorInterm % 11;
        return digitoValido;
    }

    private static int convertCharEmInt(char n) {
        int numero = -1;
        if(Character.isDigit(n)) {
            numero = n - '0';
        }
        return numero;
    }
}
