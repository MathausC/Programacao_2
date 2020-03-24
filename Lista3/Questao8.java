package Programacao_2.Lista3;
import java.util.Random;

public class Questao8 {
    public static void main(String[] args) {
        int[] vezesFaces = new int[6];
        Random random = new Random();

        for(int cont = 1; cont <= 1000000; cont++) {
            int face = random.nextInt(6);
            vezesFaces[face]++;
        }
        System.out.println("Quantidade de vezes em cada dado.");
        for(int cont = 0; cont < vezesFaces.length; cont++) {
            System.out.println("Face " + (cont + 1) +": " + vezesFaces[cont]);
        }

        System.out.print(Math.random());
    }
}