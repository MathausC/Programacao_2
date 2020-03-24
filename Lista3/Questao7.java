package Programacao_2.Lista3;
import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] numeros = new double[25];
        double maiorDiferença;
        System.out.println("Vamos preencher um vetor com 25 numeros reais.");
        preencheVetor(numeros, in);
        maiorDiferença = calcularMaiorDiferenca(numeros);
        System.out.println("A maior diferença consecutiva entre numeros é: " + maiorDiferença);
    }

    public static void preencheVetor(double[] vet, Scanner in) {
        for(int cont = 0; cont < vet.length; cont++) {
            System.out.print("Informe o valor do " + (cont +1) + "º número: ");
            vet[cont] = in.nextDouble();
        }
        System.out.println("Fim do preenchimento.");
    }

    public static double calcularMaiorDiferenca(double[] vet) {
        double diferenca = 0;
        for(int cont = 1; cont < vet.length; cont++) {
            double dif = vet[cont] - vet[cont - 1];
            if(dif < 0) {
                dif *= -1;
            }
            if(dif > diferenca) {
                diferenca = dif;
            }
        }
        return diferenca;
    }
}