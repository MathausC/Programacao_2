package Programacao_2.Lista11;
import java.util.Scanner;

public class Questao5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matA = new int[3][4];
        int[][] matB = new int[4][3];
        preencherMatriz(matA);
        transportarMatriz(matA, matB);
        System.out.println("Matriz A.");
        exibirMatriz(matA);
        System.out.println("Matriz B");
        exibirMatriz(matB);
    }

    public static void preencherMatriz(int[][] matA) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vamos preencher uma matriz 3x4.");
        for(int i = 0; i < matA.length; i++) {
            for(int j = 0; j < matA[i].length; j++) {
                System.out.print("Informe o termo da " + (i+1) + "ª linha " + (j+1) + "ª coluna: ");
                matA[i][j] = in.nextInt();
            }
        }
        System.out.println("Matriz preenchida.");
    }

    public static void transportarMatriz(int[][] matA, int[][] matB) {
        for(int i = 0; i < matB.length; i++) {
            for(int j = 0; j < matB[i].length; j++) {
                matB[i][j] = matA[j][i];
            }
        }
    }

    public static void exibirMatriz(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
