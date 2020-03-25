package Programacao_2.Lista4;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[5];
        System.out.println("Vamos preencher o vetor de 20 pessoas.");
        preencheVetorPessoas(pessoas, in);
        System.out.println("Vamos exibir os dados das pessoas.");
        exibeDadosVetor(pessoas);    
    }

    public static void preencheVetorPessoas(Pessoa[] pessoas, Scanner in) {
        String nome;
        int idade;
        char genero;
        double peso;
        double altura;
        for(int cont = 0; cont < pessoas.length; cont++) {
            System.out.print("Informe o nome da pessoa " + (cont + 1)+ ": ");
            nome = in.next();
            System.out.print("Informe a idade: ");
            idade = in.nextInt();
            while(idade < 0 || idade > 150) {
                System.out.println("Idade inválida.");
                System.out.print("Informe a idade: ");
                idade = in.nextInt();
            }
            System.out.print("Informe o gênero com M para maculino e F para Feminino: ");
            genero = in.next().charAt(0);
            genero = Character.toUpperCase(genero);
            while(genero != 'M' && genero != 'F') {
                System.out.println("Gênero inválido.");
                System.out.print("Informe o gênero com M para maculino e F para Feminino: ");
                genero = in.next().charAt(0);
                genero = Character.toUpperCase(genero);
            }
            System.out.print("Informe o peso: ");
            peso = in.nextDouble();
            while(peso <= 0 || peso > 300) {
                System.out.println("Peso inválido.");
                System.out.print("Informe o peso: ");
                peso = in.nextDouble();
            }
            System.out.print("Informe a altura: ");
            altura = in.nextDouble();
            while(altura <= 0 || altura > 3) {
                System.out.println("Altura inválida.");
                System.out.print("Informe a altura: ");
                altura = in.nextDouble();
            }
            System.out.println();
            pessoas[cont] = new Pessoa(nome, idade, genero, peso, altura);
        }
    }

    public static void exibeDadosVetor(Pessoa[] pessoas) {
        for(int cont = 0; cont < pessoas.length; cont++) {
            System.out.println("Dados da pessoa " + (cont+ 1) + ":");
            System.out.println("Nome: " + pessoas[cont].getNome());
            System.out.println("Idade: " + pessoas[cont].getIdade());
            System.out.println("Gênero: " + pessoas[cont].getGenero());
            System.out.println("Peso: " + pessoas[cont].getPeso());
            System.out.println("Altura: " + pessoas[cont].getAltura());
            System.out.println("Peso Ideal: " + pessoas[cont].getPesoIdeal());
            System.out.println();
        }
        System.out.println("Fim da exibição");
    }
}