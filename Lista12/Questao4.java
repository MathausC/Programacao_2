package Programacao_2.Lista12;
import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] gabarito = new char[100];
        char[][] respAlunos = new char[50][100];
        String[] alunos = new String[50];
        int[] respAcertadas = new int[50];
        System.out.println("Primeiro, vamos preencher o gabarito da prova.");
        preencheVetor(gabarito);
        System.out.println("Agora, vamos preencher os nomes dos alunos.");
        preencheVetor(alunos);
        System.out.println("Agora, vamos preecher a matrzi com as respostas dos alunos.");
        preencheMatriz(respAlunos, alunos);
        calcularAcertoAlunos(respAcertadas, gabarito, respAlunos);
        System.out.println("Alunos aprovados:");
        exibirAprovados(alunos, respAcertadas, 70);
        System.out.println("Alunos reprovados:");
        exibirReprovados(alunos, respAcertadas, 70);
    }

    public static void preencheVetor(char[] vet) {
        char resp;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < vet.length; i++) {
            System.out.print("Informe letra da questão " + (i+1) + ": ");
            resp = in.next().charAt(0); in.nextLine();
            resp = Character.toLowerCase(resp);
            while(resp < 'a' || resp > 'd') {
                System.out.println("Letra inválida.");
                System.out.print("Informe letra da questão " + (i+1) + ": ");
                resp = in.next().charAt(0); in.nextLine();
                resp = Character.toLowerCase(resp);
            }
            vet[i] = resp;
        }
    }

    public static void preencheVetor(String[] vet) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < vet.length; i++) {
            System.out.print("Informe o nome do aluno " + (i+1) + ": ");
            vet[i] = in.nextLine();
        }
    }

    public static void preencheMatriz(char[][] mat, String[] nomes) {
        Scanner in = new Scanner(System.in);
        char resp;
        if(mat.length == nomes.length) {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[i].length; j++) {
                    System.out.print("Informe a resposta do aluno " + nomes[i] + " na questão " + (j+1) + ": ");
                    resp = in.next().charAt(0); in.nextLine();
                    resp = Character.toLowerCase(resp);
                    while(resp < 'a' || resp > 'd') {
                        System.out.println("Letra inválida.");
                        System.out.print("Informe a resposta do aluno " + nomes[i] + " na questão " + (j+1) + ": ");
                        resp = in.next().charAt(0); in.nextLine();
                        resp = Character.toLowerCase(resp);
                    }
                    mat[i][j] = resp;
                }
            }
        }
        else {
            System.out.println("Não é possível preencher a matriz.");
        }

    }

    public static void calcularAcertoAlunos(int[] acer, char[] gab, char[][] resps) {
        if(acer.length == resps.length && gab.length == resps[0].length) {
            for(int i = 0; i < resps.length; i++) {
                for(int j = 0; j < resps[i].length; j++) {
                    if(resps[i][j] == gab[j]) {
                        acer[i] += 1;
                    }
                }
            }
        }
        else {
            System.out.print("Matriz não pode ser preenchida.");
        }
    }

    public static void exibirAprovados(String[] nomes, int[] acer, int media)  {
        if(nomes.length == acer.length) {
            for(int i = 0; i < nomes.length; i++) {
                if(acer[i] >= media) {
                    System.out.println("Aluno " + nomes[i] + " aprovado com " + acer[i] + " respostas certas.");
                }
            }
        }
        else {
            System.out.println("Não foi possível exibir os alunos aprovados.");
        }
    }

    public static void exibirReprovados(String[] nomes, int[] acer, int media)  {
        if(nomes.length == acer.length) {
            for(int i = 0; i < nomes.length; i++) {
                if(acer[i] < media) {
                    System.out.println("Aluno " + nomes[i] + " reprovado com " + acer[i] + " respostas certas.");
                }
            }
        }
        else {
            System.out.println("Não foi possível exibir os alunos reprovados.");
        }
    }
}
