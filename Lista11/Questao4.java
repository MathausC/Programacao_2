package Programacao_2.Lista11;
import java.util.Scanner;

public class Questao4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[10];
        double[][] notas = new double[10][5];
        System.out.println("Vamos preencher as notas dos alunos.");
        preencheMatriz(nomes, notas);
        exibirRelatorio(nomes, notas);
    }

    public static void preencheMatriz(String[] nomes, double[][] notas) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < nomes.length; i++) {
            System.out.print("Informe o nome do aluno: ");
            nomes[i] = in.nextLine();
            for(int j = 0; j < notas[i].length; j++) {
                System.out.print("Informe a " + (j+1) + "ª nota de " + notas[i].length + ": ");
                notas[i][j] = in.nextDouble(); in.nextLine();
                while(notas[i][j] < 0 || notas[i][j] > 10) {
                    System.out.println("Nota inválida.");
                    System.out.print("Informe a " + (j+1) + "ª nota de " + notas[i].length + ": ");
                    notas[i][j] = in.nextDouble(); in.nextLine();
                }
            }
        }
    }

    public static void exibirRelatorio(String[] nomes, double[][] notas) {
        System.out.println("Relatório dos alunos:");
        for(int i = 0; i < nomes.length; i++) {
            System.out.println("A menor nota do aluno " + nomes[i] + " foi " + menorNota(notas[i]) + ".");
        }
    }

    private static double menorNota(double[] notas) {
        double menor = notas[0];
        for(int i = 1; i < notas.length; i++) {
            if(menor > notas[i]) {
                menor = notas[i];
            }
        }
        return  menor;
    }
}
