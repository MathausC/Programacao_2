package Programacao_2.Lista7;
import java.util.Scanner;

public class OrdenaNomes {
    static String[] nomes = new String[20];
    static int cont = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nome;
        System.out.println("Vamos preencher um vetor com 20 nomes.");
        do {
            System.out.print("Informe o " + (cont + 1) + "º nome: ");
            nome = in.nextLine();
            preencher(nome);
        }while(cont < nomes.length);
        System.out.println("Os nomes em ordem alfabeticas são:");
        ordenar();
        exibir();
    }

    public static void preencher(String nome) {
        if(cont < nomes.length) {
            if(cont == 0) {
                nomes[cont] = nome;
                cont++;
            }
            else {
                int existe = procuraNome(nome);
                if(existe == -1) {
                    nomes[cont] = nome;
                    cont++;
                }
                else {
                    System.out.println("O nome já existe.");
                }
            }
        }
    }

    public static int procuraNome(String nome) {
        int ret = -1;
        if(cont > 0) {
            for(int i = 0; i < cont; i++) {
                if(nome.equalsIgnoreCase(nomes[i])) {
                    ret = i;
                    break;
                }
            }
        }
        return ret;
    }

    public static void ordenar() {
        String aux;
        int pos = 0;
        int fim = cont - 1;
        boolean trocou;
        do{
            trocou = false;
            for(int i = 0; i < fim; i++) {
                if(nomes[i].compareToIgnoreCase(nomes[i + 1]) > 0) {
                    aux = nomes[i];
                    nomes[i] = nomes[i + 1];
                    nomes[i + 1] = aux;
                    trocou = true;
                    pos = i;
                }
            }
            fim = pos;
        }while(trocou);
    }

    public static void exibir() {
        for(int i = 0; i < cont; i++) {
            System.out.println(nomes[i]);
        }
    }
}
