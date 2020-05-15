package Programacao_2.Lista7;
import java.util.Random;

public class OrdenaNumeros {
    static Random random = new Random();
    static int[] numeros = new int[100];
    static int cont = 0;

    public static void main(String[] args) {
        preencher();
        ordenar();
        exibir();
    }

    public static void preencher() {
        while(cont < numeros.length) {
            int n = random.nextInt(10000);
            if(n > 0) {
                if (cont == 0) {
                    numeros[cont] = n;
                    cont++;
                }
                else {
                    int existe = procuraNumero(n);
                    if(existe == -1) {
                        numeros[cont] = n;
                        cont++;
                    }
                }
            }
        }
    }

    private static int procuraNumero(int numero) {
        int pos = -1;
        if(cont > 0) {
            for(int i = 0; i < cont; i++) {
                if(numeros[i] == numero) {
                    pos = i;
                    break;
                }
            }
        }
        return pos;
    }

    public static void ordenar() {
        boolean trocou;
        int pos = 0;
        int aux;
        int i = 0;
        int fim = cont - 1;
        do {
            trocou = false;
            for(i = 0; i < fim; i++) {
                if (numeros[i] < numeros[i + 1]) {
                    aux = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = aux;
                    trocou = true;
                    pos = i;
                }
            }
            fim = pos;
        }while (trocou);
    }

    public static void exibir() {
        for(int i = 0; i < cont; i++) {
            System.out.println(numeros[i]);
        }
    }
}
