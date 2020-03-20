package Programacao_2.Lista2;

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int voto;
        int[] votos = new int[6];
        char resposta;
        do {
            System.out.println("Vamos votar, escolha:");
            System.out.println("1 - João");
            System.out.println("2 - Maria");
            System.out.println("3 - Pedro");
            System.out.println("4 - Luiz");
            System.out.println("0 - brancos");
            System.out.print("Seu voto:");
            voto = in.nextInt();
            if(voto > 4 || voto < 0) {
                votos[5]++;
            }
            else {
                votos[voto]++;
            }
            System.out.println("Há mais pessoas a votar?");
            resposta = in.next().charAt(0);
            while(resposta != 'S' || resposta != 's' || resposta != 'N' || resposta != 'n'){
                System.out.println("Opção inválida. Responda com S ou N.");
                System.out.println("Há mais pessoas a votar?");
                resposta = in.next().charAt(0);
            }
        }
        while(resposta == 'S' || resposta == 's');

        System.out.println("Persentual de votos.");
        System.out.println("João: " + calcularPercentual(1, votos) + "%");
        System.out.println("Maria: " + calcularPercentual(2, votos) + "%");
        System.out.println("Pedro: " + calcularPercentual(3, votos) + "%");
        System.out.println("Luiz: " + calcularPercentual(4, votos) + "%");
        System.out.println("brancos: " + calcularPercentual(0, votos) + "%");
        System.out.println("nulos: " + calcularPercentual(5, votos) + "%");

        in.close();
    }

    public static int somaValoresVet(int[] vet) {
        int soma = 0;
        for(int i = 0; i < vet.length; i++) {
            soma += vet[i];
        }
        return soma;
    }
    public static int calcularPercentual(int index, int[] vet) {
        int soma = somaValoresVet(vet);
        int percentual = (vet[index] * 100) / soma;
        return percentual;
    }}