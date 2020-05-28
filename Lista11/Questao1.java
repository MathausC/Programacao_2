package Programacao_2.Lista11;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[20];
        double[][] notas = new double[20][3];
        System.out.println("Vamos preencher uma tabela com o nome do aluno,\n" +
                " sua nota da primeira unidade e da segunda unidade.");
        for(int i = 0; i < nomes.length; i++){
            System.out.print("Informe o nome do aluno: ");
            String nome = in.nextLine();
            nomes[i] = nome;
            System.out.print("Informe a primeira nota do aluno " + nomes[i] + ": ");
            double nota1 = in.nextDouble(); in.nextLine();
            while(nota1 < 0 || nota1 > 10) {
                System.out.println("Nota inválida.");
                System.out.print("Informe a primeira nota do aluno " + nomes[i] + ": ");
                nota1 = in.nextDouble(); in.nextLine();
            }
            notas[i][0] = nota1;
            System.out.print("Informe a segunda nota do aluno " + nomes[i] + ": ");
            double nota2 = in.nextDouble(); in.nextLine();
            while(nota2 < 0 || nota2 > 10) {
                System.out.println("Nota inválida.");
                System.out.print("Informe a segunda nota do aluno " + nomes[i] + ": ");
                nota2 = in.nextDouble(); in.nextLine();
            }
            notas[i][1] = nota2;
            notas[i][2] = ((notas[i][0] * 2) + (notas[i][1] * 3)) / 5;
            System.out.println("O aluno " + nomes[i] + " obteve média " + notas[i][2] + ".");
        }
        double mediaTurna = calculaMediaTurma(notas);
        System.out.println("A média da turma é " + mediaTurna + ".");
        int mediasBaixas = verificaQuantMediaBaixa(notas);
        System.out.println("Quantidade de medias baixas são " + mediasBaixas);
        exibeMaiorEMenorMedia(notas);
    }

    public static double calculaMediaTurma(double[][] notas) {
        int qNotas = 0;
        double soma = 0;
        for(int i = 0; i < notas.length; i++) {
            for(int j = 0; j < (notas[i].length - 1); j++) {
                soma += notas[i][j];
                qNotas++;
            }
        }
        double res = soma/qNotas;
        return res;
    }

    public static int verificaQuantMediaBaixa(double[][] notas) {
        int qMediasBaixas = 0;
        for(int i = 0; i < notas.length; i++) {
            if(notas[i][2] < 7) {
                qMediasBaixas++;
            }
        }
        return qMediasBaixas;
    }

    public static void exibeMaiorEMenorMedia(double[][] notas) {
        double maior = 0;
        double menor = 10;
        for(int i = 0; i < notas.length; i++) {
            if(maior < notas[i][2]){
                maior = notas[i][2];
            }
            if(menor > notas[i][2]) {
                menor = notas[i][2];
            }
        }
        System.out.println("A maior e menor média da turma são respectivamente: " + maior + " e " + menor + ".");
    }
}
