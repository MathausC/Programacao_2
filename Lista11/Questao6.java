package Programacao_2.Lista11;
import java.util.Scanner;

public class Questao6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] ganhos = new double[9][13];
        char resp;
        double fMedio, fFruta, fMes, fAnual;
        String palavra;
        System.out.println("Vamos preencher a tabela das vendas de frutas do mercado por mês.");
        preencherMatriz(ganhos);
        System.out.println("Vamos agora para as opções.");
        do{
            exibirMenu();
            resp = in.next().charAt(0); in.nextLine();
            switch (resp) {
                case '1':
                    fMedio = calcularMediaGanhosPorMes(ganhos);
                    System.out.println("Faturamento médio por mês: R$" + fMedio);
                    break;
                case '2':
                    System.out.print("Infome o nome da fruta: ");
                    palavra = in.nextLine();
                    fFruta = faturamentoFrutaAno(palavra, ganhos);
                    System.out.println("Faturamento por venda de " + palavra + ": R$" + fFruta);
                    break;
                case '3':
                    System.out.print("Informe o mês do faturamento: ");
                    palavra = in.nextLine();
                    fMes = faturamentoMes(palavra, ganhos);
                    System.out.println("Faturamento do mes " + palavra + ": R$" + fMes);
                    break;
                case '4':
                    fAnual = faturamentoAnual(ganhos);
                    System.out.println("Faturamento anual: R$" + fAnual);
                    break;
                case '0': System.out.println("Obrigado e até mais."); break;
                default: System.out.println("Opção inválida.");
            }
        }while(resp != '0');
    }

    public static void exibirMenu() {
        String mensagem = "Informe uma das opções abaixo.\n" +
                "1 - Faturamento médio por mês.\n" +
                "2 - Faturamento anual de uma fruta.\n" +
                "3 - Faturamento no mês.\n" +
                "4 - Faturamengo anual.\n" +
                "0 - Encerrar\n" +
                "Opção: ";
        System.out.print(mensagem);
    }

    public static void preencherMatriz(double[][] ganhos) {
        Scanner in = new Scanner(System.in);
        String fruta, mes;
        double somaMes;
        int mesN = 0;
        int frutaN = 0;
        while(mesN < (ganhos[frutaN].length - 1)) {
            switch (mesN) {
                case 0: mes = "Janeiro"; break;
                case 1: mes = "Fevereiro"; break;
                case 2: mes = "Março"; break;
                case 3: mes = "Abril"; break;
                case 4: mes = "Maio"; break;
                case 5: mes = "Junho"; break;
                case 6: mes = "Julho"; break;
                case 7: mes = "Agosto"; break;
                case 8: mes = "Setembro"; break;
                case 9: mes = "Outubro"; break;
                case 10: mes = "Novembro"; break;
                case 11: mes = "Dezembro"; break;
                default: mes = "mês inválido"; break;
            }
            frutaN = 0;
            somaMes = 0;
            while(frutaN < (ganhos.length - 1)) {
                switch (frutaN) {
                    case 0: fruta = "Abacaxi"; break;
                    case 1: fruta = "Banana"; break;
                    case 2: fruta = "Maçã"; break;
                    case 3: fruta = "Mamão"; break;
                    case 4: fruta = "Melancia"; break;
                    case 5: fruta = "Melão"; break;
                    case 6: fruta = "Tangerina"; break;
                    case 7: fruta = "Uva"; break;
                    default: fruta = "nome inválido"; break;
                }
                System.out.print("Informe o valor arrecadado em " + mes + " com a venda de " + fruta + ": ");
                ganhos[frutaN][mesN] = in.nextDouble(); in.nextLine();
                somaMes += ganhos[frutaN][mesN];
                frutaN++;
            }
            ganhos[frutaN][mesN] = somaMes;
            mesN++;
        }
        double somaFrutas;
        for(int i = 0; i < ganhos.length; i++) {
            int j = 0;
            somaFrutas = 0;
            while(j < (ganhos[i].length - 1)) {
                somaFrutas += ganhos[i][j];
                j++;
            }
            ganhos[i][j] = somaFrutas;
        }
    }

    public static double calcularMediaGanhosPorMes(double[][] ganhos) {
        double media;
        int ultLin = ganhos.length - 1;
        int ultCol = ganhos[ultLin].length - 1;
        media = ganhos[ultLin][ultCol] / 12;
        return media;
    }

    public static double faturamentoFrutaAno(String fruta, double[][] ganhos) {
        int index = convertStringParaIndexFrut(fruta);
        int ultCol = ganhos[index].length - 1;
        double f;
        if(index == -1) {
            System.out.println("Fruta não encontrada.");
            f = 0;
        }
        else {
            f = ganhos[index][ultCol];
        }
        return f;
    }

    private static int convertStringParaIndexFrut(String fruta) {
        int index;
        if(fruta.equalsIgnoreCase("abacaxi")) {
            index = 0;
        }
        else if(fruta.equalsIgnoreCase("banana")) {
            index = 1;
        }
        else if(fruta.equalsIgnoreCase("maçã")) {
            index = 2;
        }
        else if(fruta.equalsIgnoreCase("mamão")) {
            index = 3;
        }
        else if(fruta.equalsIgnoreCase("melancia")) {
            index = 4;
        }
        else if(fruta.equalsIgnoreCase("melão")) {
            index = 5;
        }
        else if(fruta.equalsIgnoreCase("tangerina")) {
            index = 6;
        }
        else if(fruta.equalsIgnoreCase("uva")) {
            index = 7;
        }
        else {
            index = -1;
        }
        return index;
    }

    public static double faturamentoMes(String mes, double[][] ganhos) {
        int index = convertStringParaIndexMes(mes);
        int ultLin = ganhos.length - 1;
        double f;
        if(index == -1) {
            System.out.println("Mês não encontrado");
            f = 0;
        }
        else {
            f = ganhos[ultLin][index];
            ultLin = ganhos.length - 1;
        }
        return f;
    }

    private static int convertStringParaIndexMes(String mes) {
        int index;
        if(mes.equalsIgnoreCase("janeiro")) {
            index = 0;
        }
        else if(mes.equalsIgnoreCase("fevereiro")) {
            index = 1;
        }
        else if(mes.equalsIgnoreCase("março")) {
            index = 2;
        }
        else if(mes.equalsIgnoreCase("abril")) {
            index = 3;
        }
        else if(mes.equalsIgnoreCase("maio")) {
            index = 4;
        }
        else if(mes.equalsIgnoreCase("junho")) {
            index = 5;
        }
        else if(mes.equalsIgnoreCase("julho")) {
            index = 6;
        }
        else if(mes.equalsIgnoreCase("agosto")) {
            index = 7;
        }
        else if(mes.equalsIgnoreCase("setembro")){
            index = 8;
        }
        else  if(mes.equalsIgnoreCase("outubro")) {
            index = 9;
        }
        else if(mes.equalsIgnoreCase("novembro")) {
            index = 10;
        }
        else if(mes.equalsIgnoreCase("dezembro")) {
            index = 11;
        }
        else {
            index = -1;
        }
        return index;
    }

    public static double faturamentoAnual(double[][] ganhos) {
        int ultLin = ganhos.length - 1;
        int ultCol = ganhos[ultLin].length - 1;
        return ganhos[ultLin][ultCol];
    }
}
