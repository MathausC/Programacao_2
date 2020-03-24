package Programacao_2.Lista3;
import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numeros = new int[20];
        int maiorNumero, menorIndex;
        System.out.println("Vamos preencher um vetor de tamanho " + numeros.length);
        preencheVetor(numeros, in);
        maiorNumero = maiorNumero(numeros);
        menorIndex = indexMenorNumero(numeros);
        System.out.println("O maior numero da lista é: " + maiorNumero);
        System.out.println("O index do menor numero é: " + menorIndex);
    }

    public static void preencheVetor(int[] numeros, Scanner in) {
        for(int cont = 0; cont < numeros.length; cont++) {
            System.out.print("Informe o valor do " + (cont + 1) +"º numero: ");
            numeros[cont] = in.nextInt();
        }
        System.out.println("Fim do preenchimento.");
    }

    public static int maiorNumero(int[] numeros) {
        int maiorNumero = 0;
        for(int cont = 0; cont < numeros.length; cont++) {
            if(numeros[cont] > maiorNumero) {
                maiorNumero = numeros[cont];
            }
        }
        return maiorNumero;
    }

    public static int indexMenorNumero(int[] numeros) {
        int index = 0;
        int menorNumero = numeros[index];
        for(int cont = 0; cont < numeros.length; cont++) {
            if(numeros[cont] < menorNumero) {
                menorNumero = numeros[cont];
                index = cont;
            }
        }
        return index;
    }
}