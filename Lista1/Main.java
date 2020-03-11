package Programacao_2.Lista1;

public class Main {
    public static void main(String[] args) {
        Data data1 = new Data(16, 1, 1997);
        Data data2 = new Data(14, 12, 1995);
        Data data3 = new Data(31, 2, 4345);
        Data data4 = new Data();
        Data data5 = new Data(9, 3, 2020);

        System.out.println("data1:");
        data1.exibeData();
        System.out.println("data2:");
        data2.exibeData();
        System.out.println("data3:");
        data3.exibeData();
        System.out.println("data4:");
        data4.exibeData();
        System.out.println("data5:");
        data5.exibeData();

        System.out.println();

        System.out.println("data1:");
        data1.exibeDataEstenco();
        System.out.println("data2:");
        data2.exibeDataEstenco();
        System.out.println("data3:");
        data3.exibeDataEstenco();
        System.out.println("data4:");
        data4.exibeDataEstenco();
        System.out.println("data5:");
        data5.exibeDataEstenco();

        System.out.println();

        System.out.println("data1 adicional:");
        data1.adicionarDias(12);
        data1.exibeData();
        System.out.println("data2 adicional:");
        data2.adicionarDias(18);
        data2.exibeData();
        System.out.println("data3 adicional:");
        data3.adicionarDias(22);
        data3.exibeData();
        System.out.println("data4 adicional:");
        data4.adicionarDias(9);
        data4.exibeData();
        System.out.println("data5 adicional:");
        data5.adicionarDias(10);
        data5.exibeData();

        System.out.println();

        System.out.println("comparar data1 e data2");
        data1.compararDatas(data2);
        System.out.println("comparar data1 e data3");
        data1.compararDatas(data3);
        System.out.println("comparar data1 e data4");
        data1.compararDatas(data4);
        System.out.println("comparar data1 e data5");
        data1.compararDatas(data5);
        System.out.println("comparar data2 e data3");
        data2.compararDatas(data3);
        System.out.println("comparar data2 e data4");
        data2.compararDatas(data4);
        System.out.println("comparar data2 e data5");
        data2.compararDatas(data5);
        System.out.println("comparar data3 e data4");
        data3.compararDatas(data4);
        System.out.println("comparar data3 e data5");
        data3.compararDatas(data5);
        System.out.println("comparar data4 e data5");
        data4.compararDatas(data5);
    }
}