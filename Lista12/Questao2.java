package Programacao_2.Lista12;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o tananho da matriz quadada a ser preenchida: ");
        int tam = in.nextInt(); in.nextLine();
        while(tam <= 1) {
            System.out.println("O valor deve ser maior que 1 (um).");
            System.out.print("Informe o tananho da matriz quadada a ser preenchida: ");
            tam = in.nextInt(); in.nextLine();
        }
        int[][] mat = new int[tam][tam];
        System.out.println("Agora, vamos preenchela.");
        preencherMatriz(mat);
        int forMagico = verificaQuadradoMagico(mat);
        String mensagem;
        if(forMagico == 1) {
            mensagem = "A matriz é um quadrado mágico.";
        }
        else {
            mensagem = "A matriz não é um quadrado mágico.";
        }
        System.out.println(mensagem);
    }

    public static void preencherMatriz(int[][] mat) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                System.out.print("Informe numero da posição " + (i+1) + "x" + (j+1) + ": ");
                mat[i][j] = in.nextInt(); in.nextLine();
            }
        }
    }

    public static int verificaQuadradoMagico(int[][] mat) {
        int resp = 1;
        if(mat.length == mat[0].length) {
            int[] somaLinhas = new int[mat.length];
            int[] somaColunas = new int[mat[0].length];
            int diagonal1 = 0, diagonal2 = 0;
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[i].length; j++) {
                    somaLinhas[i] += mat[i][j];
                    somaColunas[j] += mat[j][i];
                    if(i == j) {
                        diagonal1 += mat[i][j];
                    }
                    if(i + j == mat.length - 1) {
                        diagonal2 += mat[i][j];
                    }
                }
            }
            if(diagonal1 != diagonal2) {
                resp = 0;
            }
            else {
                for(int i = 0; i < somaLinhas.length - 1; i++) {
                    if(somaLinhas[i] != somaLinhas[i+1]) {
                        resp = 0;
                        break;
                    }
                    if(somaColunas[i] != somaColunas[i+1]) {
                        resp = 0;
                        break;
                    }
                }
                if(resp == 1 && (diagonal1 != somaLinhas[0]) || (diagonal1 != somaColunas[0])) {
                    resp = 0;
                }
            }
        }
        else {
            resp = 0;
        }
        return resp;
    }
}
