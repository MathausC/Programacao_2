package Programacao_2.Lista12;
import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mat = new int[4][4];
        System.out.println("Vamos preencher uma matriz 4x4 e ver se ela é simétrica.");
        preencherMatriz(mat);
        int forSimetrica = verificarSimetria(mat);
        String mensagem;
        if(forSimetrica == 1) {
            mensagem = "A matriz é simétrica";
        }
        else {
            mensagem = "A matriz não é simétrica.";
        }
        System.out.println(mensagem);
    }

    public static void preencherMatriz(int[][] mat) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print("Informe o valor da posição " + (i+1) + "x" + (j+1) + ": ");
                mat[i][j] = in.nextInt(); in.nextLine();
            }
        }
    }

    public static int verificarSimetria(int[][] mat) {
        int resp = 1;
        if(mat.length == mat[0].length) {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat.length; j++) {
                    if(i != j && mat[i][j] != mat[j][i]) {
                        resp = 0;
                        break;
                    }
                }
            }
        }
        else {
            resp = 0;
        }
        return  resp;
    }
}
