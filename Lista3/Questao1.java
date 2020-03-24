package Programacao_2.Lista3;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[50];
        double[] notas1 =  new double[50];
        double[] notas2 = new double[50];
        double[] medias = new double[50];

        System.out.println("Vamos verificar a média de 50 alunos.");
        for(int cont = 0; cont < nomes.length; cont++) {
            System.out.print("Informe o nome do aluno nº" + (cont +1) + ": ");
            nomes[cont] = in.nextLine();
            
            System.out.print("Informe a primeira nota do aluno: ");
            notas1[cont] = in.nextDouble();
            while(notas1[cont] < 0 || notas1[cont] > 10) {
                System.out.println("Nota incorreta.");
                System.out.print("Informe a primeira nota do aluno: ");
                notas1[cont] = in.nextDouble();
            }
            
            System.out.print("Informe a segunda nota do aluno: ");
            notas2[cont] = in.nextDouble();
            while(notas2[cont] < 0 || notas2[cont] > 10) {
                System.out.println("Nota incorreta.");
                System.out.print("Informe a segunda nota do aluno: ");
                notas2[cont] = in.nextDouble();
            }
            
            medias[cont] = ((notas1[cont] * 2) + (notas2[cont] * 3)) / 5;
        }

        for(int cont = 0; cont < nomes.length; cont++) {
            System.out.println("O aluno " + nomes[cont] + " obteve média " + medias[cont] + ".");
        }
        in.close();
    }

    //Questão 2

    public static double calculaMediaTurma(double[] medias) {
        double soma = 0;
        double media;
        for(int cont = 0; cont < medias.length; cont++) {
            soma += medias[cont];
        }
        media = soma / medias.length;
        return media;
    }

    //Questão 3

    public static int calcPercentNotasBaixas(double[] medias) {
        int notasBaixas = 0;
        int percentual;
        for(int cont = 0; cont < medias.length; cont++) {
            if(medias[cont] < 7) {
                notasBaixas++;
            }
        }
        percentual = (notasBaixas * 100) / medias.length;
        return percentual;
    }

    //Questão 4

    public static int calcularAlunosAcimaMedia(double[] medias) {
        int notasAcimaMedia = 0;
        double mediaTurma = calculaMediaTurma(medias);
        for(int cont = 0; cont < medias.length; cont++) {
            if(medias[cont] > mediaTurma) {
                notasAcimaMedia++;
            }
        }
        return notasAcimaMedia;
    }

    //Questão 5

    public static double maiorMedia(double[] medias) {
        double maiorMedia = 0;
        for(int cont = 0; cont < medias.length; cont++) {
            if(medias[cont] > maiorMedia) {
                maiorMedia = medias[cont];
            }
        }
        return maiorMedia;
    }
}