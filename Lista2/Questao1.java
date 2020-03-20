package Programacao_2.Lista2;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] ags) {
        Scanner in = new Scanner(System.in);
        double[] ganhos = new double[12];
        double[] gastos = new double[12];
        double[] lucros = new double[12];

        System.out.println("Valos preencher os valores dos ganhos de cada mês.");
        preencheVet(ganhos, in);

        System.out.println("Agora vamos preencher os gastos de cada mês.");
        preencheVet(gastos, in);

        calcularLucroVet(ganhos, gastos, lucros);

        System.out.println("Ganhos do ano.");
        exibeValoresVet(ganhos);
        System.out.println("Gastos do ano.");
        exibeValoresVet(gastos);
        System.out.println("Lucros do ano.");
        exibeValoresVet(lucros);

        // Questao 2
        System.out.println("Soma dos ganhos.");
        somaEExibeValoresVet(ganhos);
        System.out.println("Soma dos gastos.");
        somaEExibeValoresVet(gastos);
        System.out.println("Soma dos lucros.");
        somaEExibeValoresVet(lucros);
        
        // Questao 3

        caculaEExibeLucroMedioMensal(lucros);
        
        in.close();
    }

    //Questão 1

    public static void preencheVet(double[] vet, Scanner in) {
        int mes = 1;
        for(int i = 0; i < vet.length; i++) {
            System.out.println("Informe o valor do mês " + mes + ":");
            vet[i] = in.nextDouble();
            mes++;
        }
    }

    public static void calcularLucroVet(double[] ganhos, double[] gastos, double[] lucros) {
        for(int i = 0; i < lucros.length; i++){
            lucros[i] = ganhos[i] - gastos[i];
        }
    }

    public static void exibeValoresVet(double[] vet) {
        int mes = 1;
        for(int i = 0; i < vet.length; i++) {
            System.out.println("O valor do mês " + mes + " é: R$" + vet[i]);
            mes++;
        }
    }

    // Questao 2

    public static void somaEExibeValoresVet(double[] vet) {
        double soma = 0;
        for(int i = 0; i < vet.length; i++) {
            soma += vet[i];
        }
        System.out.println("A soma dos valores é:" + soma);
    }

    //Questao 3

    public static void caculaEExibeLucroMedioMensal(double[] lucros) {
        double soma = 0;
        for(int i = 0; i < lucros.length; i++) {
            soma += lucros[i];
        }
        double media = soma/lucros.length;
        System.out.println("O lucro médio é: R$" + media);
    }
    
}