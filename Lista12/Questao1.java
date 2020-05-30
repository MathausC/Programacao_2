package Programacao_2.Lista12;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        int[][] produtos = new int[5][10];
        int[] totalPorArmazem = new int[5];
        int[] totalProdutos = new int[10];
        int totalArmazenado;
        Scanner in = new Scanner(System.in);
        System.out.println("Vamos preencher a matriz de produtos da Grãos & Companhia.");
        preencherMatriz(produtos, totalPorArmazem);
        calcularTotalPorProdutos(produtos, totalProdutos);
        totalArmazenado = totalDeGrãos(produtos);
        System.out.println("Quantidade de grãos por armazem.");
        exibeVetor("Armazem", totalPorArmazem);
        System.out.println("Quantidade por tipo de grão.");
        exibeVetor("Grãos", totalProdutos);
        System.out.println("Quantidade total de grãos: " + totalArmazenado);
    }

    public static void preencherMatriz(int[][] mat, int[] vetA) {
        if(mat.length == vetA.length) {
            int q;
            int soma;
            Scanner in = new Scanner(System.in);
            for(int i = 0; i < mat.length; i++) {
                soma = 0;
                for(int j = 0; j < mat[i].length; j++) {
                    System.out.print("Informe a quantidade em Kg do grão tipo " + (j+1) + " estocados no armazém " + (i+1) + ": ");
                    q = in.nextInt(); in.nextLine();
                    while(q < 0) {
                        System.out.println("A quantidade deve ser maior ou iguala a zero.");
                        System.out.print("Informe a quantidade em Kg do grão tipo " + (j+1) + " estocados no armazém " + (i+1) + ": ");
                        q = in.nextInt(); in.nextLine();
                    }
                    soma += q;
                    mat[i][j] = q;
                }
                vetA[i] = soma;
            }
        }
        else {
            System.out.println("O número de linhas da matriz deve ser igual ao número de itens do vetor.");
        }
    }

    public static void calcularTotalPorProdutos(int[][] mat, int[] vetB) {
        if(mat[0].length == vetB.length) {
            int soma;
            for(int i = 0; i < mat[0].length; i++) {
                soma = 0;
                for(int j = 0; j < mat.length; j++) {
                    soma += mat[j][i];
                }
                vetB[i] = soma;
            }
        }
        else {
            System.out.println("O número de colunas da matriz deve ser igual ao número de itens do vetor.");
        }
    }

    public static int totalDeGrãos(int[][] mat) {
        int soma = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                soma+= mat[i][j];
            }
        }
        return soma;
    }

    public static void exibeVetor(String mensagem, int[] vet) {
        for(int i = 0; i < vet.length; i++) {
            System.out.println(mensagem + " " + (i+1) + ": "+ vet[i]);
        }
    }
}
