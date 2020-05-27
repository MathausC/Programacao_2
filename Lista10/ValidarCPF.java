package Programacao_2.Lista10;
import java.util.Scanner;

public class ValidarCPF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char resp;
        String mensagem;
        System.out.println("Vamos verificar a validade de us CPF's.");
        do {
            System.out.print("Digite um CPF: ");
            String cpf = in.next();
            if(validarCPF(cpf)) {
                mensagem = "Este cpf é válido";
            }
            else {
                mensagem = "Este cpf é inválido";
            }
            System.out.println(mensagem);
            System.out.print("Deseja verificar mais um CPF? (S - sim | N - não) ");
            resp = in.next().charAt(0);
            resp = Character.toUpperCase(resp);
            while(resp != 'S' && resp != 'N') {
                System.out.println("Resposta inválida");
                System.out.print("Deseja verificar mais um CPF? (S - sim | N - não) ");
                resp = in.next().charAt(0);
                resp = Character.toUpperCase(resp);
            }
        }
        while(resp == 'S');
    }

    public static boolean validarCPF(String cpf) {
        boolean validade = true;
        int tamanho = cpf.length();
        if(tamanho != 11) {
            validade = false;
        }
        else if(!varrerStringDig(cpf)) {
                validade = false;
        }
        else {
            int dig1 = cpf.charAt(9) - '0';
            int digV1 = determDigVerif(cpf, 1);
            if(dig1 != digV1) {
                validade = false;
            }
            else {
                int dig2 = cpf.charAt(10) - '0';
                int digV2 = determDigVerif(cpf, 2);
                if(dig2 != digV2) {
                    validade =  false;
                }
            }
        }
        return  validade;
    }

    private static boolean varrerStringDig(String string) {
        boolean v = true;
        int tamanho = string.length();
        for(int i = 0; i < tamanho; i++) {
            char dig = string.charAt(i);
            if(!Character.isDigit(dig)) {
                v = false;
                break;
            }
        }
        return v;
    }

    private static int determDigVerif(String cpf, int modo) {
        char dig;
        int numCom;
        int digNum;
        int soma = 0;
        int digitoValido;
        if(modo == 1) {
            numCom = 10;
            for(int i = 0; i <= 8; i++) {
                dig = cpf.charAt(i);
                digNum = dig - '0';
                soma += (numCom * digNum);
                numCom--;
            }
        }
        if(modo == 2) {
            numCom = 11;
            for(int i = 0; i <= 9; i++) {
                dig = cpf.charAt(i);
                digNum = dig - '0';
                soma += (numCom * digNum);
                numCom--;
            }
        }
        int resto = soma % 11;
        if(resto < 2) {
            digitoValido = 0;
        }
        else {
            digitoValido = 11 - resto;
        }
        return digitoValido;
    }
}
