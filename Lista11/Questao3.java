package Programacao_2.Lista11;
import java.util.Scanner;

public class Questao3 {
    static Scanner in = new Scanner(System.in);
    static int[][] mat1 = new int[5][5];
    static int[][] mat2 = new int[5][5];

    public static void main(String[] args) {
        System.out.println("Vamos preencher uma matriz 5x5.");
        lerMatriz();
        int maior = maiorDaMatriz(mat1);
        preencheMatriz(maior);
        exibirMatriz();
    }

    public static void lerMatriz() {
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat1[i].length; j++) {
                System.out.print("Informe o intero da "  + (i+1) + "ª linha " + (j+1) + "ª coluna: ");
                mat1[i][j] = in.nextInt(); in.nextLine();
            }
        }
    }

    public static void exibirMatriz() {
        for(int i = 0; i < mat2.length; i++) {
            for(int j = 0; j < mat2[i].length; j++) {
                System.out.print(mat2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int maiorDaMatriz(int[][] mat) {
        int maior = mat[0][0];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(maior < mat[i][j]) {
                    maior = mat[i][j];
                }
            }
        }
        return maior;
    }

    public static void preencheMatriz(int esc) {
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat1[i].length; j++) {
                mat2[i][j] = mat1[i][j] * esc;
            }
        }
    }
}
